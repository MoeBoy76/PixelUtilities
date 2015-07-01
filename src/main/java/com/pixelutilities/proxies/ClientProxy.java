package com.pixelutilities.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.pixelutilities.Basemod;
import com.pixelutilities.config.PixelUtilitiesConfig;
import com.pixelutilities.enums.EnumGui;
import com.pixelutilities.gui.GuiPixelBoy;
import com.pixelutilities.gui.starters.GuiSelectPokemon;
import com.pixelutilities.models.renderers.*;
import com.pixelutilities.tileentitys.*;

public class ClientProxy extends CommonProxy
{

	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(BlockEntity.class, new BlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TotodilePokedollEntity.class, new TotodilePokedollRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AronPokedollEntity.class, new AronPokedollRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BisharpPokedollEntity.class, new BisharpPokedollRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRadio.class, new RadioBlockRenderer());

		//RenderingRegistry.registerBlockHandler(500, new ConveyorRenderer());

		if(Basemod.instance.pixelmonPresent)
		{
			//ClientRegistry.bindTileEntitySpecialRenderer(PokeballEntity.class, new PokeballRenderer());
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == EnumGui.SelectPokemon.getIndex())
			return new GuiSelectPokemon(PixelUtilitiesConfig.getInstance().getStarterList(x), x);
		else if(ID == EnumGui.PixelBoy.getIndex())
			return new GuiPixelBoy();

		return null;
	}

}
