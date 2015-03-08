package com.pixelutilities.items.tools;

import com.pixelutilities.config.PixelUtilitiesCreativeTabs;
import com.pixelutilities.config.PixelUtilitiesTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PixelShovelTool extends ItemSpade {

    public PixelShovelTool(ToolMaterial par3EnumToolMaterial, String textureName, String unLocName) {
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
    
    @Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		int x = p_77648_4_;
		int y = p_77648_5_ + 1;
		int z = p_77648_6_;

		return ToolManipulator.addToolEffect(stack, player, world, x, y, z);
	}
}
