package com.pixelutilities.blocks;

import java.util.Random;
import java.util.UUID;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.PixelmonRecievedEvent;
import com.pixelmonmod.pixelmon.api.events.ReceiveType;
import com.pixelmonmod.pixelmon.comm.ChatHandler;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.pokeloot.PokeLoot;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelutilities.Basemod;
import com.pixelutilities.achievements.PixelUtilitiesAchievements;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.tileentitys.PokegiftEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PokegiftBlock extends BlockContainer {

	// Tile Entity Class
	private Class pokeChestTileEntityClass;

	// Icons
	private IIcon blockIconHidden;

	// Drop
	private String itemName = "pokeGift";

	// PArticle Effect Vars
	private double xVel = 0.1;
	private double yVel = 0.2;
	private double zVel = 0.1;

	public PokegiftBlock(Class tileEntityClass) {
		super(Material.glass);

		// Entity
		this.pokeChestTileEntityClass = tileEntityClass;
		this.isBlockContainer = true;

		setBlockName(itemName);
		textureName = "pixelutilities:cherishball";
	}

	/**
	 * Add Textures
	 */
	public void registerIcons(IIconRegister iconReg) {
		this.blockIcon = iconReg.registerIcon("pixelutilities:cherishball");
		this.blockIconHidden = iconReg.registerIcon("pixelmon:hidden");
	}

	/**
	 * Used to determine which texture to display on each face
	 */
	@Override
	public IIcon getIcon(int side, int metadata) {
		// Invisible Meta
		if (metadata > 4)
			return this.blockIconHidden;

		// Front Face +1 to not get 0 (inv block)
		int frontFace = 4;
		if (metadata == 2)
		{ // Meta 2
			frontFace = 4;
		}
		else if (metadata == 4)
		{ // Meta 4
			frontFace = 5;
		}
		else if (metadata == 3)
		{ // Meta 3
			frontFace = 2;
		}
		else if (metadata == 1)
		{ // Meta 1
			frontFace = 3;
		}
		return this.blockIcon;
	}

	/**
	 * Right Click on block
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

		// Player Specific Stuff
		if (world.isRemote) {
			return true;
		} else {

			// Get Tile
			PokegiftEntity tile = ((PokegiftEntity) world.getTileEntity(x, y, z));

			// Set ID's
			UUID blockOwner = tile.getOwner();
			UUID playerID = ((EntityPlayerMP) player).getUniqueID();

			// Player claiming block
			if (playerID != blockOwner) {

				// Get meta
				int meta = world.getBlockMetadata(x, y, z);

				if (tile.canClaim(playerID)) {
					// Remove Block ? (Moved to break block only if claimable)
					if (tile.shouldBreakBlock()) {
						// Remove Block
						world.setBlockToAir(x, y, z);
					}
					
					if(tile.getPixelmon() == null)
					{
						ChatHandler.sendChat(player, "pixelutilities.blocks.emptygift", itemName);
						world.playSoundAtEntity(player, "pixelutilities:itemNotObtained", 0.2f, 1.0f);
						return true;
					}

					// Msg
					ChatHandler.sendChat(player, "pixelmon.blocks.chestfound", itemName);
					player.addStat(PixelUtilitiesAchievements.pokeGift, 1);

					// Add event PokeLootClaimed
					//Pixelmon.EVENT_BUS.post(new PokeLootClaimedEvent(player, tile));
					try {
						PixelmonStorage.PokeballManager.getPlayerStorage((EntityPlayerMP) player).addToParty(tile.getPixelmon());
						Pixelmon.EVENT_BUS.post(new PixelmonRecievedEvent(player, ReceiveType.PokeBall, tile.getPixelmon()));
					} catch (PlayerNotLoadedException e) {
						e.printStackTrace();
					}

					// Reset Claim String
					tile.removeClaimer(playerID);
					tile.addClaimer(playerID);

					// Play Sound
					// Old Way 1.5.2
					// world.playSoundEffect(x, y, z, "pokeloot.itemObtained",
					// 0.35f, 1.0f);

					// New 1.6.2
					world.playSoundAtEntity(player, "pixelmon:pixelmon.block.PokelootObtained", 0.2f, 1.0f);

				}
				else {

					// Already claimed
					ChatHandler.sendChat(player, "pixelmon.blocks.claimedloot");
				}

			}
			else { // Owner activating block

				// Check shift click
				boolean shiftClick = PokeLoot.proxy.isShiftClick(player);

				if (shiftClick) { // Set Server Owner
					if(tile.getPixelmon() != null)
					{
						tile.setOwner(null);
						ChatHandler.sendChat(player, "pixelmon.blocks.ownerchanged");
						player.addStat(PixelUtilitiesAchievements.givenPokeGift, 1);
						return true;
					}
					ChatHandler.sendChat(player, "pixelutilities.blocks.fillmefirst");
					return false;
				}
				else
				{
					//TODO need a better way to get the pixelmon...
					try
					{
						EntityPlayerMP playerMP = (EntityPlayerMP) player;
						PlayerStorage ownerStorage = PixelmonStorage.PokeballManager.getPlayerStorage(playerMP);
						
						int[] firstPokeID = null;
						
						for(int i = 0; i < 6; i++)
						{
							int[] pixelmonID = ownerStorage.getIDFromPosition(i);
							
							if(ownerStorage.hasSentOut(pixelmonID))
							{
								firstPokeID = pixelmonID;
								i = 6;
							}
						}
						if(firstPokeID == null)
						{
							return false;
						}
						ownerStorage.recallAllPokemon();
						
						NBTTagCompound nbt = ownerStorage.getNBT(firstPokeID);
						int pos = ownerStorage.getPosition(firstPokeID);

						EntityPixelmon toGive = (EntityPixelmon) PixelmonEntityList.createEntityFromNBT(nbt, world);

						EntityPixelmon currentPixelmon = tile.getPixelmon();
						if(currentPixelmon != null)
						{
							tile.setPixelmon(toGive);
							NBTTagCompound currentNBT = new NBTTagCompound();
							currentPixelmon.writeEntityToNBT(currentNBT);
							ownerStorage.changePokemonAndAssignID(pos, currentNBT);
						}
						else
						{
							tile.setPixelmon(toGive);
							NBTTagCompound nullify = null;
							ownerStorage.changePokemonAndAssignID(pos, nullify);
						}
						ownerStorage.sendUpdatedList();
					}
					catch (PlayerNotLoadedException e)
					{
						e.printStackTrace();
						return false;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return false;
					}
				}
			}
			return true;
		}
	}

	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack par6ItemStack) {

		if (!world.isRemote) {

			// Player ID
			UUID playerID = ((EntityPlayerMP) player).getUniqueID();

			// Set Owner
			PokegiftEntity tile = ((PokegiftEntity) world.getTileEntity(x, y, z));
			tile.setOwner(playerID);
			if(PixelUtilitiesConfig.getInstance().pokeGiftMany)
			{
				tile.setChestOneTime(false);
			}

			// Set Front Face
			int face = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			world.setBlockMetadataWithNotify(x, y, z, face + 1, 2); // +1 to not get 0 (inv block)
		}
	}

	/**
	 * Left Click Block
	 */
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		if (!world.isRemote) {
			UUID playerID = ((EntityPlayerMP) player).getUniqueID();
			PokegiftEntity tile = ((PokegiftEntity) world.getTileEntity(x, y, z));
			// Only Owner can click
			if (playerID == tile.getOwner()) {
				// Get Mode
				String mode = "";
				if ((!tile.getChestMode()) && (!tile.getDropMode())) {
					// We were @ Permanent, Unlimited Drops, goto Permanent,
					// Limit 1 Drop
					tile.setChestOneTime(false);
					tile.setDropOneTime(true);
					mode = "Permanent, Limit 1 Drop";
				}
				else {
					// We were at timed drops, goto FCFS
					tile.setDropOneTime(true);
					tile.setChestOneTime(true);
					mode = "First Come, First Served";
				}
				// Output
				ChatHandler.sendChat(player, "pixelmon.blocks.chestmode", mode);
			}
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World par1World, int var1) {
		try {
			PokegiftEntity tileP = (PokegiftEntity) this.pokeChestTileEntityClass.newInstance();
			return (TileEntity) tileP;
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {

		// If is invisible Block
		if (world.getBlockMetadata(x, y, z) > 4) {

			// Random
			float rand = random.nextFloat() * 0.5F + 1;

			// Particle Effect
			world.spawnParticle("instantSpell", x + 0.5, y + 0.5, z + 0.5, xVel * rand, yVel * rand, zVel * rand);
		}
	}

	// To render adjacent blocks
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	// Do not render block
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBounds();
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns the bounding box of the wired rectangular prism to render.
	 */
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBounds();
		return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	public void setBlockBounds()
	{
		this.setBlockBounds(0.29f, 0, 0.29f, 0.72f, 0.44f, 0.72f);
	}

}
