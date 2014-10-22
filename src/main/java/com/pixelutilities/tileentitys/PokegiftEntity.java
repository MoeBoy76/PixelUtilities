package com.pixelutilities.tileentitys;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.pokeloot.data.LootClaim;

public class PokegiftEntity extends TileEntity {

	private UUID ownerID = null;
	private boolean chestOneTime = true;
	private boolean dropOneTime = true;
	private int frontFace = 4;
	
	private EntityPixelmon pixelmon = null;
	private NBTTagCompound nbtPixelmon = new NBTTagCompound();

	private ArrayList<LootClaim> claimed = new ArrayList<>();

	public void setOwner(UUID id) {
		this.ownerID = id;
	}

	@Override
	public boolean canUpdate() {
		return false;
	}

	public UUID getOwner() {
		return ownerID;
	}

	@Override
	public void writeToNBT(NBTTagCompound tagger) {

		// Save Strings

		// Setup
		tagger.setLong("ownerIDMost", ownerID == null ? -1 : ownerID.getMostSignificantBits());
		tagger.setLong("ownerIDLeast", ownerID == null ? -1 : ownerID.getLeastSignificantBits());
		tagger.setBoolean("chestOneTime", chestOneTime);
		tagger.setBoolean("dropOneTime", dropOneTime);

		if (!claimed.isEmpty()) {
			NBTTagCompound claimedTag = new NBTTagCompound();
			for (int i = 0; i < claimed.size(); i++) {
				NBTTagCompound playerInfoTag = new NBTTagCompound();
				LootClaim playerClaim = claimed.get(i);
				playerInfoTag.setLong("most", playerClaim.getPlayerID().getMostSignificantBits());
				playerInfoTag.setLong("least", playerClaim.getPlayerID().getLeastSignificantBits());
				playerInfoTag.setLong("timeClaimed", playerClaim.getTimeClaimed());
				
				claimedTag.setTag("player" + i, playerInfoTag);
			}

			tagger.setTag("claimedPlayers", claimedTag);
		}

		//TODO write pixelmon to store
		if(pixelmon != null && !(nbtPixelmon.hasNoTags()))
		{
			pixelmon.writeEntityToNBT(nbtPixelmon);
			tagger.setTag("pixelmon", nbtPixelmon);
		}
		
		
		super.writeToNBT(tagger);

	}

	@Override
	public void readFromNBT(NBTTagCompound tagger) {

		// Owner ID
		if (tagger.getLong("ownerIDMost") != -1)
			ownerID = new UUID(tagger.getLong("ownerIDMost"), tagger.getLong("ownerIDLeast"));

		// Bools
		chestOneTime = tagger.getBoolean("chestOneTime");
		dropOneTime = tagger.getBoolean("dropOneTime");

		// Claimed

		if (tagger.hasKey("claimedPlayers")) {
			NBTTagCompound claimedTag = (NBTTagCompound) tagger.getTag("claimedPlayers");
			int i = 0;
			while (claimedTag.hasKey("player" + i)) {
				NBTTagCompound playerTag = (NBTTagCompound) claimedTag.getTag("player" + i);
				claimed.add(new LootClaim(new UUID(playerTag.getLong("most"), playerTag.getLong("least")), playerTag.getLong("timeClaimed")));
				i++;
			}
		}
		
		// Pixelmon
		nbtPixelmon = tagger.getCompoundTag("pixelmon");
		if(!(nbtPixelmon.hasNoTags()))
			pixelmon = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(nbtPixelmon, worldObj);

		super.readFromNBT(tagger);

	}

	public boolean canClaim(UUID playerID) {
		if (!dropOneTime) {
			return true;
		} else {
			LootClaim claim = getLootClaim(playerID);
			if (claim != null) {
				return false;
			}
			return true;
		}
	}
	
	public LootClaim getLootClaim(UUID playerID) {
		for (LootClaim claim : claimed)
			if (claim.getPlayerID().toString().equals(playerID.toString()))
				return claim;
		return null;
	}

	public void addClaimer(UUID playerID) {
		if (dropOneTime) {
			claimed.add(new LootClaim(playerID, System.currentTimeMillis()));
		}
	}

	public void removeClaimer(UUID playerID) {
		claimed.remove(getLootClaim(playerID));
	}

	public boolean shouldBreakBlock() {
		return chestOneTime;
	}

	public void setChestOneTime(boolean val) {
		this.chestOneTime = val;
	}

	public boolean getChestMode() {
		return chestOneTime;
	}

	public void setDropOneTime(boolean val) {
		this.dropOneTime = val;
	}

	public boolean getDropMode() {
		return dropOneTime;
	}

	public boolean isUsableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	public void setFrontFace(int face) {
		frontFace = face;
	}

	public int getFrontFace() {
		return frontFace;
	}

	public EntityPixelmon getPixelmon() {
		return pixelmon;
	}

	public void setPixelmon(EntityPixelmon pixelmon) {
		this.pixelmon = pixelmon;
		pixelmon.writeEntityToNBT(nbtPixelmon);
	}
}