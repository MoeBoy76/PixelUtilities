package com.pixelutilities.tileentitys;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class TileEntityConveyor extends TileEntity implements ISidedInventory, IUpdatePlayerListBox {
    private EnumDyeColor _dye = EnumDyeColor.WHITE;

    private boolean _rednetReversed = false;
    private boolean _isReversed = false;
    private boolean _gateReversed = false;

    private boolean _redNetAllowsActive = true;
    private boolean _gateAllowsActive = true;
    private boolean _conveyorActive = true;

    private boolean _isFast = false;

    public EnumDyeColor getDyeColor() {
        return _dye;
    }

    public void setDyeColor(EnumDyeColor dye) {
        if (worldObj != null && !worldObj.isRemote && _dye != dye) {
            worldObj.markBlockForUpdate(getPos());
        }
        _dye = dye;
    }
    
    public void setDyeColor(int dye) {
    	EnumDyeColor newDyeColour = EnumDyeColor.values()[dye];
    	if (worldObj != null && !worldObj.isRemote && _dye != newDyeColour) {
            worldObj.markBlockForUpdate(getPos());
        }
        _dye = newDyeColour;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("dye", _dye.getMetadata());
        data.setBoolean("conveyorActive", _conveyorActive);
        data.setBoolean("isFast", _isFast);
        return new S35PacketUpdateTileEntity(getPos(), 0, data);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound data = pkt.getNbtCompound();
        _dye = EnumDyeColor.byMetadata(data.getInteger("dye"));
        _conveyorActive = data.getBoolean("conveyorActive");
        _isFast = data.getBoolean("isFast");
    }

    /*@Override
    public boolean shouldRefresh(Block oldID, Block newID, int oldMeta, int newMeta, World world, int x, int y, int z) {
        return oldID != newID;
    }

    private void rotateTo(World world, int xCoord, int yCoord, int zCoord, int newmd) {
        world.setBlockMetadataWithNotify(new BlockPos(xCoord, yCoord, zCoord), newmd, 2);
    }*/

    public boolean isFast() {
        return _isFast;
    }

    public void setFast(boolean fast) {
        _isFast = fast;
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setInteger("dyeColor", _dye.getMetadata());
        tag.setBoolean("isReversed", _isReversed);
        tag.setBoolean("redNetActive", _conveyorActive);
        tag.setBoolean("gateActive", _gateAllowsActive);
        tag.setBoolean("redNetReversed", _rednetReversed);
        tag.setBoolean("gateReversed", _gateReversed);
        tag.setBoolean("glowstone", _isFast);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        if (tag.hasKey("dyeColor")) {
            _dye = EnumDyeColor.byMetadata(tag.getInteger("dyeColor"));
        }
        if (tag.hasKey("redNetActive")) {
            _conveyorActive = tag.getBoolean("redNetActive");
        }
        if (tag.hasKey("gateActive")) {
            _gateAllowsActive = tag.getBoolean("gateActive");
        }
        _isReversed = tag.getBoolean("isReversed");
        _rednetReversed = tag.getBoolean("redNetReversed");
        _gateReversed = tag.getBoolean("gateReversed");
        _isFast = tag.getBoolean("glowstone");
    }

    //IInventory
    @Override
    public int getSizeInventory() {
        return 7;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        //int horizDirection = worldObj.getBlockState(getPos()) & 0x03;

        float dropOffsetX = 0.5F;
        float dropOffsetY = 0.4F;
        float dropOffsetZ = 0.5F;
        double motionX = 0.0D;
        double motionY = 0.0D;
        double motionZ = 0.0D;

        //because of the setup, slot is also the ForgeDirection ordinal from which the item is being inserted
        switch (slot) {
            case 0: //DOWN
                dropOffsetY = 0.3F;
                motionY = 0.15D;
                break;
            case 1: //UP
                dropOffsetY = 0.8F;
                motionY = -0.15D;
                break;
            case 2: //NORTH
                dropOffsetZ = 0.2F;
                motionZ = 0.15D;
                break;
            case 3: //SOUTH
                dropOffsetZ = 0.8F;
                motionZ = -0.15D;
                break;
            case 4: //WEST
                dropOffsetX = 0.2F;
                motionX = 0.15D;
                break;
            case 5: //EAST
                dropOffsetX = 0.8F;
                motionX = -0.15D;
                break;
            case 6: //UNKNOWN
        }/*

        if (horizDirection == 0) {
            motionX = 0.05D;
        } else if (horizDirection == 1) {
            motionZ = 0.05D;
        } else if (horizDirection == 3) {
            motionX = -0.05D;
        } else if (horizDirection == 3) {
            motionZ = -0.05D;
        }*/

        EntityItem entityitem = new EntityItem(worldObj, getPos().getX() + dropOffsetX, getPos().getY() + dropOffsetY, getPos().getZ() + dropOffsetZ, stack.copy());
        entityitem.motionX = motionX;
        entityitem.motionY = motionY;
        entityitem.motionZ = motionZ;
        //entityitem.delayBeforeCanPickup = 20;
        worldObj.spawnEntityInWorld(entityitem);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return true;
    }

    //ISidedInventory
    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        int[] accessibleSlot = {side.getIndex()};
        return accessibleSlot;
    }

    /*
     * From above: returns true if the conveyor is not going uphill
     * For the NSEW sides: returns true if (conveyor is going uphill) || (!conveyor is facing in the 'from' direction)
     * From below/unknown: returns true
     */
    @Override
    public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
        int blockmeta;
        switch (direction) {
            case UP:
                return (worldObj.getBlockState(getPos()).getBlock().getMetaFromState(worldObj.getBlockState(getPos())) & 0x04) == 0;
            case EAST:
                blockmeta = worldObj.getBlockState(getPos()).getBlock().getMetaFromState(worldObj.getBlockState(getPos()));
                return (blockmeta & 0x04) != 0 | (blockmeta & 0x03) != 0;
            case SOUTH:
                blockmeta = worldObj.getBlockState(getPos()).getBlock().getMetaFromState(worldObj.getBlockState(getPos()));
                return (blockmeta & 0x04) != 0 | (blockmeta & 0x03) != 1;
            case WEST:
                blockmeta = worldObj.getBlockState(getPos()).getBlock().getMetaFromState(worldObj.getBlockState(getPos()));
                return (blockmeta & 0x04) != 0 | (blockmeta & 0x03) != 2;
            case NORTH:
                blockmeta = worldObj.getBlockState(getPos()).getBlock().getMetaFromState(worldObj.getBlockState(getPos()));
                return (blockmeta & 0x04) != 0 | (blockmeta & 0x03) != 3;
            default:
                return true;
        }
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return false;
    }

    // RedNet
    public void onRedNetChanged(int value) {
        if (_redNetAllowsActive ^ value <= 0) {
            _redNetAllowsActive = value <= 0;
            updateConveyorActive();
        }
        setReversed(_gateReversed | (_rednetReversed = value < 0));
    }

    public void updateConveyorActive() {
        setConveyorActive(true);
    }

    public void setConveyorActive(boolean conveyorActive) {
        boolean wasActive = _conveyorActive;
        _conveyorActive = conveyorActive;

        if (wasActive ^ _conveyorActive) {
            worldObj.markBlockForUpdate(getPos());
        }
    }

    public void setConveyerActiveFromGate(boolean conveyorActive) {
        boolean wasActive = _gateAllowsActive;
        _gateAllowsActive = conveyorActive;

        if (wasActive ^ _gateAllowsActive) {
            updateConveyorActive();
        }
    }

    public boolean getConveyorReversed() {
        return _isReversed;
    }

    private void setReversed(boolean isReversed) {
        boolean wasReversed = _isReversed;
        _isReversed = isReversed;

        if (wasReversed ^ _isReversed) {
            //worldObj.setBlockMetadataWithNotify(getPos(), getReversedMeta(worldObj.getBlockState(getPos()).getBlock().getMetaFromState(worldObj.getBlockState(getPos()))), 3);
        }
    }

    private void reverseConveyor() {
        setReversed(_rednetReversed | (_gateReversed = !_isReversed));
    }

    private int getReversedMeta(int meta) {
        int directionComponent = (meta + 2) % 4;
        int slopeComponent;

        if (meta / 4 == 1) {
            slopeComponent = 2;
        } else if (meta / 4 == 2) {
            slopeComponent = 1;
        } else {
            slopeComponent = 0;
        }

        return slopeComponent * 4 + directionComponent;
    }

	@Override
	public void openInventory(EntityPlayer player) {		
	}

	@Override
	public void closeInventory(EntityPlayer player) {		
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {		
	}

	@Override
	public String getCommandSenderName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
