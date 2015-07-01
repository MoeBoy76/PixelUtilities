package com.pixelutilities.gui.starters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.pixelmonmod.pixelmon.client.gui.GuiResources;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import com.pixelmonmod.pixelmon.gui.ContainerEmpty;
import com.pixelutilities.Basemod;
import com.pixelutilities.gui.GuiHelper;
import com.pixelutilities.packets.SelectPokemon;
import com.pixelutilities.packets.StarterListPacket;

public class GuiSelectPokemon extends GuiContainer {
	enum StarterScreen {
		Choose
	}
	
	int timesClicked = 0;

	StarterScreen currentScreen = StarterScreen.Choose;

	public static StarterListPacket starterListPacket;
	int starterListIndex = -1;
	
	public GuiSelectPokemon(EnumPokemon[] list, int starterListIndex) {
		super(new ContainerEmpty());
		
		starterListPacket = new StarterListPacket(list);
		StarterListStorage.starterListPacket = starterListPacket;
		this.starterListIndex = starterListIndex;
		
		Random r = new Random();
		while (shadowList.size() < 5) {
			EnumShadow shadowType;
			float f = r.nextFloat();
			if (f < 0.2f)
				shadowType = EnumShadow.Large;
			if (f < 0.5f)
				shadowType = EnumShadow.Medium;
			else
				shadowType = EnumShadow.Large;
			shadowList.add(new Shadow(shadowType, this, r.nextFloat()));
		}
	}
	
	public GuiSelectPokemon(EnumPokemon[] list) {
		super(new ContainerEmpty());
		
		starterListPacket = new StarterListPacket(list);
		StarterListStorage.starterListPacket = starterListPacket;
		starterListIndex = -1;
		
		Random r = new Random();
		while (shadowList.size() < 5) {
			EnumShadow shadowType;
			float f = r.nextFloat();
			if (f < 0.2f)
				shadowType = EnumShadow.Large;
			if (f < 0.5f)
				shadowType = EnumShadow.Medium;
			else
				shadowType = EnumShadow.Large;
			shadowList.add(new Shadow(shadowType, this, r.nextFloat()));
		}
	}

	public GuiSelectPokemon() {
		super(new ContainerEmpty());
		
		starterListPacket = new StarterListPacket();
		starterListIndex = -1;
		
		Random r = new Random();
		while (shadowList.size() < 5) {
			EnumShadow shadowType;
			float f = r.nextFloat();
			if (f < 0.2f)
				shadowType = EnumShadow.Large;
			if (f < 0.5f)
				shadowType = EnumShadow.Medium;
			else
				shadowType = EnumShadow.Large;
			shadowList.add(new Shadow(shadowType, this, r.nextFloat()));
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		int index = 0;
		int[] rowSizes = getEvenlySplitRowSizes(starterListPacket.starterList.length);
		for (int row = 0; row < rowSizes.length; row++) {
			if (index >= 15){
				break;
			}
			for (int col = 0; col < rowSizes[row]; col++) {
				int colShift = 40;
				if (rowSizes[row] % 2 == 0) {
					colShift = 0;
				}
				if (index < starterListPacket.starterList.length && starterListPacket.starterList[index] != null && buttonList.size() <= starterListPacket.starterList.length)
					buttonList.add(new SelectPokemonButton(index, width / 2 - colShift + 80 * (col - (int) Math.floor(rowSizes[row] / 2)), height / 6 + 45 + row * 41, index));
				index++;
				if (index >= 15){
					break;
				}
			}
		}
	}

	public static int[] getEvenlySplitRowSizes(int length) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (length <= 3) {
			return new int[] { length };
		} else if (length <= 10 && length % 2 == 0) {
			return new int[] { length / 2, length / 2 };
		} else {
			int width = (int) Math.floor(length / 3);
			int mod = length % 3;
			return new int[] { width + (mod >= 1 ? 1 : 0), width + (mod == 2 ? 1 : 0), width };
		}
	}

	@Override
	public void keyTyped(char i, int i1) {
	}

	@Override
	public void actionPerformed(GuiButton button) {
		if(timesClicked > 0)
			return;
		timesClicked++;
		if (((SelectPokemonButton) button).starterIndex >= 0) {
			if(starterListIndex != -1)
				Basemod.network.sendToServer(new SelectPokemon(starterListPacket.starterList[button.id].ordinal(), starterListIndex));
			else
				Basemod.network.sendToServer(new SelectPokemon(starterListPacket.starterList[button.id].ordinal()));
			mc.thePlayer.closeScreen();
		}
	}

	ArrayList<Shadow> shadowList = new ArrayList<Shadow>();

	@Override
	public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
		mc.renderEngine.bindTexture(GuiResources.starterBackground);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiHelper.drawImageQuad(0, 0, width, height, 0, 0, 1, 1, zLevel);

		for (int i = 0; i < shadowList.size(); i++)
			shadowList.get(i).draw(mc, width, height);
		GL11.glEnable(GL11.GL_BLEND);
		mc.renderEngine.bindTexture(GuiResources.starterBorders);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiHelper.drawImageQuad(0, 0, width, height, 0, 0, 1, 1, zLevel);
		if (currentScreen == StarterScreen.Choose) {
			drawCenteredString(mc.fontRendererObj, StatCollector.translateToLocal("gui.selectpokemon.message"), width / 2, 56, 0xFFFFFF);
		}
	}

	boolean boolInit = false;

	@Override
	public void updateScreen() {
		super.updateScreen();
		if (!boolInit) {
			initGui();
		}
		for (int i = 0; i < shadowList.size(); i++)
			shadowList.get(i).update();

		if (Minecraft.getMinecraft().thePlayer.getRNG().nextFloat() < 0.008f) {
			EnumShadow shadowType;
			float f = mc.thePlayer.getRNG().nextFloat();
			if (f < 0.2f)
				shadowType = EnumShadow.Large;
			if (f < 0.5f)
				shadowType = EnumShadow.Medium;
			else
				shadowType = EnumShadow.Large;
			shadowList.add(new Shadow(shadowType, this));
		}
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		try {
			super.mouseClicked(par1, par2, par3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!boolInit) {
			initGui();
		}
	}

	public void removeShadow(Shadow shadowSelectPokemon) {
		shadowList.remove(shadowSelectPokemon);
	}
}