package com.pixelutilities.events;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;

public class StandardTickHandler {

	String os = Basemod.instance.osType;

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		//System.out.println("world join ");
		if (!Basemod.instance.vlcLoaded && PixelUtilitiesConfig.getInstance().vlcMessage)//Display message in chat with link to vlc for arch
		{
			ChatStyle style = new ChatStyle().setUnderlined(true).setColor(EnumChatFormatting.GOLD);
			IChatComponent text = new ChatComponentText("You need to download VLC here to hear the radio ").setChatStyle(style);
			event.player.addChatComponentMessage(text);
			if(os.contentEquals("Windows"))
			{
				if (Basemod.instance.is64bit)
				{
					text = new ChatComponentText("http://download.videolan.org/pub/videolan/vlc/last/win64/vlc-2.1.5-win64.exe").setChatStyle(style);
				}
				else
				{
					text = new ChatComponentText("http://download.videolan.org/pub/videolan/vlc/last/win32/vlc-2.1.5-win32.exe").setChatStyle(style);
				}
			}
			else if(os.contentEquals("Mac OS X"))
			{
				text = new ChatComponentText("http://download.videolan.org/pub/videolan/vlc/last/macosx/vlc-2.1.5.dmg").setChatStyle(style);
			}
			else
			{
				text = new ChatComponentText("https://www.videolan.org/vlc/").setChatStyle(style);
			}
			event.player.addChatComponentMessage(text);
		}
	}
}
