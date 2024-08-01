package net.coma112.ctemplate.language;

import net.coma112.ctemplate.CTemplate;
import net.coma112.ctemplate.utils.ConfigUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Language extends ConfigUtils {
    public Language(@NotNull String name) {
        super(CTemplate.getInstance().getDataFolder().getPath() + File.separator + "locales", name);
        save();
    }
}
