package com.pixelutilities.items.economy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PokeCoin50Item extends Item {

    public PokeCoin50Item() {
        super();

        // Constructor Configuration
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMisc);
        setTextureName("pixelutilities:coin50");
        setUnlocalizedName("pokecoin50");
    }
}