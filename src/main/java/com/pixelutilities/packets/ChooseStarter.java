package com.pixelutilities.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.PixelmonRecievedEvent;
import com.pixelmonmod.pixelmon.api.events.ReceiveType;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.customStarters.CustomStarters;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelutilities.gui.starters.StarterListStorage;

public class ChooseStarter implements IMessage {
	int starterIndex;
	int starterPokeEnum = -1;

	public ChooseStarter() {
	}

	public ChooseStarter(int starterIndex) {
		this.starterIndex = starterIndex;
	}

	public ChooseStarter(int starterPokeEnum, int starterIndex)
	{
		this.starterIndex = starterIndex;
		this.starterPokeEnum = starterPokeEnum;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		starterIndex = buf.readInt();
		try {
			starterPokeEnum = buf.readInt();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(starterIndex);
		if(starterPokeEnum != -1)
			buf.writeInt(starterPokeEnum);
	}

	public static class Handler implements IMessageHandler<ChooseStarter, IMessage> {

		@Override
		public IMessage onMessage(ChooseStarter message, MessageContext ctx) {
			try {
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				PlayerStorage s = PixelmonStorage.PokeballManager.getPlayerStorage(player);
				if (s.starterPicked)
					return null;
				EntityPixelmon p = (EntityPixelmon) PixelmonEntityList.createEntityByName(EnumPokemon.values()[message.starterPokeEnum].name, player.worldObj);
				//EntityPixelmon p = (EntityPixelmon) PixelmonEntityList.createEntityByName(StarterListStorage.starterListPacket.starterList[message.starterIndex].name, player.worldObj);
				p.getLvl().setLevel(CustomStarters.starterLevel);
				if (CustomStarters.shinyStarter) {
					p.setIsShiny(CustomStarters.shinyStarter);
				}
				p.setHealth(p.stats.HP);
				p.loadMoveset();
				p.caughtBall = EnumPokeballs.PokeBall;
				p.friendship.initFromCapture();
				s.addToParty(p);
				s.starterPicked = true;
				Pixelmon.EVENT_BUS.post(new PixelmonRecievedEvent(player, ReceiveType.Starter, p));
			} catch (PlayerNotLoadedException e) {
			}
			return null;
		}

	}
}