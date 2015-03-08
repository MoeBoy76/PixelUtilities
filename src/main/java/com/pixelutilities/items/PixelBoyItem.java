package com.pixelutilities.items;

import com.pixelutilities.gui.GuiPixelBoy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PixelBoyItem extends Item {

    public PixelBoyItem() {
        super();

        maxStackSize = 1;
        setUnlocalizedName("PixelBoyItem");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        Minecraft.getMinecraft().displayGuiScreen(new GuiPixelBoy());

        return itemStack;
    }

}
