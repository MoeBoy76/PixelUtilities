package com.pixelutilities.items.tools;

import com.pixelutilities.config.PixelUtilitiesCreativeTabs;
import com.pixelutilities.config.PixelUtilitiesTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class PixelPickaxeTool extends ItemPickaxe {

    public PixelPickaxeTool(ToolMaterial par3EnumToolMaterial, String textureName, String unLocName) {
        super(par3EnumToolMaterial);

        setUnlocalizedName(unLocName);
        setTextureName(textureName);
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(this.iconString);
    }

    @Override
    public Item setCreativeTab(CreativeTabs tabs) {
        super.setCreativeTab(tabs);
        if (!PixelUtilitiesTools.getInstance().getToolList().contains(this))
            PixelUtilitiesTools.getInstance().getToolList().add(this);
        return null;
    }

}
