package com.pixelutilities.events;

import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.spawning.PixelmonBiomeDictionary;
import com.pixelmonmod.pixelmon.spawning.PixelmonBiomeDictionary.Type;
import com.pixelutilities.blocks.PokegiftBlock;
import com.pixelutilities.blocks.PokegiftEventBlock;
import com.pixelutilities.config.PixelUtilitiesBlocks;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.tileentitys.PokegiftEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderServer;

/**
 * 
 * @author MoeBoy76
 * 
 * this is for making the {@link PokegiftEventBlock} for Halloween or Christmas
 *
 */
public class PokegiftEventGen {

	private enum EventType {
		Christmas, Custom, Halloween
	}
	
	private int x, y, z, distance, face = 0;
	Block underBlock;
	private int x2, y2, z2, underID2, distance2, face2 = 0;
	private BiomeGenBase biome, biome2;
	private boolean goodBiome = true;
	private boolean goodBiome2 = true;
	private World world;
	
	private EventType type;

	List<String> coords = PixelUtilitiesConfig.getInstance().eventCoords;

	/**
	 * 
	 * similar to {@link PokeLoot} generation with some tweaks
	 * 
	 * @param world - the mc world
	 */
	public void generate(World world)
	{
		this.world = world;

		if(PixelUtilitiesConfig.getInstance().setEventPlacement)
		{
			String[] blankArray = {"notConfigured"};
			if(!PixelUtilitiesConfig.getInstance().eventCoords.isEmpty())
				coords = PixelUtilitiesConfig.getInstance().eventCoords;
			if(!coords.contains(blankArray))
			{
				placeEvent(world);
			}
			return;
		}

		ChunkCoordinates cc = world.getSpawnPoint();
		ChunkProviderServer ccServer = (ChunkProviderServer) world.getChunkProvider();
		if(!ccServer.chunkExists(cc.posX, cc.posZ))
		{
			ccServer.loadChunk(cc.posX, cc.posZ);
			if(!ccServer.chunkExists(cc.posX, cc.posZ))
				return;
		}

		if(PixelUtilitiesConfig.getInstance().isChristmas)
		{
			x = cc.posX + 5;
			z = cc.posZ + 5;
			y = world.getHeightValue(x, z) + 1;
			type = EventType.Christmas;
			if(!verifyCoords())
			{
				return;
			}
		}
		else if(PixelUtilitiesConfig.getInstance().isHalloween)
		{
			x = cc.posX - 5;
			z = cc.posZ - 5;
			y = world.getHeightValue(x, z) + 1;
			type = EventType.Halloween;
			if(!verifyCoords())
			{
				return;
			}
		}
		else if(PixelUtilitiesConfig.getInstance().isCustomHoliday)
		{
			x = cc.posX + 5;
			z = cc.posZ - 5;
			y = world.getHeightValue(x, z) + 1;
			type = EventType.Custom;
			if(!verifyCoords())
			{
				return;
			}
		}
		else
		{
			return;
		}

		// Get Block under loc
		underBlock = world.getBlock(x, y - 1, z);
		if(underBlock instanceof PokegiftBlock)
		{
			PixelUtilitiesConfig.getInstance().disableEventLoading();
			return;
		}

		// Get Biome
		biome = world.getBiomeGenForCoords(cc.posX * 16, cc.posZ * 16);

		// Adjust y to not be on trees/above air
		while (underBlock == Blocks.leaves || underBlock == Blocks.log || world.isAirBlock(x, y - 1, z)) {

			// Adjust Y
			y--;

			// Reset Under ID
			try {
				underBlock = world.getBlock(x, y - 1, z);
				if(underBlock instanceof PokegiftBlock)
				{
					PixelUtilitiesConfig.getInstance().disableEventLoading();
					return;
				}
			}
			catch (Exception e) {
				return;
			}

		}

		// No water biomes
		ArrayList<Type> invalidTypes = new ArrayList<Type>();
		invalidTypes.add(Type.RIVER);
		invalidTypes.add(Type.OCEAN);


		if(PixelmonBiomeDictionary.getBiomeIDsMatchingAnyTag(invalidTypes).contains(biome.biomeID)){
			goodBiome = false;
		}
		else {
			goodBiome = true;
		}

		// Do not place over water or lava blocks
		if (goodBiome && underBlock != Blocks.water && underBlock != Blocks.flowing_water && underBlock != Blocks.flowing_lava && underBlock != Blocks.lava) {
			world.setBlock(x, y, z, PixelUtilitiesBlocks.eventPokegift);
			System.out.println("Pokegift Event spawned at " + x + ", " + y + ", " + z);
			PixelUtilitiesConfig.getInstance().disableEventLoading();
		}
		else
		{
			if(!verifyCoords())
			{
				return;
			}
			try
			{
				world.setBlock(x, y, z, PixelUtilitiesBlocks.eventPokegift);
				System.out.println("Pokegift Event spawned at " + x + ", " + y + ", " + z);
				PixelUtilitiesConfig.getInstance().disableEventLoading();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Pokegift Event failed!");
			}
		}
	}

	/**
	 * 
	 * checks for existing event pokegift and checks tries to find an empty block
	 * 
	 * @author MoeBoy76
	 * 
	 * @return false if an event pokegift is detected
	 */
	private boolean verifyCoords()
	{
		if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof PokegiftEntity)
		{
			PokegiftEntity te = (PokegiftEntity) world.getTileEntity(x, y, z);
			if(te.getType() == PokegiftEntity.Type.EVENT)
			{
				return false;
			}
		}
		Block b = world.getBlock(x, y, z);
		while(b != Blocks.air)
		{
			if(type == EventType.Halloween)
			{
				x -= 1;
				z -= 1;
				y = world.getHeightValue(x, z) + 1;
			}
			if(type == EventType.Christmas)
			{
				x += 1;
				z += 1;
				y = world.getHeightValue(x, z) + 1;
			}
			if(type == EventType.Custom)
			{
				x += 1;
				z -= 1;
				y = world.getHeightValue(x, z) + 1;
			}
			b = world.getBlock(x, y, z);
		}
		return true;
	}

	/**
	 * 
	 * called by {@link EventLocation} to place the event pokegift at pre-dermined co-ords
	 * 
	 * @author MoeBoy76
	 * 
	 * @return true if placed and false if an error occurs 
	 */
	public boolean placeEvent(World world)
	{
		this.world = world;
		try
		{
			String[] blankArray = {"notConfigured"};
			if(!coords.contains(blankArray))
			{
				coords = PixelUtilitiesConfig.getInstance().eventCoords;

				x = Integer.parseInt(coords.get(0));
				y = Integer.parseInt(coords.get(1));
				z = Integer.parseInt(coords.get(2));

				world.setBlock(x, y, z, PixelUtilitiesBlocks.eventPokegift);
				return true;
			}
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
