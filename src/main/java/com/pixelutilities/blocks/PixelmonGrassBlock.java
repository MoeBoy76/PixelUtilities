package com.pixelutilities.blocks;

import com.pixelutilities.GrassSpawner;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class PixelmonGrassBlock extends Block {

	private GrassSpawner grassSpawner = GrassSpawner.getInstance();
	public static Boolean isActive = false;

	public PixelmonGrassBlock() {
		super(Material.grass);
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypeGrass);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		return null;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if(!isActive)
		{
			if (entity instanceof EntityPlayerMP)
			{
				EntityPlayerMP player = (EntityPlayerMP) entity;
				isActive = true;
				grassSpawner.spawnInGrass(world, x, y, z, player);
			}
		}
	}
}
