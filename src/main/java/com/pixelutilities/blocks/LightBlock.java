package com.pixelutilities.blocks;

import coloredlightscore.src.api.CLApi;

import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.awt.*;

public class LightBlock extends Block {

    int red, green, blue;

    public LightBlock(String name, Color rgb) {
        super(Material.redstoneLight);
        setHardness(0.5F);

        this.red = (rgb.getRed() / 255) * 15;
        this.green = (rgb.getGreen() / 255) * 15;
        this.blue = (rgb.getBlue() / 255) * 15;

        CLApi.setBlockColorRGB(this, red, green, blue, 65535);
        setBlockName(name + "Light");
        setBlockTextureName("pixelutilities:" + name + "Light");

        //make sure this is last
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesLights);
    }

    @Override
    public Block setCreativeTab(CreativeTabs tabs) {
        super.setCreativeTab(tabs);
        PixelUtilitiesBlocks.LightBlockList.add(this);
        return null;
    }


}
