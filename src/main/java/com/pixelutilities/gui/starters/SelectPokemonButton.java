package com.pixelutilities.gui.starters;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.pixelmonmod.pixelmon.client.gui.GuiResources;

public class SelectPokemonButton extends GuiButton {

	protected static final ResourceLocation buttonTexture = new ResourceLocation("pixelmon:gui/starter/starterHolder.png");
	protected static final ResourceLocation mouseOverTexture = new ResourceLocation("pixelmon:gui/starter/moStarter.png");
	protected static final ResourceLocation questionMark = new ResourceLocation("pixelmon:gui/starter/questionmark.png");

	int starterIndex;
	boolean clicked = false;

	public SelectPokemonButton(int par1, int par2, int par3, int starterIndex) {
		super(par1, par2, par3, 80, 33, "");
		this.starterIndex = starterIndex;
	}

	/**
	 * Draws this button to the screen.
	 */
	@Override
	public void drawButton(Minecraft mc, int par2, int par3) {
		if (this.visible) {
			FontRenderer fontrenderer = mc.fontRendererObj;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			int k = this.getHoverState(this.hovered);
			if (hovered && starterIndex >= 0)
				mc.getTextureManager().bindTexture(mouseOverTexture);
			else
				mc.getTextureManager().bindTexture(buttonTexture);
			drawImageQuad(xPosition, yPosition, width, height, 0, 0, 1, 1);
			// this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0,
			// this.width, this.height);
			this.mouseDragged(mc, par2, par3);
			int l = 0;

			if (starterIndex < 0) {
				l = 14737632;
				mc.renderEngine.bindTexture(questionMark);
				drawImageQuad(this.xPosition + width / 2 - 12, this.yPosition + 5, 24f, 24f, 0f, 0f, 1f, 1f);
			} else {
				if (!this.enabled) {
					l = -6250336;
				} else if (this.hovered) {
					l = 0xFFFFFF;
				}
				int npn = StarterListStorage.starterListPacket.starterListIndex[starterIndex];
				String numString = "";
				if (npn < 10)
					numString = "00" + npn;
				else if (npn < 100)
					numString = "0" + npn;
				else
					numString = "" + npn;
				mc.renderEngine.bindTexture(GuiResources.sprite(numString));
				drawImageQuad(this.xPosition + 3, this.yPosition + 3, 24f, 24f, 0f, 0f, 1f, 1f);
			}
			String name = "";
			GL11.glScalef(0.8f, 0.8f, 0.8f);
			if (starterIndex == -1) {
				name = StatCollector.translateToLocal("gui.starter.comingsoon");
				fontrenderer.drawString(name, (int) ((this.xPosition + this.width / 2 - 25) / 0.8f), (int) ((this.yPosition + (this.height - 3) / 2) / 0.8f), l);
			} else if (starterIndex == -2) {
				name = StatCollector.translateToLocal("gui.starter.disabled");
				fontrenderer.drawString(name, (int) ((this.xPosition + this.width / 2 - 15) / 0.8f), (int) ((this.yPosition + (this.height - 3) / 2) / 0.8f), l);

			} else {
				name = StatCollector.translateToLocal("pixelmon."+StarterListStorage.starterListPacket.starterList[starterIndex].name.toLowerCase()+".name");
				fontrenderer.drawString(name, (int) ((this.xPosition + this.width / 2 - 15) / 0.8f), (int) ((this.yPosition + (this.height - 3) / 2) / 0.8f), l);
			}
			GL11.glScalef(1 / 0.8f, 1 / 0.8f, 1 / 0.8f);
		}
	}

	@Override
	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {
		if(clicked)
			return false;
		clicked = true;
		if (starterIndex < 0)
			return false;
		return super.mousePressed(par1Minecraft, par2, par3);
	}

	private void drawImageQuad(double x, double y, double w, float h, double us, double vs, double ue, double ve) {
		// activate the specified texture
		float var7 = 0.00390625F;
		float var8 = 0.00390625F;
		Tessellator tess = Tessellator.getInstance();
		WorldRenderer wr = tess.getWorldRenderer();
		wr.startDrawingQuads();
		wr.addVertexWithUV((double) (x    ), (double) (y + h), (double) this.zLevel, (double) us, (double) ve);
		wr.addVertexWithUV((double) (x + w), (double) (y + h), (double) this.zLevel, (double) ue, (double) ve);
		wr.addVertexWithUV((double) (x + w), (double) (y    ), (double) this.zLevel, (double) ue, (double) vs);
		wr.addVertexWithUV((double) (x    ), (double) (y    ), (double) this.zLevel, (double) us, (double) vs);
		tess.draw();
	}

}
