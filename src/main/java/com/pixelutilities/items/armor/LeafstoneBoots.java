package com.pixelutilities.items.armor;

import java.util.UUID;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LeafstoneBoots extends ItemArmor
{
	private boolean isEquipped = false;

	public LeafstoneBoots(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesArmours);
		if (!PixelUtilitiesArmor.getArmourList().contains(this))
			PixelUtilitiesArmor.getArmourList().add(this);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == Basemod.instance.leafstoneLegs) {
			return "pixelutilities:textures/armor/LeafStoneArmor_2.png";
		}
		else
		{
			return "pixelutilities:textures/armor/LeafstoneArmor_1.png";
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/LeafstoneBoots");
	}

	private UUID elementalBootsUUID = UUID.fromString("10ae6bcc-5b15-41b1-ba51-b6101e178401");
	private AttributeModifier elementalBootsModifier = new AttributeModifier(elementalBootsUUID, SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), 0.5, 1);

	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap o = HashMultimap.create();
		if (this.isEquipped)
		{
			o.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), elementalBootsModifier);
		}
		else
		{
			o = HashMultimap.create();
		}
		return o;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if(player instanceof EntityPlayerMP)
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP) player;
			if(thePlayer.getEquipmentInSlot(1) != null)
			{
				Item boots = thePlayer.getEquipmentInSlot(1).getItem();
				if(thePlayer.getEquipmentInSlot(1) != null && thePlayer.getEquipmentInSlot(2) != null && thePlayer.getEquipmentInSlot(3) != null && thePlayer.getEquipmentInSlot(4) != null)
				{
					Item legs = thePlayer.getEquipmentInSlot(2).getItem();
					Item plate = thePlayer.getEquipmentInSlot(3).getItem();
					Item helm = thePlayer.getEquipmentInSlot(4).getItem();
					if(boots instanceof LeafstoneBoots && legs instanceof LeafstoneLegs && plate instanceof LeafstonePlate && helm instanceof LeafstoneHelmet)
					{
						isEquipped = true;
						if(!stack.isItemEnchanted())
						{
							stack.addEnchantment(Enchantment.featherFalling, 3);
							stack.addEnchantment(Enchantment.thorns, 3);
						}
					}
					else if(boots instanceof LeafstoneBoots)
					{
						isEquipped = true;
						stack = new ItemStack(Basemod.instance.leafstoneBoots, 1, boots.getDamage(stack));
					}
					else
					{
						isEquipped = false;
					}
				}
				else if(boots instanceof LeafstoneBoots)
				{
					isEquipped = true;
					stack = new ItemStack(Basemod.instance.leafstoneBoots, 1, boots.getDamage(stack));
				}
				else
				{
					isEquipped = false;
				}
			}
		}
	}
}
