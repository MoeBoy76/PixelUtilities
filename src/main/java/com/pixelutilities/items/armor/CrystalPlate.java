package com.pixelutilities.items.armor;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CrystalPlate extends ItemArmor {

	private boolean isRegular;
	
    public CrystalPlate(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean isRegular) {
        super(par2EnumArmorMaterial, par3, par4);
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesArmours);
        if (!PixelUtilitiesArmor.getArmourList().contains(this))
			PixelUtilitiesArmor.getArmourList().add(this);
        this.isRegular = isRegular;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if(isRegular)
        {
    	if (stack.getItem() == Basemod.instance.crystalLegs) {
            return "pixelutilities:textures/armor/PlasmaArmor_2.png";
        } else {
            return "pixelutilities:textures/armor/PlasmaArmor_1.png";
        }
        }
        else
        {
        	if (stack.getItem() == Basemod.instance.neoLegs) {
                return "pixelutilities:textures/armor/NeoPlasmaArmor_2.png";
            } else {
                return "pixelutilities:textures/armor/NeoPlasmaArmor_1.png";
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
    	if(isRegular)
    	{
    		this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/PlasmaChestplate");
    	}
    	else
    	{
    		this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/NeoPlasmaChestplate");
    	}
    }
}
