package com.pixelutilities.config;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

import com.pixelmonmod.pixelmon.entities.npcs.EntityTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelutilities.Basemod;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class PixelUtilitiesConfig {

	private Configuration config;

	private static PixelUtilitiesConfig instance;

	public boolean coinDrops = false;
	public boolean grassBattles = false;
	public boolean onlyGrassSpawns = false;
	public boolean scalePokes = false;
	public int grassSpawnRate;
	public int coinDropRate;
	
	public boolean pokeGiftMany = false;
	public boolean noStarterScreen = false;

	public String BattleMusicURL;
	public boolean battleMusicEnabled;

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
		Property propCoinDrop = config.get("general", "Make Pixelmon drop PokeCoins", false);
		propCoinDrop.comment = "Enable/Disable PixelUtilities coins dropping from wild pokemon";
		coinDrops = propCoinDrop.getBoolean();
		
		grassBattles = config.get("general", "Allow pixelmon spawning via pixelmon grass", false, "Enables/Disables Pixelmon spawning from PU grass").getBoolean(false);
		onlyGrassSpawns = config.get("general", "Only spawn Pixelmon in grass", false, "Currently broken :(").getBoolean(false);
		grassSpawnRate = config.get("general", "Pixelmon in grass spawn rate", 200, "Kinda weird ATM").getInt(200);
		coinDropRate = config.get("general", "Pixelmon coin drop rate", 4, "default: 4 = 1/100 chance").getInt(4);
		
		//music
		BattleMusicURL = config.get("General", "BattleMusic Song URL (If youtube make sure not https)", "http://www.youtube.com/watch?v=WnkhVPmapc8", "The URL of a song to play when in-battle").getString(); //why no https??
		battleMusicEnabled = config.get("General", "Battle Music?", false, "Plays the BattleMusicURL when you are in battle").getBoolean(false);
		
		scalePokes = config.get("general", "Scale grass encounters to team", false, "random lvl between your lowest and highest party lvls").getBoolean(false);
		
		pokeGiftMany = config.get("general", "Are Pokegifts re-usable?", false, "true means many players get the pixelmon").getBoolean(false);
		
		noStarterScreen = config.get("general", "Break the starter screen", false, "Makes the starter screen do nothing").getBoolean(false);

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
		//TODO remove pixelmon from dimension spawn list
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(Basemod.MODID))
		{
			loadConfig();
		}
	}
}
