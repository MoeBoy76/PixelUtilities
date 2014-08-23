package com.pixelutilities.items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.pixelutilities.Basemod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrystalBoots extends ItemArmor {

    public CrystalBoots(ArmorMaterial par2EnumArmorMaterial,
                        int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        setCreativeTab(CreativeTabs.tabCombat);
        setTextureName("pixelUtilities:CrystalBoots");
        setUnlocalizedName("Crystal Boots");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == Basemod.instance.crystalLegs) {
            return "pixelutilities:textures/armor/CrystalArmor_2.png";
        } else {
            return "pixelutilities:textures/armor/CrystalArmor_1.png";
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("pixelutilities:CrystalBoots");
    }
}