package org.example.model.itemStuff;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest extends TestCase {
    Item hammer = new Hammer("hammer");
    Item sword = new Sword("sword");
    Item spear = new Spear("spear");

    public void testUse() {
        hammer.use();
        sword.use();
        spear.use();

        Assert.assertEquals(14, hammer.getDurability());
        Assert.assertEquals(9, sword.getDurability());
        Assert.assertEquals(7, spear.getDurability());
    }

    public void testTestGetName() {
        Assert.assertEquals("hammer", hammer.getName());
        Assert.assertEquals("sword", sword.getName());
        Assert.assertEquals("spear", spear.getName());
    }

    public void testTestSetName() {
        hammer.setName("hammerrename");
        sword.setName("swordrename");
        spear.setName("spearrename");

        Assert.assertEquals("hammerrename", hammer.getName());
        Assert.assertEquals("swordrename", sword.getName());
        Assert.assertEquals("spearrename", spear.getName());
    }

    public void testGetDurability() {
        Assert.assertEquals(15, hammer.getDurability());
        Assert.assertEquals(10, sword.getDurability());
        Assert.assertEquals(8, spear.getDurability());
    }

    public void testSetDurability() {
        hammer.setDurability(1);
        sword.setDurability(8);
        spear.setDurability(3);

        Assert.assertEquals(14, hammer.getDurability());
        Assert.assertEquals(2, sword.getDurability());
        Assert.assertEquals(5, spear.getDurability());
    }
}