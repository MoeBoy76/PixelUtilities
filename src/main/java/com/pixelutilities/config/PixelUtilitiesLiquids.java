package com.pixelutilities.config;

import com.pixelutilities.Basemod;
import com.pixelutilities.liquids.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockLiquid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class PixelUtilitiesLiquids {

    public static Fluid sewage = new Fluid("sewage");

    public static void registerLiquids()
    {
        FluidRegistry.registerFluid(sewage);
        LiquidSewage sewageBlock = new LiquidSewage(sewage);
        GameRegistry.registerBlock(sewageBlock, Basemod.MODID + "_" + sewageBlock.getUnlocalizedName().substring(5));
        sewage.setUnlocalizedName(sewageBlock.getUnlocalizedName());
    }

}
