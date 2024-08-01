package net.coma112.ctemplate;

import com.github.Anon8281.universalScheduler.UniversalScheduler;
import com.github.Anon8281.universalScheduler.scheduling.schedulers.TaskScheduler;
import lombok.Getter;
import net.coma112.ctemplate.config.Config;
import net.coma112.ctemplate.database.AbstractDatabase;
import net.coma112.ctemplate.database.MySQL;
import net.coma112.ctemplate.database.SQLite;
import net.coma112.ctemplate.enums.DatabaseType;
import net.coma112.ctemplate.enums.LanguageType;
import net.coma112.ctemplate.enums.keys.ConfigKeys;
import net.coma112.ctemplate.enums.keys.MessageKeys;
import net.coma112.ctemplate.language.Language;
import net.coma112.ctemplate.utils.TemplateLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Objects;

import static net.coma112.ctemplate.utils.StartingUtils.registerListenersAndCommands;
import static net.coma112.ctemplate.utils.StartingUtils.saveResourceIfNotExists;

public final class CTemplate extends JavaPlugin {
    @Getter private static CTemplate instance;
    @Getter private static AbstractDatabase database;
    private Config config;
    @Getter
    private Language language;

    @Getter
    private TaskScheduler scheduler;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        scheduler = UniversalScheduler.getScheduler(this);
        initializeComponents();
        registerListenersAndCommands();
        initializeDatabaseManager();
        TemplateLogger.info(MessageKeys.TEST.getMessage());
    }

    @Override
    public void onDisable() {
        if (database != null) database.disconnect();
    }

    public Config getConfiguration() {
        return config;
    }

    private void initializeComponents() {
        config = new Config();

        saveResourceIfNotExists("locales/messages_en.yml");

        language = new Language("messages_" + LanguageType.valueOf(ConfigKeys.LANGUAGE.getString()));
    }

    private void initializeDatabaseManager() {
        try {
            switch (DatabaseType.valueOf(ConfigKeys.DATABASE.getString())) {
                case MYSQL, mysql -> {
                    database = new MySQL(Objects.requireNonNull(getConfiguration().getSection("database.mysql")));
                    MySQL mysql = (MySQL) database;
                    mysql.createTable();
                }

                case SQLITE, sqlite -> {
                    database = new SQLite();
                    SQLite sqlite = (SQLite) database;
                    sqlite.createTable();

                }
            }
        } catch (SQLException | ClassNotFoundException exception) {
            TemplateLogger.error(exception.getMessage());
        }
    }
}
