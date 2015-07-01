package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ShinglesCorner2Block extends Block {

    public ShinglesCorner2Block() {
        super(Material.rock);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeWood);
        setUnlocalizedName("Shingles Corner 2");
        setCreativeTab(CreativeTabs.tabBlock);

        //setBlockTextureName("pixelmonblocks" + ":" + "ShinglesCorner2");
    }


}