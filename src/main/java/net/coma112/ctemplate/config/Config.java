package net.coma112.ctemplate.config;

import net.coma112.ctemplate.CTemplate;
import net.coma112.ctemplate.utils.ConfigUtils;

public class Config extends ConfigUtils {
    public Config() {
        super(CTemplate.getInstance().getDataFolder().getPath(), "config");
        save();
    }
}
