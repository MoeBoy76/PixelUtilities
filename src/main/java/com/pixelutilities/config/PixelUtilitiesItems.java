package com.pixelutilities.config;

import com.pixelutilities.Basemod;
import com.pixelutilities.items.badges.*;
import com.pixelutilities.items.economy.*;
import com.pixelutilities.items.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

public class PixelUtilitiesItems {

	//Items
	/*public static Item PokeCoin1Item;
    public static Item PokeCoin5Item;
    public static Item PokeCoin10Item;
    public static Item PokeCoin50Item;
    public static Item PokeCoin100Item;
    public static Item BugBadgeItem;
    public static Item FightingBadgeItem;
    public static Item FlyingBadgeItem;
    public static Item GroundBadgeItem;
    public static Item NormalBadgeItem;
    public static Item PoisonBadgeItem;
    public static Item RockBadgeItem;
    public static Item GhostBadgeItem;
    public static Item SteelBadgeItem;
    public static Item FireBadgeItem;
    public static Item WaterBadgeItem;
    public static Item GrassBadgeItem;
    public static Item ElectricBadgeItem;
    public static Item DarkBadgeItem;
    public static Item IceBadgeItem;
    public static Item PsychicBadgeItem;
    public static Item DragonBadgeItem;
    public static Item SaphireItem;
    public static Item RubyItem;
    public static Item SiliconItem;
    public static Item CrystalItem;
    public static Item CDItem;
    public static Item HandHeldRadio;
    public static Item AmethystItem;
    public static Item PixelBoyItem;*/

	public static void load(Configuration cfg) {
		Basemod.instance.pokeCoin1Item = new PokeCoin1Item();
		Basemod.instance.pokeCoin5Item = new PokeCoin5Item();
		Basemod.instance.pokeCoin10Item = new PokeCoin10Item();
		Basemod.instance.pokeCoin50Item = new PokeCoin50Item();
		Basemod.instance.pokeCoin100Item = new PokeCoin100Item();
		Basemod.instance.bugBadgeItem = new BugBadgeItem();
		Basemod.instance.fightingBadgeItem = new FightingBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/FightingBadge");
		Basemod.instance.flyingBadgeItem = new FlyingBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/FlyingBadge");
		Basemod.instance.groundBadgeItem = new GroundBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/GroundBadge");
		Basemod.instance.normalBadgeItem = new NormalBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/NormalBadge");
		Basemod.instance.poisonBadgeItem = new PoisonBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/PoisonBadge");
		Basemod.instance.rockBadgeItem = new RockBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/RockBadge");
		Basemod.instance.ghostBadgeItem = new GhostBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/GhostBadge");
		Basemod.instance.steelBadgeItem = new SteelBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/SteelBadge");
		Basemod.instance.fireBadgeItem = new FireBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/FireBadge");
		Basemod.instance.waterBadgeItem = new WaterBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/WaterBadge");
		Basemod.instance.grassBadgeItem = new GrassBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/GrassBadge");
		Basemod.instance.electricBadgeItem = new ElectricBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/ElectricBadge");
		Basemod.instance.darkBadgeItem = new DarkBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/DarkBadge");
		Basemod.instance.iceBadgeItem = new IceBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/IceBadge");
		Basemod.instance.psychicBadgeItem = new PsychicBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/PsychicBadge");
		Basemod.instance.dragonBadgeItem = new DragonBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges).setTextureName("PixelUtilities:badges/DragonBadge");
		Basemod.instance.saphireItem = new SaphireItem().setCreativeTab(CreativeTabs.tabMaterials).setTextureName("PixelUtilities:Saphire");
		Basemod.instance.rubyItem = new RubyItem().setCreativeTab(CreativeTabs.tabMaterials).setTextureName("PixelUtilities:Ruby");
		Basemod.instance.siliconItem = new Siliconitem().setCreativeTab(CreativeTabs.tabMaterials).setTextureName("PixelUtilities:Silicon");
		Basemod.instance.crystalItem = new CrystalItem().setCreativeTab(CreativeTabs.tabMaterials).setTextureName("PixelUtilities:Crystal");
		Basemod.instance.cdItem = new CDItem().setCreativeTab(CreativeTabs.tabMisc).setTextureName("PixelUtilities:CD");
		//HandHeldRadio = new HandHeldRadioItem().setCreativeTab(CreativeTabs.tabMisc).setTextureName("PixelUtilities:handheldradio");
		Basemod.instance.amethystItem = new AmethystItem().setCreativeTab(CreativeTabs.tabMaterials).setTextureName("PixelUtilities:Amethyst");
		Basemod.instance.pixelBoyItem = new PixelBoyItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesLights).setTextureName("pixelutilities:PixelBoy");
	}

	public static void addNames() {

		//Items
		GameRegistry.registerItem(Basemod.instance.pokeCoin1Item, Basemod.instance.pokeCoin1Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin5Item, Basemod.instance.pokeCoin5Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin10Item, Basemod.instance.pokeCoin10Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin50Item, Basemod.instance.pokeCoin50Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin100Item, Basemod.instance.pokeCoin100Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.saphireItem, Basemod.instance.saphireItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rubyItem, Basemod.instance.rubyItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.siliconItem, Basemod.instance.siliconItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.cdItem, Basemod.instance.cdItem.getUnlocalizedName().substring(5));
		//GameRegistry.registerItem(HandHeldRadio, HandHeldRadio.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.crystalItem, Basemod.instance.crystalItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.amethystItem, Basemod.instance.amethystItem.getUnlocalizedName().substring(5));

		//Badges
		GameRegistry.registerItem(Basemod.instance.bugBadgeItem, Basemod.instance.bugBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.fightingBadgeItem, Basemod.instance.fightingBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.flyingBadgeItem, Basemod.instance.flyingBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.ghostBadgeItem, Basemod.instance.ghostBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.groundBadgeItem, Basemod.instance.groundBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.normalBadgeItem, Basemod.instance.normalBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.poisonBadgeItem, Basemod.instance.poisonBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rockBadgeItem, Basemod.instance.rockBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.steelBadgeItem, Basemod.instance.steelBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.fireBadgeItem, Basemod.instance.fireBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.waterBadgeItem, Basemod.instance.waterBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.grassBadgeItem, Basemod.instance.grassBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.electricBadgeItem, Basemod.instance.electricBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.psychicBadgeItem, Basemod.instance.psychicBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.darkBadgeItem, Basemod.instance.darkBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.iceBadgeItem, Basemod.instance.iceBadgeItem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.dragonBadgeItem, Basemod.instance.dragonBadgeItem.getUnlocalizedName().substring(5));

		//Sexy stuff
		GameRegistry.registerItem(Basemod.instance.pixelBoyItem, Basemod.instance.pixelBoyItem.getUnlocalizedName().substring(5));

	}
}
