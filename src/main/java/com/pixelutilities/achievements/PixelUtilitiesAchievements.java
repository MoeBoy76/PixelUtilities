package com.pixelutilities.achievements;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.config.PixelUtilitiesItems;
import com.pixelutilities.items.Siliconitem;
import com.pixelutilities.items.armor.RubyBoots;
import com.pixelutilities.items.armor.RubyHelmet;
import com.pixelutilities.items.armor.RubyLegs;
import com.pixelutilities.items.armor.RubyPlate;
import com.pixelutilities.items.armor.SaphireBoots;
import com.pixelutilities.items.armor.SaphireHelmet;
import com.pixelutilities.items.armor.SaphireLegs;
import com.pixelutilities.items.armor.SaphirePlate;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class PixelUtilitiesAchievements
{

	private final static String INDEX = "wtf";
	private int magArmor = 0;
	private int aquaArmor = 0;

	public static Achievement teammagma = new Achievement(INDEX, "teammagma", -1, -1, Basemod.instance.rubyHelm, null);
	public static Achievement teamaqua = new Achievement(INDEX + 1, "teamaqua", 3, -1, Basemod.instance.saphireHelm, null);
	
	public static Achievement teammagma1 = new Achievement(INDEX + 2, "teammagma1", -1, 1, Basemod.instance.rubyBoots, teammagma);
	public static Achievement teamaqua1 = new Achievement(INDEX + 3, "teamaqua1", 3, 1, Basemod.instance.saphireBoots, teamaqua);
	
	public static Achievement getSilicon = new Achievement(INDEX + 4, "getSilicon", 1, -1, Basemod.instance.siliconItem, null);

	public static Achievement pokeGift = new Achievement(INDEX + 5, "pokeGift", 1, 1, PixelUtilitiesBlocks.pokegift, null);
	public static Achievement givenPokeGift = new Achievement(INDEX + 6, "givenPokeGift", 1, 3, PixelUtilitiesBlocks.pokegift, null).setSpecial();
	
	public static Achievement teammagma2 = new Achievement(INDEX + 7, "teammagma2", -1, 3, Basemod.instance.rubyLegs, teammagma1);
	public static Achievement teammagma3 = new Achievement(INDEX + 8, "teammagma3", -1, 5, Basemod.instance.rubyPlate, teammagma2);
	
	public static Achievement teamaqua2 = new Achievement(INDEX + 9, "teamaqua2", 3, 3, Basemod.instance.saphireLegs, teamaqua1);
	public static Achievement teamaqua3 = new Achievement(INDEX + 10, "teamaqua3", 3, 5, Basemod.instance.saphirePlate, teamaqua2);
	
	public static AchievementPage PixelUtilitiesPage = new AchievementPage("PixelUtilities", teammagma, teamaqua, teammagma1, teamaqua1, getSilicon, pokeGift, givenPokeGift, teammagma2, teammagma3, teamaqua2, teamaqua3);

	public static void setupAchievements() {
		AchievementPage.registerAchievementPage(PixelUtilitiesPage);
	}

	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		Item item = event.crafting.getItem();
		EntityPlayer player = event.player;
		if (item instanceof RubyHelmet)
		{
			player.addStat(teammagma, 1);
			return;
		}
		if (item instanceof RubyBoots)
		{
			player.addStat(teammagma1, 1);
			return;
		}
		if (item instanceof RubyLegs)
		{
			player.addStat(teammagma2, 1);
			return;
		}
		if (item instanceof RubyPlate)
		{
			player.addStat(teammagma3, 1);
			return;
		}
		
		if (item instanceof SaphireHelmet)
		{
			player.addStat(teamaqua, 1);
			return;
		}
	}

	@SubscribeEvent
	public void onSmelting(ItemSmeltedEvent event)
	{
		Item item = event.smelting.getItem();
		EntityPlayer player = event.player;
		
		if(item instanceof Siliconitem) {
			player.addStat(getSilicon, 1);
			return;
		}
	}
}
