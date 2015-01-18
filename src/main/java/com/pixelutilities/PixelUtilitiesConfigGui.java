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
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;

public class PixelUtilitiesConfigGui extends GuiConfig
{
	public PixelUtilitiesConfigGui(GuiScreen parentScreen)
	{
		super(parentScreen, getConfigElements(), Basemod.MODID, false, false, GuiConfig.getAbridgedConfigPath(PixelUtilitiesConfig.getInstance().getConfig().toString()));
	}
	
	private static List<IConfigElement> getConfigElements()
	{
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyCategoryElement("General", "pixelutilities.gui.config.general", GeneralEntry.class));
		list.add(new DummyCategoryElement("PokeGifts", "pixelutilities.gui.config.pokegifts", PokeGiftEntry.class));
		list.add(new DummyCategoryElement("PokeGrass", "pixelutilities.gui.config.pokegrass", PokeGrassEntry.class));
		return list;
	}

	public static class GeneralEntry extends CategoryEntry
	{

		public GeneralEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
		{
			super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen()
		{
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(PixelUtilitiesConfig.getInstance().general)).getChildElements(),
					this.owningScreen.modID, PixelUtilitiesConfig.getInstance().configPath(), this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
					"General");
		}
	}
	
	public static class PokeGiftEntry extends CategoryEntry
	{

		public PokeGiftEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
		{
			super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen()
		{
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(PixelUtilitiesConfig.getInstance().pokegifts)).getChildElements(),
					this.owningScreen.modID, PixelUtilitiesConfig.getInstance().configPath(), this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
					"PokeGifts");
		}
	}
	
	public static class PokeGrassEntry extends CategoryEntry
	{

		public PokeGrassEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
		{
			super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen()
		{
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(PixelUtilitiesConfig.getInstance().pokegrass)).getChildElements(),
					this.owningScreen.modID, PixelUtilitiesConfig.getInstance().configPath(), this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
					"PokeGrass");
		}
	}
}
