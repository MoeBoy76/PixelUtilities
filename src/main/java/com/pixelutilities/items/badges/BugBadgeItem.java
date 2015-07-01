package com.pixelutilities.items.badges;

import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import net.minecraft.item.Item;

public class BugBadgeItem extends Item {

    public BugBadgeItem() {
        super();

        // Constructor Configuration
        maxStackSize = 64;
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);
        //setTextureName("pixelutilities:badges/BugBadge");
        setUnlocalizedName("bugbadge");
    }
}