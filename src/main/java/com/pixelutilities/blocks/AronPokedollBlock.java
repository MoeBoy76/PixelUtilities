package com.pixelutilities.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelutilities.config.PixelUtilitiesCreativeTabs;
import com.pixelutilities.tileentitys.AronPokedollEntity;

public class AronPokedollBlock extends BlockContainer {


	public AronPokedollBlock() {
		super(Material.cloth);
		this.setBlockBounds(0.4F, 0.0F, 0.3F, 0.4F, 0.0F, 1.0F); //0.4 0.0 1.0 
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	/*@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4) {
		this.setBlockBounds(world.getBlockState(par2, par3, par4));
		return super.getCollisionBoundingBoxFromPool(world, par2, par3, par4);
	}*/

	/**
	 * Returns the bounding box of the wired rectangular prism to render.
	 */
	/*@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int par2, int par3, int par4) {
		this.setBlockBounds(world.getBlockState(par2, par3, par4));
		return super.getSelectedBoundingBoxFromPool(world, par2, par3, par4);
	}*/

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
		int l = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos));

		if ((l & 4) != 0) {
			this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}
	}

	public void setBlockBounds(int stage) {
		this.setBlockBounds(0f, 0, 0f, 0.7f, 0.7f, 0.7f);
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}


	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new AronPokedollEntity();
	}

	/**
	 * set a blocks direction
	 */
	 /*@Override
	 public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		 int l = MathHelper
				 .floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		 int i1 = world.getBlockState(pos) >> 2;
		 ++l;
		 l %= 4;

		 if (l == 3) {
			 world.setBlockMetadataWithNotify(pos, 2 | i1 << 2,
					 2);
		 }

		 if (l == 0) {
			 world.setBlockMetadataWithNotify(pos, 3 | i1 << 2,
					 2);
		 }

		 if (l == 1) {
			 world.setBlockMetadataWithNotify(pos, i1 << 2,
					 2);
		 }

		 if (l == 2) {
			 world.setBlockMetadataWithNotify(pos, 1 | i1 << 2,
					 2);
		 }
	 }*/

}