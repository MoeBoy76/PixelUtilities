package com.pixelutilities.networking;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.pixelutilities.Basemod;
import com.pixelutilities.networking.networkMessages.MessageTileEntityRadio;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = Basemod.network;

    public static void init() {
        INSTANCE.registerMessage(MessageTileEntityRadio.Handler.class, MessageTileEntityRadio.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(MessageTileEntityRadio.Handler.class, MessageTileEntityRadio.class, 0, Side.SERVER);
    }
}
