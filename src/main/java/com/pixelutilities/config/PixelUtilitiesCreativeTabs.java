package com.pixelutilities.config;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.pixelutilities.Basemod;

public class PixelUtilitiesCreativeTabs
{
	
	public static CreativeTabs tabPUCollection = new CreativeTabs("tabPUCollection") {
		
		@Override
		public Item getTabIconItem() {
			return new ItemStack(Basemod.pixelBoyItem).getItem();
		}
	};

	/*public static CreativeTabs tabPixelmonBlocks = new CreativeTabs("tabPixelmonBlocks") {

		@Override
		public Item getTabIconItem() {
			return new ItemStack(PixelUtilitiesBlocks.blockConveyor).getItem();
		}
	};

	public static CreativeTabs tabPokefurniture = new CreativeTabs("tabPokefurniture") {

		@Override
		public Item getTabIconItem() {
			return new ItemStack(PixelUtilitiesBlocks.aronPokedollBlock).getItem();
		}
	};*/

	public static CreativeTabs tabPixelmonBadges = new CreativeTabs("tabPixelmonBadges") {

		@Override
		public Item getTabIconItem() {
			return Basemod.instance.bugBadgeItem;
		}
	};

	public static CreativeTabs tabPixelUtilitiesLights = new CreativeTabs("tabPixelUtilitiesLights") {

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllReleventItems(List itemList)
		{
			for (Block block : PixelUtilitiesBlocks.LightBlockList)
				((List<ItemStack>)itemList).add(new ItemStack(block, 1, 0));
		}

		@Override
		public Item getTabIconItem() {
			return new ItemStack(Basemod.instance.blueLightBlock).getItem();
		}
	};
}
