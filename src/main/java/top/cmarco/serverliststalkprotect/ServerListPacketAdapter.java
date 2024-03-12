/*
 *     ServerListStalkProtect - Protect Your Server from Server List Stalkers
 *     Copyright © 2024  CMarco
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package top.cmarco.serverliststalkprotect;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import com.google.gson.*;

public final class ServerListPacketAdapter extends PacketAdapter {

    private final ServerListStalkProtect plugin;
    private final Gson gson = new Gson();
    private final JsonParser jsonParser = new JsonParser();
    private String[] randomNames;
    private String[] randomUUIDs;

    public ServerListPacketAdapter(ServerListStalkProtect plugin) {
        super(plugin, ListenerPriority.HIGHEST, PacketType.Status.Server.SERVER_INFO);
        this.plugin = plugin;
        this.randomNames = Usernames.getRandomUsernamesSlice(plugin.getStdConfig().getRandomAmount());
        this.randomUUIDs = Usernames.getRandomUUIDSlice(plugin.getStdConfig().getRandomAmount());
    }

    @Override
    public void onPacketSending(final PacketEvent event) {
        PacketContainer packet = event.getPacket();
        String json = packet.getServerPings().read(0).toJson();

        if (json == null) {
            plugin.getLogger().warning("Server Status packet is null!");
            return;
        }

        String filteredJson = this.modifyPlayersField(json);

        if (filteredJson == null) {
            plugin.getLogger().warning("The filtering of JSON resulted null!");
            return;
        }

        packet.getServerPings().write(0x00, WrappedServerPing.fromJson(filteredJson));
    }

    private String modifyPlayersField(String jsonString) {
        StdConfig stdConfig  = this.plugin.getStdConfig();
        // Parse the JSON string
        JsonObject jsonObject = this.jsonParser.parse(jsonString).getAsJsonObject();

        // Set the "players" field to an empty JSON object
        jsonObject.remove("players");
        JsonObject filteredData = new JsonObject();
        JsonElement max = new JsonPrimitive(stdConfig.getMax());
        JsonElement online = new JsonPrimitive(stdConfig.getOnline());
        JsonArray sample = new JsonArray();
        
        if (!stdConfig.getRandomGenerator()) {
            JsonObject sampleObj = new JsonObject();
            sampleObj.add("name", new JsonPrimitive(stdConfig.getOnlinePlayersText()));
            sampleObj.add("id", new JsonPrimitive(this.randomUUIDs[0]));
            sample.add(sampleObj);
        } else {

            if (!stdConfig.getRandomStatic()) {
                this.randomNames = Usernames.getRandomUsernamesSlice(plugin.getStdConfig().getRandomAmount());
                this.randomUUIDs = Usernames.getRandomUUIDSlice(plugin.getStdConfig().getRandomAmount());
            }

            for (int i = 0; i < this.randomNames.length; i++) {
                JsonObject sampleObj = new JsonObject();
                sampleObj.add("name", new JsonPrimitive(this.randomNames[i]));
                sampleObj.add("id", new JsonPrimitive(this.randomUUIDs[i]));
                sample.add(sampleObj);
            }
            
        }
        
        filteredData.add("max", max);
        filteredData.add("online", online);
        filteredData.add("sample", sample);
        jsonObject.add("players", filteredData);

        // Convert the modified JSON object back to a string
        return this.gson.toJson(jsonObject);
    }
}
