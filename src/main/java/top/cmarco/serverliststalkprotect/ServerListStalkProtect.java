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

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerListStalkProtect extends JavaPlugin {

    private static final String LOGO = ChatColor.translateAlternateColorCodes('&', "&7[&b&lServerListStalkProtect&r&7]");
    private ProtocolManager protocolManager = null;
    private StdConfig stdConfig = null;

    @Override
    public void onLoad() {
        if (Bukkit.getPluginManager().getPlugin("ProtocolLib") == null) {
            getServer().getConsoleSender().sendMessage(LOGO + ChatColor.RED + ChatColor.BOLD + "PLEASE INSTALL THE DEPENDENCY ProtocolLib TO START THIS SOFTWARE!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        this.stdConfig = new StdConfig(this);

        this.protocolManager = ProtocolLibrary.getProtocolManager();
        this.protocolManager.addPacketListener(new ServerListPacketAdapter(this));
        getServer().getConsoleSender().sendMessage(LOGO + ChatColor.GREEN + ChatColor.BOLD + "Activated Safe Server list feature.");
    }

    @Override
    public void onEnable() {
        getCommand("stalkprotect").setExecutor(new MainCommand(this.stdConfig));
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public StdConfig getStdConfig() {
        return stdConfig;
    }
}
