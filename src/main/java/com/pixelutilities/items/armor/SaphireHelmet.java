package com.pixelutilities.items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SaphireHelmet extends ItemArmor {

    public SaphireHelmet(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        setCreativeTab(CreativeTabs.tabCombat);
        setTextureName("pixelUtilities:SaphireHelmet");
        setUnlocalizedName("Saphire Helmet");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == Basemod.instance.saphireLegs) {
            return "pixelutilities:textures/armor/SaphireArmor_2.png";
        } else {
            return "pixelutilities:textures/armor/SaphireArmor_1.png";
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("pixelutilities:SaphireHelmet");
    }
}