package com.pixelutilities.config;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.pixelutilities.Basemod;
import com.pixelutilities.items.CDItem;
import com.pixelutilities.items.PixelBoyItem;
import com.pixelutilities.items.badges.*;
import com.pixelutilities.items.economy.PokeCoin100Item;
import com.pixelutilities.items.economy.PokeCoin10Item;
import com.pixelutilities.items.economy.PokeCoin1Item;
import com.pixelutilities.items.economy.PokeCoin50Item;
import com.pixelutilities.items.economy.PokeCoin5Item;

public class PixelUtilitiesItems {

	public static void load(Configuration cfg) {
		Basemod.instance.pokeCoin1Item = new PokeCoin1Item().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		Basemod.instance.pokeCoin5Item = new PokeCoin5Item().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		Basemod.instance.pokeCoin10Item = new PokeCoin10Item().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		Basemod.instance.pokeCoin50Item = new PokeCoin50Item().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		Basemod.instance.pokeCoin100Item = new PokeCoin100Item().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		Basemod.instance.bugBadgeItem = new BugBadgeItem();
		Basemod.instance.fightingBadgeItem = new FightingBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/FightingBadge");
		Basemod.instance.flyingBadgeItem = new FlyingBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/FlyingBadge");
		Basemod.instance.groundBadgeItem = new GroundBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/GroundBadge");
		Basemod.instance.normalBadgeItem = new NormalBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/NormalBadge");
		Basemod.instance.poisonBadgeItem = new PoisonBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/PoisonBadge");
		Basemod.instance.rockBadgeItem = new RockBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/RockBadge");
		Basemod.instance.ghostBadgeItem = new GhostBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/GhostBadge");
		Basemod.instance.steelBadgeItem = new SteelBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/SteelBadge");
		Basemod.instance.fireBadgeItem = new FireBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/FireBadge");
		Basemod.instance.waterBadgeItem = new WaterBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/WaterBadge");
		Basemod.instance.grassBadgeItem = new GrassBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/GrassBadge");
		Basemod.instance.electricBadgeItem = new ElectricBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/ElectricBadge");
		Basemod.instance.darkBadgeItem = new DarkBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/DarkBadge");
		Basemod.instance.iceBadgeItem = new IceBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/IceBadge");
		Basemod.instance.psychicBadgeItem = new PsychicBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/PsychicBadge");
		Basemod.instance.dragonBadgeItem = new DragonBadgeItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBadges);//.setTextureName("PixelUtilities:badges/DragonBadge");
		//Basemod.instance.cdItem = new CDItem().setCreativeTab(CreativeTabs.tabMisc);//.setTextureName("PixelUtilities:CD");
		Basemod.instance.pixelBoyItem = new PixelBoyItem().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);//.setTextureName("pixelutilities:PixelBoy");
	}

	public static void addNames() {

		//Items
		GameRegistry.registerItem(Basemod.instance.pokeCoin1Item, Basemod.instance.pokeCoin1Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin5Item, Basemod.instance.pokeCoin5Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin10Item, Basemod.instance.pokeCoin10Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin50Item, Basemod.instance.pokeCoin50Item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.pokeCoin100Item, Basemod.instance.pokeCoin100Item.getUnlocalizedName().substring(5));
		//GameRegistry.registerItem(Basemod.instance.cdItem, Basemod.instance.cdItem.getUnlocalizedName().substring(5));

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
