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

public class StarterListPacket implements IMessage {

	public StarterListPacket() {
	}

	public EnumPokemon[] starterList;
	public int[] starterListIndex;

	public StarterListPacket(EnumPokemon... starters) {
		starterList = starters;
		starterListIndex = new int[starterList.length];

		for (int i = 0; i < starterList.length; i++) {
			if(i > 14)
				break;
			if (starterList[i] != null) {
				int ID = Entity3HasStats.getBaseStats(starterList[i].name).nationalPokedexNumber;
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
				starterListIndex[i] = value;
			} else
				starterListIndex[i] = -1;
		}
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		starterList = new EnumPokemon[buffer.readShort()];
		starterListIndex = new int[starterList.length];
		for (int i = 0; i < starterList.length; i++) {
			int index = buffer.readInt();
			starterListIndex[i] = index;
			if (index >= 0)
				starterList[i] = EnumPokemon.getFromName(Entity3HasStats.getBaseStats(index).pixelmonName);
		}
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeShort(starterList.length);
		for (int i : starterListIndex) {
			buffer.writeInt(i);
		}
	}

	public static class Handler implements IMessageHandler<StarterListPacket, IMessage> {

		@Override
		public IMessage onMessage(StarterListPacket message, MessageContext ctx) {
			StarterListStorage.starterListPacket = message;
			//Minecraft.getMinecraft().thePlayer.openGui(Basemod.instance, EnumGui.SelectPokemon.getIndex(), Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
			return null;
		}

	}
}