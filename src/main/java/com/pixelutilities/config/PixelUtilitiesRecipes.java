package com.pixelutilities.config;

import static com.pixelutilities.items.recipes.RecipeHelper.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelutilities.Basemod;

import cpw.mods.fml.common.registry.GameRegistry;

public class PixelUtilitiesRecipes
{
    public void addRecipes() {

        //Ore Smelting
        GameRegistry.addSmelting(PixelUtilitiesBlocks.amethystOre, new ItemStack(Basemod.instance.amethystItem), 10);
        GameRegistry.addSmelting(PixelUtilitiesBlocks.crystalOre, new ItemStack(Basemod.instance.crystalItem), 10);
        GameRegistry.addSmelting(PixelUtilitiesBlocks.rubyOre, new ItemStack(Basemod.instance.rubyItem), 10);
        GameRegistry.addSmelting(PixelUtilitiesBlocks.saphireOre, new ItemStack(Basemod.instance.saphireItem), 10);
        GameRegistry.addSmelting(PixelUtilitiesBlocks.siliconOre, new ItemStack(Basemod.instance.siliconItem), 10);

        //Block
        makeItemToBlockRecipe(PixelUtilitiesBlocks.rubyBlock, Basemod.instance.rubyItem);
        makeItemToBlockRecipe(PixelUtilitiesBlocks.saphireBlock, Basemod.instance.saphireItem);
        makeItemToBlockRecipe(PixelUtilitiesBlocks.amethystBlock, Basemod.instance.amethystItem);
        makeItemToBlockRecipe(PixelUtilitiesBlocks.crystalBlock, Basemod.instance.crystalItem);

        makeItemsFromBlock(Basemod.instance.rubyItem, PixelUtilitiesBlocks.rubyBlock);
        makeItemsFromBlock(Basemod.instance.saphireItem, PixelUtilitiesBlocks.saphireBlock);
        makeItemsFromBlock(Basemod.instance.amethystItem, PixelUtilitiesBlocks.amethystBlock);
        makeItemsFromBlock(Basemod.instance.crystalItem, PixelUtilitiesBlocks.crystalBlock);

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
            
            makeHelmRecipe(Basemod.instance.firestoneHelm, PixelmonItems.fireStone);
            makePlateRecipe(Basemod.instance.firestonePlate,PixelmonItems.fireStone);
            makeLegsRecipe(Basemod.instance.firestoneLegs, PixelmonItems.fireStone);
            makeBootsRecipe(Basemod.instance.firestoneBoots, PixelmonItems.fireStone);
            
            makeHelmRecipe(Basemod.instance.waterstoneHelm, PixelmonItems.waterStone);
            makePlateRecipe(Basemod.instance.waterstonePlate,PixelmonItems.waterStone);
            makeLegsRecipe(Basemod.instance.waterstoneLegs, PixelmonItems.waterStone);
            makeBootsRecipe(Basemod.instance.waterstoneBoots, PixelmonItems.waterStone);
            
            makeHelmRecipe(Basemod.instance.leafstoneHelm, PixelmonItems.leafStone);
            makePlateRecipe(Basemod.instance.leafstonePlate,PixelmonItems.leafStone);
            makeLegsRecipe(Basemod.instance.leafstoneLegs, PixelmonItems.leafStone);
            makeBootsRecipe(Basemod.instance.leafstoneBoots, PixelmonItems.leafStone);
            
            makeHelmRecipe(Basemod.instance.thunderstoneHelm, PixelmonItems.thunderStone);
            makePlateRecipe(Basemod.instance.thunderstonePlate,PixelmonItems.thunderStone);
            makeLegsRecipe(Basemod.instance.thunderstoneLegs, PixelmonItems.thunderStone);
            makeBootsRecipe(Basemod.instance.thunderstoneBoots, PixelmonItems.thunderStone);
            
            makeHelmRecipe(Basemod.instance.sunstoneHelm, PixelmonItems.sunStone);
            makePlateRecipe(Basemod.instance.sunstonePlate,PixelmonItems.sunStone);
            makeLegsRecipe(Basemod.instance.sunstoneLegs, PixelmonItems.sunStone);
            makeBootsRecipe(Basemod.instance.sunstoneBoots, PixelmonItems.sunStone);
            
            makeHelmRecipe(Basemod.instance.moonstoneHelm, PixelmonItems.moonStone);
            makePlateRecipe(Basemod.instance.moonstonePlate,PixelmonItems.moonStone);
            makeLegsRecipe(Basemod.instance.moonstoneLegs, PixelmonItems.moonStone);
            makeBootsRecipe(Basemod.instance.moonstoneBoots, PixelmonItems.moonStone);
            
            GameRegistry.addRecipe(new ItemStack(PixelUtilitiesBlocks.pokegift, 4), " B ","B B"," B ", 'B', new ItemStack(PixelmonItemsPokeballs.cherishBall,1));
            
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
        
        makeHelmRecipe(Basemod.instance.crystalHelm, Basemod.instance.crystalItem);
        makePlateRecipe(Basemod.instance.crystalPlate,Basemod.instance.crystalItem);
        makeLegsRecipe(Basemod.instance.crystalLegs, Basemod.instance.crystalItem);
        makeBootsRecipe(Basemod.instance.crystalBoots, Basemod.instance.crystalItem);
        
        //Neo Plasma
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.neoHelm, 1), "xxx","y y","  ",'x', new ItemStack(Basemod.instance.crystalItem), 'y', new ItemStack(Basemod.instance.siliconItem));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.neoPlate, 1), "x x","xxx","yyy",'x', new ItemStack(Basemod.instance.crystalItem), 'y', new ItemStack(Basemod.instance.siliconItem));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.neoLegs, 1), "xxx","x x","y y",'x', new ItemStack(Basemod.instance.crystalItem), 'y', new ItemStack(Basemod.instance.siliconItem));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.neoBoots, 1), "x x","y y",'x', new ItemStack(Basemod.instance.crystalItem), 'y', new ItemStack(Basemod.instance.siliconItem));
        
        makeHelmRecipe(Basemod.instance.rocketHelm, Basemod.instance.amethystItem);
        makePlateRecipe(Basemod.instance.rocketPlate,Basemod.instance.amethystItem);
        makeLegsRecipe(Basemod.instance.rocketLegs, Basemod.instance.amethystItem);
        makeBootsRecipe(Basemod.instance.rocketBoots, Basemod.instance.amethystItem);

        //Radio
        GameRegistry.addRecipe(new ItemStack(PixelUtilitiesBlocks.radioBlock), "  y", "xyx", "xzx", 'x', new ItemStack(Blocks.planks), 'y', new ItemStack(Items.iron_ingot), 'z', new ItemStack(Items.diamond));

        //Lights
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.blueLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 11), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.redLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 14), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.purpleLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 10), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.yellowLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 4), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.orangeLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 1), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.whiteLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 0), 'y', new ItemStack(Blocks.redstone_torch, 1));
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.greenLightBlock, 1), "xxx","xyx","xxx", 'x', new ItemStack(Blocks.stained_glass_pane, 1, 5), 'y', new ItemStack(Blocks.redstone_torch, 1));
        
        GameRegistry.addRecipe(new ItemStack(Basemod.instance.pixelBoyItem, 1), new Object[] { "XXX", "XYX", "ZZZ", Character.valueOf('X'), new ItemStack(Basemod.instance.crystalItem), Character.valueOf('Y'), new ItemStack(Blocks.glass_pane), Character.valueOf('Z'), new ItemStack(Basemod.instance.siliconItem)});
    }

}
