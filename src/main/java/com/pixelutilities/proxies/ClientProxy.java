package com.pixelutilities.proxies;

import com.pixelutilities.Basemod;
import com.pixelutilities.entitys.SeatEntity;
import com.pixelutilities.models.renderers.*;
import com.pixelutilities.tileentitys.*;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{

	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(BlockEntity.class, new BlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TreeEntity.class, new TreeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BolderEntity.class, new BolderRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BoxEntity.class, new BoxRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ClothedTableEntity.class, new ClothedTableRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(RedCusionChairEntity.class, new RedCusionChairRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TrashcanEntity.class, new TrashcanRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(YellowCusionChairEntity.class, new YellowCusionChairRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TotodilePokedollEntity.class, new TotodilePokedollRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AronPokedollEntity.class, new AronPokedollRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BisharpPokedollEntity.class, new BisharpPokedollRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PokeballStatueTileEntity.class, new PokeballStatueTileEntityRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRadio.class, new RadioBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(GymSignEntity.class, new GymSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TVEntity.class, new TVRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BlueRugEntity.class, new BlueRugRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(RedRugEntity.class, new RedRugRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(GreenRugEntity.class, new GreenRugRenderer());

		RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, new InvisibleRenderer());

		if(Basemod.instance.pixelmonPresent)
		{
			ClientRegistry.bindTileEntitySpecialRenderer(PokegiftEntity.class, new PokegiftRenderer());
			ClientRegistry.bindTileEntitySpecialRenderer(PokeballEntity.class, new PokeballRenderer());
		}
	}

}
