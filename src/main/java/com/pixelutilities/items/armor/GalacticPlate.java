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

public class GalacticPlate extends ItemArmor {

    public GalacticPlate(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesArmours);
        if (!PixelUtilitiesArmor.getArmourList().contains(this))
			PixelUtilitiesArmor.getArmourList().add(this);
        setTextureName("pixelutilities:armor/GalacticPlate");
        setUnlocalizedName("Galactic_ChestPlate");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == Basemod.instance.galacticLegs) {
            return "pixelutilities:textures/armor/GalacticArmor_2.png";
        } else {
            return "pixelutilities:textures/armor/GalacticArmor_1.png";
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/GalacticChestplate");
    }
}
