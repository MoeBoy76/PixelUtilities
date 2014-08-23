package com.pixelutilities.config;

import static com.pixelutilities.items.recipes.RecipeHelper.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelutilities.Basemod;

import cpw.mods.fml.common.registry.GameRegistry;

public class PixelUtilitiesRecipes
{
    public void addRecipes() {

        //Ore Smelting
        GameRegistry.addSmelting(Basemod.instance.amethystOre, new ItemStack(Basemod.instance.amethystItem), 10);
        GameRegistry.addSmelting(Basemod.instance.crystalOre, new ItemStack(Basemod.instance.crystalItem), 10);
        GameRegistry.addSmelting(Basemod.instance.rubyOre, new ItemStack(Basemod.instance.rubyItem), 10);
        GameRegistry.addSmelting(Basemod.instance.saphireOre, new ItemStack(Basemod.instance.saphireItem), 10);
        GameRegistry.addSmelting(Basemod.instance.siliconOre, new ItemStack(Basemod.instance.siliconItem), 10);
        //We need to add a stupid af smelting method here for a easter egg. What? Not sure.

        //Block
        makeItemToBlockRecipe(Basemod.instance.rubyBlock, Basemod.instance.rubyItem);
        makeItemToBlockRecipe(Basemod.instance.saphireBlock, Basemod.instance.saphireItem);
        makeItemToBlockRecipe(Basemod.instance.amethystBlock, Basemod.instance.amethystItem);
        makeItemToBlockRecipe(Basemod.instance.crystalBlock, Basemod.instance.crystalItem);


        makeItemsFromBlock(Basemod.instance.rubyItem, Basemod.instance.rubyBlock);
        makeItemsFromBlock(Basemod.instance.saphireItem, Basemod.instance.saphireBlock);
        makeItemsFromBlock(Basemod.instance.amethystItem, Basemod.instance.amethystBlock);
        makeItemsFromBlock(Basemod.instance.crystalItem, Basemod.instance.crystalBlock);


        //Ruby Tools
        makePickaxeRecipe(Basemod.instance.rubyPickaxe, Basemod.instance.rubyItem);
        makeHammerRecipe(Basemod.instance.rubyHammer, Basemod.instance.rubyItem);
        makeAxeRecipe(Basemod.instance.rubyAxe, Basemod.instance.rubyItem);
        makeShovelRecipe(Basemod.instance.rubyShovel, Basemod.instance.rubyItem);
        makeHoeRecipe(Basemod.instance.rubyHoe, Basemod.instance.rubyItem);
        makeSwordRecipe(Basemod.instance.rubySword, Basemod.instance.rubyItem);

        //Saphire Tools
        makePickaxeRecipe(Basemod.instance.saphirePickaxe, Basemod.instance.saphireItem);
        makeHammerRecipe(Basemod.instance.saphireHammer, Basemod.instance.saphireItem);
        makeAxeRecipe(Basemod.instance.saphireAxe, Basemod.instance.saphireItem);
        makeShovelRecipe(Basemod.instance.saphireShovel, Basemod.instance.saphireItem);
        makeHoeRecipe(Basemod.instance.saphireHoe, Basemod.instance.saphireItem);
        makeSwordRecipe(Basemod.instance.saphireSword, Basemod.instance.saphireItem);

        //Amethyst Tools
        makePickaxeRecipe(Basemod.instance.amethystPickaxe, Basemod.instance.amethystItem);
        makeHammerRecipe(Basemod.instance.amethystHammer, Basemod.instance.amethystItem);
        makeAxeRecipe(Basemod.instance.amethystAxe, Basemod.instance.amethystItem);
        makeShovelRecipe(Basemod.instance.amethystShovel, Basemod.instance.amethystItem);
        makeHoeRecipe(Basemod.instance.amethystHoe, Basemod.instance.amethystItem);
        makeSwordRecipe(Basemod.instance.amethystSword, Basemod.instance.amethystItem);

        //Evo Tools
        if (Basemod.instance.pixelmonPresent)
        {
            makePickaxeRecipe(Basemod.instance.firestonePickaxe, PixelmonItems.fireStone);
            makeHammerRecipe(Basemod.instance.firestoneHammer, PixelmonItems.fireStone);
            makeAxeRecipe(Basemod.instance.firestoneAxe, PixelmonItems.fireStone);
            makeShovelRecipe(Basemod.instance.firestoneShovel, PixelmonItems.fireStone);
            makeHoeRecipe(Basemod.instance.firestoneHoe, PixelmonItems.fireStone);
            makeSwordRecipe(Basemod.instance.firestoneSword, PixelmonItems.fireStone);

            makePickaxeRecipe(Basemod.instance.waterstonePickaxe, PixelmonItems.waterStone);
            makeHammerRecipe(Basemod.instance.waterstoneHammer, PixelmonItems.waterStone);
            makeAxeRecipe(Basemod.instance.waterstoneAxe, PixelmonItems.waterStone);
            makeShovelRecipe(Basemod.instance.waterstoneShovel, PixelmonItems.waterStone);
            makeHoeRecipe(Basemod.instance.waterstoneHoe, PixelmonItems.waterStone);
            makeSwordRecipe(Basemod.instance.waterstoneSword, PixelmonItems.waterStone);

            makePickaxeRecipe(Basemod.instance.leafstonePickaxe, PixelmonItems.leafStone);
            makeHammerRecipe(Basemod.instance.leafstoneHammer, PixelmonItems.leafStone);
            makeAxeRecipe(Basemod.instance.leafstoneAxe, PixelmonItems.leafStone);
            makeShovelRecipe(Basemod.instance.leafstoneShovel, PixelmonItems.leafStone);
            makeHoeRecipe(Basemod.instance.leafstoneHoe, PixelmonItems.leafStone);
            makeSwordRecipe(Basemod.instance.leafstoneSword, PixelmonItems.leafStone);
            
            makePickaxeRecipe(Basemod.instance.thunderstonePickaxe, PixelmonItems.thunderStone);
            makeHammerRecipe(Basemod.instance.thunderstoneHammer, PixelmonItems.thunderStone);
            makeAxeRecipe(Basemod.instance.thunderstoneAxe, PixelmonItems.thunderStone);
            makeShovelRecipe(Basemod.instance.thunderstoneShovel, PixelmonItems.thunderStone);
            makeHoeRecipe(Basemod.instance.thunderstoneHoe, PixelmonItems.thunderStone);
            makeSwordRecipe(Basemod.instance.thunderstoneSword, PixelmonItems.thunderStone);
            
            makePickaxeRecipe(Basemod.instance.sunstonePickaxe, PixelmonItems.sunStone);
            makeHammerRecipe(Basemod.instance.sunstoneHammer, PixelmonItems.sunStone);
            makeAxeRecipe(Basemod.instance.sunstoneAxe, PixelmonItems.sunStone);
            makeShovelRecipe(Basemod.instance.sunstoneShovel, PixelmonItems.sunStone);
            makeHoeRecipe(Basemod.instance.sunstoneHoe, PixelmonItems.sunStone);
            makeSwordRecipe(Basemod.instance.sunstoneSword, PixelmonItems.sunStone);
            
            makePickaxeRecipe(Basemod.instance.moonstonePickaxe, PixelmonItems.moonStone);
            makeHammerRecipe(Basemod.instance.moonstoneHammer, PixelmonItems.moonStone);
            makeAxeRecipe(Basemod.instance.moonstoneAxe, PixelmonItems.moonStone);
            makeShovelRecipe(Basemod.instance.moonstoneShovel, PixelmonItems.moonStone);
            makeHoeRecipe(Basemod.instance.moonstoneHoe, PixelmonItems.moonStone);
            makeSwordRecipe(Basemod.instance.moonstoneSword, PixelmonItems.moonStone);
            
        }//TODO alternative recipies!

        //Crystal Tools
        makePickaxeRecipe(Basemod.instance.crystalPickaxe, Basemod.instance.crystalItem);
        makeHammerRecipe(Basemod.instance.crystalHammer, Basemod.instance.crystalItem);
        makeAxeRecipe(Basemod.instance.crystalAxe, Basemod.instance.crystalItem);
        makeShovelRecipe(Basemod.instance.crystalShovel, Basemod.instance.crystalItem);
        makeHoeRecipe(Basemod.instance.crystalHoe, Basemod.instance.crystalItem);
        makeSwordRecipe(Basemod.instance.crystalSword, Basemod.instance.crystalItem);

        //Armor
        makeHelmRecipe(Basemod.instance.rubyHelm, Basemod.instance.rubyItem);
        makePlateRecipe(Basemod.instance.rubyPlate,Basemod.instance.rubyItem);
        makeLegsRecipe(Basemod.instance.rubyLegs, Basemod.instance.rubyItem);
        makeBootsRecipe(Basemod.instance.rubyBoots, Basemod.instance.rubyItem);

        makeHelmRecipe(Basemod.instance.saphireHelm, Basemod.instance.saphireItem);
        makePlateRecipe(Basemod.instance.saphirePlate,Basemod.instance.saphireItem);
        makeLegsRecipe(Basemod.instance.saphireLegs, Basemod.instance.saphireItem);
        makeBootsRecipe(Basemod.instance.saphireBoots, Basemod.instance.saphireItem);

        makeHelmRecipe(Basemod.instance.galacticHelm, Basemod.instance.siliconItem);
        makePlateRecipe(Basemod.instance.galacticPlate,Basemod.instance.siliconItem);
        makeLegsRecipe(Basemod.instance.galacticLegs, Basemod.instance.siliconItem);
        makeBootsRecipe(Basemod.instance.galacticBoots, Basemod.instance.siliconItem);

        //Radio
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.radioBlock), "  y", "xyx", "xzx", 'x', new ItemStack(Blocks.planks), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.diamond));

        //Lights
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.blueLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 11), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.redLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 14), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.purpleLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 10), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.yellowLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 4), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.orangeLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 1), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.whiteLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 0), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.greenLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 5), 'y', new ItemStack(Blocks.redstone_torch, 1));

        //GameRegistry.addRecipe(new ItemStack(Basemod.instance.blueLightBlock), new Object[] {"X X", "X X", Character.valueOf('X'), BlockStainedGlass});
    }

}
