package com.pixelutilities.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import com.pixelutilities.items.armor.DawnstoneBoots;
import com.pixelutilities.items.armor.DawnstoneHelmet;
import com.pixelutilities.items.armor.DawnstoneLegs;
import com.pixelutilities.items.armor.DawnstonePlate;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FallEliminator
{
	@SubscribeEvent
	public void onPlayerFall(LivingFallEvent e)
	{
		if(e.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) e.entity;
			if(dawnstoneArmourChecker(player))
			{
				e.distance = 0F;
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
