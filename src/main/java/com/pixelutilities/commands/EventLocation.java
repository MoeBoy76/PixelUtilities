package com.pixelutilities.commands;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class EventLocation extends CommandBase {

	@Override
	public String getCommandName()
	{
		return "puevent";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "/puevent <x or y/n or spawn> <y> <z> <y/n> - sets the location of the event pokegift to the player location or to the specified location, spawns it if last argument is y, just spawns if spawn";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		if(!PixelUtilitiesConfig.getInstance().setEventPlacement)
		{
			ChatComponentTranslation chat = new ChatComponentTranslation("You need to activate this in the config");
			chat.getChatStyle().setColor(EnumChatFormatting.RED);
			sender.addChatMessage(chat);
			return;
		}

		if(args.length == 1)
		{
			EntityPlayerMP player = getCommandSenderAsPlayer(sender);
			if(args[0].equalsIgnoreCase("spawn"))
			{
				if(Basemod.instance.pge.placeEvent(player.worldObj))
				{
					ChatComponentTranslation chat = new ChatComponentTranslation("You're standing on me!");
					chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
					player.addChatMessage(chat);
				}
				else
				{
					ChatComponentTranslation chat = new ChatComponentTranslation("Uh-oh, something went wrong!");
					chat.getChatStyle().setColor(EnumChatFormatting.RED);
					player.addChatMessage(chat);
				}
			}
			else
			{
				boolean doSpawn = args[0].equalsIgnoreCase("y");

				int x = (int) player.posX;
				int y = (int) player.posY;
				int z = (int) player.posZ;

				if(PixelUtilitiesConfig.getInstance().setLocation(x, y, z, doSpawn, player.worldObj))
				{
					if(doSpawn)
					{
						ChatComponentTranslation chat = new ChatComponentTranslation("You're standing on me!");
						chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
						player.addChatMessage(chat);
					}
					else
					{
						ChatComponentTranslation chat = new ChatComponentTranslation("Location set!");
						chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
						player.addChatMessage(chat);
					}
				}
				else
				{
					ChatComponentTranslation chat = new ChatComponentTranslation("Something went wrong!");
					chat.getChatStyle().setColor(EnumChatFormatting.RED);
					player.addChatMessage(chat);
				}
			}
		}
		else if(args.length > 2 && args.length < 5)
		{
			EntityPlayerMP player = getCommandSenderAsPlayer(sender);

			boolean doSpawn = false;

			if(args.length == 4 && args[3].equalsIgnoreCase("y"))
			{
				doSpawn = true;
			}

			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			int z = Integer.parseInt(args[2]);

			if(PixelUtilitiesConfig.getInstance().setLocation(x, y, z, doSpawn, player.worldObj))
			{
				if(doSpawn)
				{
					ChatComponentTranslation chat = new ChatComponentTranslation("You're standing on me!");
					chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
					player.addChatMessage(chat);
				}
				else
				{
					ChatComponentTranslation chat = new ChatComponentTranslation("Location set!");
					chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
					player.addChatMessage(chat);
				}
			}
			else
			{
				ChatComponentTranslation chat = new ChatComponentTranslation("Something went wrong!");
				chat.getChatStyle().setColor(EnumChatFormatting.RED);
				player.addChatMessage(chat);
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
