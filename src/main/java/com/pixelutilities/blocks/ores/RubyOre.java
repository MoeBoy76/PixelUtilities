package com.pixelutilities.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.Random;

public class RubyOre extends Block {

    public RubyOre() {
        super(Material.rock);
        setHardness(4.0F); // 33% harder than diamond
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }
}
