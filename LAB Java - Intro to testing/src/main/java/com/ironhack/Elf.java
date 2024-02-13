package com.ironhack;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Elf extends Player{
     private int speed;

    public Elf(int lives, int strength, int speed) {
        super(lives, strength);
        setSpeed(speed);
    }
}
