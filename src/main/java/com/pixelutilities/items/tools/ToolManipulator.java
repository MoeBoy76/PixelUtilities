package com.pixelutilities.items.tools;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ToolManipulator 
{
	public ToolManipulator()
	{

	}

	public static boolean addToolEffect(ItemStack stack, EntityPlayer player, World world, int x, int y, int z)
	{
		String toolName = stack.getUnlocalizedName();

		if(toolName.contains("fire"))
		{
			if(world.getBlock(x, y, z).equals(Blocks.water))
			{
				world.setBlock(x, y, z, Blocks.obsidian);
				stack.damageItem(1, player);
				return true;
			}
		}
		if(toolName.contains("water"))
		{
			if(world.getBlock(x, y, z).equals(Blocks.lava))
			{
				world.setBlock(x, y, z, Blocks.obsidian);
				stack.damageItem(1, player);
				return true;
			}
		}
		if(toolName.contains("leaf"))
		{
			if (ItemDye.applyBonemeal(stack, world, x, y - 1, z, player))
			{
				if (!world.isRemote)
				{
					world.playAuxSFX(2005, x, y, z, 0);
				}
				stack.damageItem(1, player);
				return true;
			}
		}
		if(toolName.contains("thunder"))
		{
			stack.addEnchantment(Enchantment.efficiency, 8);
			stack.damageItem(1, player);
			return true;
		}
		if(toolName.contains("sun"))
		{
			if(Blocks.torch.canPlaceBlockAt(world, x, y, z))
			{
				world.setBlock(x, y, z, Blocks.torch);
				stack.damageItem(1, player);
				return true;
			}
		}
		if(toolName.contains("moon"))
		{
			player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 6000, 0, true));
			stack.damageItem(1, player);
			return true;
		}
		return false;
	}
}
