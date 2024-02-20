package org.example.model;

import junit.framework.TestCase;
import org.example.model.itemStuff.Hammer;
import org.example.model.itemStuff.HealingItem;
import org.example.model.itemStuff.Spear;
import org.example.model.itemStuff.Sword;
import org.junit.Assert;

public class EntityTest extends TestCase {
    Barbarian barbarian = new Barbarian("barbarian");
    Wizard wizard = new Wizard("wizard");
    Paladin paladin = new Paladin("paladin");
    Goblin goblin = new Goblin("goblin");

    public void testAttack() {
        int damage = barbarian.attack(wizard);

        Assert.assertEquals(damage , wizard.getHealth());
    }

    public void testGetHealth() {
        Assert.assertEquals(65, barbarian.getHealth());
        Assert.assertEquals(30, wizard.getHealth());
        Assert.assertEquals(80, paladin.getHealth());
        Assert.assertEquals(40, goblin.getHealth());
    }

    public void testSetHealth() {
        barbarian.setHealth(50);
        wizard.setHealth(45);
        paladin.setHealth(40);
        goblin.setHealth(35);

        Assert.assertEquals(50, barbarian.getHealth());
        Assert.assertEquals(45, wizard.getHealth());
        Assert.assertEquals(40, paladin.getHealth());
        Assert.assertEquals(35, goblin.getHealth());
    }

    public void testGetSpeed() {
        Assert.assertEquals(20, barbarian.getSpeed());
        Assert.assertEquals(25, wizard.getSpeed());
        Assert.assertEquals(10, paladin.getSpeed());
        Assert.assertEquals(25, goblin.getSpeed());
    }

    public void testSetSpeed() {
        barbarian.setSpeed(50);
        wizard.setSpeed(45);
        paladin.setSpeed(40);
        goblin.setSpeed(35);

        Assert.assertEquals(50, barbarian.getSpeed());
        Assert.assertEquals(45, wizard.getSpeed());
        Assert.assertEquals(40, paladin.getSpeed());
        Assert.assertEquals(35, goblin.getSpeed());
    }

    public void testTestGetName() {
        Assert.assertEquals("barbarian", barbarian.getName());
        Assert.assertEquals("wizard", wizard.getName());
        Assert.assertEquals("paladin", paladin.getName());
        Assert.assertEquals("goblin", goblin.getName());
    }

    public void testTestSetName() {
        barbarian.setName("50");
        wizard.setName("45");
        paladin.setName("40");
        goblin.setName("35");

        Assert.assertEquals("50", barbarian.getName());
        Assert.assertEquals("45", wizard.getName());
        Assert.assertEquals("40", paladin.getName());
        Assert.assertEquals("35", goblin.getName());
    }

    public void testIsAlive() {
        wizard.setHealth(0);
        goblin.setHealth(0);

        Assert.assertTrue(barbarian.isAlive());
        Assert.assertFalse(wizard.isAlive());
        Assert.assertTrue(paladin.isAlive());
        Assert.assertFalse(goblin.isAlive());
    }

    public void testGetWeapon() {
        Assert.assertEquals("Copper sword", barbarian.getWeapon().getName());
        Assert.assertEquals("Copper sword", wizard.getWeapon().getName());
        Assert.assertEquals("Copper sword", paladin.getWeapon().getName());
        Assert.assertEquals("Copper sword", goblin.getWeapon().getName());
    }

    public void testSetWeapon() {
        barbarian.setWeapon(new Sword("sword"));
        wizard.setWeapon(new Hammer("hammer"));
        paladin.setWeapon(new Spear("spear"));
        goblin.setWeapon(new Hammer("hammer"));

        Assert.assertEquals("sword", barbarian.getWeapon().getName());
        Assert.assertEquals("hammer", wizard.getWeapon().getName());
        Assert.assertEquals("spear", paladin.getWeapon().getName());
        Assert.assertEquals("hammer", goblin.getWeapon().getName());
    }
}