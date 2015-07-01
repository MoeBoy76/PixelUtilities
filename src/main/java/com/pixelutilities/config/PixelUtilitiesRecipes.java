package com.pixelutilities.config;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.pixelmonmod.pixelmon.config.PixelUtilitiesAdditions;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelmonmod.pixelmon.config.PixelmonItemsPokeballs;
import com.pixelutilities.Basemod;

public class PixelUtilitiesRecipes
{
	public void addRecipes() {

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

		if(Basemod.instance.pixelmonPresent)
			GameRegistry.addRecipe(new ItemStack(Basemod.instance.pixelBoyItem, 1), new Object[] { "XXX", "XYX", "ZZZ", Character.valueOf('X'), new ItemStack(PixelUtilitiesAdditions.crystalItem), Character.valueOf('Y'), new ItemStack(Blocks.glass_pane), Character.valueOf('Z'), new ItemStack(PixelUtilitiesAdditions.siliconItem)});
	}

}
