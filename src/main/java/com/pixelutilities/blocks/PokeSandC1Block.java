package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PokeSandC1Block extends Block {

    public PokeSandC1Block() {
        super(Material.sand);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeSand);
        setUnlocalizedName("PokesandCorner1");
        setCreativeTab(CreativeTabs.tabBlock);
    }

}