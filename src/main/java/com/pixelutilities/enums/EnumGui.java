package com.pixelutilities.enums;


public enum EnumGui {
	PixelBoy,
	SelectPokemon,
	Radio;
	
	public Integer getIndex() {
		return ordinal();
	}

	public static boolean hasGUI(String name) {
		try {
			return EnumGui.valueOf(name) != null;
		} catch (Exception e) {
			return false;
		}
	}
}
