package com.pixelutilities.blocks;

import java.util.Random;

import com.pixelutilities.GrassSpawner;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PixelmonGrassBlock extends Block implements IGrowable {

	private GrassSpawner grassSpawner = GrassSpawner.getInstance();
	public static Boolean isActive = false;

	public PixelmonGrassBlock() {
		super(Material.grass);
		setHardness(4.0F);
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
		if (entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) entity;
			grassSpawner.spawnInGrass(world, x, y, z, player);
		}
	}

	/*@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) entity;
			grassSpawner.spawnInGrass(world, x, y, z, player);
		}
		else if(entity instanceof EntityClientPlayerMP)
		{
			EntityClientPlayerMP playerSP = (EntityClientPlayerMP) entity;
			EntityPlayer ep = playerSP.worldObj.getPlayerEntityByName(playerSP.getDisplayName());
			if(ep instanceof EntityPlayerMP)
			{
				EntityPlayerMP player = (EntityPlayerMP) entity;
				grassSpawner.spawnInGrass(world, x, y, z, player);
			}
			//MinecraftServer.getServer().worldServers[0].getPlayerEntityByName(playerSP.getDisplayName());
		}
	}*/

	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
	{
		int l = p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_);
		return l != 0;
	}

	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
	{
		return true;
	}

	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		//makes regular grass into 2 blocks high grass
	}
}
