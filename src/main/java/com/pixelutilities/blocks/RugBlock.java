package com.pixelutilities.blocks;

import com.pixelutilities.tileentitys.BlueRugEntity;
import com.pixelutilities.tileentitys.GreenRugEntity;
import com.pixelutilities.tileentitys.RedRugEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;


public class RugBlock extends BlockContainer {

    String color;

    public RugBlock(String color) {
        super(Material.cloth);
        this.setBlockBounds(0.4F, 0.0F, 0.3F, 0.3F, 3.0F, 0.3F); //0.4 0.0 1.0 
        this.color = color;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this
     * box can change after the pool has been cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        this.setBlockBounds(par1World.getBlockMetadata(par2, par3, par4));
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        this.setBlockBounds(par1World.getBlockMetadata(par2, par3, par4));
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if ((l & 4) != 0) {
            this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        if (color.equals("blue"))
            blockIcon = par1IconRegister.registerIcon("pixelutilities:BluePokeballRug");
        if (color.equals("red"))
            blockIcon = par1IconRegister.registerIcon("pixelutilities:RedPokeballRug");
        if (color.equals("green"))
            blockIcon = par1IconRegister.registerIcon("pixelutilities:GreenPokeballRug");
    }

    public void setBlockBounds(int stage) {
        this.setBlockBounds(0f, 0, 0f, 1f, 0.01f, 2f);
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
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        //noinspection StringEquality
        if (color == "blue")
            return new BlueRugEntity();
        //noinspection StringEquality
        if (color == "red")
            return new RedRugEntity();
        //noinspection StringEquality
        if (color == "green")
            return new GreenRugEntity();

        return new BlueRugEntity();
    }

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
                                EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper
                .floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = par1World.getBlockMetadata(par2, par3, par4) >> 2;
        ++l;
        l %= 4;

        if (l == 3) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | i1 << 2,
                    2);
        }

        if (l == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | i1 << 2,
                    2);
        }

        if (l == 1) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i1 << 2,
                    2);
        }

        if (l == 2) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | i1 << 2,
                    2);
        }
    }

}