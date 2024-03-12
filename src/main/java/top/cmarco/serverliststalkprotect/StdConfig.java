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

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public final class StdConfig {

    private FileConfiguration configuration;
    private final ServerListStalkProtect plugin;


    public StdConfig(ServerListStalkProtect plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        this.configuration = plugin.getConfig();
    }

    public void reload() {
        configuration = plugin.getConfig();
    }

    public int getOnline() {
        return this.configuration.getInt("display.online-players", 0);
    }

    public int getMax() {
        return this.configuration.getInt("display.max-players", 0);
    }

    public String getOnlinePlayersText() {
        return this.configuration.getString("display.online-players-text", "§cHidden");
    }

    public boolean getRandomGenerator() {
        return this.configuration.getBoolean("display.random-fake-player-list", false);
    }

    public boolean getRandomStatic() {
        return this.configuration.getBoolean("display.random-fake-players-fixed", true);
    }

    public int getRandomAmount() {
        return this.configuration.getInt("display.random-fake-players-amount", 5);
    }
}
