package com.pixelutilities.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelmonmod.pixelmon.api.events.BattleStartedEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedAbnormalEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.radioplayer.VLCPlayer;

@SideOnly(Side.CLIENT)
public class PUTickHandler
{
	public static VLCPlayer playerRadio = new VLCPlayer(PixelUtilitiesConfig.getInstance().BattleMusicURL, 50);
	public boolean inBattle = false;

	@SubscribeEvent
	public void onBattleStart(BattleStartedEvent event)
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
