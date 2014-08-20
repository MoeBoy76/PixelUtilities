package com.pixelutilities.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class PixelUtilitiesConfig {

    private Configuration config;

    private static PixelUtilitiesConfig instance;

    public boolean coinDrops = false;
    public boolean grassBattles = false;
    public boolean onlyGrassSpawns = false;
    public int grassSpawnRate;
    public int coinDropRate;
    public boolean lightsOn = true;

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

    public void setEvent(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        loadConfig();
        config.save();
    }

    private void loadConfig() {
        
        coinDrops = config.get("general", "Make Pixelmon drop PokeCoins", false).getBoolean(false);
        grassBattles = config.get("general", "Allow pixelmon spawning blocks to spawn pixelmon", true).getBoolean(true);
        onlyGrassSpawns = config.get("general", "Only spawn Pixelmon in grass", false).getBoolean(false);
        grassSpawnRate = config.get("general", "Pixelmon in grass spawn rate", 200).getInt();
        coinDropRate = config.get("general", "Pixelmon coin drop rate", 4).getInt();
        lightsOn = config.get("general", "Do you want the lights?", true).getBoolean(true);

        //music
        BattleMusicURL = config.get("General", "BattleMusic Music Song URL (If youtube make sure http not https)", "http://www.youtube.com/watch?v=WnkhVPmapc8").getString();
        battleMusicEnabled = config.get("General", "Battle Music Enabled", true).getBoolean(true);
        
        PixelUtilitiesTools.getInstance().load(config); //Get instance sets it up.
        PixelUtilitiesItems.load(config);
        PixelUtilitiesBlocks.load(config);
        PixelUtilitiesArmor.load(config);
        PixelUtilitiesBlocks.addNames();
        PixelUtilitiesItems.addNames();
        PixelUtilitiesArmor.addNames();
        PixelUtilitiesTools.getInstance().addNames();
        PixelUtilitiesLiquids.registerLiquids();
        
        config.save();
    }

}