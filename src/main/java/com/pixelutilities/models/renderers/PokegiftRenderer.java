package com.pixelutilities.models.renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.pixelmonmod.pixelmon.client.models.pokeballs.ModelCherishBall;
import com.pixelmonmod.pixelmon.config.PixelmonConfig;
import com.pixelmonmod.pixelmon.entities.pokeballs.EntityPokeBall;
import com.pixelutilities.tileentitys.PokegiftEntity;

public class PokegiftRenderer extends TileEntitySpecialRenderer
{
	private ModelCherishBall cherishBall;
	private EntityPokeBall entityPokeBall = new EntityPokeBall(Minecraft.getMinecraft().theWorld);
	
	public static ResourceLocation pokegift = new ResourceLocation("pixelmon:textures/pokeballs/cherishball.png");
	public static ResourceLocation lowPokegift = new ResourceLocation("pixelmon:low-res/pokeballs/cherishball.png");
	
	public PokegiftRenderer()
	{
		cherishBall = new ModelCherishBall();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double d0, double d1, double d2, float f) {
		// Draw Model
		renderModelAt(((PokegiftEntity) tile), d0, d1, d2, f);
	}

	private void renderModelAt(PokegiftEntity tile, double d0, double d1, double d2, float f) {

		// Texture
		ResourceLocation t = pokegift;
		if (PixelmonConfig.useLowResTextures)
			t = lowPokegift;
		else
			t = pokegift;
		// Rotation
				int meta = tile.getBlockMetadata(); // this is for rotation
				int j = 0;

				if (meta == 3) {
					j = 180;
				}
				if (meta == 4) {
					j = 90;
				}
				if (meta == 1) {
					j = 0;
				}
				if (meta == 2) {
					j = 270;
				}

				// Hidden
				if (meta > 4)
					return;

				// Bind Texture
				bindTexture(t);

				// Code From RenderPC
				GL11.glPushMatrix(); // start
				GL11.glTranslatef((float) d0 + 0.5F, (float) d1 + .03f, (float) d2 + 0.5F); // size
				GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); // rotate based on metadata

				GL11.glScalef(.1f, .1f, .1f); // if you read this comment out this line and you can see what happens
				RenderHelper.enableStandardItemLighting();
				GL11.glEnable(GL12.GL_RESCALE_NORMAL);

				cherishBall.render(entityPokeBall, 0.0625F); // renders and yes 0.0625 is a random number
					
				RenderHelper.disableStandardItemLighting();
				GL11.glDisable(GL12.GL_RESCALE_NORMAL);

				GL11.glPopMatrix(); // end
	}
}
