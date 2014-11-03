package com.pixelutilities.liquids;

import com.pixelutilities.Basemod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class LiquidSewage extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public LiquidSewage(Fluid fluid) {
        super(fluid,Material.water);
        setCreativeTab(CreativeTabs.tabMisc);
        setBlockName("sewageFluid");
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.stillIcon = iconRegister.registerIcon(Basemod.MODID+":sewageStill");
        this.flowingIcon = iconRegister.registerIcon(Basemod.MODID+":sewageFlowing");
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid())
        {
        	return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }
    
    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z)
    {
    	return false;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	if(entity instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) entity;
    		//Poison for 5 seconds
    		player.addPotionEffect(new PotionEffect(19, 5, 1, false));
    	}

    	super.onEntityCollidedWithBlock(world, x, y, z, entity);
    }
}
