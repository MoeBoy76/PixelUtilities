package com.pixelutilities.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class PokegearExit extends GuiButton {
    public PokegearExit(int par1, int par2, int par3, int par4, int par5,
                        String par6Str) {
        super(par1, par2, par3, par4, par5, par6Str);

        this.width = 64;
        this.height = 64;
        this.enabled = true;
        this.visible = true;
        this.id = par1;
        this.xPosition = par2;
        this.yPosition = par3;
        this.width = par4;
        this.height = par5;
        this.displayString = par6Str;
    }

    protected static final ResourceLocation buttonTextures = new ResourceLocation("pixelutilitys:textures/guis/pokegear/Exit.png");

    @Override
    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
        if (this.visible) {
            FontRenderer var4 = Minecraft.getMinecraft().fontRendererObj;
            Minecraft.getMinecraft().renderEngine.bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawTexturedModalRect(width / 2, height / 2, 0, 64, 64, this.height);

            this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = 14737632;
            //this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }

    public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
        return this.enabled && this.visible && p_146116_2_ >= this.xPosition && p_146116_3_ >= this.yPosition && p_146116_2_ < this.xPosition + this.width && p_146116_3_ < this.yPosition + this.height;
    }

    public int getButtonWidth() {
        return this.width;
    }
}
