package com.pixelutilities;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.version.LibVlcVersion;
import uk.co.caprica.vlcj.version.Version;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelutilities.achievements.PixelUtilitiesAchievements;
import com.pixelutilities.commands.AddToDrops;
import com.pixelutilities.commands.AddToGrassCommand;
import com.pixelutilities.commands.EventLocation;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.config.PixelUtilitiesRecipes;
import com.pixelutilities.entitys.SeatEntity;
import com.pixelutilities.events.CustomDrops;
import com.pixelutilities.events.FallEliminator;
import com.pixelutilities.events.MissingMappingsHandler;
import com.pixelutilities.events.PUTickHandler;
import com.pixelutilities.events.PokegiftEventGen;
import com.pixelutilities.networking.PacketHandler;
import com.pixelutilities.proxies.CommonProxy;
import com.pixelutilities.radioplayer.VLCPlayer;
import com.pixelutilities.tileentitys.AronPokedollEntity;
import com.pixelutilities.tileentitys.BlueRugEntity;
import com.pixelutilities.tileentitys.BolderEntity;
import com.pixelutilities.tileentitys.BoxEntity;
import com.pixelutilities.tileentitys.ClothedTableEntity;
import com.pixelutilities.tileentitys.GreenRugEntity;
import com.pixelutilities.tileentitys.GymSignEntity;
import com.pixelutilities.tileentitys.PokeballEntity;
import com.pixelutilities.tileentitys.PokeballStatueTileEntity;
import com.pixelutilities.tileentitys.PokegiftEntity;
import com.pixelutilities.tileentitys.RedCusionChairEntity;
import com.pixelutilities.tileentitys.RedRugEntity;
import com.pixelutilities.tileentitys.TVEntity;
import com.pixelutilities.tileentitys.TileEntityConveyor;
import com.pixelutilities.tileentitys.TileEntityRadio;
import com.pixelutilities.tileentitys.TotodilePokedollEntity;
import com.pixelutilities.tileentitys.TrashcanEntity;
import com.pixelutilities.tileentitys.TreeEntity;
import com.pixelutilities.tileentitys.YellowCusionChairEntity;
import com.pixelutilities.worldgen.*;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Basemod.MODID, name = Basemod.NAME, version = Basemod.VERSION, dependencies = "after:pixelmon", guiFactory="com.pixelutilities.PixelUtilitiesGuiFactory")
public class Basemod
{
	public static final String MODID = "pixelutilities";
	public static final String NAME = "PixelUtilities";
	public static final String VERSION = "3.3.6";

	/*public final ToolMaterial FIRESTONE = EnumHelper.addToolMaterial("FIRESTONE", 3, 1561, 8.0F, 3.0F, 10);
	public final ToolMaterial WATERSTONE = EnumHelper.addToolMaterial("WATERSTONE", 3, 1561, 8.0F, 3.0F, 10);
	public final ToolMaterial LEAFSTONE = EnumHelper.addToolMaterial("LEAFSTONE", 2, 250, 6.0F, 2.0F, 14);
	public final ToolMaterial THUNDERSTONE = EnumHelper.addToolMaterial("THUNDERSTONE", 3, 1561, 8.0F, 3.0F, 10);
	public final ToolMaterial MOONSTONE = EnumHelper.addToolMaterial("MOONSTONE", 2, 500, 6.0F, 2.0F, 14);
	public final ToolMaterial SUNSTONE = EnumHelper.addToolMaterial("SUNSTONE", 3, 1561, 8.0F, 3.0F, 10);*/

	public final ToolMaterial ELEMENTSTONE = EnumHelper.addToolMaterial("ELEMENTSTONE", 3, 1561, 12.0F, 0.0F, 22);

	public final ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY", 2, 300, 6.5F, 2, 14);
	public final ToolMaterial SAPHIRE = EnumHelper.addToolMaterial("SAPHIRE", 2, 300, 6.5F, 2, 14);
	public final ToolMaterial AMETHYST = EnumHelper.addToolMaterial("AMETHYST", 2, 300, 6.5F, 2, 14);
	public final ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 2, 300, 6.5F, 2, 14);

	/*public final ArmorMaterial FIRESTONEA = EnumHelper.addArmorMaterial("FIRESTONE", 40, new int[]{4, 8, 6, 4}, 10);
	public final ArmorMaterial WATERSTONEA = EnumHelper.addArmorMaterial("WATERSTONE", 40, new int[]{4, 8, 6, 4}, 10);
	public final ArmorMaterial LEAFSTONEA = EnumHelper.addArmorMaterial("LEAFSTONE", 15, new int[]{2, 6, 5, 2}, 9);*/

	public final ArmorMaterial ELEMENTSTONE1 = EnumHelper.addArmorMaterial("ELEMENTSTONE1", 40, new int[]{4, 8, 6, 4}, 0);
	public final ArmorMaterial ELEMENTSTONE2 = EnumHelper.addArmorMaterial("ELEMENTSTONE2", 15, new int[]{3, 7, 6, 3}, 0);


	public final ArmorMaterial RUBYA = EnumHelper.addArmorMaterial("RUBY", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial SAPHIREA = EnumHelper.addArmorMaterial("SAPHIRE", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial CRYSTALA = EnumHelper.addArmorMaterial("CRYSTAL", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial SILICONA = EnumHelper.addArmorMaterial("SILICON", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial AMETHYSTA = EnumHelper.addArmorMaterial("AMETHYST", 200, new int[]{3, 7, 6, 3}, 10);

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
	public Item amethystItem;
	public static Item pixelBoyItem;

	//Ruby Tools
	public static Item rubyPickaxe;
	public static Item rubyHammer;
	public static Item rubyAxe;
	public static Item rubyShovel;
	public static Item rubyHoe;
	public static Item rubySword;

	//Saphire Tools
	public static Item saphirePickaxe;
	public static Item saphireHammer;
	public static Item saphireAxe;
	public static Item saphireShovel;
	public static Item saphireHoe;
	public static Item saphireSword;

	//Amethyst Tools
	public static Item amethystPickaxe;
	public static Item amethystHammer;
	public static Item amethystShovel;
	public static Item amethystAxe;
	public static Item amethystHoe;
	public static Item amethystSword;

	public static Item crystalPickaxe;
	public static Item crystalHammer;
	public static Item crystalAxe;
	public static Item crystalShovel;
	public static Item crystalHoe;
	public static Item crystalSword;

	//EvoTools
	//Firestone tools
	public static Item firestonePickaxe;
	public static Item firestoneHammer;
	public static Item firestoneAxe;
	public static Item firestoneShovel;
	public static Item firestoneHoe;
	public static Item firestoneSword;

	//Waterstone tools
	public static Item waterstonePickaxe;
	public static Item waterstoneHammer;
	public static Item waterstoneAxe;
	public static Item waterstoneShovel;
	public static Item waterstoneHoe;
	public static Item waterstoneSword;

	//Leafstone tools
	public static Item leafstonePickaxe;
	public static Item leafstoneHammer;
	public static Item leafstoneAxe;
	public static Item leafstoneShovel;
	public static Item leafstoneHoe;
	public static Item leafstoneSword;

	public static Item thunderstonePickaxe;
	public static Item thunderstoneHammer;
	public static Item thunderstoneAxe;
	public static Item thunderstoneShovel;
	public static Item thunderstoneHoe;
	public static Item thunderstoneSword;

	public static Item moonstonePickaxe;
	public static Item moonstoneHammer;
	public static Item moonstoneAxe;
	public static Item moonstoneShovel;
	public static Item moonstoneHoe;
	public static Item moonstoneSword;

	public static Item sunstonePickaxe;
	public static Item sunstoneHammer;
	public static Item sunstoneAxe;
	public static Item sunstoneShovel;
	public static Item sunstoneHoe;
	public static Item sunstoneSword;

	public static Item dawnstonePickaxe;
	public static Item dawnstoneHammer;
	public static Item dawnstoneAxe;
	public static Item dawnstoneShovel;
	public static Item dawnstoneHoe;
	public static Item dawnstoneSword;

	//Armours
	public static Item rubyHelm;
	public static Item rubyPlate;
	public static Item rubyLegs;
	public static Item rubyBoots;

	public static Item saphireHelm;
	public static Item saphirePlate;
	public static Item saphireLegs;
	public static Item saphireBoots;

	public static Item galacticHelm;
	public static Item galacticBoots;
	public static Item galacticPlate;
	public static Item galacticLegs;

	public static Item crystalHelm;
	public static Item crystalBoots;
	public static Item crystalPlate;
	public static Item crystalLegs;
	
	public static Item neoHelm;
	public static Item neoBoots;
	public static Item neoPlate;
	public static Item neoLegs;

	public static Item rocketHelm;
	public static Item rocketBoots;
	public static Item rocketPlate;
	public static Item rocketLegs;


	public static Item firestoneHelm;
	public static Item firestonePlate;
	public static Item firestoneLegs;
	public static Item firestoneBoots;

	public static Item waterstoneHelm;
	public static Item waterstonePlate;
	public static Item waterstoneLegs;
	public static Item waterstoneBoots;

	public static Item leafstoneHelm;
	public static Item leafstonePlate;
	public static Item leafstoneLegs;
	public static Item leafstoneBoots;

	public static Item thunderstoneHelm;
	public static Item thunderstonePlate;
	public static Item thunderstoneLegs;
	public static Item thunderstoneBoots;

	public static Item sunstoneHelm;
	public static Item sunstonePlate;
	public static Item sunstoneLegs;
	public static Item sunstoneBoots;

	public static Item moonstoneHelm;
	public static Item moonstonePlate;
	public static Item moonstoneLegs;
	public static Item moonstoneBoots;

	public static Item dawnstoneHelm;
	public static Item dawnstonePlate;
	public static Item dawnstoneLegs;
	public static Item dawnstoneBoots;

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
	public static ArrayList<VLCPlayer> playerList = new ArrayList<>();
	public static ArrayList<VLCPlayer> battleMusicList = new ArrayList<>();
	public VLCPlayer localMusicPlayer = null;
	
	//this holds players battling in grass
	public HashMap<String, ArrayList<String>> grassBattlers = new HashMap<String, ArrayList<String>>();

	@Instance(Basemod.MODID)
	public static Basemod instance;

	@SidedProxy(clientSide = "com.pixelutilities.proxies.ClientProxy", serverSide = "com.pixelutilities.proxies.CommonProxy")
	public static CommonProxy proxy;

	PixelUtilitiesConfig config;
	
	public PokegiftEventGen pge;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		try
		{
			if (Class.forName("com.pixelmonmod.pixelmon.Pixelmon") != null)
				pixelmonPresent = true;
		}
		catch (ClassNotFoundException e)
		{
			FMLLog.warning("Pixelmon mod not found, pixelmon functions disabled.");
		}

		if(pixelmonPresent)
		{
			Pixelmon.EVENT_BUS.register(CustomDrops.getInstance());
			if(event.getSide().equals(Side.CLIENT))
				Pixelmon.EVENT_BUS.register(new PUTickHandler());
		}

		AddMeta(event);
		config = PixelUtilitiesConfig.getInstance();
		config.setEvent(event);
		pge = new PokegiftEventGen();
		PixelUtilitiesAchievements.setupAchievements();

		EntityRegistry.registerModEntity(SeatEntity.class, "Seat", 0, this, 3, 1, false);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		if (event.getSide().equals(Side.CLIENT))
		{
			FMLCommonHandler.instance().bus().register(config);

			PUTickHandler tickHandler = new PUTickHandler();
			FMLCommonHandler.instance().bus().register(tickHandler);
			MinecraftForge.EVENT_BUS.register(tickHandler);
			
			initVLC();
		}
		
		FMLCommonHandler.instance().bus().register(new PixelUtilitiesAchievements());
		MinecraftForge.EVENT_BUS.register(new FallEliminator());
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

	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();

		GameRegistry.registerTileEntity(TreeEntity.class, "Tree");
		GameRegistry.registerTileEntity(BolderEntity.class, "Boulder");
		GameRegistry.registerTileEntity(BoxEntity.class, "Box");
		GameRegistry.registerTileEntity(ClothedTableEntity.class, "ClothedTable");
		GameRegistry.registerTileEntity(PokeballEntity.class, "Pokeball");
		GameRegistry.registerTileEntity(RedCusionChairEntity.class, "RedCusionChair");
		GameRegistry.registerTileEntity(TrashcanEntity.class, "Trashcan");
		GameRegistry.registerTileEntity(YellowCusionChairEntity.class, "YellowCusionChair");
		GameRegistry.registerTileEntity(TotodilePokedollEntity.class, "TotodileDoll");
		
		//where the hell did these disappear from?
		GameRegistry.registerTileEntity(AronPokedollEntity.class, "AronDoll");
		GameRegistry.registerTileEntity(GymSignEntity.class, "GymSign");
		GameRegistry.registerTileEntity(TVEntity.class, "TV");
		GameRegistry.registerTileEntity(BlueRugEntity.class, "BlueRug");
		GameRegistry.registerTileEntity(RedRugEntity.class, "RedRug");
		GameRegistry.registerTileEntity(GreenRugEntity.class, "GreenRug");
		
		GameRegistry.registerTileEntity(PokeballStatueTileEntity.class, "PokeballStatue");
				
		GameRegistry.registerTileEntity(TileEntityRadio.class, "Radio");
		GameRegistry.registerTileEntity(TileEntityConveyor.class, "Conveyor");

		GameRegistry.registerTileEntity(PokegiftEntity.class, "Pokegift");

		if(config.oreGen)
		{
			//Ore generation
			GameRegistry.registerWorldGenerator(new RubyGenerator(), 3);
			GameRegistry.registerWorldGenerator(new SaphireGenerator(), 3);
			GameRegistry.registerWorldGenerator(new AmethystGenerator(), 3);
			GameRegistry.registerWorldGenerator(new SiliconGenerator(), 3);
			GameRegistry.registerWorldGenerator(new CrystalGenerator(), 3);
		}
		
		if(config.grassGen)
			GameRegistry.registerWorldGenerator(new PixelmonGrassGenerator(), 3);

		PixelUtilitiesRecipes recipes = new PixelUtilitiesRecipes();
		recipes.addRecipes();

		PixelUtilitiesBlocks.rubyOre.setHarvestLevel("pickaxe", 2);
		PixelUtilitiesBlocks.saphireOre.setHarvestLevel("pickaxe", 2);
		PixelUtilitiesBlocks.amethystOre.setHarvestLevel("pickaxe", 2);
		PixelUtilitiesBlocks.siliconOre.setHarvestLevel("pickaxe", 2);
		PixelUtilitiesBlocks.crystalOre.setHarvestLevel("pickaxe", 2);

	}

	@Mod.EventHandler
	public void onServerStart(FMLServerStartingEvent event)
	{		
		event.registerServerCommand(new AddToDrops());
		event.registerServerCommand(new AddToGrassCommand());
		event.registerServerCommand(new EventLocation());

		if(config.doEvents && config.isEvent && pixelmonPresent)
		{
			World world = event.getServer().worldServerForDimension(0);
			pge.generate(world);
		}
		
		if (DEBUGMODE)
		{
			//Here be dragons.
			for (Block block : (Iterable<Block>) GameData.getBlockRegistry())
			{
				if (!GameRegistry.findUniqueIdentifierFor(block).modId.equals("minecraft"))
					continue;

				if(block.delegate.name().contains("minecraft"))
					continue;
				
				String localName = block.getLocalizedName();

				if (localName.contains("tile"))
				{
					System.out.println("Block " + block.getClass().getName() + " Doesn't seem to have a name set!");
					System.out.println();
					System.out.println(localName);
					System.out.println();
				}

				/*if (block.getCreativeTabToDisplayOn() == null)
				{
					System.out.println("Block " + block.getClass().getName() + " Doesn't seem to have a creative tab set!");
					System.out.println();
				}*/

			}

			for (Item item : (Iterable<Item>) GameData.getItemRegistry())
			{
				ItemStack itemStack = new ItemStack(item, 0, 1);

				String itemName = item.getItemStackDisplayName(itemStack);

				//if (!GameRegistry.findUniqueIdentifierFor(item).modId.equals(MODID))
				//	continue;

				if (itemName.contains("item."))
				{
					System.out.println("Item " + itemName + " doesn't seem to have a name set");
					System.out.println();
				}

			}
			System.out.println("Debug complete!");
		}
		//////////////////////////////////////////////////////


	}

	/*@Mod.EventHandler
	public void onServerStarted(FMLServerStartedEvent event)
	{
		event.getModState(); //this is here for when i check the debug
	}*/

	@Mod.EventHandler
	public void serverStop(FMLServerStoppedEvent event) {
		killAllStreams();
	}

	/**
	 * Fix dem spaces and don't break saves, ty Haxxy
	 * 
	 * @param event
	 */
	@Mod.EventHandler
	public void processMissingMapping(FMLMissingMappingsEvent event) {
		MissingMappingsHandler.processMissingMapping(event);
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
		m.url = "";
		m.updateUrl = "";
		//m.description = "A mod that adds Pokemon blocks and items into Pixelmon";
		//m.description = "Happy Halloween >=D";
		m.description = "Welcome to Pixeltopia";
		m.authorList.add("AnDwHaT5");
		m.authorList.add("Clienthax");
		m.authorList.add("MoeBoy76");
		m.credits = "The PixelUtilities Team";
	}
}
