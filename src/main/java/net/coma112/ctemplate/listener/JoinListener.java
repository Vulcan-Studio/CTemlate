package net.coma112.ctemplate.listener;

import net.coma112.ctemplate.enums.keys.ItemKeys;
import net.coma112.ctemplate.item.IItemBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        event.getPlayer().getInventory().addItem(ItemKeys.TEST_ITEM.getItem());
    }
}
