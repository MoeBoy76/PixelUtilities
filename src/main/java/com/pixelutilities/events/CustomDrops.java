package com.pixelutilities.events;

import java.util.Random;

import net.minecraft.item.ItemStack;

import com.pixelmonmod.pixelmon.api.events.BeatWildPixelmonEvent;
import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

//@Optional.Interface(iface = "com.pixelmonmod.pixelmon.api.events.IPixelmonEventHandler", modid = "pixelmon")
public class CustomDrops
{

	public static Random random = new Random();
	private PixelUtilitiesConfig pixelConfig = PixelUtilitiesConfig.getInstance();

	@SubscribeEvent
	public void onWildPokemonDefeat(BeatWildPixelmonEvent event)
	{
		if (!pixelConfig.coinDrops)
		{
			return;
		}
		int doDrop = (int) (Math.random() * (pixelConfig.coinDropRate * 25));
		if(doDrop < 25 && doDrop != 10)
		{
			int amount = random.nextInt(2) + 1;
			event.player.inventory.addItemStackToInventory(new ItemStack(Basemod.instance.pokeCoin1Item, amount));
		}
		if(doDrop == 10)
		{
			event.player.inventory.addItemStackToInventory(new ItemStack(Basemod.instance.pokeCoin10Item, 1));
		}
	}

	/*@Optional.Method(modid = "pixelmon")
    @Override
    public void eventFired(EventType eventType, EntityPlayer entityPlayer, Object... objects)
    {
        if (!pixelConfig.coinDrops)
        {
            return;
        }

        if(eventType == EventType.BeatWildPokemon)
        {
            int doDrop = (int) (Math.random() * (pixelConfig.coinDropRate * 25));
            if(doDrop < 25 && doDrop != 10)
            {
                int amount = random.nextInt(2) + 1;
                entityPlayer.inventory.addItemStackToInventory(new ItemStack(Basemod.instance.pokeCoin1Item, amount));
            }
            if(doDrop == 10)
            {
                entityPlayer.inventory.addItemStackToInventory(new ItemStack(Basemod.instance.pokeCoin10Item, 1));
            }
        }
    }*/
}