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
}
