package net.coma112.ctemplate.utils;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

@Getter
public class MenuUtils {
    private final Player owner;
    private static final HashMap<Player, MenuUtils> menuMap = new HashMap<>();

    public MenuUtils(@NotNull Player player) {
        this.owner = player;
    }

    public static MenuUtils getMenuUtils(@NotNull Player player) {
        MenuUtils menuUtils;

        if (!(menuMap.containsKey(player))) {
            menuUtils = new MenuUtils(player);
            menuMap.put(player, menuUtils);

            return menuUtils;
        }

        return menuMap.get(player);
    }

}

