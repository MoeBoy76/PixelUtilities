package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PokeSandSide4Block extends Block {

    public PokeSandSide4Block() {
        super(Material.sand);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeSand);
        setUnlocalizedName("PokeSandSide4");
        setCreativeTab(CreativeTabs.tabBlock);

        //setBlockTextureName("pixelmonblocks" + ":" + "PokeSandSide4");
    }


}