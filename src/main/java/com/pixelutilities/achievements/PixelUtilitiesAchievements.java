package com.pixelutilities.achievements;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.config.PixelUtilitiesItems;
import com.pixelutilities.items.armor.RubyHelmet;
import com.pixelutilities.items.armor.SaphireBoots;
import com.pixelutilities.items.armor.SaphireHelmet;
import com.pixelutilities.items.armor.SaphireLegs;
import com.pixelutilities.items.armor.SaphirePlate;

import cpw.mods.fml.common.Mod.EventHandler;

public class PixelUtilitiesAchievements
{

	private final static String INDEX = "wtf";
	private int magArmor = 0;
	private int aquaArmor = 0;

	public static Achievement teammagma = new Achievement(INDEX, "teammagma", -1, -1, Basemod.instance.rubyHelm, null);
	public static Achievement teamaqua = new Achievement(INDEX + 1, "teamaqua", 3, -1, Basemod.instance.saphireHelm, null);
	public static Achievement teammagma1 = new Achievement(INDEX + 2, "teammagma1", -1, 1, Basemod.instance.rubyPlate, teammagma);
	public static Achievement teamaqua1 = new Achievement(INDEX + 3, "teamaqua1", 3, 1, Basemod.instance.saphirePlate, teamaqua);
	public static Achievement getSilicon = new Achievement(INDEX + 4, "getSilicon", 1, -1, Basemod.instance.siliconItem, null);

	public static Achievement pokeGift = new Achievement(INDEX + 5, "pokeGift", 1, 1, PixelUtilitiesBlocks.obtainablePixelmon, null);
	//public static Achievement hiddenPokeGift = new Achievement(INDEX + 6, "hiddenPokeGift", 3, -2, PixelUtilitiesBlocks.obtainablePixelmon, pokeGift).registerStat();
	
	public static AchievementPage PixelUtilitiesPage = new AchievementPage("PixelUtilities", teammagma, teamaqua, teammagma1, teamaqua1, getSilicon, pokeGift);

	public static void setupAchievements() {
		AchievementPage.registerAchievementPage(PixelUtilitiesPage);
	}

	@EventHandler
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
	{
		if (item.getItem() instanceof RubyHelmet)
		{
			player.addStat(teammagma, 1);
		}
		if (item.getItem() instanceof SaphirePlate || item.getItem() instanceof SaphireHelmet || item.getItem() instanceof SaphireBoots || item.getItem() instanceof SaphireLegs)
		{
			player.addStat(teamaqua, 1);
		}
	}

	@EventHandler
	public void onSmelting(EntityPlayer player, ItemStack item)
	{
		if(item.getItem() == Basemod.instance.siliconItem) {
			player.addStat(getSilicon, 1);
		}

	}

}
