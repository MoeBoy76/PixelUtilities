package com.pixelutilities;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.version.LibVlcVersion;
import uk.co.caprica.vlcj.version.Version;

import com.pixelutilities.achievements.PixelUtilitiesAchievements;
import com.pixelutilities.commands.AddToGrassCommand;
import com.pixelutilities.commands.PokecheckmeCommand;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.config.PixelUtilitiesRecipes;
import com.pixelutilities.entitys.SeatEntity;
import com.pixelutilities.events.CustomDrops;
import com.pixelutilities.events.PUTickHandler;
import com.pixelutilities.networking.PacketHandler;
import com.pixelutilities.proxies.CommonProxy;
import com.pixelutilities.radioplayer.VLCPlayer;
import com.pixelutilities.tileentitys.*;
import com.pixelutilities.worldgen.*;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Basemod.MODID, name = Basemod.NAME, version = Basemod.VERSION, dependencies = "after:pixelmon")
//change to "after" once we are non dependant
public class Basemod
{

	public static final String MODID = "pixelutilities";
	public static final String NAME = "PixelUtilities";
	public static final String VERSION = "3.3.0";

	public final ToolMaterial FIRESTONE = EnumHelper.addToolMaterial("FIRESTONE", 3, 1561, 8.0F, 3.0F, 10);
	public final ToolMaterial WATERSTONE = EnumHelper.addToolMaterial("WATERSTONE", 3, 1561, 8.0F, 3.0F, 10);
	public final ToolMaterial LEAFSTONE = EnumHelper.addToolMaterial("LEAFSTONE", 2, 250, 6.0F, 2.0F, 14);

	public final ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY", 2, 300, 6.5F, 2, 14);
	public final ToolMaterial SAPHIRE = EnumHelper.addToolMaterial("SAPHIRE", 2, 300, 6.5F, 2, 14);
	public final ToolMaterial AMETHYST = EnumHelper.addToolMaterial("AMETHYST", 2, 300, 6.5F, 2, 14);
	public final ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 2, 300, 6.5F, 2, 14);

	public final ArmorMaterial FIRESTONEA = EnumHelper.addArmorMaterial("FIRESTONEA", 40, new int[]{4, 8, 6, 4}, 10);
	public final ArmorMaterial WATERSTONEA = EnumHelper.addArmorMaterial("WATERSTONEA", 40, new int[]{4, 8, 6, 4}, 10);
	public final ArmorMaterial LEAFSTONEA = EnumHelper.addArmorMaterial("LEAFSTONEA", 15, new int[]{2, 6, 5, 2}, 9);

	public final ArmorMaterial RUBYA = EnumHelper.addArmorMaterial("RUBYA", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial SAPHIREA = EnumHelper.addArmorMaterial("SAPHIREA", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial CRYSTALA = EnumHelper.addArmorMaterial("CRYSTALA", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial SILICONA = EnumHelper.addArmorMaterial("SILICONA", 200, new int[]{3, 7, 6, 3}, 10);

	//Massive chunk of variables to reduce static
	//Items
	public Item pokeCoin1Item;
	public Item pokeCoin5Item;
	public Item pokeCoin10Item;
	public Item pokeCoin50Item;
	public Item pokeCoin100Item;
	public Item bugBadgeItem;
	public Item fightingBadgeItem;
	public Item flyingBadgeItem;
	public Item groundBadgeItem;
	public Item normalBadgeItem;
	public Item poisonBadgeItem;
	public Item rockBadgeItem;
	public Item ghostBadgeItem;
	public Item steelBadgeItem;
	public Item fireBadgeItem;
	public Item waterBadgeItem;
	public Item grassBadgeItem;
	public Item electricBadgeItem;
	public Item darkBadgeItem;
	public Item iceBadgeItem;
	public Item psychicBadgeItem;
	public Item dragonBadgeItem;
	public Item saphireItem;
	public Item rubyItem;
	public Item siliconItem;
	public Item crystalItem;
	public Item cdItem;
	//public Item handHeldRadio;
	public Item amethystItem;
	public Item pixelBoyItem;

	//Ruby Tools
	public Item rubyPickaxe;
	public Item rubyHammer;
	public Item rubyAxe;
	public Item rubyShovel;
	public Item rubyHoe;
	public Item rubySword;

	//Saphire Tools
	public Item saphirePickaxe;
	public Item saphireHammer;
	public Item saphireAxe;
	public Item saphireShovel;
	public Item saphireHoe;
	public Item saphireSword;

	//Amethyst Tools
	public Item amethystPickaxe;
	public Item amethystHammer;
	public Item amethystShovel;
	public Item amethystAxe;
	public Item amethystHoe;
	public Item amethystSword;

	//EvoTools
	//Firestone tools
	public Item firestonePickaxe;
	public Item firestoneHammer;
	public Item firestoneAxe;
	public Item firestoneShovel;
	public Item firestoneHoe;
	public Item firestoneSword;

	//Waterstone tools
	public Item waterstonePickaxe;
	public Item waterstoneHammer;
	public Item waterstoneAxe;
	public Item waterstoneShovel;
	public Item waterstoneHoe;
	public Item waterstoneSword;

	//Leafstone tools
	public Item leafstonePickaxe;
	public Item leafstoneHammer;
	public Item leafstoneAxe;
	public Item leafstoneShovel;
	public Item leafstoneHoe;
	public Item leafstoneSword;

	//Ruby Tools
	public Item crystalPickaxe;
	public Item crystalHammer;
	public Item crystalAxe;
	public Item crystalShovel;
	public Item crystalHoe;
	public Item crystalSword;

	//Armours
	public Item rubyHelm;
    public Item rubyPlate;
    public Item rubyLegs;
    public Item rubyBoots;

    public Item saphireHelm;
    public Item saphirePlate;
    public Item saphireLegs;
    public Item saphireBoots;

    public Item galacticHelm;
    public Item galacticBoots;
    public Item galacticPlate;
    public Item galacticLegs;

    public Item crystalHelm;
    public Item crystalBoots;
    public Item crystalPlate;
    public Item crystalLegs;

    public Item rocketHelm;
    public Item rocketBoots;
    public Item rocketPlate;
    public Item rocketLegs;

    /*
    public Item firestoneHelm;
    public Item firestonePlate;
    public Item firestoneLegs;
    public Item firestoneBoots;

    public Item waterstoneHelm;
    public Item waterstonePlate;
    public Item waterstoneLegs;
    public Item waterstoneBoots;

    public Item leafstoneHelm;
    public Item leafstonePlate;
    public Item leafstoneLegs;
    public Item leafstoneBoots;
    */
	
	//Blocks
    public Block newGrassBlock;
	public Block pokeDirtBlock;
	public Block pokeSandBlock;
	public Block pokeSandC1Block;
	public Block pokeSandC2Block;
	public Block pokeSandC3Block;
	public Block pokeSandC4Block;
	public Block insideMoldingBlock;
	public Block pixelmonGrassBlock;
	public Block shinglesBlock;
	public Block shinglesCorner1Block;
	public Block shinglesCorner2Block;
	public Block treeTopBlock;
	public Block treeBottomBlock;
	public Block pokeSandSide1Block;
	public Block pokeSandSide2Block;
	public Block pokeSandSide3Block;
	public Block pokeSandSide4Block;
	public Block window1Block;
	public Block window2Block;
	public Block woodenFlooringBlock;
	public Block pokeCenterSignBlock;
	public Block pokeMartSignBlock;
	public Block sandyGrassBlock;
	public Block rockBlock;
	public Block caveRockBlock;
	public Block bridgeBlockBlock;
	public Block treeBlock;
	public Block bolderBlock;
	public Block boxBlock;
	public Block rubyOre;
	public Block saphireOre;
	public Block amethystOre;
	public Block crystalOre;
	public Block rubyBlock;
	public Block saphireBlock;
	public Block amethystBlock;
	public Block crystalBlock;
	public Block siliconOre;
	public Block clothedTableBlock;
	public Block pokeballBlock;
	public Block redCusionChairBlock;
	public Block trashcanBlock;
	public Block yellowCusionChairBlock;
	//public Block basicDeskBlock;
	public Block totodilePokedollBlock;
	public Block aronPokedollBlock;
	public Block bisharpPokedollBlock;
	public Block radioBlock;
	public Block gymSignBlock;
	public Block tvBlock;
	public Block blockConveyor;
	public Block blueRugBlock;
	public Block redRugBlock;
	public Block greenRugBlock;
	public Block pokeballStatue;


	//lights
	public Block blueLightBlock;
	public Block redLightBlock;
	public Block purpleLightBlock;
	public Block yellowLightBlock;
	public Block orangeLightBlock;
	public Block whiteLightBlock;
	public Block greenLightBlock;

	public boolean vlcLoaded = false;
	public boolean pixelmonPresent = false;
	public final boolean is64bit = Integer.parseInt(System.getProperty("sun.arch.data.model")) == 64;
	public boolean DEBUGMODE = false;
	public FMLEventChannel channel;
	public static List<VLCPlayer> playerList = new ArrayList<>();
	public static List<VLCPlayer> battleMusicList = new ArrayList<>();
	public VLCPlayer localMusicPlayer = null;

	//In development biome //pokebiome
	//Biomes
	public static BiomeGenBase PokeBiome;

	@Instance(Basemod.MODID)
	public static Basemod instance;

	@SidedProxy(clientSide = "com.pixelutilities.proxies.ClientProxy", serverSide = "com.pixelutilities.proxies.CommonProxy")
	public static CommonProxy proxy;

	PixelUtilitiesConfig config;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		try
		{
			if (Class.forName("com.pixelmonmod.pixelmon.Pixelmon") != null)
				pixelmonPresent = true;
		}
		catch (ClassNotFoundException e)
		{
			FMLLog.warning("Pixelmon mod not found, pixelmon functions disabled.");
		}

		AddMeta(event);
		config = PixelUtilitiesConfig.getInstance();
		config.setEvent(event);
		PixelUtilitiesAchievements.setupAchievements();

		EntityRegistry.registerModEntity(SeatEntity.class, "Seat", 0, this, 3, 1, false);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

		if (event.getSide().equals(Side.CLIENT))
		{
			PUTickHandler tickHandler = new PUTickHandler();

			FMLCommonHandler.instance().bus().register(tickHandler);
			MinecraftForge.EVENT_BUS.register(tickHandler);
			initVLC();
		}

		PacketHandler.init();
	}

	private void initVLC()
	{
		new NativeDiscovery().discover();

		try
		{
			Version vlcVersion = LibVlcVersion.getVersion();
			System.out.println("VLC VERSION " + vlcVersion.toString());
			vlcLoaded = true;
		}
		catch (UnsatisfiedLinkError error)
		{
			System.out.println("You need to install VLC for radio functions.");
		}

	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		GameRegistry.registerTileEntity(TreeEntity.class, "Tree");
		GameRegistry.registerTileEntity(BolderEntity.class, "Bolder");
		GameRegistry.registerTileEntity(BoxEntity.class, "Box");
		GameRegistry.registerTileEntity(ClothedTableEntity.class, "ClothedTable");
		GameRegistry.registerTileEntity(PokeballEntity.class, "Pokeball");
		GameRegistry.registerTileEntity(RedCusionChairEntity.class, "RedCusionChair");
		GameRegistry.registerTileEntity(TrashcanEntity.class, "Trashcan");
		GameRegistry.registerTileEntity(YellowCusionChairEntity.class, "YellowCusionChair");
		GameRegistry.registerTileEntity(TotodilePokedollEntity.class, "TotodileDoll");

		GameRegistry.registerTileEntity(TileEntityRadio.class, "Radio");
		GameRegistry.registerTileEntity(TileEntityConveyor.class, "Conveyor");

		//Ore generation

		GameRegistry.registerWorldGenerator(new RubyGenerator(), 0);
		GameRegistry.registerWorldGenerator(new SaphireGenerator(), 0);
		GameRegistry.registerWorldGenerator(new AmethystGenerator(), 0);
		GameRegistry.registerWorldGenerator(new SiliconGenerator(), 0);
		GameRegistry.registerWorldGenerator(new CrystalGenerator(), 0);

		PixelUtilitiesRecipes recipes = new PixelUtilitiesRecipes();
		recipes.addRecipes();

		rubyOre.setHarvestLevel("pickaxe", 2);
		saphireOre.setHarvestLevel("pickaxe", 2);
		amethystOre.setHarvestLevel("pickaxe", 2);
		siliconOre.setHarvestLevel("pickaxe", 2);
		crystalOre.setHarvestLevel("pickaxe", 2);

		MinecraftForge.EVENT_BUS.register(new CustomDrops());
	}

	@Mod.EventHandler
	public void onServerStart(FMLServerStartingEvent event)
	{
		if (MinecraftServer.getServer().getCommandManager() instanceof ServerCommandManager)
		{
			//((ServerCommandManager) MinecraftServer.getServer().getCommandManager()).registerCommand(new PokecheckmeCommand());
			((ServerCommandManager) MinecraftServer.getServer().getCommandManager()).registerCommand(new AddToGrassCommand());
		}

		if (DEBUGMODE)
		{
			//Here be dragons.
			for (Block block : (Iterable<Block>) GameData.getBlockRegistry())
			{
				if (GameRegistry.findUniqueIdentifierFor(block).modId.equals("minecraft"))
					continue;

				String localName = block.getLocalizedName();

				if (localName.contains("tile"))
				{
					System.out.println("Block " + block.getClass().getName() + " Doesn't seem to have a name set!");
					System.out.println();
				}

				if (block.getCreativeTabToDisplayOn() == null)
				{
					System.out.println("Block " + block.getClass().getName() + " Doesn't seem to have a creative tab set!");
					System.out.println();
				}

			}

			for (Item item : (Iterable<Item>) GameData.getItemRegistry())
			{
				ItemStack itemStack = new ItemStack(item, 0, 1);

				String itemName = item.getItemStackDisplayName(itemStack);

				if (!itemName.getClass().getName().contains(MODID))
					return;

				if (itemName.contains("item."))
				{
					System.out.println("Item " + itemName + " doesn't seem to have a name set");
				}

			}

		}

		//////////////////////////////////////////////////////


	}

	@Mod.EventHandler
	public void serverStop(FMLServerStoppedEvent event) {
		killAllStreams();
	}

	public static void killAllStreams() {
		for (VLCPlayer p : playerList) {
			p.stop();
		}

		for (VLCPlayer p : battleMusicList) {
			p.stop();
		}

		PUTickHandler.playerRadio.stop();
	}

	/**
	 * Add Pack Meta Data
	 */
	private void AddMeta(FMLPreInitializationEvent event) {

		ModMetadata m = event.getModMetadata(); // This is required or it will not work
		m.autogenerated = false; // This is required otherwise it will not work
		m.modId = Basemod.MODID;
		m.version = Basemod.VERSION;
		m.name = Basemod.NAME;
		m.url = "http://www.pixelmonmod.com";
		m.updateUrl = "http://www.pixelmonmod.com";
		m.description = "A mod that adds Pokemon blocks and items into Pixelmon";
		m.authorList.add("AnDwHaT5");
		m.authorList.add("Clienthax");
		m.authorList.add("MoeBoy76");
		m.credits = "The PixelUtilities Team";
	}
}
