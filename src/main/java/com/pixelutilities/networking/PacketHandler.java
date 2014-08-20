package com.pixelutilities.networking;

import com.pixelutilities.Basemod;
import com.pixelutilities.networking.networkMessages.MessageTileEntityRadio;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Basemod.MODID);

    public static void init() {
        INSTANCE.registerMessage(MessageTileEntityRadio.Handler.class, MessageTileEntityRadio.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(MessageTileEntityRadio.Handler.class, MessageTileEntityRadio.class, 0, Side.SERVER);
    }
}
