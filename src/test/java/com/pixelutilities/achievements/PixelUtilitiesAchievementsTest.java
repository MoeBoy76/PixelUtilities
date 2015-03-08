package com.pixelutilities.achievements;

import com.pixelutilities.Basemod;
import com.pixelutilities.items.armor.*;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Unit Test for the {@link com.pixelutilities.achievements.PixelUtilitiesAchievements}
 * Created by forsterth on 21/10/2014.
 */
public class PixelUtilitiesAchievementsTest {

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingRubyHelmet()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new RubyHelmet(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teammagma,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingRubyBoots()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new RubyBoots(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teammagma1,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingRubyPlate()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new RubyPlate(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teammagma3,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingRubyLegs()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new RubyLegs(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teammagma2,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingSaphireHelmet()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new SaphireHelmet(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teamaqua,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingSaphireBoots()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new SaphireBoots(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teamaqua1,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingSaphirePlate()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new SaphirePlate(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teamaqua3,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingSaphireLegs()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new SaphireLegs(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teamaqua2,1);

    }
    
    
    
    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent)}
     */
    @Test
    public void testOnCraftingSapphirePlate()
    {
        //Assign
        Basemod basemod = new Basemod();
        Basemod.instance = basemod;
        PixelUtilitiesAchievements pixelUtilitiesAchievements = new PixelUtilitiesAchievements();
        EntityPlayer player = mock(EntityPlayer.class);
        ItemStack itemStack = new ItemStack(new SaphirePlate(ItemArmor.ArmorMaterial.DIAMOND,1,1));
        IInventory craftMatrix = mock(IInventory.class);
        PlayerEvent.ItemCraftedEvent itemCraftedEvent = new PlayerEvent.ItemCraftedEvent(player,itemStack,craftMatrix);
        //Act
        pixelUtilitiesAchievements.onCrafting(itemCraftedEvent);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teamaqua3,1);

    }

}
