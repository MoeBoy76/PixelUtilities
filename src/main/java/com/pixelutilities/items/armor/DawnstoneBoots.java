package com.pixelutilities.items.armor;

import java.util.UUID;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DawnstoneBoots extends ItemArmor
{
	private boolean isEquipped = false;

	public DawnstoneBoots(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		setCreativeTab(PixelUtilitiesCreativeTabs.tabPixelUtilitiesArmours);
		if (!PixelUtilitiesArmor.getArmourList().contains(this))
			PixelUtilitiesArmor.getArmourList().add(this);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == Basemod.instance.dawnstoneLegs) {
			return "pixelutilities:textures/armor/DawnStoneArmor_2.png";
		}
		else
		{
			return "pixelutilities:textures/armor/DawnstoneArmor_1.png";
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("pixelutilities:armor/DawnstoneBoots");
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
		if(player.getEquipmentInSlot(1) != null)
		{
			Item boots = player.getEquipmentInSlot(1).getItem();
			if(player.getEquipmentInSlot(1) != null && player.getEquipmentInSlot(2) != null && player.getEquipmentInSlot(3) != null && player.getEquipmentInSlot(4) != null)
			{
				if(dawnstoneArmourChecker(player))
				{
					isEquipped = true;
					PotionEffect lancer = new PotionEffect(Potion.jump.getId(), 20, 32, false);
					player.addPotionEffect(lancer);
				}
				else
				{
					isEquipped = false;
				}
			}
			else if(boots instanceof DawnstoneBoots)
			{
				isEquipped = true;
			}
			else
			{
				isEquipped = false;
			}
		}
	}
	
	public boolean dawnstoneArmourChecker(EntityPlayer player)
	{
		if(player.getEquipmentInSlot(1) != null && player.getEquipmentInSlot(2) != null && player.getEquipmentInSlot(3) != null && player.getEquipmentInSlot(4) != null)
		{
			if(player.getEquipmentInSlot(1).getItem() instanceof DawnstoneBoots && player.getEquipmentInSlot(2).getItem() instanceof DawnstoneLegs && player.getEquipmentInSlot(3).getItem() instanceof DawnstonePlate && player.getEquipmentInSlot(4).getItem() instanceof DawnstoneHelmet)
			{
				return true;
			}
		}
		return false;
	}
}
