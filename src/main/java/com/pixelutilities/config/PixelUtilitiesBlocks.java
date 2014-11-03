package com.pixelutilities.config;

import com.pixelutilities.Basemod;
import com.pixelutilities.blocks.*;
import com.pixelutilities.blocks.ores.*;
import com.pixelutilities.tileentitys.PokegiftEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PixelUtilitiesBlocks {

	//Blocks
	public static Block newGrassBlock;
	public static Block pokeDirtBlock;
	public static Block pokeSandBlock;
	public static Block pokeSandC1Block;
	public static Block pokeSandC2Block;
	public static Block pokeSandC3Block;
	public static Block pokeSandC4Block;
	public static Block insideMoldingBlock;
	public static Block pixelmonGrassBlock;
	public static Block shinglesBlock;
	public static Block shinglesCorner1Block;
	public static Block shinglesCorner2Block;
	public static Block treeTopBlock;
	public static Block treeBottomBlock;
	public static Block pokeSandSide1Block;
	public static Block pokeSandSide2Block;
	public static Block pokeSandSide3Block;
	public static Block pokeSandSide4Block;
	public static Block window1Block;
	public static Block window2Block;
	public static Block woodenFlooringBlock;
	public static Block pokeCenterSignBlock;
	public static Block pokeMartSignBlock;
	public static Block sandyGrassBlock;
	public static Block rockBlock;
	public static Block caveRockBlock;
	public static Block bridgeBlockBlock;
	public static Block treeBlock;
	public static Block bolderBlock;
	public static Block boxBlock;
	public static Block rubyOre;
	public static Block saphireOre;
	public static Block amethystOre;
	public static Block crystalOre;
	public static Block rubyBlock;
	public static Block saphireBlock;
	public static Block amethystBlock;
	public static Block crystalBlock;
	public static Block siliconOre;
	public static Block clothedTableBlock;
	public static Block pokeballBlock;
	public static Block redCusionChairBlock;
	public static Block trashcanBlock;
	public static Block yellowCusionChairBlock;
	//public static Block BasicDeskBlock;
	public static Block totodilePokedollBlock;
	public static Block aronPokedollBlock;
	public static Block bisharpPokedollBlock;
	public static Block radioBlock;
	public static Block gymSignBlock;
	public static Block tvBlock;
	public static Block blockConveyor;
	public static Block blueRugBlock;
	public static Block redRugBlock;
	public static Block greenRugBlock;
	public static Block pokeballStatue;
	public static Block pokegift;
	public static Block eventPokegift;


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
		newGrassBlock = new PUBlock(Material.grass, "PokeGrass", 4.0F, PixelUtilitiesCreativeTabs.tabPixelmonBlocks, Block.soundTypeGrass);
		pokeDirtBlock = new PokeDirtBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("PokeDirt").setBlockTextureName("PixelUtilities" + ":" + "PokeDirt").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);
		pokeSandBlock = new PokeSandBlock().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSand").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "pokesand");
		pokeSandC1Block = new PokeSandC1Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC1");
		pokeSandC2Block = new PokeSandC2Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC2");
		pokeSandC3Block = new PokeSandC3Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner3").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC3");
		pokeSandC4Block = new PokeSandC4Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner4").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC4");
		insideMoldingBlock = new InsideMoldingBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Inside_Wall_Molding").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "InsideMolding");
		shinglesBlock = new ShinglesBlock().setHardness(0.5f).setStepSound(Block.soundTypeStone).setBlockName("Shingles").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Shingles");
		shinglesCorner1Block = new ShinglesCorner1Block().setHardness(0.5f).setStepSound(Block.soundTypeStone).setBlockName("Shingles_Corner_1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "RoofCorner1");
		shinglesCorner2Block = new ShinglesCorner2Block().setHardness(0.5f).setStepSound(Block.soundTypeStone).setBlockName("Shingles_Corner_2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "RoofCorner2");
		treeTopBlock = new TreeTopBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Tree_Top").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "TreeTop");
		treeBottomBlock = new TreeBottomBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Tree_Bottom").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "TreeBottom");
		pokeSandSide1Block = new PokeSandSide1Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide1");
		pokeSandSide2Block = new PokeSandSide2Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide2");
		pokeSandSide3Block = new PokeSandSide3Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide3").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide3");
		pokeSandSide4Block = new PokeSandSide4Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide4").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide4");
		window1Block = new Window1Block().setHardness(0.5f).setStepSound(Block.soundTypeGlass).setBlockName("Window1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Window");
		window2Block = new Window2Block().setHardness(0.5f).setStepSound(Block.soundTypeGlass).setBlockName("Window2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Window2");
		woodenFlooringBlock = new WoodenFlooringBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("WoodenFlooring").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "WoodenFlooring");
		pokeCenterSignBlock = new PokeCenterSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("PokeCenterSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Pokecenter");
		pokeMartSignBlock = new PokeMartSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("PokeMartSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokemartSign");
		sandyGrassBlock = new SandyGrassBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("SandyGrass").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "SandyGrass");
		rockBlock = new RockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("Rock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Rock");
		caveRockBlock = new CaveRockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("CaveRock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "CaveRock");
		bridgeBlockBlock = new BridgeBlockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("BridgeBlock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "BridgeBlock");
		treeBlock = new TreeBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Tree").setBlockTextureName("pixelutilities:Tree").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);
		bolderBlock = new BolderBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Boulder").setBlockTextureName("pixelutilities:Bolder").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);
		boxBlock = new BoxBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Box");
		rubyOre = new RubyOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("RubyOre").setBlockTextureName("pixelutilities:RubyOre");
		saphireOre = new SaphireOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("SaphireOre").setBlockTextureName("pixelutilities:SaphireOre");
		amethystOre = new AmethystOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("AmethystOre").setBlockTextureName("pixelutilities:AmethystOre");
		crystalOre = new CrystalOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("CrystalOre").setBlockTextureName("pixelutilities:CrystalOre");
		rubyBlock = new RubyBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("RubyBlock").setBlockTextureName("pixelutilities:RubyBlock").setCreativeTab(CreativeTabs.tabBlock);
		saphireBlock = new SaphireBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("SaphireBlock").setBlockTextureName("pixelutilities:SaphireBlock").setCreativeTab(CreativeTabs.tabBlock);
		amethystBlock = new AmethystBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("AmethystBlock").setBlockTextureName("pixelutilities:AmethystBlock").setCreativeTab(CreativeTabs.tabBlock);
		crystalBlock = new CrystalBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("CrystalBlock").setBlockTextureName("pixelutilities:CrystalBlock").setCreativeTab(CreativeTabs.tabBlock);
		siliconOre = new SiliconOre().setHardness(1.2f).setStepSound(Block.soundTypeMetal).setBlockName("SiliconOre").setBlockTextureName("pixelutilities:SiliconOre").setCreativeTab(CreativeTabs.tabBlock);
		clothedTableBlock = new ClothedTableBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("ClothedTable").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);			
		redCusionChairBlock = new RedCusionChairBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("RedCusionChair").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		trashcanBlock = new TrashcanBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("Trashcan").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		yellowCusionChairBlock = new YellowCusionChairBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("YellowCusionChair").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		totodilePokedollBlock = new TotodilePokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("TotodileDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		aronPokedollBlock = new AronPokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("AronDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		bisharpPokedollBlock = new BisharpPokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("BisharpDoll");
		radioBlock = new RadioBlock();
		gymSignBlock = new com.pixelutilities.blocks.GymSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("GymSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		tvBlock = new TVBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("TV").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		blockConveyor = new BlockConveyor();
		blueRugBlock = new RugBlock("blue").setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("BlueRug").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		redRugBlock = new RugBlock("red").setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("RedRug").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		greenRugBlock = new RugBlock("green").setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("GreenRug").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		if (Basemod.instance.pixelmonPresent)
		{
			pokeballStatue = new PokeballStatueBlock().setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture).setBlockName("PokeballStatue");
			pokegift = new PokegiftBlock(PokegiftEntity.class).setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("Pokegift").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
			pixelmonGrassBlock = new PixelmonGrassBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("Pixelmon_Grass").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PixelmonGrass");
			pokeballBlock = new PokeballBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("Pokeball").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
			eventPokegift = new PokegiftEventBlock(PokegiftEntity.class).setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("Event_Pokegift");
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

		GameRegistry.registerBlock(newGrassBlock, "PokeGrass");
		GameRegistry.registerBlock(pokeSandBlock, "PokeSand");
		GameRegistry.registerBlock(pokeSandC1Block, "PokeSandCorner1");
		GameRegistry.registerBlock(pokeSandC2Block, "PokeSandCorner2");
		GameRegistry.registerBlock(pokeSandC3Block, "PokeSandCorner3");
		GameRegistry.registerBlock(pokeSandC4Block, "PokeSandCorner4");
		GameRegistry.registerBlock(pokeDirtBlock, "PokeDirt");
		GameRegistry.registerBlock(insideMoldingBlock, "Inside Wall Molding");			
		GameRegistry.registerBlock(shinglesCorner2Block, "Shingles Corner 2");
		GameRegistry.registerBlock(shinglesBlock, "Shingles");
		GameRegistry.registerBlock(shinglesCorner1Block, "Shingles Corner 1");
		GameRegistry.registerBlock(treeTopBlock, "Tree Top");
		GameRegistry.registerBlock(treeBottomBlock, "Tree Bottom");
		GameRegistry.registerBlock(pokeSandSide1Block, "PokeSand Side 1");
		GameRegistry.registerBlock(pokeSandSide2Block, "PokeSand Side 2");
		GameRegistry.registerBlock(pokeSandSide3Block, "PokeSand Side 3");
		GameRegistry.registerBlock(pokeSandSide4Block, "PokeSand Side 4");
		GameRegistry.registerBlock(window1Block, "Window 1");
		GameRegistry.registerBlock(window2Block, "Window 2");
		GameRegistry.registerBlock(woodenFlooringBlock, "Wooden Flooring");
		GameRegistry.registerBlock(pokeCenterSignBlock, "PokeCenter Sign");
		GameRegistry.registerBlock(pokeMartSignBlock, "PokeMart Sign");
		GameRegistry.registerBlock(sandyGrassBlock, "Sandy Grass");
		GameRegistry.registerBlock(rockBlock, "Rock");
		GameRegistry.registerBlock(caveRockBlock, "Cave Rock");
		GameRegistry.registerBlock(bridgeBlockBlock, "Bridge");
		GameRegistry.registerBlock(rubyBlock, "RubyBlock");
		GameRegistry.registerBlock(saphireBlock, "SaphireBlock");
		GameRegistry.registerBlock(amethystBlock, "AmethystBlock");
		GameRegistry.registerBlock(crystalBlock, "CrystalBlock");
		GameRegistry.registerBlock(treeBlock, "Tree");
		GameRegistry.registerBlock(bolderBlock, "Bolder");
		GameRegistry.registerBlock(boxBlock, "Box");
		GameRegistry.registerBlock(clothedTableBlock, "ClothedTable");
		GameRegistry.registerBlock(redCusionChairBlock, "RedCusionChair");
		GameRegistry.registerBlock(trashcanBlock, "Trashcan");
		GameRegistry.registerBlock(yellowCusionChairBlock, "YellowCusionChair");
		GameRegistry.registerBlock(siliconOre, "SiliconOre");
		GameRegistry.registerBlock(rubyOre, "RubyOre");
		GameRegistry.registerBlock(saphireOre, "SaphireOre");
		GameRegistry.registerBlock(amethystOre, "AmethystOre");
		GameRegistry.registerBlock(crystalOre, "CrystalOre");
		GameRegistry.registerBlock(totodilePokedollBlock, "TotodileDoll");
		GameRegistry.registerBlock(aronPokedollBlock, "AronDoll");
		GameRegistry.registerBlock(radioBlock, "Radio");
		GameRegistry.registerBlock(gymSignBlock, "GymSign");
		GameRegistry.registerBlock(tvBlock, "TV");
		GameRegistry.registerBlock(blockConveyor, "Conveyor");
		GameRegistry.registerBlock(blueRugBlock, "BlueRug");
		GameRegistry.registerBlock(redRugBlock, "RedRug");
		GameRegistry.registerBlock(greenRugBlock, "GreenRug");
		if (Basemod.instance.pixelmonPresent)
		{
			GameRegistry.registerBlock(pokeballStatue, "PokeballStatue");
			GameRegistry.registerBlock(pokegift, "Pokegift");
			GameRegistry.registerBlock(pixelmonGrassBlock, "Pixelmon Grass");
			GameRegistry.registerBlock(pokeballBlock, "Pokeball");
			GameRegistry.registerBlock(eventPokegift, "Event_Pokegift");
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