package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SaphireBlock extends Block {

    public SaphireBlock() {
        super(Material.rock);
        setHardness(4.0F); // 33% harder than diamond
        setStepSound(Block.soundTypeStone);
        setBlockName("SaphireBlock");


        setBlockTextureName("pixelmonblocks" + ":" + "SaphireBlock");
    }


}