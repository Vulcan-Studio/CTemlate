package net.coma112.ctemplate.utils;

import net.coma112.ctemplate.CTemplate;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class StartingUtils {
    public static void registerListenersAndCommands() {
        RegisterUtils.registerEvents();
        RegisterUtils.registerCommands();
    }

    public static void saveResourceIfNotExists(@NotNull String resourcePath) {
        if (!new File(CTemplate.getInstance().getDataFolder(), resourcePath).exists())
            CTemplate.getInstance().saveResource(resourcePath, false);
    }
}
