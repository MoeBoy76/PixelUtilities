package com.pixelutilities.packets;

import net.minecraftforge.fml.relauncher.Side;

import com.pixelutilities.Basemod;

public class PacketRegistry {
	static int id = 0;

	public static void registerPackets() {
		Basemod.network.registerMessage(StarterListPacket.Handler.class, StarterListPacket.class, id++, Side.CLIENT);
		//Basemod.network.registerMessage(SelectPokemonListPacket.Handler.class, SelectPokemonListPacket.class, id++, Side.CLIENT);
		Basemod.network.registerMessage(SelectPokemon.Handler.class, SelectPokemon.class, id++, Side.SERVER);
	}
}
