package net.coma112.ctemplate.menu;

import net.coma112.ctemplate.enums.keys.ConfigKeys;
import net.coma112.ctemplate.enums.keys.ItemKeys;
import net.coma112.ctemplate.item.IItemBuilder;
import net.coma112.ctemplate.utils.MenuUtils;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;
    @Getter protected int maxItemsPerPage = ConfigKeys.MENU_SIZE.getInt() - 2;

    public PaginatedMenu(@NotNull MenuUtils menuUtils) {
        super(menuUtils);
    }

    public void addMenuBorder() {
        inventory.setItem(ConfigKeys.BACK_SLOT.getInt(), ItemKeys.BACK_ITEM.getItem());
        inventory.setItem(ConfigKeys.FORWARD_SLOT.getInt(), ItemKeys.FORWARD_ITEM.getItem());
    }
}

