package com.pixelutilities.items.tools;


import com.google.common.collect.Multimap;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;
import com.pixelutilities.config.PixelUtilitiesTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PixelAxeTool extends ItemAxe
{

    public PixelAxeTool(ToolMaterial par3EnumToolMaterial, String textureName, String unLocName)
    {
        super(par3EnumToolMaterial);

        setUnlocalizedName(unLocName);
        setTextureName(textureName);
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.iconString);
    }

    @Override
    public Item setCreativeTab(CreativeTabs tabs)
    {
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
    	
    	String toolName = stack.getUnlocalizedName();
    	
    	if(toolName.contains("fire"))
    	{
    		if(world.getBlock(x, y, z).equals(Blocks.water))
    		{
    			world.setBlock(x, y, z, Blocks.obsidian);
    			stack.damageItem(1, player);
    			return true;
    		}
    		if(Blocks.torch.canPlaceBlockAt(world, x, y, z))
    		{
    			world.setBlock(x, y, z, Blocks.torch);
    			stack.damageItem(1, player);
    			return true;
    		}
    	}
    	if(toolName.contains("water"))
    	{
    		if(world.getBlock(x, y, z).equals(Blocks.lava))
    		{
    			world.setBlock(x, y, z, Blocks.obsidian);
    			stack.damageItem(1, player);
    			return true;
    		}
    		else
    		{
    			world.setBlock(x, y, z, Blocks.water);
    			stack.damageItem(1, player);
    			return true;
    		}
    	}
    	if(stack.getUnlocalizedName().contains("leaf"))
    	{
    		
    	}
    	return false;
    }
}
