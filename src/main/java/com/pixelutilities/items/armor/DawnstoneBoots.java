package com.pixelutilities.items.armor;

import java.util.UUID;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesArmor;
import com.pixelutilities.config.PixelUtilitiesCreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DawnstoneBoots extends ItemArmor
{
	private boolean isEquipped = false;
	private boolean setComplete = false;

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

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		world = player.worldObj;
		if (itemStack != null) {
			if (itemStack.getItem() == Basemod.instance.dawnstoneBoots)
			{
				this.isEquipped = true;
			}
			else
			{
				this.isEquipped = false;
			}
		}
		else
		{
			this.isEquipped = false;
		}
		if(player.getEquipmentInSlot(1).getItem() instanceof DawnstoneBoots 
				&& player.getEquipmentInSlot(2).getItem() instanceof DawnstoneLegs 
				&& player.getEquipmentInSlot(3).getItem() instanceof DawnstonePlate 
				&& player.getEquipmentInSlot(4).getItem() instanceof DawnstoneHelmet)
		{
			NBTTagList nbtList = itemStack.getEnchantmentTagList();
			for(int i = 0; i < nbtList.tagCount(); i++)
			{
				NBTTagCompound nbtComp = nbtList.getCompoundTagAt(i);
				if(nbtComp.hasKey("Enchantment"))
				{
					System.out.println("[PixelUtilities] Enchanted Armour!");
				}
			}
		}
	}

	private UUID runningShoesUUID = UUID.fromString("B7060ADF-8FAF-4C0F-B816-87CB5721979F");
	private AttributeModifier oldRunningShoesModifier = new AttributeModifier(runningShoesUUID, SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), 0.5, 1);
	//private AttributeModifier dawnstoneModifier = new AttributeModifier(SharedMonsterAttributes.attackDamage, p_i1605_2_, p_i1605_4_)

	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap o = HashMultimap.create();
		if (this.isEquipped)
		{
			o.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), oldRunningShoesModifier);
		}
		else
		{
			o = HashMultimap.create();
		}
		return o;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
		this.isEquipped = false;
		setComplete = false;
	}

}
