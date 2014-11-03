package com.pixelutilities.achievements;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.items.Siliconitem;
import com.pixelutilities.items.armor.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class PixelUtilitiesAchievements
{

	private int magArmor = 0;
	private int aquaArmor = 0;

	public static Achievement teammagma = new Achievement("achievement.teammagma", "teammagma", -1, -1, Basemod.instance.rubyHelm, null).registerStat();
	public static Achievement teamaqua = new Achievement("achievement.teamaqua", "teamaqua", 3, -1, Basemod.instance.saphireHelm, null).registerStat();
	
	public static Achievement teammagma1 = new Achievement("achievement.teammagma1", "teammagma1", -1, 1, Basemod.instance.rubyBoots, teammagma).registerStat();
	public static Achievement teamaqua1 = new Achievement("achievement.teamaqua1", "teamaqua1", 3, 1, Basemod.instance.saphireBoots, teamaqua).registerStat();
	
	public static Achievement getSilicon = new Achievement("achievement.getsilicon", "getSilicon", 1, -1, Basemod.instance.siliconItem, null).registerStat();

	public static Achievement pokeGift = new Achievement("achievement.pokegift", "pokeGift", 1, 1, PixelUtilitiesBlocks.pokegift, null).registerStat();
	public static Achievement givenPokeGift = new Achievement("achievement.givenpokegift", "givenPokeGift", 1, 3, PixelUtilitiesBlocks.pokegift, null).registerStat().setSpecial();
	
	public static Achievement teammagma2 = new Achievement("achievement.teammagma2", "teammagma2", -1, 3, Basemod.instance.rubyLegs, teammagma1).registerStat();
	public static Achievement teammagma3 = new Achievement("achievement.teammagma3", "teammagma3", -1, 5, Basemod.instance.rubyPlate, teammagma2).registerStat();
	
	public static Achievement teamaqua2 = new Achievement("achievement.teamaqua2", "teamaqua2", 3, 3, Basemod.instance.saphireLegs, teamaqua1).registerStat();
	public static Achievement teamaqua3 = new Achievement("achievement.teamaqua3", "teamaqua3", 3, 5, Basemod.instance.saphirePlate, teamaqua2).registerStat();
	
	//TODO Team Rocket, Galactic and Plasma
	
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
        if (item instanceof SaphireBoots)
        {
            player.addStat(teamaqua1, 1);
            return;
        }
        if (item instanceof SaphireLegs)
        {
            player.addStat(teamaqua2, 1);
            return;
        }
        if (item instanceof SaphirePlate)
        {
            player.addStat(teamaqua3, 1);
            return;
        }

        //TODO as above
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
