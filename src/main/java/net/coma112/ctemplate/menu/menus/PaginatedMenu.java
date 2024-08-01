package net.coma112.ctemplate.menu.menus;

import net.coma112.ctemplate.enums.keys.ConfigKeys;
import net.coma112.ctemplate.enums.keys.MessageKeys;
import net.coma112.ctemplate.item.IItemBuilder;
import net.coma112.ctemplate.utils.MenuUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class PaginatedMenu extends net.coma112.ctemplate.menu.PaginatedMenu implements Listener {

    public PaginatedMenu(MenuUtils menuUtils) {
        super(menuUtils);
    }

    @Override
    public String getMenuName() {
        return ConfigKeys.MENU_TITLE.getString();
    }

    @Override
    public int getSlots() {
        return ConfigKeys.MENU_SIZE.getInt();
    }

    @Override
    public void handleMenu(final InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        if (!event.getInventory().equals(inventory)) return;

        event.setCancelled(true);

        if (event.getSlot() == ConfigKeys.FORWARD_SLOT.getInt()) {
            int nextPageIndex = page + 1;
            int totalPages = (int) Math.ceil(10.0 / getMaxItemsPerPage());

            if (nextPageIndex >= totalPages) {
                player.sendMessage(MessageKeys.LAST_PAGE.getMessage());
                return;
            } else {
                page++;
                super.open();
            }
        }

        if (event.getSlot() == ConfigKeys.BACK_SLOT.getInt()) {
            if (page == 0) {
                player.sendMessage(MessageKeys.FIRST_PAGE.getMessage());
            } else {
                page--;
                super.open();
            }
        }
    }

    @Override
    public void setMenuItems() {
        inventory.clear();
        addMenuBorder();
        ItemStack diamondItem = IItemBuilder.create(Material.DIAMOND).setName("Test Diamond").finish();
        inventory.setItem(1, diamondItem);
    }

    @EventHandler
    public void onClose(final InventoryCloseEvent event) {
        if (event.getInventory().equals(inventory)) close();
    }
}
