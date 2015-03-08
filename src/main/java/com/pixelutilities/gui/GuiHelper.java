package com.pixelutilities.gui;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;

public class GuiHelper {
    public static void drawImageQuad(int x, int y, float w, float h, float us, float vs, float ue, float ve, float zLevel) {
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
	    worldRenderer.startDrawingQuads();
	    worldRenderer.addVertexWithUV((double) (x), (double) (y + h), (double) zLevel, (double) ((float) us), (double) ((float) ve));
	    worldRenderer.addVertexWithUV((double) (x + w), (double) (y + h), (double) zLevel, (double) ((float) ue), (double) ((float) ve));
	    worldRenderer.addVertexWithUV((double) (x + w), (double) (y), (double) zLevel, (double) ((float) ue), (double) ((float) vs));
	    worldRenderer.addVertexWithUV((double) (x), (double) (y), (double) zLevel, (double) ((float) us), (double) ((float) vs));
	    worldRenderer.draw();
    }
}
