package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PokeSandC2Block extends Block {

    public PokeSandC2Block() {
        super(Material.sand);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeSand);
        setUnlocalizedName("PokesandCorner2");
        setCreativeTab(CreativeTabs.tabBlock);
        //setBlockTextureName("pixelmonblocks" + ":" + "PokeSandC2");
    }


}