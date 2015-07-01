package com.pixelutilities.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;

import com.pixelutilities.events.CustomDrops;

public class AddToDrops extends CommandBase {

	@Override
	public String getCommandName() {
		return "dropsadd";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/dropsadd <amount> - adds held item into the drop list with a chance of being a stack of 0 to <amount>";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		
		if (args.length == 1 || args.length == 0)
		{
			EntityPlayerMP player = null;
			try {
				player = getCommandSenderAsPlayer(sender);
			} catch (PlayerNotFoundException e) {
				e.printStackTrace();
			}
			int stackSize = -1;
			if(args.length == 1)
				stackSize = Integer.parseInt(args[0]);
			
			if (player.getHeldItem() != null) {
				ItemStack itemStack = player.getHeldItem();
				if(stackSize != -1)
					itemStack.stackSize = stackSize;
				
				CustomDrops.getInstance().addItemDrop(sender, itemStack);
				notifyOperators(sender, this, "Successfully added " + itemStack.getDisplayName() + "x" + itemStack.stackSize + " to the drop list");
			}
			else
			{
				ChatComponentTranslation chat = new ChatComponentTranslation("You need to be holding an item!");
				chat.getChatStyle().setColor(EnumChatFormatting.RED);
				sender.addChatMessage(chat);
			}
		}
		else
		{
			ChatComponentTranslation chat = new ChatComponentTranslation(getCommandUsage(sender));
			chat.getChatStyle().setColor(EnumChatFormatting.RED);
			sender.addChatMessage(chat);
		}
	}
}
