package com.pixelutilities.blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.PixelmonRecievedEvent;
import com.pixelmonmod.pixelmon.api.events.ReceiveType;
import com.pixelmonmod.pixelmon.comm.ChatHandler;
import com.pixelmonmod.pixelmon.config.PixelmonEntityList;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.entities.pixelmon.abilities.AbilityBase;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.BaseStats;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.IVStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Stats;
import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import com.pixelmonmod.pixelmon.enums.EnumNature;
import com.pixelmonmod.pixelmon.enums.EnumPokeballs;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerNotLoadedException;
import com.pixelutilities.Basemod;
import com.pixelutilities.achievements.PixelUtilitiesAchievements;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.tileentitys.PokegiftEntity;
import com.pixelutilities.tileentitys.PokegiftEntity.Type;

public class PokegiftEventBlock extends PokegiftBlock
{
	
	public PokegiftEventBlock(Class tileEntityClass) {
		super(tileEntityClass);
		if(PixelUtilitiesConfig.getInstance().isChristmas)
		{
			itemName = "Christmas Pokegift";
		}
		else if(PixelUtilitiesConfig.getInstance().isHalloween)
		{
			itemName = "Halloween Pokegift";
		}
		else if(PixelUtilitiesConfig.getInstance().isCustomHoliday)
		{
			itemName = "Custom Event Pokegift";
		}
		TYPE = Type.EVENT;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return null;
	}

	/**
	 * Right Click on block
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		// Player Specific Stuff
		if (world.isRemote) {
			return true;
		}
		else if(PixelUtilitiesConfig.getInstance().doEvents)
		{
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

					if(tile.getSpecialPixelmon().isEmpty())
					{
						ChatHandler.sendChat(player, "pixelutilities.blocks.emptygift", itemName);
						world.playSoundAtEntity(player, "pixelutilities:itemNotObtained", 0.2f, 1.0f);
						return true;
					}

					// Msg
					ChatHandler.sendChat(player, "pixelmon.blocks.chestfound", itemName);
					player.addStat(PixelUtilitiesAchievements.pokeGift, 1);

					// Add event PokeLootClaimed
					try {
						for(EntityPixelmon p : tile.getSpecialPixelmon())
						{
							PixelmonStorage.PokeballManager.getPlayerStorage((EntityPlayerMP) player).addToParty(p);
							Pixelmon.EVENT_BUS.post(new PixelmonRecievedEvent(player, ReceiveType.PokeBall, p));
						}
					}
					catch (PlayerNotLoadedException e) {
						e.printStackTrace();
					}

					tile.addClaimer(playerID);

					// Play Sound
					world.playSoundAtEntity(player, "pixelmon:pixelmon.block.PokelootObtained", 0.2f, 1.0f);

				}
				else {

					// Already claimed
					ChatHandler.sendChat(player, "pixelmon.blocks.claimedloot");
				}
			}
		}
		else// if(PixelUtilitiesConfig.getInstance().isChristmas || PixelUtilitiesConfig.getInstance().isHalloween || PixelUtilitiesConfig.getInstance().isCustomHoliday)
		{
			ChatHandler.sendChat(player, "pixelutilities.event.noevents");
		}
		return true;
	}
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int var1) {
		try {
			PokegiftEntity tileP = (PokegiftEntity) this.pokeChestTileEntityClass.newInstance();
			tileP.setChestOneTime(false);
			tileP.setOwner(null);
			tileP.setAllSpecialPixelmon(generatePixelmon(world));
			return (TileEntity) tileP;
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
	
	private ArrayList<EntityPixelmon> generatePixelmon(World world)
	{
		ArrayList<EntityPixelmon> pixelmon = new ArrayList<>();
		
		Random rng = new Random();
		
		int max = PixelUtilitiesConfig.getInstance().maxEventPokes;
		
		int numberToCreate = rng.nextInt(max);
		
		if(numberToCreate == 0 || numberToCreate > 6 || numberToCreate > max)
		{
			numberToCreate = 1;
		}
		
		for(int i = 0; i < numberToCreate; i++)
		{
			String name = "";
			if(PixelUtilitiesConfig.getInstance().eventLegendaries)
			{
				name = EnumPokemon.randomPoke(false).name;
			}
			else
			{
				name = EnumPokemon.randomPoke(true).name;
			}
			EntityPixelmon p = (EntityPixelmon) PixelmonEntityList.createEntityByName(name, world);
			p.getLvl().setLevel(5);
			p.setGrowth(EnumGrowth.getRandomGrowth());
			if(PixelUtilitiesConfig.getInstance().eventShinies)
			{
				if(rng.nextInt(PixelUtilitiesConfig.getInstance().eventShinyRate) == 0)
				{
					p.setIsShiny(true);
				}
			}
			p.setNature(EnumNature.getRandomNature());
			p.caughtBall = EnumPokeballs.CherishBall;
			p.friendship.setFriendship(150);
			p.baseStats.baseFriendship = 150;
			p.stats.IVs.CreateNewIVs();
			pixelmon.add(p);
		}
		return pixelmon;
	}
}
