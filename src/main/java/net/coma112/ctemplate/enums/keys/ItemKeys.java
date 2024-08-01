package net.coma112.ctemplate.enums.keys;

import net.coma112.ctemplate.item.IItemBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public enum ItemKeys {
    BACK_ITEM("menu.back-item"),
    TEST_ITEM("test-item"),
    FORWARD_ITEM("menu.forward-item");

    private final String path;

    ItemKeys(@NotNull final String path) {
        this.path = path;
    }

    public ItemStack getItem() {
        return IItemBuilder.createItemFromString(path);
    };
}
