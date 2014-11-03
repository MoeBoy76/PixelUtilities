package com.pixelutilities;

import java.util.ArrayList;
import java.util.List;

import com.pixelutilities.config.PixelUtilitiesConfig;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui.ChunkLoaderEntry;
import net.minecraftforge.client.gui.ForgeGuiFactory.ForgeConfigGui.GeneralEntry;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;

public class PixelUtilitiesConfigGui extends GuiConfig
{
	public PixelUtilitiesConfigGui(GuiScreen parentScreen)
	{
		super(parentScreen, new ConfigElement(PixelUtilitiesConfig.getInstance().getConfig().getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Basemod.MODID, false, false, GuiConfig.getAbridgedConfigPath(PixelUtilitiesConfig.getInstance().getConfig().toString()));
	}/*

	private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyCategoryElement("forgeCfg", "pixelutilities.configgui.ctgy.pixelutilitiesConfig", GeneralEntry.class));
        list.add(new DummyCategoryElement("forgeChunkLoadingCfg", "pixelutilities.configgui.ctgy.pixelutilitiesSpawnerConfig", ChunkLoaderEntry.class));
        return list;
    }*/
	
}
