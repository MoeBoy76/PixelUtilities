package com.pixelutilities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

import com.pixelutilities.config.PixelUtilitiesConfig;

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
		list.add(new DummyCategoryElement("Starters", "pixelutilities.gui.config.starters", StarterEntry.class));
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
	
	public static class StarterEntry extends CategoryEntry
	{

		public StarterEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
		{
			super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen()
		{
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(PixelUtilitiesConfig.getInstance().starters)).getChildElements(),
					this.owningScreen.modID, PixelUtilitiesConfig.getInstance().configPath(), this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
					"Starters");
		}
	}
}
