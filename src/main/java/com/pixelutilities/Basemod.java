package com.pixelutilities;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.version.LibVlcVersion;
import uk.co.caprica.vlcj.version.Version;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelutilities.commands.AddToDrops;
import com.pixelutilities.commands.StarterScreen;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.config.PixelUtilitiesRecipes;
import com.pixelutilities.events.CustomDrops;
import com.pixelutilities.events.MissingMappingsHandler;
import com.pixelutilities.events.PUTickHandler;
import com.pixelutilities.events.StandardTickHandler;
import com.pixelutilities.networking.PacketHandler;
import com.pixelutilities.packets.PacketRegistry;
import com.pixelutilities.proxies.CommonProxy;
import com.pixelutilities.radioplayer.VLCPlayer;
import com.pixelutilities.tileentitys.PokeballEntity;
import com.pixelutilities.tileentitys.TileEntityConveyor;
import com.pixelutilities.tileentitys.TileEntityRadio;

@Mod(modid = Basemod.MODID, name = Basemod.NAME, version = Basemod.VERSION, dependencies = "after:pixelmon", guiFactory="com.pixelutilities.PixelUtilitiesGuiFactory")
public class Basemod
{
	public static final String MODID = "pixelutilities";
	public static final String NAME = "PixelUtilities";
	public static final String VERSION = "3.3.8";

	//public final ToolMaterial ELEMENTSTONE = EnumHelper.addToolMaterial("ELEMENTSTONE", 3, 1561, 12.0F, 0.0F, 22);

	//public final ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY", 2, 300, 6.5F, 2, 14);
	//public final ToolMaterial SAPHIRE = EnumHelper.addToolMaterial("SAPHIRE", 2, 300, 6.5F, 2, 14);
	//public final ToolMaterial AMETHYST = EnumHelper.addToolMaterial("AMETHYST", 2, 300, 6.5F, 2, 14);
	//public final ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 2, 300, 6.5F, 2, 14);

	/*public final ArmorMaterial ELEMENTSTONE1 = EnumHelper.addArmorMaterial("ELEMENTSTONE1", 40, new int[]{4, 8, 6, 4}, 0);
	public final ArmorMaterial ELEMENTSTONE2 = EnumHelper.addArmorMaterial("ELEMENTSTONE2", 15, new int[]{3, 7, 6, 3}, 0);

	public final ArmorMaterial RUBYA = EnumHelper.addArmorMaterial("RUBY", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial SAPHIREA = EnumHelper.addArmorMaterial("SAPHIRE", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial CRYSTALA = EnumHelper.addArmorMaterial("CRYSTAL", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial SILICONA = EnumHelper.addArmorMaterial("SILICON", 200, new int[]{3, 7, 6, 3}, 10);
	public final ArmorMaterial AMETHYSTA = EnumHelper.addArmorMaterial("AMETHYST", 200, new int[]{3, 7, 6, 3}, 10);*/

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
	public static Item pixelBoyItem;

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
	public final String osType = System.getProperty("os.name");
	public boolean DEBUGMODE = false;
	public static ArrayList<VLCPlayer> playerList = new ArrayList<>();
	public static ArrayList<VLCPlayer> battleMusicList = new ArrayList<>();
	public VLCPlayer localMusicPlayer = null;

	@Mod.Instance(Basemod.MODID)
	public static Basemod instance;
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@SidedProxy(clientSide = "com.pixelutilities.proxies.ClientProxy", serverSide = "com.pixelutilities.proxies.CommonProxy")
	public static CommonProxy proxy;

	PixelUtilitiesConfig config;

	public static SimpleNetworkWrapper network;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Basemod.MODID);
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
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		if (event.getSide().equals(Side.CLIENT))
		{
			FMLCommonHandler.instance().bus().register(config);

			StandardTickHandler tickHandler = new StandardTickHandler();
			FMLCommonHandler.instance().bus().register(tickHandler);
			MinecraftForge.EVENT_BUS.register(tickHandler);

			initVLC();
		}

		PacketHandler.init();
		PacketRegistry.registerPackets();
	}

	private void initVLC()
	{
		new NativeDiscovery().discover();

		try
		{
			Version vlcVersion = LibVlcVersion.getVersion();
			//System.out.println("VLC VERSION " + vlcVersion.toString());
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
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		proxy.registerRenderThings();

		GameRegistry.registerTileEntity(PokeballEntity.class, "Pokeball");

		//GameRegistry.registerTileEntity(PokeballStatueTileEntity.class, "PokeballStatue");

		GameRegistry.registerTileEntity(TileEntityRadio.class, "Radio");
		GameRegistry.registerTileEntity(TileEntityConveyor.class, "Conveyor");


		PixelUtilitiesRecipes recipes = new PixelUtilitiesRecipes();
		recipes.addRecipes();

	}

	@Mod.EventHandler
	public void onServerStart(FMLServerStartingEvent event)
	{		
		event.registerServerCommand(new AddToDrops());
		event.registerServerCommand(new StarterScreen());

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

				if (!GameRegistry.findUniqueIdentifierFor(item).modId.equals(MODID))
					continue;

				if (itemName.contains("item."))
				{
					System.out.println("Item " + itemName + " doesn't seem to have a name set");
					System.out.println();
				}

				if(item.getCreativeTab() == null)
				{
					System.out.println("Item " + itemName + " doesn't seem to have a creative tab set");
					System.out.println();
				}
			}
			System.out.println("Debug complete!");
		}
		//////////////////////////////////////////////////////
	}

	@Mod.EventHandler
	public void onServerStarted(FMLServerStartedEvent event)
	{

	}

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
		//m.description = "Welcome to Pixeltopia";
		m.description = "Free Starter Screens!";
		m.authorList.add("AnDwHaT5");
		m.authorList.add("Clienthax");
		m.authorList.add("MoeBoy76");
		m.credits = "The PixelUtilities Team";
	}
}
