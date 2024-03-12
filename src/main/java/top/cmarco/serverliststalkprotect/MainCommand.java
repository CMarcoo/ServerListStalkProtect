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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class MainCommand implements CommandExecutor {

    private final StdConfig stdConfig;

    public MainCommand(StdConfig stdConfig) {
        this.stdConfig = stdConfig;
    }

    private static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission("stalkprotect.admin")) {
            commandSender.sendMessage(color("&7[&b&lServerListStalkProtect&r&7] &cMissing permission stalkprotect.admin"));
            return true;
        }

        if (strings.length == 0) {
            commandSender.sendMessage(color("&7[&b&lServerListStalkProtect&r&7] Help Page"));
            commandSender.sendMessage(color("&7/&3stalkprotect reload"));
            return true;
        } else if (strings.length == 1 && strings[0].equalsIgnoreCase("reload")) {
            this.stdConfig.reload();
            commandSender.sendMessage(color("&7[&b&lServerListStalkProtect&r&7] &aReloaded!"));
            return true;
        } else {
            commandSender.sendMessage(color("&7[&b&lServerListStalkProtect&r&7] &cUnknown Command!"));
            return true;
        }

    }
}
