package com.pixelutilities.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelutilities.gui.GuiRadio;
import com.pixelutilities.tileentitys.TileEntityRadio;

public class RadioBlock extends Block implements ITileEntityProvider {

    public TileEntityRadio radio;

    public RadioBlock() {
        super(Material.wood);
        setHardness(2.0F);
        setResistance(10.0F);
        setStepSound(Block.soundTypeStone);
        setUnlocalizedName("Radio");
        //setCreativeTab(CreativeTabs.tabDecorations);
        //setBlockTextureName("pixelutilities:radio");
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {

        } else {
            Side mcSide = FMLCommonHandler.instance().getEffectiveSide();
            if (mcSide == Side.CLIENT) {
                openGUI(world, pos);
            }
        }

        return true;

    }

    @SideOnly(Side.CLIENT)
    private void openGUI(World par1World, BlockPos pos) {
        TileEntityRadio ter = (TileEntityRadio) par1World.getTileEntity(pos);
        Minecraft.getMinecraft().displayGuiScreen(new GuiRadio(ter));
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 189;
    }

    /*@Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        switch (par1IBlockAccess.getTileEntity(par2, par3, par4).getBlockMetadata()) {
            default:
                setBlockBounds(0.0F, 0.0F, 0.4F, 1.0F, 0.5F, 0.7F);
                break;
            case 1:
                setBlockBounds(0.4F, 0.5F, 0.0F, 0.7F, 0.0F, 1.0F);
                break;
            case 2:
                setBlockBounds(0.0F, 0.0F, 0.4F, 1.0F, 0.5F, 0.7F);
                break;
            case 3:
                setBlockBounds(0.4F, 0.5F, 0.0F, 0.7F, 0.0F, 1.0F);
                break;
        }

    }*/

    /**
     * Called when the block is placed in the world.
     */
    /*@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = world.getBlockMetadata(pos) >> 2;
        ++l;
        l %= 4;

        if (l == 3) {
            world.setBlockMetadataWithNotify(pos, 2 | i1 << 2, 2);
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

    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @Override
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {

        TileEntityRadio radio = (TileEntityRadio) Minecraft.getMinecraft().theWorld.getTileEntity(pos);
        if (radio.isPlaying())
            for (int l = 0; l < 4; ++l) {
                double d0 = (double) ((float) pos.getX() + rand.nextFloat());
                double d1 = (double) ((float) pos.getY() + rand.nextFloat());
                double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
                double d3;
                double d4;
                double d5;
                int i1 = rand.nextInt(2) * 2 - 1;
                d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
                d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
                d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

                if (world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) != this && world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) != this) {
                    d0 = (double) pos.getX() + 0.5D + 0.25D * (double) i1;
                    d3 = (double) (rand.nextFloat() * 2.0F * (float) i1);
                } else {
                    d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) i1;
                    d5 = (double) (rand.nextFloat() * 2.0F * (float) i1);
                }

                world.spawnParticle(EnumParticleTypes.NOTE, d0, d1, d2, d3, d4, d5);
            }

    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityRadio();
    }
}
