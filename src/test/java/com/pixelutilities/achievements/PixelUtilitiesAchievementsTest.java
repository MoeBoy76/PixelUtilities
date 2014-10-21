package com.pixelutilities.achievements;

import com.pixelutilities.Basemod;
import com.pixelutilities.items.armor.RubyHelmet;
import com.pixelutilities.items.armor.SaphirePlate;
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
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(net.minecraft.entity.player.EntityPlayer, net.minecraft.item.ItemStack, net.minecraft.inventory.IInventory)}
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
        //Act
        pixelUtilitiesAchievements.onCrafting(player,itemStack,craftMatrix);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teammagma,1);

    }

    /**
     * Test for {@link com.pixelutilities.achievements.PixelUtilitiesAchievements#onCrafting(net.minecraft.entity.player.EntityPlayer, net.minecraft.item.ItemStack, net.minecraft.inventory.IInventory)}
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
        //Act
        pixelUtilitiesAchievements.onCrafting(player,itemStack,craftMatrix);
        //Assert
        verify(player).addStat(PixelUtilitiesAchievements.teamaqua,1);

    }

}
