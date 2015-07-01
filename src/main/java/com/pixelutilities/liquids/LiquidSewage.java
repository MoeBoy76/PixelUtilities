package com.pixelutilities.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

public class LiquidSewage extends BlockFluidClassic {


    public LiquidSewage(Fluid fluid) {
        super(fluid,Material.water);
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
        setUnlocalizedName("sewageFluid");
    }

    /*@Override
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
    }*/

    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
        return super.canDisplace(world, pos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos pos)
    {
        if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
        {
        	return false;
        }
        return super.displaceIfPossible(world, pos);
    }
    
    /*@Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, BlockPos pos)
    {
    	return false;
    }*/
    
    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity)
    {
    	if(entity instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) entity;
    		//Poison for 5 seconds
    		player.addPotionEffect(new PotionEffect(19, 5, 1, false, false));
    	}

    	super.onEntityCollidedWithBlock(world, pos, entity);
    }
}
