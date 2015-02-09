package com.pixelutilities.networking.networkMessages;

import com.pixelutilities.networking.PacketHandler;
import com.pixelutilities.tileentitys.TileEntityRadio;
import io.netty.buffer.ByteBuf;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageTileEntityRadio implements IMessage {

    public BlockPos blockPos;
    public boolean playing = false;
    public String url = "http://www.youtube.com/watch?v=4M6qAMMqFhI&hd=1";

    public MessageTileEntityRadio() {
    }

    public MessageTileEntityRadio(BlockPos blockPos, boolean playing, String url) {
        this.blockPos = blockPos;
        this.playing = playing;
        this.url = url;
    }

    public MessageTileEntityRadio(TileEntityRadio radio) {
        this.blockPos = radio.getPos();
        this.url = radio.streamURL;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
	    this.blockPos = new BlockPos(x, y, z);
        this.playing = buf.readBoolean();
        int streamLength = buf.readInt();
        if (streamLength > 0)
            this.url = new String(buf.readBytes(streamLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.blockPos.getX());
        buf.writeInt(this.blockPos.getY());
        buf.writeInt(this.blockPos.getZ());
        buf.writeBoolean(playing);

        int urlLength = this.url.length();
        buf.writeInt(urlLength);
        if (urlLength > 0)
            buf.writeBytes(this.url.getBytes());

    }

    public static class Handler implements IMessageHandler<MessageTileEntityRadio, IMessage> {
        @Override
        public IMessage onMessage (MessageTileEntityRadio message, MessageContext context){
            if (context.side == Side.SERVER) {
                PacketHandler.INSTANCE.sendToAll(message);
            }

            TileEntity te = null;
            if (context.side == Side.SERVER) {
                EntityPlayerMP p = context.getServerHandler().playerEntity;
                te = MinecraftServer.getServer().worldServerForDimension(p.dimension).getTileEntity(message.blockPos);
            }
            if (context.side == Side.CLIENT) {
                te = Minecraft.getMinecraft().theWorld.getTileEntity(message.blockPos);
            }


            if (te == null) {
                System.out.println("te is null D:");
                System.out.println("te should be at "+ message.blockPos.toString());
            }


            if (te instanceof TileEntityRadio) {
                TileEntityRadio r = (TileEntityRadio) te;
                r.streamURL = message.url;

                if (context.side == Side.CLIENT)
                    if (message.playing && !r.isPlaying()) {
                        r.startStream();
                    } else {
                        r.stopStream();
                    }
            }
            return null;


        }
    }


}
