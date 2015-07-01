package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PokeSandC3Block extends Block {

    public PokeSandC3Block() {
        super(Material.sand);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeSand);
        setUnlocalizedName("PokesandCorner3");
        setCreativeTab(CreativeTabs.tabBlock);
        //setBlockTextureName("pixelmonblocks:" + "PokeSandC3");
    }


}