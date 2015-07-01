package com.pixelutilities.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.pixelmonmod.pixelmon.config.PixelmonConfig;
import com.pixelmonmod.pixelmon.config.StarterList;
import com.pixelmonmod.pixelmon.customStarters.CustomStarters;
import com.pixelmonmod.pixelmon.enums.EnumPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelutilities.Basemod;

public class PixelUtilitiesConfig {

	private Configuration config;

	private static PixelUtilitiesConfig instance;

	public ConfigCategory general;
	public ConfigCategory starters;

	public boolean coinDrops = false;
	public int currencyDropRate;
	public int moneyWild;
	public int moneyNPC;
	public int moneyPlayer;

	public String BattleMusicURL;
	public boolean battleMusicEnabled;
	public boolean vlcMessage = false;

	public boolean starterListsOn;
	public int starterListNum = 1;
	String[] defaultStarterList = {"Pikachu"};
	String[] pixelmonStarters = new String[15];

	static
	{
		if (instance == null)
		{
			instance = new PixelUtilitiesConfig();
		}
	}

	public static PixelUtilitiesConfig getInstance()
	{
		return instance;
	}

	private PixelUtilitiesConfig()
	{
		//i always forget why this is here and then remember that this way nobody can create one :)
	}

	public Configuration getConfig() {
		return config;
	}

	public void setEvent(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		loadConfig();
		loadOther();
		if(config.hasChanged())
			config.save();
	}

	private void loadConfig()
	{
		general = config.getCategory("general");
		starters = config.getCategory("starters");
		config.addCustomCategoryComment("General", "The general settings for PU");
		config.addCustomCategoryComment("Starters", "Custom \"Starter\" lists");

		coinDrops = config.get("general", "drop PokeCoins?", false,"Enable PixelUtilities coins dropping instead of giving PokeDollars?").getBoolean();
		
		moneyWild = config.get("General", "Wild Pixelmon money value", 0, "How many PokeDollars should Wild Pixelmon give?").getInt();
		moneyNPC = config.get("General", "Trainer NPC money value", 0, "How many PokeDollars should Trainers give?").getInt();
		moneyPlayer = config.get("General", "Player money value", 0, "How many PokeDollars should Players give?").getInt();

		currencyDropRate = config.get("general", "Pixelmon coin drop rate", 4, "default: 4 = 1/100 chance").getInt(4);

		//music
		BattleMusicURL = config.get("General", "BattleMusic URL", "http://www.youtube.com/watch?v=WnkhVPmapc8", "The URL of a song to play when in-battle (no https)").getString();
		battleMusicEnabled = config.get("General", "Battle Music?", false, "Plays the BattleMusicURL when you are in battle").getBoolean(false);

		vlcMessage = config.get("general", "VLC missing message", true, "Displays the message to download VLC when it is missing").getBoolean(true);

		starterListsOn = config.get("Starters", "Have Custom Starter lists?", false, "Allows for custom lists of Pixelmon to give").getBoolean();
		starterListNum = config.get("Starters", "Max Starter Lists", 1, "Sets that maximum amount of custom starter screen lists to allow").getInt();
		populateStarterList();
		String[] starters = config.get("Starters", "Starter Option 0", pixelmonStarters, "Starters for starter screen 0").getStringList();
		
		if(config.hasChanged())
			config.save();
	}

	private void loadOther()
	{
		PixelUtilitiesItems.load(config);
		PixelUtilitiesBlocks.load(config);
		PixelUtilitiesBlocks.addNames();
		PixelUtilitiesItems.addNames();
		PixelUtilitiesLiquids.registerLiquids();
	}

	public String configPath()
	{
		return config.toString();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(Basemod.MODID))
		{
			loadConfig();
		}
	}

	public EnumPokemon[] getStarterList(int listNum) {
		
		if(listNum > starterListNum)
			return null;
		
		switch (listNum) {
		case 0:
			return StarterList.StarterList;
		default:
			String[] starters = config.get("Starters", "Starter Option " + listNum, defaultStarterList, "Starters for starter screen " + listNum).getStringList();
			EnumPokemon[] starterList = new EnumPokemon[starters.length];
			for(int i = 0; i < starters.length; i++)
			{
				EnumPokemon p = EnumPokemon.valueOf(starters[i]);
				starterList[i] = p;
			}
			if(config.hasChanged())
				config.save();
			return starterList;
		}
	}
	
	private void populateStarterList()
	{
		List<String> list = new ArrayList<>();
		for(EnumPokemon p : CustomStarters.starterList)
		{
			list.add(p.name());
		}
		list.toArray(pixelmonStarters);
	}
	
	public boolean isListAddon(int listNum)
	{
		boolean isAddon = config.get("Starters", "Is list " + listNum + " an Extra List?", false, "Is list " + listNum + " an extra list or a starter list? (starters are obtained once)").getBoolean();
		if(config.hasChanged())
			config.save();
		return isAddon;
	}
	
	public EnumPokeballs getPokeballForList(int listNum)
	{
		String pokeballStr = config.get("Starters", "Pokeball for list " + listNum, "PokeBall", "The Pokeball used for list " + listNum).getString();
		if(config.hasChanged())
			config.save();
		pokeballStr = pokeballStr.split("b")[0] + "B" + pokeballStr.split("b")[1];
		pokeballStr = pokeballStr.substring(0, 1).toUpperCase() + pokeballStr.substring(1, pokeballStr.length());
		if(EnumPokeballs.hasPokeball(pokeballStr))
			return EnumPokeballs.valueOf(pokeballStr);
		return EnumPokeballs.PokeBall;
	}

	public int getStarterListLvl(int listNum) {
		int starterLvl = config.get("Starters", "Level for list " + listNum, 5, "The Level of Pixelmon obtained from list " + listNum).getInt();
		if(config.hasChanged())
			config.save();
		return starterLvl;
	}
}
