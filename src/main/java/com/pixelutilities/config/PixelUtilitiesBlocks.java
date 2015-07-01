package com.pixelutilities.config;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.pixelutilities.Basemod;
import com.pixelutilities.blocks.*;

public class PixelUtilitiesBlocks {

	//Blocks
	/*public static Block pokeSandBlock;
	public static Block pokeSandC1Block;
	public static Block pokeSandC2Block;
	public static Block pokeSandC3Block;
	public static Block pokeSandC4Block;
	public static Block insideMoldingBlock;
	public static Block shinglesBlock;
	public static Block shinglesCorner1Block;
	public static Block shinglesCorner2Block;
	public static Block pokeSandSide1Block;
	public static Block pokeSandSide2Block;
	public static Block pokeSandSide3Block;
	public static Block pokeSandSide4Block;
	public static Block woodenFlooringBlock;
	public static Block pokeCenterSignBlock;
	public static Block pokeMartSignBlock;
	public static Block sandyGrassBlock;
	public static Block caveRockBlock;
	public static Block bridgeBlockBlock;*/
	public static Block pokeballBlock;
	//public static Block BasicDeskBlock;
	public static Block totodilePokedollBlock;
	public static Block aronPokedollBlock;
	public static Block bisharpPokedollBlock;
	public static Block radioBlock;
	public static Block blockConveyor;
	//public static Block pokeballStatue;

	//lights
	/*public static Block blueLightBlock;
	public static Block redLightBlock;
	public static Block purpleLightBlock;
	public static Block yellowLightBlock;
	public static Block orangeLightBlock;
	public static Block whiteLightBlock;
	public static Block greenLightBlock;*/

	public static List<Block> LightBlockList = new ArrayList<>();


	public static void load(Configuration cfg) {
		/*pokeSandBlock = new PokeSandBlock().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSand").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "pokesand");
		pokeSandC1Block = new PokeSandC1Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandCorner1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandC1");
		pokeSandC2Block = new PokeSandC2Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandCorner2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandC2");
		pokeSandC3Block = new PokeSandC3Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandCorner3").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandC3");
		pokeSandC4Block = new PokeSandC4Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandCorner4").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandC4");
		insideMoldingBlock = new InsideMoldingBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("Inside_Wall_Molding").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "InsideMolding");
		shinglesBlock = new ShinglesBlock().setHardness(0.5f).setStepSound(Block.soundTypeStone).setUnlocalizedName("Shingles").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "Shingles");
		shinglesCorner1Block = new ShinglesCorner1Block().setHardness(0.5f).setStepSound(Block.soundTypeStone).setUnlocalizedName("Shingles_Corner_1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "RoofCorner1");
		shinglesCorner2Block = new ShinglesCorner2Block().setHardness(0.5f).setStepSound(Block.soundTypeStone).setUnlocalizedName("Shingles_Corner_2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "RoofCorner2");
		pokeSandSide1Block = new PokeSandSide1Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandSide1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide1");
		pokeSandSide2Block = new PokeSandSide2Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandSide2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide2");
		pokeSandSide3Block = new PokeSandSide3Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandSide3").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide3");
		pokeSandSide4Block = new PokeSandSide4Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setUnlocalizedName("PokeSandSide4").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide4");
		woodenFlooringBlock = new WoodenFlooringBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("WoodenFlooring").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "WoodenFlooring");
		pokeCenterSignBlock = new PokeCenterSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("PokeCenterSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "Pokecenter");
		pokeMartSignBlock = new PokeMartSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setUnlocalizedName("PokeMartSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "PokemartSign");
		sandyGrassBlock = new SandyGrassBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("SandyGrass").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "SandyGrass");
		caveRockBlock = new CaveRockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("CaveRock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "CaveRock");
		bridgeBlockBlock = new BridgeBlockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setUnlocalizedName("BridgeBlock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);//.setBlockTextureName("PixelUtilities" + ":" + "BridgeBlock");
*/		totodilePokedollBlock = new TotodilePokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("TotodileDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		aronPokedollBlock = new AronPokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("AronDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		bisharpPokedollBlock = new BisharpPokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("BisharpDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		radioBlock = new RadioBlock().setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		blockConveyor = new BlockConveyor();
		if (Basemod.instance.pixelmonPresent)
		{
			pokeballBlock = new PokeballBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setUnlocalizedName("Pokeball").setCreativeTab(PixelUtilitiesCreativeTabs.tabPUCollection);
		}

		//lights
		Basemod.instance.blueLightBlock = new LightBlock("Blue", Color.BLUE);
		Basemod.instance.redLightBlock = new LightBlock("Red", Color.RED);
		Basemod.instance.purpleLightBlock = new LightBlock("Purple", Color.MAGENTA);
		Basemod.instance.yellowLightBlock = new LightBlock("Yellow", Color.YELLOW);
		Basemod.instance.orangeLightBlock = new LightBlock("Orange", Color.ORANGE);
		Basemod.instance.greenLightBlock = new LightBlock("Green", Color.GREEN);
		Basemod.instance.whiteLightBlock = new LightBlock("White", Color.WHITE);
	}

	public static void addNames() {

		/*GameRegistry.registerBlock(pokeSandBlock, "PokeSand");
		GameRegistry.registerBlock(pokeSandC1Block, "PokeSandCorner1");
		GameRegistry.registerBlock(pokeSandC2Block, "PokeSandCorner2");
		GameRegistry.registerBlock(pokeSandC3Block, "PokeSandCorner3");
		GameRegistry.registerBlock(pokeSandC4Block, "PokeSandCorner4");
		GameRegistry.registerBlock(insideMoldingBlock, "Inside_Wall_Molding");			
		GameRegistry.registerBlock(shinglesCorner2Block, "Shingles_Corner_2");
		GameRegistry.registerBlock(shinglesBlock, "Shingles");
		GameRegistry.registerBlock(shinglesCorner1Block, "Shingles_Corner_1");
		GameRegistry.registerBlock(pokeSandSide1Block, "PokeSand_Side_1");
		GameRegistry.registerBlock(pokeSandSide2Block, "PokeSand_Side_2");
		GameRegistry.registerBlock(pokeSandSide3Block, "PokeSand_Side_3");
		GameRegistry.registerBlock(pokeSandSide4Block, "PokeSand_Side_4");
		GameRegistry.registerBlock(woodenFlooringBlock, "Wooden_Flooring");
		GameRegistry.registerBlock(pokeCenterSignBlock, "PokeCenter_Sign");
		GameRegistry.registerBlock(pokeMartSignBlock, "PokeMart_Sign");
		GameRegistry.registerBlock(sandyGrassBlock, "Sandy_Grass");
		GameRegistry.registerBlock(caveRockBlock, "Cave_Rock");
		GameRegistry.registerBlock(bridgeBlockBlock, "Bridge");*/
		GameRegistry.registerBlock(totodilePokedollBlock, "TotodileDoll");
		GameRegistry.registerBlock(aronPokedollBlock, "AronDoll");
		GameRegistry.registerBlock(radioBlock, "Radio");
		GameRegistry.registerBlock(blockConveyor, "Conveyor");
		if (Basemod.instance.pixelmonPresent)
		{
			//GameRegistry.registerBlock(pokeballStatue, "PokeballStatue");
			GameRegistry.registerBlock(pokeballBlock, "Pokeball");
		}

		//lights
		GameRegistry.registerBlock(Basemod.instance.blueLightBlock, "BlueLight");
		GameRegistry.registerBlock(Basemod.instance.redLightBlock, "RedLight");
		GameRegistry.registerBlock(Basemod.instance.purpleLightBlock, "PurpleLight");
		GameRegistry.registerBlock(Basemod.instance.yellowLightBlock, "YellowLight");
		GameRegistry.registerBlock(Basemod.instance.orangeLightBlock, "OrangeLight");
		GameRegistry.registerBlock(Basemod.instance.whiteLightBlock, "WhiteLight");
		GameRegistry.registerBlock(Basemod.instance.greenLightBlock, "GreenLight");
	}
}