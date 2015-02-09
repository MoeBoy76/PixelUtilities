package com.pixelutilities.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import com.pixelutilities.Basemod;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PixelUtilitiesConfig {

	private Configuration config;

	private static PixelUtilitiesConfig instance;

	public ConfigCategory general;
	public ConfigCategory pokegifts;
	public ConfigCategory pokegrass;

	public boolean coinDrops = false;
	public boolean grassBattles = false;
	public boolean onlyGrassSpawns = false;
	public boolean grassGen = false;
	public boolean scalePokes = false;
	public int grassSpawnRate;
	public int coinDropRate;

	public boolean pokeGiftMany = false;

	public String BattleMusicURL;
	public boolean battleMusicEnabled;
	public boolean vlcMessage = false;

	public boolean doEvents = true;
	public boolean isEvent = false;
	public boolean eventLegendaries = false;
	public boolean eventShinies = false;
	public boolean isHalloween = false;
	public boolean isChristmas = false;
	public boolean setEventPlacement = false;
	public String customEventTime = "DD/MM";
	public boolean isCustomHoliday = false;
	public int maxEventPokes = 1;
	public int eventShinyRate = 10;

	public List<String> eventCoords = new ArrayList<>();
	String[] blankArray = {"notConfigured"};
	Property coordsProp;

	public boolean oreGen = true;

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
		pokegifts = config.getCategory("pokegifts");
		pokegrass = config.getCategory("pokegrass");

		config.addCustomCategoryComment("General", "The general settings for PU");
		config.addCustomCategoryComment("PokeGifts", "All the gift settings, including events");
		config.addCustomCategoryComment("PokeGrass", "All the settings for grass battles");

		Property propCoinDrop = config.get("general", "Make Pixelmon drop PokeCoins", false);
		propCoinDrop.comment = "Enable/Disable PixelUtilities coins dropping from wild pokemon";
		coinDrops = propCoinDrop.getBoolean();

		grassBattles = config.get("pokegrass", "Pixelmon spawn in grass", false, "Enables/Disables Pixelmon spawning from PU grass").getBoolean(false);
		onlyGrassSpawns = config.get("pokegrass", "Only spawn Pixelmon in grass", false, "Currently broken :(").getBoolean(false);
		grassSpawnRate = config.get("pokegrass", "Pixelmon grass spawn rate", 200, "Kinda weird ATM").getInt(200);
		coinDropRate = config.get("general", "Pixelmon coin drop rate", 4, "default: 4 = 1/100 chance").getInt(4);
		grassGen = config.get("pokegrass", "Pixelmon grass worldgen", false, "Enables/Disables Pixelmon grass from randomly generating").getBoolean(false);

		//music
		BattleMusicURL = config.get("General", "BattleMusic URL", "http://www.youtube.com/watch?v=WnkhVPmapc8", "The URL of a song to play when in-battle (no https)").getString();
		battleMusicEnabled = config.get("General", "Battle Music?", false, "Plays the BattleMusicURL when you are in battle").getBoolean(false);

		scalePokes = config.get("pokegrass", "Scale encounters to team", false, "random lvl between your lowest and highest party lvls").getBoolean(false);

		pokeGiftMany = config.get("pokegifts", "Are Pokegifts re-usable?", false, "true means many players get the pixelmon").getBoolean(false);

		vlcMessage = config.get("general", "VLC missing message", true, "Displays the message to download VLC when it is missing").getBoolean(true);

		doEvents = config.get("pokegifts", "Have events", true, "Allows PokeGifts to be used (both placing and using)").getBoolean(true);
		isEvent = config.get("pokegifts", "Event load", false, "Should an event pokegift spawn? (only during the 3 weeks around halloween and christmas)").getBoolean(false);
		setEventPlacement = config.get("pokegifts", "Specify event spawns", false, "True to use a specific set of co-ordinates for each pokegift event").getBoolean(false);

		coordsProp = config.get("pokegifts", "Event Co-ords", blankArray, "specify the co-ordinates of the pokegift event chest here");
		eventCoords = Arrays.asList(coordsProp.getStringList());

		eventLegendaries = config.get("pokegifts", "Event has Legendaries", false, "Enable/Disable legendaries from being added to the event pokegift").getBoolean(false);
		eventShinies = config.get("pokegifts","Event has Shinies",false, "Each Pixelmon has a 1/10 chance of being a shiny").getBoolean(false);

		oreGen = config.get("general", "Ore Generation", true, "Allows Ruby, Sapphire, Amethyst, Crystal and Silicon ores to spawn").getBoolean(true);

		customEventTime = config.get("pokegifts", "Custom Event Time", "D/M", "A custom date for pokegift events (day then month)").getString();
		
		maxEventPokes = config.get("pokegifts","Max Event Pixelmon", 1, "Sets the maximum amount of Pixelmon that are in spawned PokeGifts").getInt(1);
		eventShinyRate = config.get("pokegifts", "Event shiny rate", 10, "The rate of shiny pixelmon appearing in a PokeGift (1/x)").getInt(10);
		
		checkTime();

		if(config.hasChanged())
			config.save();
	}

	private void loadOther()
	{
		PixelUtilitiesTools.getInstance().load(config); //Get instance sets it up.
		PixelUtilitiesItems.load(config);
		PixelUtilitiesBlocks.load(config);
		PixelUtilitiesArmor.load(config);
		PixelUtilitiesBlocks.addNames();
		PixelUtilitiesItems.addNames();
		PixelUtilitiesArmor.addNames();
		PixelUtilitiesTools.getInstance().addNames();
		PixelUtilitiesLiquids.registerLiquids();

	}

	public void removePixelmonSpawns(FMLServerStartingEvent event)
	{
		//TODO remove pixelmon from dimension spawn list, or someshit

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

	/**
	 * check if the current time is around Halloween or Christmas
	 */
	private void checkTime()
	{
		Calendar cal = Calendar.getInstance();
		String[] dayMonth = customEventTime.split("/");
		if(dayMonth != null && dayMonth.length == 2)
		{
			if(!(dayMonth[0].equalsIgnoreCase("D") || dayMonth[1].equalsIgnoreCase("M")))
			{				
				int day = Integer.parseInt(dayMonth[0]);
				int month = Integer.parseInt(dayMonth[1]);
				if(cal.get(Calendar.DAY_OF_MONTH) == day && cal.get(Calendar.MONTH) == (month - 1))
				{
					isCustomHoliday = true;
				}
			}
		}

		if((cal.get(Calendar.WEEK_OF_YEAR) >= 42 && cal.get(Calendar.WEEK_OF_YEAR) <= 44))
		{
			isHalloween = true;
		}
		else if((cal.get(Calendar.WEEK_OF_YEAR) >= 50 && cal.get(Calendar.WEEK_OF_YEAR) <= 52))
		{
			isChristmas = true;
		}
	}

	public void disableEventLoading()
	{
		isEvent = false;
		Property eventLoad = config.get("pokegifts", "Event load", false, "Should an event pokegift spawn?");
		eventLoad.set(false);
		isEvent = eventLoad.getBoolean(false);
		if(config.hasChanged())
			config.save();
	}

	/**
	 * 
	 * @param x - x co-ordinate for event pokegift
	 * @param y - y co-ordinate for event pokegift
	 * @param z - z co-ordinate for event pokegift
	 * @param doSpawn - spawn the pokegift after setting the co-ordinates
	 * @return - if event pokegift is able to be placed
	 */
	public boolean setLocation(int x, int y, int z, boolean doSpawn, World world)
	{
		String strX = "" + x;
		String strY = "" + y;
		String strZ = "" + z;

		String[] coords = {strX, strY, strZ};

		eventCoords = Arrays.asList(coords);

		coordsProp = config.get("general", "Event Co-ords", coords, "specify the co-ordinates of the pokegift event chest here");

		config.save();

		if(doSpawn)
		{
			return Basemod.instance.pge.placeEvent(world);
		}
		else
		{
			return true;
		}
	}
}
