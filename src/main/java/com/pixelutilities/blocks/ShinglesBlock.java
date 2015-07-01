package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ShinglesBlock extends Block {

    public ShinglesBlock() {
        super(Material.rock);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeWood);
        setUnlocalizedName("Shingles");
        setCreativeTab(CreativeTabs.tabBlock);

        //setBlockTextureName("pixelmonblocks" + ":" + "Shingles");
    }


}