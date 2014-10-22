package com.pixelutilities.items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RocketLegs extends ItemArmor {

    public RocketLegs(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesArmours);
        if (!PixelUtilitiesArmor.getArmourList().contains(this))
			PixelUtilitiesArmor.getArmourList().add(this);
        setTextureName("pixelutilities:armor/RocketLegs");
        setUnlocalizedName("Rocket_Leggings");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == Basemod.instance.rocketLegs) {
            return "pixelutilities:textures/armor/RocketArmor_2.png";
        } else {
            return "pixelutilities:textures/armor/RocketArmor_1.png";
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/RocketLeggings");
    }
}
