package com.pixelutilities.config;

import com.pixelutilities.Basemod;
import com.pixelutilities.blocks.*;
import com.pixelutilities.blocks.ores.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PixelUtilitiesBlocks {

/*	//Blocks
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


	//lights
	public static Block blueLightBlock;
	public static Block redLightBlock;
	public static Block purpleLightBlock;
	public static Block yellowLightBlock;
	public static Block orangeLightBlock;
	public static Block whiteLightBlock;
	public static Block greenLightBlock;*/

	public static List<Block> LightBlockList = new ArrayList<>();


	public static void load(Configuration cfg) {
		Basemod.instance.newGrassBlock = new PUBlock(Material.grass, "PokeGrass", 4.0F, PixelUtilitiesCreativeTabs.tabPixelmonBlocks, Block.soundTypeGrass);
		Basemod.instance.pokeDirtBlock = new PokeDirtBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("PokeDirt").setBlockTextureName("PixelUtilities" + ":" + "PokeDirt").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);
		Basemod.instance.pokeSandBlock = new PokeSandBlock().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSand").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "pokesand");
		Basemod.instance.pokeSandC1Block = new PokeSandC1Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC1");
		Basemod.instance.pokeSandC2Block = new PokeSandC2Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC2");
		Basemod.instance.pokeSandC3Block = new PokeSandC3Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner3").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC3");
		Basemod.instance.pokeSandC4Block = new PokeSandC4Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandCorner4").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandC4");
		Basemod.instance.insideMoldingBlock = new InsideMoldingBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Inside Wall Molding").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "InsideMolding");
		if (Basemod.instance.pixelmonPresent)
			Basemod.instance.pixelmonGrassBlock = new PixelmonGrassBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("Pixelmon Grass").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PixelmonGrass");
		Basemod.instance.shinglesBlock = new ShinglesBlock().setHardness(0.5f).setStepSound(Block.soundTypeStone).setBlockName("Shingles").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Shingles");
		Basemod.instance.shinglesCorner1Block = new ShinglesCorner1Block().setHardness(0.5f).setStepSound(Block.soundTypeStone).setBlockName("Shingles Corner 1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "RoofCorner1");
		Basemod.instance.shinglesCorner2Block = new ShinglesCorner2Block().setHardness(0.5f).setStepSound(Block.soundTypeStone).setBlockName("Shingles Corner 2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "RoofCorner2");
		Basemod.instance.treeTopBlock = new TreeTopBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Tree Top").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "TreeTop");
		Basemod.instance.treeBottomBlock = new TreeBottomBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Tree Bottom").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "TreeBottom");
		Basemod.instance.pokeSandSide1Block = new PokeSandSide1Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide1");
		Basemod.instance.pokeSandSide2Block = new PokeSandSide2Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide2");
		Basemod.instance.pokeSandSide3Block = new PokeSandSide3Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide3").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide3");
		Basemod.instance.pokeSandSide4Block = new PokeSandSide4Block().setHardness(0.5f).setStepSound(Block.soundTypeSand).setBlockName("PokeSandSide4").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokeSandSide4");
		Basemod.instance.window1Block = new Window1Block().setHardness(0.5f).setStepSound(Block.soundTypeGlass).setBlockName("Window1").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Window");
		Basemod.instance.window2Block = new Window2Block().setHardness(0.5f).setStepSound(Block.soundTypeGlass).setBlockName("Window2").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Window2");
		Basemod.instance.woodenFlooringBlock = new WoodenFlooringBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("WoodenFlooring").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "WoodenFlooring");
		Basemod.instance.pokeCenterSignBlock = new PokeCenterSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("PokeCenterSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Pokecenter");
		Basemod.instance.pokeMartSignBlock = new PokeMartSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("PokeMartSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "PokemartSign");
		Basemod.instance.sandyGrassBlock = new SandyGrassBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("SandyGrass").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "SandyGrass");
		Basemod.instance.rockBlock = new RockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("Rock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "Rock");
		Basemod.instance.caveRockBlock = new CaveRockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("CabeRock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "CaveRock");
		Basemod.instance.bridgeBlockBlock = new BridgeBlockBlock().setHardness(0.5f).setStepSound(Block.soundTypeGrass).setBlockName("BridgeBlock").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks).setBlockTextureName("PixelUtilities" + ":" + "BridgeBlock");
		Basemod.instance.treeBlock = new TreeBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Tree").setBlockTextureName("pixelutilities:Tree").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);
		Basemod.instance.bolderBlock = new BolderBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Bolder").setBlockTextureName("pixelutilities:Bolder").setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelmonBlocks);
		Basemod.instance.boxBlock = new BoxBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("Box");
		Basemod.instance.rubyOre = new RubyOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("RubyOre").setBlockTextureName("pixelutilities:RubyOre");
		Basemod.instance.saphireOre = new SaphireOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("SaphireOre").setBlockTextureName("pixelutilities:SaphireOre");
		Basemod.instance.amethystOre = new AmethystOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("AmethystOre").setBlockTextureName("pixelutilities:AmethystOre");
		Basemod.instance.crystalOre = new CrystalOre().setHardness(1.5f).setStepSound(Block.soundTypeStone).setBlockName("CrystalOre").setBlockTextureName("pixelutilities:CrystalOre");
		Basemod.instance.rubyBlock = new RubyBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("RubyBlock").setBlockTextureName("pixelutilities:RubyBlock").setCreativeTab(CreativeTabs.tabBlock);
		Basemod.instance.saphireBlock = new SaphireBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("SaphireBlock").setBlockTextureName("pixelutilities:SaphireBlock").setCreativeTab(CreativeTabs.tabBlock);
		Basemod.instance.amethystBlock = new AmethystBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("AmethystBlock").setBlockTextureName("pixelutilities:AmethystBlock").setCreativeTab(CreativeTabs.tabBlock);
		Basemod.instance.crystalBlock = new CrystalBlock().setHardness(8.5f).setStepSound(Block.soundTypeMetal).setBlockName("CrystalBlock").setBlockTextureName("pixelutilities:CrystalBlock").setCreativeTab(CreativeTabs.tabBlock);
		Basemod.instance.siliconOre = new SiliconOre().setHardness(1.2f).setStepSound(Block.soundTypeMetal).setBlockName("SiliconOre").setBlockTextureName("pixelutilities:SiliconOre").setCreativeTab(CreativeTabs.tabBlock);
		Basemod.instance.clothedTableBlock = new ClothedTableBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("ClothedTable").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		if (Basemod.instance.pixelmonPresent)
			Basemod.instance.pokeballBlock = new PokeballBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("Pokeball").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.redCusionChairBlock = new RedCusionChairBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("RedCusionChair").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.trashcanBlock = new TrashcanBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("Trashcan").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.yellowCusionChairBlock = new YellowCusionChairBlock().setHardness(0.5f).setStepSound(Block.soundTypeWood).setBlockName("YellowCusionChair").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.totodilePokedollBlock = new TotodilePokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("TotodileDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.aronPokedollBlock = new AronPokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("AronDoll").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.bisharpPokedollBlock = new BisharpPokedollBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("BisharpDoll");
		Basemod.instance.radioBlock = new RadioBlock();
		Basemod.instance.gymSignBlock = new com.pixelutilities.blocks.GymSignBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("GymSign").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.tvBlock = new TVBlock().setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("TV").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.blockConveyor = new BlockConveyor();
		Basemod.instance.blueRugBlock = new RugBlock("blue").setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("BlueRug").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.redRugBlock = new RugBlock("red").setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("RedRug").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		Basemod.instance.greenRugBlock = new RugBlock("green").setHardness(0.5f).setStepSound(Block.soundTypeMetal).setBlockName("GreenRug").setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture);
		if (Basemod.instance.pixelmonPresent)
			Basemod.instance.pokeballStatue = new PokeballStatueBlock().setCreativeTab(PixelUtilitiesCreativeTabs.tabPokefurniture).setBlockName("PokeballStatue");

		if(PixelUtilitiesConfig.getInstance().lightsOn)
		{
			//lights
			Basemod.instance.blueLightBlock = new LightBlock("Blue", Color.BLUE);
			Basemod.instance.redLightBlock = new LightBlock("Red", Color.RED);
			Basemod.instance.purpleLightBlock = new LightBlock("Purple", Color.MAGENTA);
			Basemod.instance.yellowLightBlock = new LightBlock("Yellow", Color.YELLOW);
			Basemod.instance.orangeLightBlock = new LightBlock("Orange", Color.ORANGE);
			Basemod.instance.greenLightBlock = new LightBlock("Green", Color.GREEN);
			Basemod.instance.whiteLightBlock = new LightBlock("White", Color.WHITE);
		}

	}

	public static void addNames() {

		GameRegistry.registerBlock(Basemod.instance.newGrassBlock, "PokeGrass");
		GameRegistry.registerBlock(Basemod.instance.pokeSandBlock, "PokeSand");
		GameRegistry.registerBlock(Basemod.instance.pokeSandC1Block, "PokeSandCorner1");
		GameRegistry.registerBlock(Basemod.instance.pokeSandC2Block, "PokeSandCorner2");
		GameRegistry.registerBlock(Basemod.instance.pokeSandC3Block, "PokeSandCorner3");
		GameRegistry.registerBlock(Basemod.instance.pokeSandC4Block, "PokeSandCorner4");
		GameRegistry.registerBlock(Basemod.instance.pokeDirtBlock, "PokeDirt");
		GameRegistry.registerBlock(Basemod.instance.insideMoldingBlock, "Inside Wall Molding");
		if (Basemod.instance.pixelmonPresent)
			GameRegistry.registerBlock(Basemod.instance.pixelmonGrassBlock, "Pixelmon Grass");
		GameRegistry.registerBlock(Basemod.instance.shinglesCorner2Block, "Shingles Corner 2");
		GameRegistry.registerBlock(Basemod.instance.shinglesBlock, "Shingles");
		GameRegistry.registerBlock(Basemod.instance.shinglesCorner1Block, "Shingles Corner 1");
		GameRegistry.registerBlock(Basemod.instance.treeTopBlock, "Tree Top");
		GameRegistry.registerBlock(Basemod.instance.treeBottomBlock, "Tree Bottom");
		GameRegistry.registerBlock(Basemod.instance.pokeSandSide1Block, "PokeSand Side 1");
		GameRegistry.registerBlock(Basemod.instance.pokeSandSide2Block, "PokeSand Side 2");
		GameRegistry.registerBlock(Basemod.instance.pokeSandSide3Block, "PokeSand Side 3");
		GameRegistry.registerBlock(Basemod.instance.pokeSandSide4Block, "PokeSand Side 4");
		GameRegistry.registerBlock(Basemod.instance.window1Block, "Window 1");
		GameRegistry.registerBlock(Basemod.instance.window2Block, "Window 2");
		GameRegistry.registerBlock(Basemod.instance.woodenFlooringBlock, "Wooden Flooring");
		GameRegistry.registerBlock(Basemod.instance.pokeCenterSignBlock, "PokeCenter Sign");
		GameRegistry.registerBlock(Basemod.instance.pokeMartSignBlock, "PokeMart Sign");
		GameRegistry.registerBlock(Basemod.instance.sandyGrassBlock, "Sandy Grass");
		GameRegistry.registerBlock(Basemod.instance.rockBlock, "Rock");
		GameRegistry.registerBlock(Basemod.instance.caveRockBlock, "Cave Rock");
		GameRegistry.registerBlock(Basemod.instance.bridgeBlockBlock, "Bridge");
		GameRegistry.registerBlock(Basemod.instance.rubyBlock, "RubyBlock");
		GameRegistry.registerBlock(Basemod.instance.saphireBlock, "SaphireBlock");
		GameRegistry.registerBlock(Basemod.instance.amethystBlock, "AmethystBlock");
		GameRegistry.registerBlock(Basemod.instance.crystalBlock, "CrystalBlock");
		GameRegistry.registerBlock(Basemod.instance.treeBlock, "Tree");
		GameRegistry.registerBlock(Basemod.instance.bolderBlock, "Bolder");
		GameRegistry.registerBlock(Basemod.instance.boxBlock, "Box");
		GameRegistry.registerBlock(Basemod.instance.clothedTableBlock, "ClothedTable");
		if (Basemod.instance.pixelmonPresent)
			GameRegistry.registerBlock(Basemod.instance.pokeballBlock, "Pokeball");
		GameRegistry.registerBlock(Basemod.instance.redCusionChairBlock, "RedCusionChair");
		GameRegistry.registerBlock(Basemod.instance.trashcanBlock, "Trashcan");
		GameRegistry.registerBlock(Basemod.instance.yellowCusionChairBlock, "YellowCusionChair");
		GameRegistry.registerBlock(Basemod.instance.siliconOre, "SiliconOre");
		GameRegistry.registerBlock(Basemod.instance.rubyOre, "RubyOre");
		GameRegistry.registerBlock(Basemod.instance.saphireOre, "SaphireOre");
		GameRegistry.registerBlock(Basemod.instance.amethystOre, "AmethystOre");
		GameRegistry.registerBlock(Basemod.instance.crystalOre, "CrystalOre");
		GameRegistry.registerBlock(Basemod.instance.totodilePokedollBlock, "TotodileDoll");
		GameRegistry.registerBlock(Basemod.instance.aronPokedollBlock, "AronDoll");
		//GameRegistry.registerBlock(Basemod.instance.BisharpPokedollBlock, "BisharpDoll");
		GameRegistry.registerBlock(Basemod.instance.radioBlock, "Radio");
		GameRegistry.registerBlock(Basemod.instance.gymSignBlock, "GymSign");
		GameRegistry.registerBlock(Basemod.instance.tvBlock, "TV");
		GameRegistry.registerBlock(Basemod.instance.blockConveyor, "Conveyor");
		GameRegistry.registerBlock(Basemod.instance.blueRugBlock, "BlueRug");
		GameRegistry.registerBlock(Basemod.instance.redRugBlock, "RedRug");
		GameRegistry.registerBlock(Basemod.instance.greenRugBlock, "GreenRug");
		if (Basemod.instance.pixelmonPresent)
			GameRegistry.registerBlock(Basemod.instance.pokeballStatue, "PokeballStatue");

		if(PixelUtilitiesConfig.getInstance().lightsOn)
		{
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
}