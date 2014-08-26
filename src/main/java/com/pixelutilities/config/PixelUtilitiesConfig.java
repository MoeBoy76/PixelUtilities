package com.pixelutilities.config;

import java.lang.reflect.Modifier;
import java.util.Iterator;

import com.pixelmonmod.pixelmon.entities.npcs.EntityTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelutilities.Basemod;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;

public class PixelUtilitiesConfig {

	private Configuration config;

	private static PixelUtilitiesConfig instance;

	public boolean coinDrops = false;
	public boolean grassBattles = false;
	public boolean onlyGrassSpawns = false;
	public int grassSpawnRate;
	public int coinDropRate;

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

	private PixelUtilitiesConfig() {

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
		config.save();
	}

	private void loadConfig()
	{
		coinDrops = config.get("general", "Make Pixelmon drop PokeCoins", false).getBoolean(false);
		grassBattles = config.get("general", "Allow pixelmon spawning via pixelmon grass", false).getBoolean(false);
		onlyGrassSpawns = config.get("general", "Only spawn Pixelmon in grass", false).getBoolean(false);
		grassSpawnRate = config.get("general", "Pixelmon in grass spawn rate", 200).getInt();
		coinDropRate = config.get("general", "Pixelmon coin drop rate (scaled from 4 to 100)", 4).getInt();

		//music
		BattleMusicURL = config.get("General", "BattleMusic Music Song URL (If youtube make sure http not https)", "http://www.youtube.com/watch?v=WnkhVPmapc8").getString(); //why no https??
		battleMusicEnabled = config.get("General", "Battle Music Enabled", false).getBoolean(false);

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

		if(onlyGrassSpawns && grassBattles)
			removePixelmonSpawns();
	}

	private void removePixelmonSpawns()
	{
		EntityRegistry.removeSpawn(EntityPixelmon.class, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray());
		EntityRegistry.removeSpawn(EntityPixelmon.class, EnumCreatureType.ambient, BiomeGenBase.getBiomeGenArray());
		EntityRegistry.removeSpawn(EntityPixelmon.class, EnumCreatureType.waterCreature, BiomeGenBase.getBiomeGenArray());
		EntityRegistry.removeSpawn("Pixelmon", EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray());
		EntityRegistry.removeSpawn("Pixelmon", EnumCreatureType.ambient, BiomeGenBase.getBiomeGenArray());
		EntityRegistry.removeSpawn("Pixelmon", EnumCreatureType.waterCreature, BiomeGenBase.getBiomeGenArray());
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
