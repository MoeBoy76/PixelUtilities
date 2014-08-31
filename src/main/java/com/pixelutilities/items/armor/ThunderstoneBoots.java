package com.pixelutilities.items.armor;

import java.util.UUID;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ThunderstoneBoots extends ItemArmor
{
	private boolean isEquipped = false;
	private boolean fullSet = false;

	public ThunderstoneBoots(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesArmours);
		if (!PixelUtilitiesArmor.getArmourList().contains(this))
			PixelUtilitiesArmor.getArmourList().add(this);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == Basemod.instance.thunderstoneLegs) {
			return "pixelutilities:textures/armor/ThunderStoneArmor_2.png";
		}
		else
		{
			return "pixelutilities:textures/armor/ThunderstoneArmor_1.png";
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/ThunderstoneBoots");
	}

	private UUID elementalBootsUUID = UUID.fromString("10ae6bcc-5b15-41b1-ba51-b6101e178401");
	private AttributeModifier elementalBootsModifier = new AttributeModifier(elementalBootsUUID, SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), 0.5, 1);
	private UUID thunderstoneBootsUUID = UUID.fromString("de4f0383-fcf9-4ba7-8ffc-0767c1ead7b9");
	private AttributeModifier thunderstoneBootsModifier = new AttributeModifier(thunderstoneBootsUUID, SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), 1, 1);	

	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap o = HashMultimap.create();
		if (this.isEquipped)
		{
			o.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), elementalBootsModifier);
		}
		else if(fullSet)
		{
			o.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), thunderstoneBootsModifier);
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
				if(thePlayer.getEquipmentInSlot(2) != null && thePlayer.getEquipmentInSlot(3) != null && thePlayer.getEquipmentInSlot(4) != null)
				{
					Item legs = thePlayer.getEquipmentInSlot(2).getItem();
					Item plate = thePlayer.getEquipmentInSlot(3).getItem();
					Item helm = thePlayer.getEquipmentInSlot(4).getItem();
					if(boots instanceof ThunderstoneBoots && legs instanceof ThunderstoneLegs && plate instanceof ThunderstonePlate && helm instanceof ThunderstoneHelmet)
					{
						isEquipped = false;
						fullSet = true;
						thePlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20));
					}
				}
				else if(boots instanceof ThunderstoneBoots)
				{
					isEquipped = true;
					fullSet = false;
				}
				else
				{
					isEquipped = false;
					fullSet = false;
				}
			}
			else
			{
				isEquipped = false;
				fullSet = false;
			}
		}
	}
}
