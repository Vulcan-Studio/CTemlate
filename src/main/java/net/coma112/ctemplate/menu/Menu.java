package net.coma112.ctemplate.menu;

import net.coma112.ctemplate.enums.keys.ConfigKeys;
import net.coma112.ctemplate.processor.MessageProcessor;
import net.coma112.ctemplate.utils.MenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public abstract class Menu implements InventoryHolder {

    protected MenuUtils menuUtils;
    protected Inventory inventory;

    public Menu(MenuUtils menuUtils) {
        this.menuUtils = menuUtils;
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public abstract void handleMenu(final InventoryClickEvent event);

    public abstract void setMenuItems();

    public void open() {
        inventory = Bukkit.createInventory(this, getSlots(), MessageProcessor.process(getMenuName()));

        this.setMenuItems();

        menuUtils.getOwner().openInventory(inventory);
        MenuUpdater menuUpdater = new MenuUpdater(this);
        menuUpdater.start(ConfigKeys.MENU_TICK.getInt() * 20);
    }

    public void updateMenuItems() {
        if (inventory != null) {
            setMenuItems();
            menuUtils.getOwner().updateInventory();
        }
    }

    public void close() {
        MenuUpdater menuUpdater = new MenuUpdater(this);
        menuUpdater.stop();
        inventory = null;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}

