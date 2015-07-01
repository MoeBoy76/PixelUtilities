package com.pixelutilities.config;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.pixelutilities.Basemod;
import com.pixelutilities.liquids.LiquidSewage;

public class PixelUtilitiesLiquids {

    public static Fluid sewage = new Fluid("sewage");
    public static Block sewageBlock;

    public static void registerLiquids()
    {
        FluidRegistry.registerFluid(sewage);
        sewageBlock = new LiquidSewage(sewage);
        GameRegistry.registerBlock(sewageBlock, Basemod.MODID + "_" + sewageBlock.getUnlocalizedName().substring(5));
        sewage.setUnlocalizedName(sewageBlock.getUnlocalizedName().substring(5));
    }

}
