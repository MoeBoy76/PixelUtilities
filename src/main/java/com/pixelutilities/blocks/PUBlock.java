package com.pixelutilities.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PUBlock extends Block {

    public PUBlock(Material material, String blockName, float hardness, CreativeTabs tab, Block.SoundType soundType) {
        super(material);

        setHardness(hardness); // 33% harder than diamond
        setStepSound(soundType);
        setUnlocalizedName(blockName);
        setCreativeTab(tab);
        //setBlockTextureName("pixelutilities" + ":" + blockName);
    }

}
