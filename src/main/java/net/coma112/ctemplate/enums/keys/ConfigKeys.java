package net.coma112.ctemplate.enums.keys;

import net.coma112.ctemplate.CTemplate;
import net.coma112.ctemplate.processor.MessageProcessor;
import org.jetbrains.annotations.NotNull;

public enum ConfigKeys {
    //
    LANGUAGE("language"),
    DATABASE("database.type"),
    MENU_TICK("menu.update-tick"),
    MENU_TITLE("menu.title"),
    MENU_SIZE("menu.size"),
    BACK_SLOT("menu.back-item.slot"),
    FORWARD_SLOT("menu.forward-item.slot");


    private final String path;

    ConfigKeys(@NotNull final String path) {
        this.path = path;
    }

    public String getString() {
        return MessageProcessor.process(CTemplate.getInstance().getConfiguration().getString(path));
    }

    public boolean getBoolean() {
        return CTemplate.getInstance().getConfiguration().getBoolean(path);
    }

    public int getInt() {
        return CTemplate.getInstance().getConfiguration().getInt(path);
    }
}
