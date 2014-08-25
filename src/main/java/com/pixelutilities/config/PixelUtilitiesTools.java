package com.pixelutilities.config;

import com.pixelutilities.Basemod;
import com.pixelutilities.items.tools.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class PixelUtilitiesTools
{

	//Ruby Tools
	/*public Item rubyPickaxe;
	public Item rubyHammer;
	public Item rubyAxe;
	public Item rubyShovel;
	public Item rubyHoe;
	public Item rubySword;

	//Saphire Tools
	public Item saphirePickaxe;
	public Item saphireHammer;// new com.PixelUtilities.tools.SaphireHammerTool(6052, Basemod.instance.SAPHIRE, "saphireHammer", "Saphire Hammer").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("saphireHammer");
	public Item saphireAxe;// new com.PixelUtilities.tools.SaphireAxeTool(6053, Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireAxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("saphireAxe");
	public Item saphireShovel;// new com.PixelUtilities.tools.SaphireShovelTool(6054, Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireShovel").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("saphireShovel");
	public Item saphireHoe;// new com.PixelUtilities.tools.SaphireHoeTool(6055, Basemod.instance.SAPHIRE, "PixelUtilities:SaphireHoe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("saphireHoe");
	public Item saphireSword;// new com.PixelUtilities.tools.SaphireSwordTool(6056, Basemod.instance.SAPHIRE, "PixelUtilities:SaphireSword").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("saphireSword");

	//Amethyst Tools
	public Item amethystPickaxe;// new com.PixelUtilities.tools.AmethystPickaxeTool(6057, 6.5F, Basemod.instance.AMETHYST, "PixelUtilities:AmethystPickaxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("amethystPickaxe");
	public Item amethystHammer;// new com.PixelUtilities.tools.AmethystHammerTool(6058, Basemod.instance.AMETHYST, "AmethystHammer", "Amethyst Hammer").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("amethystHammer").setTextureName("PixelUtilities:AmethystHammer");
	public Item amethystShovel;// new com.PixelUtilities.tools.AmethystShovelTool(6059, Basemod.instance.AMETHYST, "PixelUtilities:AmethystShovel").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("amethystShovel");
	public Item amethystAxe;// new com.PixelUtilities.tools.AmethystAxeTool(6060, Basemod.instance.AMETHYST, "PixelUtilities:AmethystAxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("amethystAxe");
	public Item amethystHoe;// new com.PixelUtilities.tools.AmethystHoeTool(6061, Basemod.instance.AMETHYST, "PixelUtilities:AmethystHoe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("amethystHoe");
	public Item amethystSword;// new com.PixelUtilities.tools.AmethystSwordTool(6062, Basemod.instance.AMETHYST, "PixelUtilities:AmethystSword").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("amethystSword");

	//EvoTools
	//Firestone tools
	public Item FirestonePickaxe;// new com.PixelUtilities.tools.FirestonePickaxe(6083, 6.5F, ELEMENTSTONE, "pixelutilities:tools/FirestonePickaxe").setTextureName("PixelUtilities:FirestonePickaxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("FirestonePickaxe");
	public Item FirestoneHammer;// new com.PixelUtilities.tools.FirestoneHammer(6084, ELEMENTSTONE, "FirestoneHammer", "Firestone Hammer").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setTextureName("PixelUtilities:FirestoneHammer").setUnlocalizedName("FirestoneHammer");
	public Item FirestoneAxe;// new com.PixelUtilities.tools.FirestoneAxe(6085, ELEMENTSTONE, "pixelutilities:tools/FirestoneAxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("FirestoneAxe").setTextureName("PixelUtilities:FirestoneAxe");
	public Item FirestoneShovel;// new com.PixelUtilities.tools.FirestoneShovel(6086, ELEMENTSTONE, "pixelutilities:tools/FirestoneShovel").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("FirestoneShovel").setTextureName("PixelUtilities:FirestoneShovel");
	public Item FirestoneHoe;// new com.PixelUtilities.tools.FirestoneHoe(6087, ELEMENTSTONE, "pixelutilities:tools/FirestoneHoe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("FirestoneHoe").setTextureName("pixelutilities:tools/FirestoneHoe");
	public Item FirestoneSword;// new com.PixelUtilities.tools.FirestoneSword(6088, ELEMENTSTONE, "pixelutilities:tools/FirestoneSword").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("FirestoneSword").setTextureName("PixelUtilities:FirestoneSword");

	//Waterstone tools
	public Item WaterstonePickaxe;// new com.PixelUtilities.tools.WaterstonePickaxe(6089, 6.5F, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstonePickaxe").setTextureName("PixelUtilities:WaterstonePickaxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("WaterstonePickaxe");
	public Item WaterstoneHammer;// new com.PixelUtilities.tools.WaterstoneHammer(6090, Basemod.instance.ELEMENTSTONE, "WaterstoneHammer", "Waterstone Hammer").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setTextureName("PixelUtilities:WaterstoneHammer").setUnlocalizedName("WaterstoneHammer");
	public Item WaterstoneAxe;// new com.PixelUtilities.tools.WaterstoneAxe(6091, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneAxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("WaterstoneAxe").setTextureName("PixelUtilities:WaterstoneAxe");
	public Item WaterstoneShovel;// new com.PixelUtilities.tools.WaterstoneShovel(6092, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneShovel").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("WaterstoneShovel").setTextureName("PixelUtilities:WaterstoneShovel");
	public Item WaterstoneHoe;// new com.PixelUtilities.tools.WaterstoneHoe(6093, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneHoe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("WaterstoneHoe").setTextureName("pixelutilities:tools/WaterstoneHoe");
	public Item WaterstoneSword;// new com.PixelUtilities.tools.WaterstoneSword(6094, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneSword").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("WaterstoneSword").setTextureName("PixelUtilities:WaterstoneSword");

	//Leafstone tools
	public Item LeafstonePickaxe;// new com.PixelUtilities.tools.LeafstonePickaxe(6095, 6.5F, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstonePickaxe").setTextureName("PixelUtilities:LeafstonePickaxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("LeafstonePickaxe");
	public Item LeafstoneHammer;// new com.PixelUtilities.tools.LeafstoneHammer(6096, Basemod.instance.ELEMENTSTONE, "rubyHammer", "Leafstone Hammer").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setTextureName("PixelUtilities:LeafstoneHammer").setUnlocalizedName("LeafstoneHammer");
	public Item LeafstoneAxe;// new com.PixelUtilities.tools.LeafstoneAxe(6097, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneAxe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("LeafstoneAxe").setTextureName("PixelUtilities:LeafstoneAxe");
	public Item LeafstoneShovel;// new com.PixelUtilities.tools.LeafstoneShovel(6098, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneShovel").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("LeafstoneShovel").setTextureName("PixelUtilities:LeafstoneShovel");
	public Item LeafstoneHoe;// new com.PixelUtilities.tools.LeafstoneHoe(6099, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneHoe").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("LeafstoneHoe").setTextureName("pixelutilities:tools/LeafstoneHoe");
	public Item LeafstoneSword;// new com.PixelUtilities.tools.LeafstoneSword(6100, Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneSword").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools).setUnlocalizedName("LeafstoneSword").setTextureName("PixelUtilities:LeafstoneSword");

	//Ruby Tools
	public Item CrystalPickaxe;
	public Item CrystalHammer;
	public Item CrystalAxe;
	public Item CrystalShovel;
	public Item CrystalHoe;
	public Item CrystalSword;*/
	private List<Item> toolList = new ArrayList<>();
	//Reflection to allow non pixelmon use
	public Constructor PixelHammerToolConstructor = null;

	private static PixelUtilitiesTools instance;

	static
	{
		instance = new PixelUtilitiesTools();
	}

	public static PixelUtilitiesTools getInstance()
	{
		return instance;
	}

	private PixelUtilitiesTools()
	{

	}

	public void load(Configuration configuration){

		try
		{
			if (Basemod.instance.pixelmonPresent)
				PixelHammerToolConstructor = Class.forName("com.pixelutilities.items.tools.PixelHammerTool").getConstructor(Item.ToolMaterial.class, String.class, String.class);
			else
				PixelHammerToolConstructor = Class.forName("com.pixelutilities.items.tools.BaseHammerTool").getConstructor(Item.ToolMaterial.class, String.class, String.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		//Ruby Tools
		Basemod.instance.rubyPickaxe = new PixelPickaxeTool(Basemod.instance.RUBY, "pixelutilities:tools/RubyPickaxe", "rubyPickaxe");
		Basemod.instance.rubyHammer = registerHammer(Basemod.instance.RUBY, "pixelutilities:tools/RubyHammer", "rubyHammer");
		Basemod.instance.rubyAxe = new PixelAxeTool(Basemod.instance.RUBY, "pixelutilities:tools/RubyAxe", "rubyAxe");
		Basemod.instance.rubyShovel = new PixelShovelTool(Basemod.instance.RUBY, "pixelutilities:tools/RubyShovel", "rubyShovel");
		Basemod.instance.rubyHoe = new PixelHoeTool(Basemod.instance.RUBY, "pixelutilities:tools/RubyHoe", "rubyHoe");
		Basemod.instance.rubySword = new PixelSwordTool(Basemod.instance.RUBY, "pixelutilities:tools/RubySword", "rubySword");

		//Saphire Tools
		Basemod.instance.saphirePickaxe = new PixelPickaxeTool(Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphirePickaxe", "saphirePickaxe");
		Basemod.instance.saphireHammer = registerHammer(Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireHammer", "saphireHammer");
		Basemod.instance.saphireAxe = new PixelAxeTool(Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireAxe", "saphireAxe");
		Basemod.instance.saphireShovel = new PixelShovelTool(Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireShovel", "saphireShovel");
		Basemod.instance.saphireHoe = new PixelHoeTool(Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireHoe", "saphireHoe");
		Basemod.instance.saphireSword = new PixelSwordTool(Basemod.instance.SAPHIRE, "pixelutilities:tools/SaphireSword", "saphireSword");

		//Amethyst Tools
		Basemod.instance.amethystPickaxe = new PixelPickaxeTool(Basemod.instance.AMETHYST, "pixelutilities:tools/AmethystPickaxe", "amethystPickaxe");
		Basemod.instance.amethystHammer = registerHammer(Basemod.instance.AMETHYST, "pixelutilities:tools/AmethystHammer", "amethystHammer");
		Basemod.instance.amethystAxe = new PixelAxeTool(Basemod.instance.AMETHYST, "pixelutilities:tools/AmethystAxe", "amethystAxe");
		Basemod.instance.amethystShovel = new PixelShovelTool(Basemod.instance.AMETHYST, "pixelutilities:tools/AmethystShovel", "amethystShovel");
		Basemod.instance.amethystHoe = new PixelHoeTool(Basemod.instance.AMETHYST, "pixelutilities:tools/AmethystHoe", "amethystHoe");
		Basemod.instance.amethystSword = new PixelSwordTool(Basemod.instance.AMETHYST, "pixelutilities:tools/AmethystSword", "amethystSword");

		//EvoTools
		//Firestone tools
		Basemod.instance.firestonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/FirestonePickaxe", "firestonePickaxe");
		Basemod.instance.firestoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/FirestoneHammer", "firestoneHammer");
		Basemod.instance.firestoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/FirestoneAxe", "firestoneAxe");
		Basemod.instance.firestoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/FirestoneShovel", "firestoneShovel");
		Basemod.instance.firestoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/FirestoneHoe", "firestoneHoe");
		Basemod.instance.firestoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/FirestoneSword", "firestoneSword");

		//Waterstone tools
		Basemod.instance.waterstonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstonePickaxe", "waterstonePickaxe");
		Basemod.instance.waterstoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneHammer", "waterstoneHammer");
		Basemod.instance.waterstoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneAxe", "waterstoneAxe");
		Basemod.instance.waterstoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneShovel", "waterstoneShovel");
		Basemod.instance.waterstoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneHoe", "waterstoneHoe");
		Basemod.instance.waterstoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/WaterstoneSword", "waterstoneSword");

		//Leafstone tools
		Basemod.instance.leafstonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstonePickaxe", "leafstonePickaxe");
		Basemod.instance.leafstoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneHammer", "leafstoneHammer");
		Basemod.instance.leafstoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneAxe", "leafstoneAxe");
		Basemod.instance.leafstoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneShovel", "leafstoneShovel");
		Basemod.instance.leafstoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneHoe", "leafstoneHoe");
		Basemod.instance.leafstoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/LeafstoneSword", "leafstoneSword");
		
		Basemod.instance.thunderstonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/ThunderstonePickaxe", "thunderstonePickaxe");
		Basemod.instance.thunderstoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/ThunderstoneHammer", "thunderstoneHammer");
		Basemod.instance.thunderstoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/ThunderstoneAxe", "thunderstoneAxe");
		Basemod.instance.thunderstoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/ThunderstoneShovel", "thunderstoneShovel");
		Basemod.instance.thunderstoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/ThunderstoneHoe", "thunderstoneHoe");
		Basemod.instance.thunderstoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/ThunderstoneSword", "thunderstoneSword");
		
		Basemod.instance.sunstonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/SunstonePickaxe", "sunstonePickaxe");
		Basemod.instance.sunstoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/SunstoneHammer", "sunstoneHammer");
		Basemod.instance.sunstoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/SunstoneAxe", "sunstoneAxe");
		Basemod.instance.sunstoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/SunstoneShovel", "sunstoneShovel");
		Basemod.instance.sunstoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/SunstoneHoe", "sunstoneHoe");
		Basemod.instance.sunstoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/SunstoneSword", "sunstoneSword");
		
		Basemod.instance.moonstonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/MoonstonePickaxe", "moonstonePickaxe");
		Basemod.instance.moonstoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/MoonstoneHammer", "moonstoneHammer");
		Basemod.instance.moonstoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/MoonstoneAxe", "moonstoneAxe");
		Basemod.instance.moonstoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/MoonstoneShovel", "moonstoneShovel");
		Basemod.instance.moonstoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/MoonstoneHoe", "moonstoneHoe");
		Basemod.instance.moonstoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/MoonstoneSword", "moonstoneSword");
		
		Basemod.instance.dawnstonePickaxe = new PixelPickaxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/DawnstonePickaxe", "dawnstonePickaxe");
		Basemod.instance.dawnstoneHammer = registerHammer(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/DawnstoneHammer", "dawnstoneHammer");
		Basemod.instance.dawnstoneAxe = new PixelAxeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/DawnstoneAxe", "dawnstoneAxe");
		Basemod.instance.dawnstoneShovel = new PixelShovelTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/DawnstoneShovel", "dawnstoneShovel");
		Basemod.instance.dawnstoneHoe = new PixelHoeTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/DawnstoneHoe", "dawnstoneHoe");
		Basemod.instance.dawnstoneSword = new PixelSwordTool(Basemod.instance.ELEMENTSTONE, "pixelutilities:tools/DawnstoneSword", "dawnstoneSword");

		//Crystal tools
		Basemod.instance.crystalPickaxe = new PixelPickaxeTool(Basemod.instance.CRYSTAL, "pixelutilities:tools/CrystalPickaxe", "crystalPickaxe");
		Basemod.instance.crystalHammer = registerHammer(Basemod.instance.CRYSTAL, "pixelutilities:tools/CrystalHammer", "crystalHammer");
		Basemod.instance.crystalAxe = new PixelAxeTool(Basemod.instance.CRYSTAL, "pixelutilities:tools/CrystalAxe", "crystalAxe");
		Basemod.instance.crystalShovel = new PixelShovelTool(Basemod.instance.CRYSTAL, "pixelutilities:tools/CrystalShovel", "crystalShovel");
		Basemod.instance.crystalHoe = new PixelHoeTool(Basemod.instance.CRYSTAL, "pixelutilities:tools/CrystalHoe", "crystalHoe");
		Basemod.instance.crystalSword = new PixelSwordTool(Basemod.instance.CRYSTAL, "pixelutilities:tools/CrystalSword", "crystalSword");

	}

	private Item registerHammer(Item.ToolMaterial toolMaterial, String itemString, String itemName)
	{
		//hacky ass method because the jvm won't play nice
		try
		{
			return (Item) PixelHammerToolConstructor.newInstance(toolMaterial, itemString, itemName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public void addNames()
	{

		GameRegistry.registerItem(Basemod.instance.rubyPickaxe, "Ruby Pickaxe");
		GameRegistry.registerItem(Basemod.instance.rubyAxe, "Ruby Axe");
		GameRegistry.registerItem(Basemod.instance.rubyShovel, "Ruby Shovel");
		GameRegistry.registerItem(Basemod.instance.rubyHoe, "Ruby Hoe");
		GameRegistry.registerItem(Basemod.instance.rubySword, "Ruby Sword");
		GameRegistry.registerItem(Basemod.instance.rubyHammer, "Ruby Hammer");

		GameRegistry.registerItem(Basemod.instance.saphirePickaxe, "Saphire Pickaxe");
		GameRegistry.registerItem(Basemod.instance.saphireAxe, "Saphire Axe");
		GameRegistry.registerItem(Basemod.instance.saphireShovel, "Saphire Shovel");
		GameRegistry.registerItem(Basemod.instance.saphireHoe, "Saphire Hoe");
		GameRegistry.registerItem(Basemod.instance.saphireSword, "Saphire Sword");
		GameRegistry.registerItem(Basemod.instance.saphireHammer, "Saphire Hammer");

		GameRegistry.registerItem(Basemod.instance.amethystPickaxe, "Amethyst Pickaxe");
		GameRegistry.registerItem(Basemod.instance.amethystAxe, "Amethyst Axe");
		GameRegistry.registerItem(Basemod.instance.amethystShovel, "Amethyst Shovel");
		GameRegistry.registerItem(Basemod.instance.amethystHoe, "Amethyst Hoe");
		GameRegistry.registerItem(Basemod.instance.amethystSword, "Amethyst Sword");
		GameRegistry.registerItem(Basemod.instance.amethystHammer, "Amethyst Hammer");

		GameRegistry.registerItem(Basemod.instance.firestonePickaxe, "Firestone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.firestoneAxe, "Firestone Axe");
		GameRegistry.registerItem(Basemod.instance.firestoneHoe, "Firestone Hoe");
		GameRegistry.registerItem(Basemod.instance.firestoneSword, "Firestone Sword");
		GameRegistry.registerItem(Basemod.instance.firestoneShovel, "Firestone Shovel");
		GameRegistry.registerItem(Basemod.instance.firestoneHammer, "Firestone Hammer");


		GameRegistry.registerItem(Basemod.instance.waterstonePickaxe, "Waterstone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.waterstoneAxe, "Waterstone Axe");
		GameRegistry.registerItem(Basemod.instance.waterstoneHoe, "Waterstone Hoe");
		GameRegistry.registerItem(Basemod.instance.waterstoneSword, "Waterstone Sword");
		GameRegistry.registerItem(Basemod.instance.waterstoneShovel, "Waterstone Shovel");
		GameRegistry.registerItem(Basemod.instance.waterstoneHammer, "Waterstone Hammer");

		GameRegistry.registerItem(Basemod.instance.leafstonePickaxe, "Leafstone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.leafstoneAxe, "Leafstone Axe");
		GameRegistry.registerItem(Basemod.instance.leafstoneHoe, "Leafstone Hoe");
		GameRegistry.registerItem(Basemod.instance.leafstoneSword, "Leafstone Sword");
		GameRegistry.registerItem(Basemod.instance.leafstoneShovel, "Leafstone Shovel");
		GameRegistry.registerItem(Basemod.instance.leafstoneHammer, "Leafstone Hammer");
		
		GameRegistry.registerItem(Basemod.instance.thunderstonePickaxe, "Thunderstone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.thunderstoneAxe, "Thunderstone Axe");
		GameRegistry.registerItem(Basemod.instance.thunderstoneHoe, "Thunderstone Hoe");
		GameRegistry.registerItem(Basemod.instance.thunderstoneSword, "Thunderstone Sword");
		GameRegistry.registerItem(Basemod.instance.thunderstoneShovel, "Thunderstone Shovel");
		GameRegistry.registerItem(Basemod.instance.thunderstoneHammer, "Thunderstone Hammer");
		
		GameRegistry.registerItem(Basemod.instance.sunstonePickaxe, "Sunstone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.sunstoneAxe, "Sunstone Axe");
		GameRegistry.registerItem(Basemod.instance.sunstoneHoe, "Sunstone Hoe");
		GameRegistry.registerItem(Basemod.instance.sunstoneSword, "Sunstone Sword");
		GameRegistry.registerItem(Basemod.instance.sunstoneShovel, "Sunstone Shovel");
		GameRegistry.registerItem(Basemod.instance.sunstoneHammer, "Sunstone Hammer");
		
		GameRegistry.registerItem(Basemod.instance.moonstonePickaxe, "Moonstone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.moonstoneAxe, "Moonstone Axe");
		GameRegistry.registerItem(Basemod.instance.moonstoneHoe, "Moonstone Hoe");
		GameRegistry.registerItem(Basemod.instance.moonstoneSword, "Moonstone Sword");
		GameRegistry.registerItem(Basemod.instance.moonstoneShovel, "Moonstone Shovel");
		GameRegistry.registerItem(Basemod.instance.moonstoneHammer, "Moonstone Hammer");
		
		GameRegistry.registerItem(Basemod.instance.dawnstonePickaxe, "Dawnstone Pickaxe");
		GameRegistry.registerItem(Basemod.instance.dawnstoneAxe, "Dawnstone Axe");
		GameRegistry.registerItem(Basemod.instance.dawnstoneHoe, "Dawnstone Hoe");
		GameRegistry.registerItem(Basemod.instance.dawnstoneSword, "Dawnstone Sword");
		GameRegistry.registerItem(Basemod.instance.dawnstoneShovel, "Dawnstone Shovel");
		GameRegistry.registerItem(Basemod.instance.dawnstoneHammer, "Dawnstone Hammer");

		GameRegistry.registerItem(Basemod.instance.crystalPickaxe, "Crystal Pickaxe");
		GameRegistry.registerItem(Basemod.instance.crystalAxe, "Crystal Axe");
		GameRegistry.registerItem(Basemod.instance.crystalHoe, "Crystal Hoe");
		GameRegistry.registerItem(Basemod.instance.crystalSword, "Crystal Sword");
		GameRegistry.registerItem(Basemod.instance.crystalShovel, "Crystal Shovel");
		GameRegistry.registerItem(Basemod.instance.crystalHammer, "Crystal Hammer");

	}

	public List<Item> getToolList() {
		return toolList;
	}

	public void setToolList(List<Item> toolList) {
		this.toolList = toolList;
	}
}