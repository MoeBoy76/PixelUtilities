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

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
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

	private BlockPos position;
	Block underBlock;
	private BiomeGenBase biome;
	private boolean goodBiome = true;
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

		BlockPos cc = world.getSpawnPoint();
		ChunkProviderServer ccServer = (ChunkProviderServer) world.getChunkProvider();
		if(!ccServer.chunkExists(cc.getX(), cc.getZ()))
		{
			ccServer.loadChunk(cc.getX(), cc.getZ());
			if(!ccServer.chunkExists(cc.getX(), cc.getZ()))
				return;
		}

		if(PixelUtilitiesConfig.getInstance().isChristmas)
		{
			position = cc.add(5, world.getHeight(cc).getY() + 1, 5);
			type = EventType.Christmas;
			if(!verifyCoords())
			{
				return;
			}
		}
		else if(PixelUtilitiesConfig.getInstance().isHalloween)
		{
			position = cc.add(-5, world.getHeight(cc).getY() + 1, -5);
			type = EventType.Halloween;
			if(!verifyCoords())
			{
				return;
			}
		}
		else if(PixelUtilitiesConfig.getInstance().isCustomHoliday)
		{
			position = cc.add(5, world.getHeight(cc).getY() + 1, -5);
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
		underBlock = world.getBlockState(position.down()).getBlock();
		if(underBlock instanceof PokegiftBlock)
		{
			PixelUtilitiesConfig.getInstance().disableEventLoading();
			return;
		}

		// Get Biome
		biome = world.getBiomeGenForCoords(new BlockPos(cc.getX() * 16, 0, cc.getZ() * 16));

		// Adjust y to not be on trees/above air
		while (underBlock == Blocks.leaves || underBlock == Blocks.log || world.isAirBlock(position.down())) {

			// Adjust Y
			position = position.down();

			// Reset Under ID
			try {
				underBlock = world.getBlockState(position.down()).getBlock();
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
			world.setBlockState(position, PixelUtilitiesBlocks.eventPokegift.getDefaultState());
			System.out.println("Pokegift Event spawned at " + position.toString());
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
				world.setBlockState(position, PixelUtilitiesBlocks.eventPokegift.getDefaultState());
				System.out.println("Pokegift Event spawned at " + position.toString());
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
		if(world.getTileEntity(position) != null && world.getTileEntity(position) instanceof PokegiftEntity)
		{
			PokegiftEntity te = (PokegiftEntity) world.getTileEntity(position);
			if(te.getType() == PokegiftEntity.Type.EVENT)
			{
				return false;
			}
		}
		Block b = world.getBlockState(position).getBlock();
		while(b != Blocks.air)
		{
			if(type == EventType.Halloween)
			{
				position = position.add(-1, world.getHeight(position).getY() + 1, -1);
			}
			if(type == EventType.Christmas)
			{
				position = position.add(1, world.getHeight(position).getY() + 1, 1);
			}
			if(type == EventType.Custom)
			{
				position = position.add(1, world.getHeight(position).getY() + 1, -1);
			}
			b = world.getBlockState(position).getBlock();
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

				int x = Integer.parseInt(coords.get(0));
				int y = Integer.parseInt(coords.get(1));
				int z = Integer.parseInt(coords.get(2));
				BlockPos pos = new BlockPos(x, y, z);

				world.setBlockState(pos, PixelUtilitiesBlocks.eventPokegift.getDefaultState());
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
