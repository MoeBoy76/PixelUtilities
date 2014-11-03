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

		Basemod.instance.crystalHelm = new CrystalHelmet(Basemod.instance.CRYSTALA, 0, 0, true).setTextureName("pixelUtilities:armor/PlasmaHelmet").setUnlocalizedName("Plasma_Helmet");
		Basemod.instance.crystalPlate = new CrystalPlate(Basemod.instance.CRYSTALA, 0, 1, true).setTextureName("pixelUtilities:armor/PlasmaPlate").setUnlocalizedName("Plasma_ChestPlate");
		Basemod.instance.crystalLegs = new CrystalLegs(Basemod.instance.CRYSTALA, 0, 2, true).setTextureName("pixelUtilities:armor/PlasmaLegs").setUnlocalizedName("Plasma_Leggings");
		Basemod.instance.crystalBoots = new CrystalBoots(Basemod.instance.CRYSTALA, 0, 3, true).setTextureName("pixelUtilities:armor/PlasmaBoots").setUnlocalizedName("Plasma_Boots");
		
		Basemod.instance.neoHelm = new CrystalHelmet(Basemod.instance.CRYSTALA, 0, 0, false).setTextureName("pixelutilities:armor/NeoPlasmaHelmet").setUnlocalizedName("Neo_Plasma_Helmet");
		Basemod.instance.neoPlate = new CrystalPlate(Basemod.instance.CRYSTALA, 0, 1, false).setTextureName("pixelUtilities:armor/NeoPlasmaPlate").setUnlocalizedName("Neo_Plasma_Chestplate");
		Basemod.instance.neoLegs = new CrystalLegs(Basemod.instance.CRYSTALA, 0, 2, false).setTextureName("pixelUtilities:armor/NeoPlasmaLegs").setUnlocalizedName("Neo_Plasma_Leggings");
		Basemod.instance.neoBoots = new CrystalBoots(Basemod.instance.CRYSTALA, 0, 3, false).setTextureName("pixelUtilities:armor/NeoPlasmaBoots").setUnlocalizedName("Neo_Plasma_Boots");
		
		Basemod.instance.rocketHelm = new RocketHelmet(Basemod.instance.AMETHYSTA, 0, 0);
		Basemod.instance.rocketPlate = new RocketPlate(Basemod.instance.AMETHYSTA, 0, 1);
		Basemod.instance.rocketLegs = new RocketLegs(Basemod.instance.AMETHYSTA, 0, 2);
		Basemod.instance.rocketBoots = new RocketBoots(Basemod.instance.AMETHYSTA, 0, 3);

		Basemod.instance.firestoneHelm = new FirestoneHelmet(Basemod.instance.ELEMENTSTONE1, 0, 0).setTextureName("pixelUtilities:armor/FirestoneHelmet").setUnlocalizedName("Firestone_Helmet");
		Basemod.instance.firestonePlate = new FirestonePlate(Basemod.instance.ELEMENTSTONE1, 0, 1).setTextureName("pixelUtilities:armor/FirestonePlate").setUnlocalizedName("Firestone_ChestPlate");
		Basemod.instance.firestoneLegs = new FirestoneLegs(Basemod.instance.ELEMENTSTONE1, 0, 2).setTextureName("pixelUtilities:armor/FirestoneLegs").setUnlocalizedName("Firestone_Leggings");
		Basemod.instance.firestoneBoots = new FirestoneBoots(Basemod.instance.ELEMENTSTONE1, 0, 3).setTextureName("pixelUtilities:armor/FirestoneBoots").setUnlocalizedName("Firestone_Boots");

		Basemod.instance.waterstoneHelm = new WaterstoneHelmet(Basemod.instance.ELEMENTSTONE1, 0, 0).setTextureName("pixelutilities:armor/WaterstoneHelmet").setUnlocalizedName("Waterstone_Helmet");
		Basemod.instance.waterstonePlate = new WaterstonePlate(Basemod.instance.ELEMENTSTONE1, 0, 1).setTextureName("pixelutilities:armor/WaterstonePlate").setUnlocalizedName("Waterstone_ChestPlate");
		Basemod.instance.waterstoneLegs = new WaterstoneLegs(Basemod.instance.ELEMENTSTONE1, 0, 2).setTextureName("pixelutilities:armor/WaterstoneLegs").setUnlocalizedName("Waterstone_Leggings");
		Basemod.instance.waterstoneBoots = new WaterstoneBoots(Basemod.instance.ELEMENTSTONE1, 0, 3).setTextureName("pixelutilities:armor/WaterstoneBoots").setUnlocalizedName("Waterstone_Boots");

		Basemod.instance.leafstoneHelm = new LeafstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/LeafstoneHelmet").setUnlocalizedName("Leafstone_Helmet");
		Basemod.instance.leafstonePlate = new LeafstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/LeafstonePlate").setUnlocalizedName("Leafstone_ChestPlate");
		Basemod.instance.leafstoneLegs = new LeafstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/LeafstoneLegs").setUnlocalizedName("Leafstone_Leggings");
		Basemod.instance.leafstoneBoots = new LeafstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/LeafstoneBoots").setUnlocalizedName("Leafstone_Boots");
		
		Basemod.instance.thunderstoneHelm = new ThunderstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/ThunderstoneHelmet").setUnlocalizedName("Thunderstone_Helmet");
		Basemod.instance.thunderstonePlate = new ThunderstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/ThunderstonePlate").setUnlocalizedName("Thunderstone_ChestPlate");
		Basemod.instance.thunderstoneLegs = new ThunderstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/ThunderstoneLegs").setUnlocalizedName("Thunderstone_Leggings");
		Basemod.instance.thunderstoneBoots = new ThunderstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/ThunderstoneBoots").setUnlocalizedName("Thunderstone_Boots");

		Basemod.instance.sunstoneHelm = new SunstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/SunstoneHelmet").setUnlocalizedName("Sunstone_Helmet");
		Basemod.instance.sunstonePlate = new SunstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/SunstonePlate").setUnlocalizedName("Sunstone_ChestPlate");
		Basemod.instance.sunstoneLegs = new SunstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/SunstoneLegs").setUnlocalizedName("Sunstone_Leggings");
		Basemod.instance.sunstoneBoots = new SunstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/SunstoneBoots").setUnlocalizedName("Sunstone_Boots");

		Basemod.instance.moonstoneHelm = new MoonstoneHelmet(Basemod.instance.ELEMENTSTONE2, 0, 0).setTextureName("pixelutilities:armor/MoonstoneHelmet").setUnlocalizedName("Moonstone_Helmet");
		Basemod.instance.moonstonePlate = new MoonstonePlate(Basemod.instance.ELEMENTSTONE2, 0, 1).setTextureName("pixelutilities:armor/MoonstonePlate").setUnlocalizedName("Moonstone_ChestPlate");
		Basemod.instance.moonstoneLegs = new MoonstoneLegs(Basemod.instance.ELEMENTSTONE2, 0, 2).setTextureName("pixelutilities:armor/MoonstoneLegs").setUnlocalizedName("Moonstone_Leggings");
		Basemod.instance.moonstoneBoots = new MoonstoneBoots(Basemod.instance.ELEMENTSTONE2, 0, 3).setTextureName("pixelutilities:armor/MoonstoneBoots").setUnlocalizedName("Moonstone_Boots");
		
		Basemod.instance.dawnstoneHelm = new DawnstoneHelmet(Basemod.instance.ELEMENTSTONE1, 0, 0).setTextureName("pixelutilities:armor/DawnstoneHelmet").setUnlocalizedName("Dawnstone_Helmet");
		Basemod.instance.dawnstonePlate = new DawnstonePlate(Basemod.instance.ELEMENTSTONE1, 0, 1).setTextureName("pixelutilities:armor/DawnstonePlate").setUnlocalizedName("Dawnstone_ChestPlate");
		Basemod.instance.dawnstoneLegs = new DawnstoneLegs(Basemod.instance.ELEMENTSTONE1, 0, 2).setTextureName("pixelutilities:armor/DawnstoneLegs").setUnlocalizedName("Dawnstone_Leggings");
		Basemod.instance.dawnstoneBoots = new DawnstoneBoots(Basemod.instance.ELEMENTSTONE1, 0, 3).setTextureName("pixelutilities:armor/DawnstoneBoots").setUnlocalizedName("Dawnstone_Boots");
	}

	public static void addNames()
	{

		GameRegistry.registerItem(Basemod.instance.rubyHelm, Basemod.instance.rubyHelm.getUnlocalizedName());
		GameRegistry.registerItem(Basemod.instance.rubyPlate, "Ruby_Chestplate");
		GameRegistry.registerItem(Basemod.instance.rubyLegs, "Ruby_Leggings");
		GameRegistry.registerItem(Basemod.instance.rubyBoots, "Ruby_Boots");

		GameRegistry.registerItem(Basemod.instance.saphireHelm, "Sapphire_Helmet");
		GameRegistry.registerItem(Basemod.instance.saphirePlate, "Sapphire_Chestplate");
		GameRegistry.registerItem(Basemod.instance.saphireLegs, "Sapphire_Leggings");
		GameRegistry.registerItem(Basemod.instance.saphireBoots, "Sapphire_Boots");

		GameRegistry.registerItem(Basemod.instance.galacticHelm, "Galactic_Helmet");
		GameRegistry.registerItem(Basemod.instance.galacticPlate, "Galactic_Chestplate");
		GameRegistry.registerItem(Basemod.instance.galacticLegs, "Galactic_Leggings");
		GameRegistry.registerItem(Basemod.instance.galacticBoots, "Galactic_Boots");

		GameRegistry.registerItem(Basemod.instance.rocketHelm, "Rocket_Helmet");
		GameRegistry.registerItem(Basemod.instance.rocketPlate, "Rocket_Chestplate");
		GameRegistry.registerItem(Basemod.instance.rocketLegs, "Rocket_Leggings");
		GameRegistry.registerItem(Basemod.instance.rocketBoots, "Rocket_Boots");

		GameRegistry.registerItem(Basemod.instance.firestoneHelm, "Firestone_Helmet");
		GameRegistry.registerItem(Basemod.instance.firestonePlate, "Firestone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.firestoneLegs, "Firestone_Leggings");
		GameRegistry.registerItem(Basemod.instance.firestoneBoots, "Firestone_Boots");

		GameRegistry.registerItem(Basemod.instance.waterstoneHelm, "Waterstone_Helmet");
		GameRegistry.registerItem(Basemod.instance.waterstonePlate, "Waterstone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.waterstoneLegs, "Waterstone_Leggings");
		GameRegistry.registerItem(Basemod.instance.waterstoneBoots, "Waterstone_Boots");

		GameRegistry.registerItem(Basemod.instance.leafstoneHelm, "Leafstone_Helmet");
		GameRegistry.registerItem(Basemod.instance.leafstonePlate, "Leafstone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.leafstoneLegs, "Leafstone_Leggings");
		GameRegistry.registerItem(Basemod.instance.leafstoneBoots, "Leafstone_Boots");
		
		GameRegistry.registerItem(Basemod.instance.thunderstoneHelm, "Thunderstone_Helmet");
		GameRegistry.registerItem(Basemod.instance.thunderstonePlate, "Thunderstone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.thunderstoneLegs, "Thunderstone_Leggings");
		GameRegistry.registerItem(Basemod.instance.thunderstoneBoots, "Thunderstone_Boots");
		
		GameRegistry.registerItem(Basemod.instance.sunstoneHelm, "Sunstone_Helmet");
		GameRegistry.registerItem(Basemod.instance.sunstonePlate, "Sunstone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.sunstoneLegs, "Sunstone_Leggings");
		GameRegistry.registerItem(Basemod.instance.sunstoneBoots, "Sunstone_Boots");
		
		GameRegistry.registerItem(Basemod.instance.moonstoneHelm, "Moonstone_Helmet");
		GameRegistry.registerItem(Basemod.instance.moonstonePlate, "Moonstone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.moonstoneLegs, "Moonstone_Leggings");
		GameRegistry.registerItem(Basemod.instance.moonstoneBoots, "Moonstone_Boots");
		
		GameRegistry.registerItem(Basemod.instance.dawnstoneHelm, "Dawnstone_Helmet");
		GameRegistry.registerItem(Basemod.instance.dawnstonePlate, "Dawnstone_Chestplate");
		GameRegistry.registerItem(Basemod.instance.dawnstoneLegs, "Dawnstone_Leggings");
		GameRegistry.registerItem(Basemod.instance.dawnstoneBoots, "Dawnstone_Boots");
		
		GameRegistry.registerItem(Basemod.instance.crystalHelm, "Plasma_Helmet");
		GameRegistry.registerItem(Basemod.instance.crystalPlate, "Plasma_Chestplate");
		GameRegistry.registerItem(Basemod.instance.crystalLegs, "Plasma_Leggings");
		GameRegistry.registerItem(Basemod.instance.crystalBoots, "Plasma_Boots");
		
		GameRegistry.registerItem(Basemod.instance.neoHelm, "Neo_Plasma_Helmet");
		GameRegistry.registerItem(Basemod.instance.neoPlate, "Neo_Plasma_Chestplate");
		GameRegistry.registerItem(Basemod.instance.neoLegs, "Neo_Plasma_Leggings");
		GameRegistry.registerItem(Basemod.instance.neoBoots, "Neo_Plasma_Boots");
	}
	
	public static List<Item> getArmourList() {
		return armourList;
	}

	public void setArmourList(List<Item> armourList) {
		this.armourList = armourList;
	}
}