package com.pixelutilities.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.pixelmonmod.pixelmon.config.PixelmonConfig;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity3HasStats;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelutilities.Basemod;
import com.pixelutilities.enums.EnumGui;
import com.pixelutilities.gui.starters.StarterListStorage;

public class SelectPokemonListPacket implements IMessage {

	public SelectPokemonListPacket() {
	}

	public EnumPokemon[] pokemonList;
	public int[] pokemonListIndex;
	
	public SelectPokemonListPacket(EnumPokemon... starters) {
		pokemonList = starters;
		pokemonListIndex = new int[pokemonList.length];

		for (int i = 0; i < pokemonList.length; i++)
			if (pokemonList[i] != null) {
				int ID = Entity3HasStats.getBaseStats(pokemonList[i].name).nationalPokedexNumber;
				int value = -2;
				if (ID <= 151) {
					if (PixelmonConfig.Gen1)
						value = ID;
				} else if (ID > 151 && ID <= 251) {
					if (PixelmonConfig.Gen2)
						value = ID;
				} else if (ID > 251 && ID <= 386) {
					if (PixelmonConfig.Gen3)
						value = ID;
				} else if (ID > 386 && ID <= 493) {
					if (PixelmonConfig.Gen4)
						value = ID;
				} else if (ID > 493 && ID <= 649) {
					if (PixelmonConfig.Gen5)
						value = ID;
				}
				pokemonListIndex[i] = value;
			} else
				pokemonListIndex[i] = -1;
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		pokemonList = new EnumPokemon[buffer.readShort()];
		pokemonListIndex = new int[pokemonList.length];
		for (int i = 0; i < pokemonList.length; i++) {
			int index = buffer.readInt();
			pokemonListIndex[i] = index;
			if (index >= 0)
				pokemonList[i] = EnumPokemon.getFromName(Entity3HasStats.getBaseStats(index).pixelmonName);
		}
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeShort(pokemonList.length);
		for (int i : pokemonListIndex) {
			buffer.writeInt(i);
		}
	}

	public static class Handler implements IMessageHandler<SelectPokemonListPacket, IMessage> {

		@Override
		public IMessage onMessage(SelectPokemonListPacket message, MessageContext ctx) {
			//StarterListStorage.selectPokemonListPacket = message;
			//Minecraft.getMinecraft().thePlayer.openGui(Basemod.instance, EnumGui.SelectPokemon.getIndex(), Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
			return null;
		}

	}
}