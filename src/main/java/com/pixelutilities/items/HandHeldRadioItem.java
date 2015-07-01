package com.pixelutilities.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelutilities.gui.GuiHandHeldRadio;

public class HandHeldRadioItem extends Item {
    private String URL;

    public HandHeldRadioItem() {
        setUnlocalizedName("HandHeldRadioItem");

    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiHandHeldRadio(player));
        return itemStack;

    }


}
