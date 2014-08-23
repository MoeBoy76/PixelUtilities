package com.pixelutilities.items.tools;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.items.ItemHammer;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;
import com.pixelutilities.config.PixelUtilitiesTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PixelHammerTool extends ItemHammer {

	public PixelHammerTool(ToolMaterial par3EnumToolMaterial, String itemString, String itemName) {
		super(par3EnumToolMaterial, itemString, itemName);

		setTextureName(itemString);
		setUnlocalizedName(itemName);
		setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesTools);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(this.getIconString());
	}

	@Override
	public Item setCreativeTab(CreativeTabs tabs) {
		super.setCreativeTab(tabs);
		if (!PixelUtilitiesTools.getInstance().getToolList().contains(this))
			PixelUtilitiesTools.getInstance().getToolList().add(this);
		return null;
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block == PixelmonBlocks.anvil) {
			if (toolMaterial == ToolMaterial.WOOD)
				return 1;
			else if (toolMaterial == ToolMaterial.STONE)
				return 2;
			else if (toolMaterial == ToolMaterial.IRON)
				return 3;
			else if (toolMaterial == ToolMaterial.GOLD)
				return 4;
			else if (toolMaterial == ToolMaterial.EMERALD)
				return 5;
			else if (toolMaterial == Basemod.instance.RUBY)
				return 4;
			else if (toolMaterial == Basemod.instance.SAPHIRE)
				return 4;
			else if(toolMaterial == Basemod.instance.ELEMENTSTONE)
				return 6;
			/*else if (toolMaterial == Basemod.instance.FIRESTONE)
                return 6;
            else if (toolMaterial == Basemod.instance.WATERSTONE)
                return 6;
            else if (toolMaterial == Basemod.instance.LEAFSTONE)
                return 4;*/
		}
		return 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		int x = p_77648_4_;
		int y = p_77648_5_ + 1;
		int z = p_77648_6_;

		return ToolManipulator.addToolEffect(stack, player, world, x, y, z);
	}

}
