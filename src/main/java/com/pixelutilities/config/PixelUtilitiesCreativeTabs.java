package com.pixelutilities.config;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

import com.pixelutilities.Basemod;

public class PixelUtilitiesCreativeTabs
{

	public static CreativeTabs tabPixelmonBlocks = new CreativeTabs("tabPixelmonBlocks") {

		@Override
		public Item getTabIconItem() {
			return new ItemStack(PixelUtilitiesBlocks.treeBlock).getItem();
		}
	};

	public static CreativeTabs tabPokefurniture = new CreativeTabs("tabPokefurniture") {

		@Override
		public Item getTabIconItem() {
			return new ItemStack(PixelUtilitiesBlocks.trashcanBlock).getItem();
		}
	};

	public static CreativeTabs tabPixelmonBadges = new CreativeTabs("tabPixelmonBadges") {

		@Override
		public Item getTabIconItem() {
			return Basemod.instance.bugBadgeItem;
		}
	};

	public static CreativeTabs tabPixelUtilitiesTools = new CreativeTabs("tabPixelUtilitiesTools") {

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllReleventItems(List itemList)//Allows us to not deal with vanillas stupid sorting
		{
			itemList.clear();
			for (Item item : PixelUtilitiesTools.getInstance().getToolList())
				((List<ItemStack>)itemList).add(new ItemStack(item, 1, 0));

		}

		@Override
		public Item getTabIconItem() {
			return Basemod.instance.rubyAxe;
		}
	};

	public static CreativeTabs tabPixelUtilitiesArmours = new CreativeTabs("tabPixelUtilitiesArmours") {

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllReleventItems(List itemList)
		{
			itemList.clear();
			for (Item item : PixelUtilitiesArmor.getArmourList())
				((List<ItemStack>)itemList).add(new ItemStack(item, 1, 0));

		}

		@Override
		public Item getTabIconItem() {
			return Basemod.instance.rubyHelm;
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
