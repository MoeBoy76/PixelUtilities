package com.pixelutilities.tileentitys;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.networking.PacketHandler;
import com.pixelutilities.networking.networkMessages.MessageTileEntityRadio;
import com.pixelutilities.radioplayer.VLCPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityRadio extends TileEntity {

    private VLCPlayer player = null;
    private boolean isPlaying = false;
    private boolean isLooping = false;
    public String streamURL = "";

    public Block getBlockType() {
        return PixelUtilitiesBlocks.radioBlock;
    }

    @SideOnly(Side.CLIENT)
    public void startStream() {
        System.out.println("start Stream " + streamURL);

        Side side = FMLCommonHandler.instance().getEffectiveSide();

        System.out.println(side.name());

        if (!isPlaying) {
            isPlaying = true;

            if (side == Side.CLIENT) {
                System.out.println("making new player");
                player = new VLCPlayer(streamURL);
                System.out.println("player working? " + player.isPlaying());
                Basemod.playerList.add(player);
            }
        } else {
            System.err.println("Tried to play a stream twice out of one radio!");
        }
    }

    @SideOnly(Side.CLIENT)
    public void stopStream() {
        System.out.println("stopping stream");
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        if (isPlaying) {
            if (side == Side.CLIENT) {
                System.out.println("is stoped player playing " + player.isPlaying());
                player.stop();
                Basemod.playerList.remove(player);
            }
            isPlaying = false;//player.isPlaying();
        } else {
            System.err.println("Tried to stop a nonplaying radio!");
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public boolean isLooping() {
        return isLooping;
    }

    public void setIsLooping(boolean loop) {
        isLooping = loop;

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void invalidate() {
        PacketHandler.INSTANCE.sendToServer(new MessageTileEntityRadio(this.getPos(), !isPlaying(), streamURL));
        stopStream();
        super.invalidate();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onChunkUnload() {
        if (isPlaying) {
            stopStream();
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateEntity() {
        if (Minecraft.getMinecraft().thePlayer != null && player != null && !isInvalid()) {
            float vol = (float) getDistanceSq(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ);
            if (vol > 10000) {
                player.setVolume(0);
            } else {
                float v2 = (10000f / vol) / 100f;
                if (v2 > 1) {
                    player.setVolume(1);
                } else {
                    player.setVolume(v2);
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        streamURL = par1NBTTagCompound.getString("streamurl");
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("streamurl", streamURL);
    }

    @Override
    public Packet getDescriptionPacket() {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            PacketHandler.INSTANCE.sendToServer(new MessageTileEntityRadio(this.getPos(), isPlaying(), streamURL));
        return null;
    }
}