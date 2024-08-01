package net.coma112.ctemplate.utils;

import net.coma112.ctemplate.CTemplate;
import net.coma112.ctemplate.commands.CommandTemplate;
import net.coma112.ctemplate.listener.JoinListener;
import net.coma112.ctemplate.menu.MenuListener;
import org.bukkit.event.Listener;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class RegisterUtils {
    public static void registerEvents() {
        getListenerClasses().forEach(clazz -> {
            try {
                CTemplate.getInstance().getServer().getPluginManager().registerEvents(clazz.getDeclaredConstructor().newInstance(), CTemplate.getInstance());
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException exception) {
                throw new RuntimeException(exception);
            }
        });
    }

    public static void registerCommands() {
        BukkitCommandHandler handler = BukkitCommandHandler.create(CTemplate.getInstance());
        // add your commands here
        handler.register(new CommandTemplate());
    }

    private static Set<Class<? extends Listener>> getListenerClasses() {
        Set<Class<? extends Listener>> listenerClasses = new HashSet<>();
        // add your listeners here
        listenerClasses.add(MenuListener.class);
        listenerClasses.add(JoinListener.class);
        return listenerClasses;
    }
}
