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
import com.pixelmonmod.pixelmon.customStarters.SelectPokemonController;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelutilities.config.PixelUtilitiesConfig;

public class SelectPokemon implements IMessage {
	int starterScreenIndex;
	int starterPokeEnum = -1;

	public SelectPokemon() {
	}

	public SelectPokemon(int starterPokeEnum) {
		this.starterPokeEnum = starterPokeEnum;
	}

	public SelectPokemon(int starterPokeEnum, int starterIndex)
	{
		this.starterScreenIndex = starterIndex;
		this.starterPokeEnum = starterPokeEnum;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		starterPokeEnum = buf.readInt();
		try {
			starterScreenIndex = buf.readInt();
		} catch (Exception e)
		{
			
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(starterPokeEnum);
		if(starterScreenIndex != -1)
			buf.writeInt(starterScreenIndex);
	}

	public static class Handler implements IMessageHandler<SelectPokemon, IMessage> {

		@Override
		public IMessage onMessage(SelectPokemon message, MessageContext ctx) {
			try {
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				PlayerStorage s = PixelmonStorage.PokeballManager.getPlayerStorage(player);
				EntityPixelmon p = (EntityPixelmon) PixelmonEntityList.createEntityByName(EnumPokemon.values()[message.starterPokeEnum].name, player.worldObj);
				//EntityPixelmon p = (EntityPixelmon) PixelmonEntityList.createEntityByName(SelectPokemonController.getPokemonList(player)[message.starterIndex].name, player.worldObj);
				SelectPokemonController.removePlayer(player);
				if(message.starterScreenIndex != -1)
					p.getLvl().setLevel(PixelUtilitiesConfig.getInstance().getStarterListLvl(message.starterScreenIndex));
				else
					p.getLvl().setLevel(CustomStarters.starterLevel);
				p.setHealth(p.stats.HP);
				p.loadMoveset();
				if(message.starterScreenIndex != -1)
					p.caughtBall = PixelUtilitiesConfig.getInstance().getPokeballForList(message.starterScreenIndex);
				else
					p.caughtBall = EnumPokeballs.PokeBall;
				p.friendship.initFromCapture();
				s.addToParty(p);
				s.starterPicked = true;
				Pixelmon.EVENT_BUS.post(new PixelmonRecievedEvent(player, ReceiveType.SelectPokemon, p));
			} catch (PlayerNotLoadedException e) {
			}
			return null;
		}
	}
}