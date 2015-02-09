package com.pixelutilities.worldgen;

import com.pixelutilities.config.PixelUtilitiesBlocks;

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class SiliconGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 2; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(25);
            int firstBlockYCoord = rand.nextInt(64);
            int firstBlockZCoord = chunkZ + rand.nextInt(25);

            (new WorldGenMinable(PixelUtilitiesBlocks.siliconOre.getDefaultState(), 3, BlockHelper.forBlock(Blocks.stone))).generate(world, rand, new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord));
        }
    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
    }

}