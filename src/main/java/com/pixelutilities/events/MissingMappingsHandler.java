package com.pixelutilities.events;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.pixelutilities.Basemod;

import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MissingMappingsHandler
{

	public static void processMissingMapping(FMLMissingMappingsEvent event) {
		System.out.println("Processing missing mappings");

		for (FMLMissingMappingsEvent.MissingMapping mapping : event.get())
		{
			if (!mapping.name.startsWith(Basemod.MODID + ":"))
				return;
			//System.out.println("missingmap " + mapping.name);
			//System.out.println("new mapping " + mapping.name.replaceAll(" ", "_"));

			if (mapping.type.equals(GameRegistry.Type.BLOCK))
			{
				if (Block.getBlockFromName(mapping.name.replaceAll(" ", "_")) != null)
					mapping.remap(Block.getBlockFromName(mapping.name.replaceAll(" ", "_")));
			}
			else if (mapping.type.equals(GameRegistry.Type.ITEM))
			{
				if (Item.itemRegistry.getObject(mapping.name.replaceAll(" ", "_")) != null)
					mapping.remap((Item) Item.itemRegistry.getObject(mapping.name.replaceAll(" ", "_")));
			}
		}
	}
}
