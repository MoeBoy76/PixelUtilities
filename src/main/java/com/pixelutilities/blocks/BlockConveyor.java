package com.pixelutilities.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelutilities.config.PixelUtilitiesCreativeTabs;
import com.pixelutilities.tileentitys.TileEntityConveyor;

public class BlockConveyor extends BlockContainer {
    
    private int renderPass;

    public BlockConveyor() {
        super(Material.circuits);
        setHardness(0.5F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.01F, 0.1F);
        setUnlocalizedName("conveyor");
        setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        base = ir.registerIcon("pixelutilities:" + getUnlocalizedName() + ".base");
        overlay = ir.registerIcon("pixelutilities:" + getUnlocalizedName() + ".overlay");
        overlayFast = ir.registerIcon("pixelutilities:" + getUnlocalizedName() + ".overlay.fast");
        overlayStopped = ir.registerIcon("pixelutilities:" + getUnlocalizedName() + ".overlay.stopped");
    }*/

    @Override
    public boolean recolorBlock(World world, BlockPos pos, EnumFacing side, EnumDyeColor color) {
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityConveyor) {
            EnumDyeColor dye = ((TileEntityConveyor) tile).getDyeColor();
            ((TileEntityConveyor) tile).setDyeColor(color);
            return dye != ((TileEntityConveyor) tile).getDyeColor();
        }
        return false;
    }

    @Override
    public int getRenderColor(IBlockState state) {
        return 0xFFFFFF;
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (renderPass == 1)
            switch (meta) {
                case 0:
                    return overlayStopped;
                case 1:
                    return overlay;
                case 2:
                    return overlayFast;
            }
        return base;
    }*/

    //TODO fix metadata thingy
    /*@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (placer == null) {
            return;
        }
        int facing = MathHelper.floor_double((placer.rotationYaw * 4F) / 360F + 0.5D) & 3;
        if (facing == 0) {
            world.setBlockMetadataWithNotify(pos, 1, 2);
        }
        if (facing == 1) {
            world.setBlockMetadataWithNotify(pos, 2, 2);
        }
        if (facing == 2) {
            world.setBlockMetadataWithNotify(pos, 3, 2);
        }
        if (facing == 3) {
            world.setBlockMetadataWithNotify(pos, 0, 2);
        }

        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityConveyor) {
            ((TileEntityConveyor) te).setDyeColor(stack.getItemDamage() == 16 ? -1 : stack.getItemDamage());
        }
    }*/


    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, BlockPos pos, Vec3 vec3d, Vec3 vec3d1) {
        setBlockBoundsBasedOnState(world, pos);
        return super.collisionRayTrace(world, pos, vec3d, vec3d1);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
        int l = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos));
        if (l >= 4 && l <= 11) {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }
    }

    @Override
    public int getRenderType() {
        return 500;//TODO BAD BAD BAD BAD BAD
        //return MineFactoryReloadedCore.renderIdConveyor;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    /*@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return canBlockStay(world, pos);
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos) {
        return world.isSideSolid(pos, EnumFacing.UP, false);
    }*/

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
    	ItemStack item = player.getHeldItem();

        if (item != null && item.getItem().equals(Items.glowstone_dust)) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileEntityConveyor && !((TileEntityConveyor) te).isFast()) {
                ((TileEntityConveyor) te).setFast(true);
                world.markBlockForUpdate(pos);
                if (!player.capabilities.isCreativeMode)
                    item.stackSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborId) {
        /*if (!canBlockStay(world, pos)) {
            world.setBlockToAir(pos);
            dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
            return;
        }*/

        TileEntity tec = world.getTileEntity(pos);
        if (tec instanceof TileEntityConveyor) {
            ((TileEntityConveyor) tec).updateConveyorActive();
        }
    }


    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity) {
        double playerx = entity.posX;
        double playerz = entity.posZ;
        if (!((playerz > pos.getZ() + 0.40) && (playerz < pos.getZ() + 0.60)))
            if (!((playerx > pos.getX() + 0.40) && (playerx < pos.getX() + 0.60)))
                return;

        boolean isItem = entity instanceof EntityItem || entity instanceof EntityXPOrb;

        if (!(isItem || entity instanceof EntityLivingBase || entity instanceof EntityTNTPrimed))
            return;

        TileEntity conveyor = world.getTileEntity(pos);
        if (!(conveyor instanceof TileEntityConveyor))
            return;

        if (entity instanceof EntityLivingBase)
            l:{
                ItemStack item = ((EntityLivingBase) entity).getEquipmentInSlot(1);
                if (item == null) break l;
            }
        double mult = ((TileEntityConveyor) conveyor).isFast() ? 500.1 : 10.15;

        double xVelocity = 0;
        double yVelocity = 0;
        double zVelocity = 0;

        int md = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos));

        int horizDirection = md & 0x03;
        boolean isUphill = (md & 0x04) != 0;
        boolean isDownhill = (md & 0x08) != 0;

        if (isUphill) {
            yVelocity = 0.17D * mult;
        } else if (entity.posY - pos.getY() < 0.1 & entity.posY - pos.getY() > 0) {
            entity.posY = pos.getY() + 0.1;
        } else if (isDownhill) {
            yVelocity = -0.07 * mult;
        }

        if (isUphill | isDownhill) {
            entity.onGround = false;
        }

        switch (horizDirection) {
            case 0:
                zVelocity = 0;
                xVelocity = 0.1D * mult;
                break;
            case 1:
                xVelocity = 0;
                zVelocity = 0.1D * mult;
                break;
            case 2:
                zVelocity = 0;
                xVelocity = -0.1D * mult;
                break;
            case 3:
                xVelocity = 0;
                zVelocity = -0.1D * mult;
                break;
        }
        entity.setPosition(pos.getX() + 0.5, entity.posY + 0.1, pos.getZ() + 0.5);

        setEntityVelocity(entity, xVelocity, yVelocity, zVelocity);

        entity.fallDistance *= 0.9;
        /*if (entity instanceof EntityItem) {
            ((EntityItem) entity).delayBeforeCanPickup = 40;
        }*/
    }

    private void setEntityVelocity(Entity e, double x, double y, double z) {
        e.motionX = x;
        e.motionY = y;
        e.motionZ = z;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityConveyor();
    }

    /*@Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, BlockPos pos) {
        TileEntity te = world.getTileEntity(pos);
        int dyeColor = 16;
        if (te instanceof TileEntityConveyor) {
            dyeColor = ((TileEntityConveyor) te).getDyeColor();
            if (dyeColor == -1) dyeColor = 16;
        }
        return getRenderColor(dyeColor);
    }*/

    @Override
    public int getDamageValue(World world, BlockPos pos) {
        TileEntity te = world.getTileEntity(pos);
        int dyeColor = 16;
        if (te instanceof TileEntityConveyor) {
            dyeColor = ((TileEntityConveyor) te).getDyeColor().getDyeDamage();
            if (dyeColor == -1) dyeColor = 16;
        }
        return dyeColor;
    }

    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<>();
        if (world.getBlockState(pos).getBlock().equals(this)) {
            ret.add(new ItemStack(this, 1, getDamageValue((World) world, pos)));
            if (((TileEntityConveyor) world.getTileEntity(pos)).isFast())
                ret.add(new ItemStack(Items.glowstone_dust, 1));
        }
        return ret;
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te) {
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) { // HACK: called before block is destroyed by the player prior to the player getting the drops. destroy block here.
        if (!player.capabilities.isCreativeMode) {
            dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
        }
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }

    @Override
    public boolean canProvidePower() {
        return false;
    }

}
