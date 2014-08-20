package com.pixelutilities.items.economy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PokeCoin10Item extends Item {

    public PokeCoin10Item() {
        super();

        // Constructor Configuration
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMisc);
        setTextureName("pixelutilities:coin10");
        setUnlocalizedName("pokecoin10");
    }
}