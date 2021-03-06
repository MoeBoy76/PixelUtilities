package com.pixelutilities.arcade.system.programs;

import java.awt.image.BufferedImage;

import com.pixelutilities.arcade.system.OS;

public interface IProgram {

	public OS getOS();
	public void load();
	public void initialize();
	public void unload();
	public String getTitle();
	public void onKeyUp(int i);
	public void onKeyDown(int i);
	public BufferedImage getImage();
}
