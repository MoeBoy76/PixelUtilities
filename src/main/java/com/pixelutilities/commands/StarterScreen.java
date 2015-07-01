package com.pixelutilities.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.customStarters.CustomStarters;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.enums.EnumGui;
import com.pixelutilities.gui.starters.GuiSelectPokemon;
import com.pixelutilities.packets.StarterListPacket;

public class StarterScreen extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "starterscreen";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "/starterscreen <list#>- opens the starter screen if it hasn't been displayed yet";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		ChatComponentTranslation chat;
		if(args.length == 0)
		{
			//CustomStarters.reloadStarters();
			EntityPlayerMP player = null;
			try {
				player = getCommandSenderAsPlayer(sender);
			} catch (PlayerNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try
			{
				PlayerStorage storage = PixelmonStorage.PokeballManager.getPlayerStorage(player);
				int party = 0;
				for(NBTTagCompound nbt : storage.partyPokemon)
				{
					if(nbt != null)
					{
						party++;
					}
				}
				if(storage.starterPicked && party > 0)
				{
					chat = new ChatComponentTranslation("Sorry but you cannot pick a starter");
					chat.getChatStyle().setColor(EnumChatFormatting.RED);
					sender.addChatMessage(chat);
					return;
				}
				storage.starterPicked = false;
			}
			catch(PlayerNotLoadedException e)
			{
				
			}
			player.openGui(Pixelmon.instance, com.pixelmonmod.pixelmon.enums.EnumGui.ChooseStarter.getIndex(), player.worldObj, 0, 0, 0);
			//Minecraft.getMinecraft().displayGuiScreen(new GuiSelectPokemon(PixelUtilitiesConfig.getInstance().getStarterList(0)));
		}
		else if(args.length == 1)
		{
			if(!PixelUtilitiesConfig.getInstance().starterListsOn)
			{
				chat = new ChatComponentTranslation("An error occurred when loading these, check their formatting");
				chat.getChatStyle().setColor(EnumChatFormatting.GOLD);
				sender.addChatMessage(chat);
				return;
			}
			EntityPlayerMP player = null;
			try {
				player = getCommandSenderAsPlayer(sender);
			} catch (PlayerNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int listNum = Integer.parseInt(args[0]);
			
			try
			{
				PlayerStorage storage = PixelmonStorage.PokeballManager.getPlayerStorage(player);
				int party = 0;
				for(NBTTagCompound nbt : storage.partyPokemon)
				{
					if(nbt != null)
					{
						party++;
					}
				}
				if(storage.starterPicked && party > 0 && !PixelUtilitiesConfig.getInstance().isListAddon(listNum))
				{
					chat = new ChatComponentTranslation("Sorry but you cannot pick a starter");
					chat.getChatStyle().setColor(EnumChatFormatting.RED);
					sender.addChatMessage(chat);
					return;
				}
				storage.starterPicked = false;
			}
			catch(PlayerNotLoadedException e)
			{
				
			}
			
			//Minecraft.getMinecraft().displayGuiScreen(new GuiSelectPokemon(PixelUtilitiesConfig.getInstance().getStarterList(listNum)));
			player.openGui(Basemod.instance, EnumGui.SelectPokemon.getIndex(), player.worldObj, listNum, 0, 0);
			//Basemod.network.sendTo(new StarterListPacket(PixelUtilitiesConfig.getInstance().getStarterList(listNum)), player);
			return;
		}
		else
		{
			chat = new ChatComponentTranslation(getCommandUsage(sender));
			chat.getChatStyle().setColor(EnumChatFormatting.RED);
			sender.addChatMessage(chat);
		}
	}
}