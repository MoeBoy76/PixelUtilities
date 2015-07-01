package com.pixelutilities.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.pixelmonmod.pixelmon.gui.GuiHandler;
import com.pixelutilities.gui.starters.GuiSelectPokemon;

public class CommonProxy implements IGuiHandler
{
	public GuiHandler guiHandler = new GuiHandler();

    public void registerRenderThings()
    {
    	
    }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return guiHandler.getServerGuiElement(ID, player, world, x, y, z);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}