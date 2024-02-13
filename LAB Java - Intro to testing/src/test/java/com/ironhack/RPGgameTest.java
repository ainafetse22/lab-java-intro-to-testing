package com.ironhack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RPGgameTest {

    @Test
    @DisplayName("Test Constructors and Getters")
    void testSubclassConstructorAndGetters() {
        int lives = 5;
        int strength = 10;
        int additional =4;
        // Test for Warrior
        testSubclassConstructorAndGetters(new Warrior(lives, strength,additional),lives,strength,additional);

        // Test for Elf
        testSubclassConstructorAndGetters(new Elf(lives, strength,additional),lives,strength,additional);

        // Test for Wizard
        testSubclassConstructorAndGetters(new Wizard(lives, strength,additional),lives,strength,additional);
    }

    void testSubclassConstructorAndGetters(Player player, int lives, int strength, int additional) {
        int playerHealth = player.getHealth();
        int playerStrength = player.getStrength();
        int playerLives = player.getLives();

        assertEquals(Player.ORIGINAL_HEALTH, playerHealth);
        assertEquals(strength, playerStrength);
        assertEquals(lives, playerLives);

        if (player instanceof Warrior) {
            Warrior warrior = (Warrior) player;
            assertEquals(additional, warrior.getForce());
        } else if (player instanceof Elf) {
            Elf elf = (Elf) player;
            assertEquals(additional, elf.getSpeed());
        } else if (player instanceof Wizard) {
            Wizard wizard = (Wizard) player;
            assertEquals(additional, wizard.getSpell());
        }
    }
    @Test
    @DisplayName("Test Constructors and Getters")
    void testSubclassSetters() {
        int lives = 15;
        int strength = 20;
        int health =20;
        int additional =24;
        // Test for Warrior
        testSubclassSetters(new Warrior(lives, strength,additional),lives,strength,additional,health);

        // Test for Elf
        testSubclassSetters(new Elf(lives, strength,additional),lives,strength,additional,health);

        // Test for Wizard
        testSubclassSetters(new Wizard(lives, strength,additional),lives,strength,additional,health);
    }

    void testSubclassSetters(Player player, int lives, int strength, int additional, int health) {
        player.setLives(lives);
        player.setHealth(health);
        player.setStrength(strength);

        int playerHealth = player.getHealth();
        int playerStrength = player.getStrength();
        int playerLives = player.getLives();

        assertEquals(health, playerHealth);
        assertEquals(strength, playerStrength);
        assertEquals(lives, playerLives);

        if (player instanceof Warrior) {
            Warrior warrior = (Warrior) player;
            warrior.setForce(additional);
            assertEquals(additional, warrior.getForce());
        } else if (player instanceof Elf) {
            Elf elf = (Elf) player;
            elf.setSpeed(additional);
            assertEquals(additional, elf.getSpeed());
        } else if (player instanceof Wizard) {
            Wizard wizard = (Wizard) player;
            wizard.setSpell(additional);
            assertEquals(additional, wizard.getSpell());
        }

    }


    @Test
    void testDecrementLivePlayerLive() {
        int lives = 15;
        int strength = 20;
        int health =20;
        int additional =24;
        // Test for Warrior
        testSubclassDecrementLivePlayerLive(new Warrior(lives, strength,additional),lives,strength,additional,health);

        // Test for Elf
        testSubclassDecrementLivePlayerLive(new Elf(lives, strength,additional),lives,strength,additional,health);

        // Test for Wizard
        testSubclassDecrementLivePlayerLive(new Wizard(lives, strength,additional),lives,strength,additional,health);
    }

    void testSubclassDecrementLivePlayerLive(Player player,int lives, int strength, int additional, int health ){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        player.decrementLive();
        int current_live = player.getLives();
        assertEquals(lives-1,current_live,"Lives decrements by 1");
        assertEquals("", outputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    void testDecrementLivePlayerDead() {
        int lives = 1;
        int strength = 20;
        int health =20;
        int additional =24;
        // Test for Warrior
        testSubclassDecrementLivePlayerDead(new Warrior(lives, strength,additional),lives,strength,additional,health);

        // Test for Elf
        testSubclassDecrementLivePlayerDead(new Elf(lives, strength,additional),lives,strength,additional,health);

        // Test for Wizard
        testSubclassDecrementLivePlayerDead(new Wizard(lives, strength,additional),lives,strength,additional,health);
    }

    void testSubclassDecrementLivePlayerDead(Player player,int lives, int strength, int additional, int health ){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        player.decrementLive();
        int current_live = player.getLives();
        assertTrue(outputStream.toString().contains("This character is dead"));
        System.setOut(System.out);
    }

    @Test
    void testWarriorAttackElf() {
        Warrior warrior = new Warrior( 100, 55, 3);
        Elf target_elf = new Elf( 90, 45, 3);

        playerOneAttackPlayerTwo(warrior,target_elf);
    }

    @Test
    void testElfAttackWizard() {
        Elf elf = new Elf( 100, 55, 3);
        Wizard target_wizard = new Wizard( 90, 45, 3);

        playerOneAttackPlayerTwo(elf,target_wizard);
    }

    @Test
    void testWizardAttacksWarrior(){
        // Test for Wizard attacking Warrior
        Wizard wizard = new Wizard( 100, 55, 3);
        Warrior target_warrior = new Warrior( 90, 45, 3);

        playerOneAttackPlayerTwo(wizard,target_warrior);

    }
    void playerOneAttackPlayerTwo(Player player_attack, Player player_damage) {
        int damage_health = 20;
        player_damage.setHealth(damage_health);

        int attacker_strength = player_attack.getStrength();
        int expected_health = damage_health-attacker_strength;


        player_attack.attack(player_damage);
        assertEquals(expected_health, player_damage.getHealth()); // Warrior's health should decrease by wizard's strength
    }

    @Test
    void testCheckHealth_Warrior_PlayerDead() {

        Warrior warrior = new Warrior(0, 50, 3);
        warrior.setHealth(0);

        warrior.checkHealth();

        assertEquals(-1, warrior.getLives()); // Lives should decrement by 1
        assertEquals(Player.ORIGINAL_HEALTH, warrior.getHealth()); // Health should reset to original value
    }

    @Test
    void testCheckHealth_Elf_PlayerAlive() {
        Elf elf = new Elf( 50, 50, 3);
        elf.setHealth(10);
        elf.checkHealth();

        assertEquals(50, elf.getLives());
        assertEquals(10, elf.getHealth());
    }

    @Test
    void testCheckHealth_Wizard_PlayerDead() {

        Wizard wizard = new Wizard(10, 50, 3);
        wizard.setHealth(0);

        wizard.checkHealth();

        assertEquals(9, wizard.getLives()); // Lives should decrement by 1
        assertEquals(Player.ORIGINAL_HEALTH, wizard.getHealth()); // Health should reset to original value
    }


    @Test
    void testConvertToElfFromWarrior() {
        Warrior warrior = new Warrior(100, 50, 3);
        warrior.setLives(100);

        Elf convertedElf = warrior.convertToElf();

        assertEquals(100, convertedElf.getHealth());
        assertEquals(50, convertedElf.getStrength());
        assertEquals(100, convertedElf.getLives());
        assertEquals(3, convertedElf.getSpeed());
    }

    @Test
    void testConvertToElfFromWizard() {
        Wizard wizard = new Wizard( 100, 50, 3);
        wizard.setLives(100);
        wizard.setHealth(100);

        Elf convertedElf = wizard.convertToElf();

        assertEquals(100, convertedElf.getHealth());
        assertEquals(50, convertedElf.getStrength());
        assertEquals(100, convertedElf.getLives());
        assertEquals(3, convertedElf.getSpeed());
    }

}
