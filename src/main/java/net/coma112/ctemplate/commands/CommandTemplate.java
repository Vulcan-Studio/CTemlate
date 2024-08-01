package net.coma112.ctemplate.commands;


import net.coma112.ctemplate.enums.keys.MessageKeys;
import net.coma112.ctemplate.menu.menus.PaginatedMenu;
import net.coma112.ctemplate.utils.MenuUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

import java.util.List;


//Main command here:
@Command({"ctemplate", "template"})
public class CommandTemplate {
    // if u need use the default command you can use @DefaultFor
    @DefaultFor({"ctemplate", "template"})
    public void menu(@NotNull Player player) {
        new PaginatedMenu(MenuUtils.getMenuUtils(player)).open();
    }

    // It's a simple help command  without any permissions
    @Subcommand("help")
    public void help(@NotNull CommandSender sender) {
        List<String> helpMessages = MessageKeys.HELP.getMessages();
        helpMessages.forEach(sender::sendMessage);
    }

    // It's a simple test command with permission (template.test)
    @Subcommand("test")
    @CommandPermission("template.test")
    public void test(@NotNull Player player) {
        player.sendMessage("Hello! This is a test.");
    }
}
