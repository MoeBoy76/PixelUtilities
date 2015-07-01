package com.pixelutilities.gui;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;

public class GuiHelper {
    public static void drawImageQuad(int x, int y, float w, float h, float us, float vs, float ue, float ve, float zLevel) {
        Tessellator tess = Tessellator.getInstance();
        WorldRenderer wr = tess.getWorldRenderer();
        wr.startDrawingQuads();
        wr.addVertexWithUV((double) (x), (double) (y + h), (double) zLevel, (double) ((float) us), (double) ((float) ve));
        wr.addVertexWithUV((double) (x + w), (double) (y + h), (double) zLevel, (double) ((float) ue), (double) ((float) ve));
        wr.addVertexWithUV((double) (x + w), (double) (y), (double) zLevel, (double) ((float) ue), (double) ((float) vs));
        wr.addVertexWithUV((double) (x), (double) (y), (double) zLevel, (double) ((float) us), (double) ((float) vs));
        tess.draw();
    }
}
