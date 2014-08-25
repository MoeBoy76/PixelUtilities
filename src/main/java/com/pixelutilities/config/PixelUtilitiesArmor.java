package com.pixelutilities.config;

import java.util.ArrayList;
import java.util.List;

import com.pixelutilities.Basemod;
import com.pixelutilities.items.armor.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

public class PixelUtilitiesArmor
{
	/*public static Item rubyHelm;
    public static Item rubyPlate;
    public static Item rubyLegs;
    public static Item rubyBoots;

    public static Item saphireHelm;
    public static Item saphirePlate;
    public static Item saphireLegs;
    public static Item saphireBoots;

    public static Item galacticHelm;
    public static Item galacticBoots;
    public static Item galacticPlate;
    public static Item galacticLegs;

    public static Item crystalHelm;
    public static Item crystalBoots;
    public static Item crystalPlate;
    public static Item crystalLegs;

    public static Item rocketHelm;
    public static Item rocketBoots;
    public static Item rocketPlate;
    public static Item rocketLegs;


    public static Item firestoneHelm;
    public static Item firestonePlate;
    public static Item firestoneLegs;
    public static Item firestoneBoots;

    public static Item waterstoneHelm;
    public static Item waterstonePlate;
    public static Item waterstoneLegs;
    public static Item waterstoneBoots;

    public static Item leafstoneHelm;
    public static Item leafstonePlate;
    public static Item leafstoneLegs;
    public static Item leafstoneBoots;
	 */
	private static List<Item> armourList = new ArrayList<>();
	
	public static void load(Configuration cfg)
	{
		//TODO, textures for armour are referenced but not present?
		Basemod.instance.rubyHelm = new RubyHelmet(Basemod.instance.RUBYA, 0, 0);
		Basemod.instance.rubyPlate = new RubyPlate(Basemod.instance.RUBYA, 0, 1);
		Basemod.instance.rubyLegs = new RubyLegs(Basemod.instance.RUBYA, 0, 2);
		Basemod.instance.rubyBoots = new RubyBoots(Basemod.instance.RUBYA, 0, 3);

		Basemod.instance.saphireHelm = new SaphireHelmet(Basemod.instance.SAPHIREA, 0, 0);
		Basemod.instance.saphirePlate = new SaphirePlate(Basemod.instance.SAPHIREA, 0, 1);
		Basemod.instance.saphireLegs = new SaphireLegs(Basemod.instance.SAPHIREA, 0, 2);
		Basemod.instance.saphireBoots = new SaphireBoots(Basemod.instance.SAPHIREA, 0, 3);

		Basemod.instance.galacticHelm = new GalacticHelmet(Basemod.instance.SILICONA, 0, 0);
		Basemod.instance.galacticPlate = new GalacticPlate(Basemod.instance.SILICONA, 0, 1);
		Basemod.instance.galacticLegs = new GalacticLegs(Basemod.instance.SILICONA, 0, 2);
		Basemod.instance.galacticBoots = new GalacticBoots(Basemod.instance.SILICONA, 0, 3);

		/*Basemod.instance.crystalHelm = new CrystalHelmet(Basemod.instance.CRYSTALA, 0, 0);
		Basemod.instance.crystalPlate = new CrystalPlate(Basemod.instance.CRYSTALA, 0, 1);
		Basemod.instance.crystalLegs = new CrystalLegs(Basemod.instance.CRYSTALA, 0, 2);
		Basemod.instance.crystalBoots = new CrystalBoots(Basemod.instance.CRYSTALA, 0, 3);*/

		Basemod.instance.rocketHelm = new RocketHelmet(Basemod.instance.CRYSTALA, 0, 0);
		Basemod.instance.rocketPlate = new RocketPlate(Basemod.instance.CRYSTALA, 0, 1);
		Basemod.instance.rocketLegs = new RocketLegs(Basemod.instance.CRYSTALA, 0, 2);
		Basemod.instance.rocketBoots = new RocketBoots(Basemod.instance.CRYSTALA, 0, 3);

		Basemod.instance.firestoneHelm = new FirestoneHelmet(Basemod.instance.ELEMENTSTONE1, 0, 0).setTextureName("pixelUtilities:armor/FirestoneHelmet").setUnlocalizedName("Firestone Helmet");
		Basemod.instance.firestonePlate = new FirestonePlate(Basemod.instance.ELEMENTSTONE1, 0, 1).setTextureName("pixelUtilities:armor/FirestonePlate").setUnlocalizedName("Firestone ChestPlate");
		Basemod.instance.firestoneLegs = new FirestoneLegs(Basemod.instance.ELEMENTSTONE1, 0, 2).setTextureName("pixelUtilities:armor/FirestoneLegs").setUnlocalizedName("Firestone Leggings");
		Basemod.instance.firestoneBoots = new FirestoneBoots(Basemod.instance.ELEMENTSTONE1, 0, 3).setTextureName("pixelUtilities:armor/FirestoneBoots").setUnlocalizedName("Firestone Boots");

		Basemod.instance.waterstoneHelm = new WaterstoneHelmet(Basemod.instance.ELEMENTSTONE1, 0, 0).setTextureName("pixelutilities:armor/WaterstoneHelmet").setUnlocalizedName("Waterstone Helmet");
		Basemod.instance.waterstonePlate = new WaterstonePlate(Basemod.instance.ELEMENTSTONE1, 0, 1).setTextureName("pixelutilities:armor/WaterstonePlate").setUnlocalizedName("Waterstone ChestPlate");
		Basemod.instance.waterstoneLegs = new WaterstoneLegs(Basemod.instance.ELEMENTSTONE1, 0, 2).setTextureName("pixelutilities:armor/WaterstoneLegs").setUnlocalizedName("Waterstone Leggings");
		Basemod.instance.waterstoneBoots = new WaterstoneBoots(Basemod.instance.ELEMENTSTONE1, 0, 3).setTextureName("pixelutilities:armor/WaterstoneBoots").setUnlocalizedName("Waterstone Boots");

		Basemod.instance.leafstoneHelm = new LeafstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/LeafstoneHelmet").setUnlocalizedName("Leafstone Helmet");
		Basemod.instance.leafstonePlate = new LeafstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/LeafstonePlate").setUnlocalizedName("Leafstone ChestPlate");
		Basemod.instance.leafstoneLegs = new LeafstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/LeafstoneLegs").setUnlocalizedName("Leafstone Leggings");
		Basemod.instance.leafstoneBoots = new LeafstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/LeafstoneBoots").setUnlocalizedName("Leafstone Boots");
		
		Basemod.instance.thunderstoneHelm = new ThunderstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/ThunderstoneHelmet").setUnlocalizedName("Thunderstone Helmet");
		Basemod.instance.thunderstonePlate = new ThunderstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/ThunderstonePlate").setUnlocalizedName("Thunderstone ChestPlate");
		Basemod.instance.thunderstoneLegs = new ThunderstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/ThunderstoneLegs").setUnlocalizedName("Thunderstone Leggings");
		Basemod.instance.thunderstoneBoots = new ThunderstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/ThunderstoneBoots").setUnlocalizedName("Thunderstone Boots");

		Basemod.instance.sunstoneHelm = new SunstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/SunstoneHelmet").setUnlocalizedName("Sunstone Helmet");
		Basemod.instance.sunstonePlate = new SunstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/SunstonePlate").setUnlocalizedName("Sunstone ChestPlate");
		Basemod.instance.sunstoneLegs = new SunstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/SunstoneLegs").setUnlocalizedName("Sunstone Leggings");
		Basemod.instance.sunstoneBoots = new SunstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/SunstoneBoots").setUnlocalizedName("Sunstone Boots");

		Basemod.instance.moonstoneHelm = new MoonstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/MoonstoneHelmet").setUnlocalizedName("Moonstone Helmet");
		Basemod.instance.moonstonePlate = new MoonstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/MoonstonePlate").setUnlocalizedName("Moonstone ChestPlate");
		Basemod.instance.moonstoneLegs = new MoonstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/MoonstoneLegs").setUnlocalizedName("Moonstone Leggings");
		Basemod.instance.moonstoneBoots = new MoonstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/MoonstoneBoots").setUnlocalizedName("Moonstone Boots");
		
		Basemod.instance.dawnstoneHelm = new DawnstoneHelmet(Basemod.instance.ELEMENTSTONE1, 0, 0).setTextureName("pixelutilities:armor/DawnstoneHelmet").setUnlocalizedName("Dawnstone Helmet");
		Basemod.instance.dawnstonePlate = new DawnstonePlate(Basemod.instance.ELEMENTSTONE1, 0, 1).setTextureName("pixelutilities:armor/DawnstonePlate").setUnlocalizedName("Dawnstone ChestPlate");
		Basemod.instance.dawnstoneLegs = new DawnstoneLegs(Basemod.instance.ELEMENTSTONE1, 0, 2).setTextureName("pixelutilities:armor/DawnstoneLegs").setUnlocalizedName("Dawnstone Leggings");
		Basemod.instance.dawnstoneBoots = new DawnstoneBoots(Basemod.instance.ELEMENTSTONE1, 0, 3).setTextureName("pixelutilities:armor/DawnstoneBoots").setUnlocalizedName("Dawnstone Boots");
	}

	public static void addNames()
	{

		GameRegistry.registerItem(Basemod.instance.rubyHelm, Basemod.instance.rubyHelm.getUnlocalizedName());
		GameRegistry.registerItem(Basemod.instance.rubyPlate, "Ruby Chestplate");
		GameRegistry.registerItem(Basemod.instance.rubyLegs, "Ruby Leggings");
		GameRegistry.registerItem(Basemod.instance.rubyBoots, "Ruby Boots");

		GameRegistry.registerItem(Basemod.instance.saphireHelm, "Sapphire Helmet");
		GameRegistry.registerItem(Basemod.instance.saphirePlate, "Sapphire Chestplate");
		GameRegistry.registerItem(Basemod.instance.saphireLegs, "Sapphire Leggings");
		GameRegistry.registerItem(Basemod.instance.saphireBoots, "Sapphire Boots");

		GameRegistry.registerItem(Basemod.instance.galacticHelm, "Galactic Helmet");
		GameRegistry.registerItem(Basemod.instance.galacticPlate, "Galactic Chestplate");
		GameRegistry.registerItem(Basemod.instance.galacticLegs, "Galactic Leggings");
		GameRegistry.registerItem(Basemod.instance.galacticBoots, "Galactic Boots");

		GameRegistry.registerItem(Basemod.instance.rocketHelm, "Rocket Helmet");
		GameRegistry.registerItem(Basemod.instance.rocketPlate, "Rocket Chestplate");
		GameRegistry.registerItem(Basemod.instance.rocketLegs, "Rocket Leggings");
		GameRegistry.registerItem(Basemod.instance.rocketBoots, "Rocket Boots");

		GameRegistry.registerItem(Basemod.instance.firestoneHelm, "Firestone Helmet");
		GameRegistry.registerItem(Basemod.instance.firestonePlate, "Firestone Chestplate");
		GameRegistry.registerItem(Basemod.instance.firestoneLegs, "Firestone Leggings");
		GameRegistry.registerItem(Basemod.instance.firestoneBoots, "Firestone Boots");

		GameRegistry.registerItem(Basemod.instance.waterstoneHelm, "Waterstone Helmet");
		GameRegistry.registerItem(Basemod.instance.waterstonePlate, "Waterstone Chestplate");
		GameRegistry.registerItem(Basemod.instance.waterstoneLegs, "Waterstone Leggings");
		GameRegistry.registerItem(Basemod.instance.waterstoneBoots, "Waterstone Boots");

		GameRegistry.registerItem(Basemod.instance.leafstoneHelm, "Leafstone Helmet");
		GameRegistry.registerItem(Basemod.instance.leafstonePlate, "Leafstone Chestplate");
		GameRegistry.registerItem(Basemod.instance.leafstoneLegs, "Leafstone Leggings");
		GameRegistry.registerItem(Basemod.instance.leafstoneBoots, "Leafstone Boots");
		
		GameRegistry.registerItem(Basemod.instance.thunderstoneHelm, "Thunderstone Helmet");
		GameRegistry.registerItem(Basemod.instance.thunderstonePlate, "Thunderstone Chestplate");
		GameRegistry.registerItem(Basemod.instance.thunderstoneLegs, "Thunderstone Leggings");
		GameRegistry.registerItem(Basemod.instance.thunderstoneBoots, "Thunderstone Boots");
		
		GameRegistry.registerItem(Basemod.instance.sunstoneHelm, "Sunstone Helmet");
		GameRegistry.registerItem(Basemod.instance.sunstonePlate, "Sunstone Chestplate");
		GameRegistry.registerItem(Basemod.instance.sunstoneLegs, "Sunstone Leggings");
		GameRegistry.registerItem(Basemod.instance.sunstoneBoots, "Sunstone Boots");
		
		GameRegistry.registerItem(Basemod.instance.moonstoneHelm, "Moonstone Helmet");
		GameRegistry.registerItem(Basemod.instance.moonstonePlate, "Moonstone Chestplate");
		GameRegistry.registerItem(Basemod.instance.moonstoneLegs, "Moonstone Leggings");
		GameRegistry.registerItem(Basemod.instance.moonstoneBoots, "Moonstone Boots");
		
		GameRegistry.registerItem(Basemod.instance.dawnstoneHelm, "Dawnstone Helmet");
		GameRegistry.registerItem(Basemod.instance.dawnstonePlate, "Dawnstone Chestplate");
		GameRegistry.registerItem(Basemod.instance.dawnstoneLegs, "Dawnstone Leggings");
		GameRegistry.registerItem(Basemod.instance.dawnstoneBoots, "Dawnstone Boots");
		
		/*GameRegistry.registerItem(Basemod.instance.crystalHelm, "Crystal Helmet");
		GameRegistry.registerItem(Basemod.instance.crystalPlate, "Crystal Chestplate");
		GameRegistry.registerItem(Basemod.instance.crystalLegs, "Crystal Leggings");
		GameRegistry.registerItem(Basemod.instance.crystalBoots, "Crystal Boots");*/
	}
	
	public static List<Item> getArmourList() {
		return armourList;
	}

	public void setArmourList(List<Item> armourList) {
		this.armourList = armourList;
	}
}