package com.ironhack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

abstract class Player {
    @Getter @Setter private int health;
    @Getter @Setter private int Strength;
    @Getter @Setter private int lives;
    public static final int ORIGINAL_HEALTH = 5;

    public Player(int lives, int strength) {
        setHealth(ORIGINAL_HEALTH);
        setStrength(strength);
        setLives(lives);
    }

    public void decrementLive(){
        setLives( getLives() - 1);
        setHealth(ORIGINAL_HEALTH);
        if(getLives() <=0){
            System.out.println("This character is dead");
        }

    }
    public void attack (Player playerToAttack){
        int player_health = playerToAttack.getHealth();
        playerToAttack.setHealth(player_health-getStrength());

    }

    public void checkHealth(){
        if (getHealth()<=0){
            this.decrementLive();
        }
    }


}
