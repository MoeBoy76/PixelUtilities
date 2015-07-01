package com.pixelutilities.events;

import java.io.File;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;

public class CustomDrops
{
	private PixelUtilitiesConfig pixelConfig = PixelUtilitiesConfig.getInstance();

	private static CustomDrops instance;
	private Configuration dropConfig;// = null;
	//String[] blankArray = {"notConfigured"};
	ArrayList<ItemStack> dropStacks = new ArrayList<>();
	Property propDropStacks;
	Property propStackSize;
	Property propMaxDrops;
	int maxDropItems;

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
		dropConfig = new Configuration(new File("config/" + Basemod.MODID + "-drops.cfg"));
		dropConfig.load();

		propMaxDrops = dropConfig.get("General", "Max Items in drop list", 1, "Used to determine how many items there are to load");
		maxDropItems = propMaxDrops.getInt();
		for(int i = 0; i < maxDropItems; i++) {
			propDropStacks = dropConfig.get("General", "Drop Item " + i, "minecraft:grass", "Possible Item to drop when a Player wins a battle");
			propStackSize = dropConfig.get("General", "Drop Item " + i + " size", 1, "Maximum amount of Drop Item " + i + " to drop");
			String propString = propDropStacks.getString();
			Item item = GameRegistry.findItem(propString.split(":")[0], propString.split(":")[1]);
			Block block = GameRegistry.findBlock(propString.split(":")[0], propString.split(":")[1]);
			ItemStack stack;
			if(item != null)
				stack = new ItemStack(item);
			else if(block != null)
				stack  = new ItemStack(block);
			else {
				Basemod.LOGGER.error("Could not find block/item " + i + " when loading pixelutilities-drops.cfg");
				break;
			}
			stack.stackSize = propStackSize.getInt();
			if(stack.getItem() != new ItemStack(Blocks.grass).getItem())
				dropStacks.add(stack);
		}

		if(dropConfig.hasChanged())
			dropConfig.save();
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
				if(toDrop.stackSize > 0)
				{
					toDrop.stackSize = event.player.getRNG().nextInt(toDrop.stackSize);
				}
				else
				{
					toDrop.stackSize = 1;
				}
				event.player.inventory.addItemStackToInventory(toDrop);
				event.player.addChatMessage(new ChatComponentText("You just got " + toDrop.getDisplayName() + " x " + toDrop.stackSize));
			}
			int doDrop = (int) (Math.random() * (pixelConfig.currencyDropRate * 25));
			if (pixelConfig.coinDrops)
			{
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
			else
			{
				if(doDrop < 25)
				{
					try {
						PlayerStorage storage = PixelmonStorage.PokeballManager.getPlayerStorage(event.player);
						int money = storage.getCurrency();
						if(doDrop != 10)
							money += pixelConfig.moneyWild;
						else
							money += (pixelConfig.moneyWild * 10);
						storage.setCurrency(money);
						//event.player.addChatMessage(new ChatComponentTranslation("you won " + pixelConfig.moneyWild));
					} catch (PlayerNotLoadedException e) { }
				}
			}
		}
	}

	public void addItemDrop(ICommandSender sender, ItemStack stack)
	{	
		if(dropStacks.size() >= maxDropItems) {
			propMaxDrops.set(maxDropItems + 1);
			maxDropItems++;
		}

		dropStacks.add(stack);

		for(int i = 0; i < dropStacks.size(); i++) {
			ItemStack currStack = dropStacks.get(i);
			String name = currStack.getItem().delegate.name();
			propDropStacks = dropConfig.get("General", "Drop Item " + i, "minecraft:grass", "Possible Item to drop when a Player wins a battle");
			propStackSize = dropConfig.get("General", "Drop Item " + i + " size", 1, "Maximum amount of Drop Item " + i + " to drop");
			propDropStacks.set(name);
			propStackSize.set(currStack.stackSize);
		}
		//dropStackAmounts.add(stack.stackSize);

		if(dropConfig.hasChanged())
			dropConfig.save();

		sender.addChatMessage(new ChatComponentText("Successfully added " + stack.getDisplayName() + "x" + stack.stackSize + " to the drop list"));
	}
}
