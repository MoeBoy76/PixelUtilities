package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PokeSandC4Block extends Block {

    public PokeSandC4Block() {
        super(Material.sand);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeSand);
        setBlockName("PokesandCorner4");
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockTextureName("pixelmonblocks" + ":" + "PokeSandC4");
    }


}