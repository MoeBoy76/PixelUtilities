package com.pixelutilities;

import java.util.List;

import com.pixelutilities.config.PixelUtilitiesConfig;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class PixelUtilitiesConfigGui extends GuiConfig
{
	public PixelUtilitiesConfigGui(GuiScreen parentScreen)
	{
		super(parentScreen, new ConfigElement(PixelUtilitiesConfig.getInstance().getConfig().getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Basemod.MODID, false, false, GuiConfig.getAbridgedConfigPath(PixelUtilitiesConfig.getInstance().getConfig().toString()));
	}

}
