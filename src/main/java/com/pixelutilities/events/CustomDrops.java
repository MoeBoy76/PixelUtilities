package com.pixelutilities.events;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tv.twitch.chat.ChatMessage;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.Configuration;

import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CustomDrops
{
	private PixelUtilitiesConfig pixelConfig = PixelUtilitiesConfig.getInstance();

	private static CustomDrops instance;
	private Configuration dropConfig = null;
	String[] blankArray = {"notConfigured"};
	ArrayList<ItemStack> dropStacks = new ArrayList<>();
	//ArrayList<Integer> dropStackAmounts = new ArrayList<>();

	static
	{
		if (getInstance() == null)
			instance = new CustomDrops();
	}

	public static CustomDrops getInstance() {
		return instance;
	}

	private CustomDrops()
	{
		//TODO make config load and save
		/*dropConfig = new Configuration(new File("config/" + Basemod.MODID + "-drops.cfg"));
		dropConfig.load();
		
		List<String> drops = Arrays.asList(dropConfig.get(Configuration.CATEGORY_GENERAL, "Items for Pixelmon to drop", blankArray, "These are the items to drop").getStringList());
		List<String> amounts = Arrays.asList(dropConfig.get(Configuration.CATEGORY_GENERAL, "Amounts to drop", blankArray, "these correspond to the drops").getStringList());
		
		
		if(dropConfig.hasChanged())
			dropConfig.save();*/
	}

	@SubscribeEvent
	public void onWildPokemonDefeat(BeatWildPixelmonEvent event)
	{
		if(event.player != null)
		{
			if(!dropStacks.isEmpty())
			{
				int itemNum = event.player.getRNG().nextInt(dropStacks.size());
				ItemStack toDrop = dropStacks.get(itemNum);
				toDrop.stackSize = event.player.getRNG().nextInt(toDrop.stackSize);
				event.player.inventory.addItemStackToInventory(toDrop);
				event.player.addChatMessage(new ChatComponentText("You just got " + toDrop.getDisplayName() + "x" + toDrop.stackSize));
			}
			if(Basemod.instance.pixelmonPresent)
			{
				if (!pixelConfig.coinDrops)
				{
					return;
				}
				int doDrop = (int) (Math.random() * (pixelConfig.coinDropRate * 25));
				if(doDrop < 25 && doDrop != 10)
				{
					int amount = event.player.getRNG().nextInt(2) + 1;
					event.player.inventory.addItemStackToInventory(new ItemStack(Basemod.instance.pokeCoin1Item, amount));
				}
				if(doDrop == 10)
				{
					event.player.inventory.addItemStackToInventory(new ItemStack(Basemod.instance.pokeCoin10Item, 1));
				}
			}
		}
	}

	public void addItemDrop(ICommandSender sender, ItemStack stack)
	{	
		dropStacks.add(stack);
		//dropStackAmounts.add(stack.stackSize);
		
		//dropConfig.save();
		
		//sender.addChatMessage(new ChatComponentText("Successfully added " + stack.getDisplayName() + "x" + stack.stackSize + " to the drop list"));
	}
}
