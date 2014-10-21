package com.pixelutilities.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedAbnormalEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleStartedEvent;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.radioplayer.VLCPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PUTickHandler
{
	public static VLCPlayer playerRadio = new VLCPlayer(PixelUtilitiesConfig.getInstance().BattleMusicURL, 50);
	public boolean inBattle = false;

	@SubscribeEvent
	public void onBattleStart(PlayerBattleStartedEvent event)
	{
		if (!PixelUtilitiesConfig.getInstance().battleMusicEnabled)
			return;
		playerRadio.start();
	}

	@SubscribeEvent
	public void onBattleEnd(PlayerBattleEndedEvent event)
	{
		playerRadio.stop();
	}

	@SubscribeEvent
	public void onBattleEndAbnormal(PlayerBattleEndedAbnormalEvent event)
	{
		playerRadio.stop();
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		if(Basemod.instance.pixelmonPresent)
		{
			if(PixelUtilitiesConfig.getInstance().noStarterScreen)
			{
				if(event.player instanceof EntityPlayerMP)
				{
					EntityPlayerMP player = (EntityPlayerMP) event.player;
					try {
						PlayerStorage s = PixelmonStorage.PokeballManager.getPlayerStorage(player);
						if(!s.starterPicked)
						{
							s.starterPicked = true;

							ChatComponentTranslation chat = new ChatComponentTranslation("Starter screen has been skipped!");
							chat.getChatStyle().setColor(EnumChatFormatting.GREEN);
							player.addChatMessage(chat);
						}
					}
					catch (PlayerNotLoadedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		System.out.println("world join ");
		if (!Basemod.instance.vlcLoaded)//Display message in chat with link to vlc for arch
		{
			ChatStyle style = new ChatStyle().setUnderlined(true).setColor(EnumChatFormatting.GOLD);
			IChatComponent text = new ChatComponentText("You need to download VLC here to hear the radio ").setChatStyle(style);
			event.player.addChatComponentMessage(text);

			if (Basemod.instance.is64bit)
			{
				//TODO detect platform (mac/linux/windogs)
				text = new ChatComponentText("http://download.videolan.org/pub/videolan/vlc/last/win64/vlc-2.1.3-win64.exe").setChatStyle(style);
			}
			else
			{
				text = new ChatComponentText("http://download.videolan.org/pub/videolan/vlc/last/win32/vlc-2.1.3-win32.exe").setChatStyle(style);
			}
			event.player.addChatComponentMessage(text);
		}
	}
}
