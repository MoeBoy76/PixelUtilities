package com.pixelutilities.config;

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

		Basemod.instance.crystalHelm = new CrystalHelmet(Basemod.instance.CRYSTALA, 0, 0);
		Basemod.instance.crystalPlate = new CrystalPlate(Basemod.instance.CRYSTALA, 0, 1);
		Basemod.instance.crystalLegs = new CrystalLegs(Basemod.instance.CRYSTALA, 0, 2);
		Basemod.instance.crystalBoots = new CrystalBoots(Basemod.instance.CRYSTALA, 0, 3);

		Basemod.instance.rocketHelm = new RocketHelmet(Basemod.instance.CRYSTALA, 0, 0);
		Basemod.instance.rocketPlate = new RocketPlate(Basemod.instance.CRYSTALA, 0, 1);
		Basemod.instance.rocketLegs = new RocketLegs(Basemod.instance.CRYSTALA, 0, 2);
		Basemod.instance.rocketBoots = new RocketBoots(Basemod.instance.CRYSTALA, 0, 3);
		/*
		Basemod.instance.firestoneHelm = new FireStoneHelmet(firestoneHelmID, Basemod.instance.FIRESTONEA, 0, 0).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:FireStoneHelmet").setUnlocalizedName("Firestone Helmet");
		Basemod.instance.firestonePlate = new FireStonePlate(firestonePlateID, Basemod.instance.FIRESTONEA, 0, 1).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:FireStonePlate").setUnlocalizedName("Firestone Chestlate");
		Basemod.instance.firestoneLegs = new FireStoneLegs(firestoneLegsID, Basemod.instance.FIRESTONEA, 0, 2).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:FireStoneLegs").setUnlocalizedName("Firestone Leggings");
		Basemod.instance.firestoneBoots = new FireStoneBoots(firestoneBootsID, Basemod.instance.FIRESTONEA, 0, 3).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:FireStoneBoots").setUnlocalizedName("Firestone Boots");

		Basemod.instance.waterstoneHelm = new WaterStoneHelmet(waterstoneHelmID, Basemod.instance.WATERSTONEA, 0, 0).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:WaterStoneHelmet").setUnlocalizedName("Waterstone Helmet");
		Basemod.instance.waterstonePlate = new WaterStonePlate(waterstonePlateID, Basemod.instance.WATERSTONEA, 0, 1).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:WaterStonePlate").setUnlocalizedName("Waterstone Chestlate");
		Basemod.instance.waterstoneLegs = new WaterStoneLegs(waterstoneLegsID, Basemod.instance.WATERSTONEA, 0, 2).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:WaterStoneLegs").setUnlocalizedName("Waterstone Leggings");
		Basemod.instance.waterstoneBoots = new WaterStoneBoots(waterstoneBootsID, Basemod.instance.WATERSTONEA, 0, 3).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:WaterStoneBoots").setUnlocalizedName("Waterstone Boots");

		Basemod.instance.leafstoneHelm = new LeafStoneHelmet(leafstoneHelmID, Basemod.instance.LEAFSTONEA, 0, 0).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:LeafStoneHelmet").setUnlocalizedName("Leafstone Helmet");
		Basemod.instance.leafstonePlate = new LeafStonePlate(leafstonePlateID, Basemod.instance.LEAFSTONEA, 0, 1).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:LeafStonePlate").setUnlocalizedName("Leafstone Chestlate");
		Basemod.instance.leafstoneLegs = new LeafStoneLegs(leafstoneLegsID, Basemod.instance.LEAFSTONEA, 0, 2).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:LeafStoneLegs").setUnlocalizedName("Leafstone Leggings");
		Basemod.instance.leafstoneBoots = new LeafStoneBoots(leafstoneBootsID, Basemod.instance.LEAFSTONEA, 0, 3).setCreativeTab(CreativeTabs.tabCombat).setTextureName("pixelUtilities:LeafStoneBoots").setUnlocalizedName("Leafstone Boots");
		 */
	}

	public static void addNames()
	{

		GameRegistry.registerItem(Basemod.instance.rubyHelm, Basemod.instance.rubyHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rubyPlate, Basemod.instance.rubyPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rubyLegs, Basemod.instance.rubyLegs.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rubyBoots, Basemod.instance.rubyBoots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(Basemod.instance.saphireHelm, Basemod.instance.saphireHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.saphirePlate, Basemod.instance.saphirePlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.saphireLegs, Basemod.instance.saphireLegs.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.saphireBoots, Basemod.instance.saphireBoots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(Basemod.instance.galacticHelm, Basemod.instance.galacticHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.galacticPlate, Basemod.instance.galacticPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.galacticLegs, Basemod.instance.galacticLegs.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.galacticBoots, Basemod.instance.galacticBoots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(Basemod.instance.rocketHelm, Basemod.instance.rocketHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rocketPlate, Basemod.instance.rocketPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rocketLegs, Basemod.instance.rocketLegs.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Basemod.instance.rocketBoots, Basemod.instance.rocketBoots.getUnlocalizedName().substring(5));

		/*GameRegistry.registerItem(Basemod.instance.firestoneHelm, "Firestone Helmet");
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
		GameRegistry.registerItem(Basemod.instance.leafstoneBoots, "Leafstone Boots");*/
	}
}