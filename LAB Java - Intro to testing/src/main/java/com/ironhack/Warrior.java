package com.ironhack;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Warrior extends Player{
    private int force;

    public Warrior(int live,int strength,int force){
        super(live,strength);
        setForce(force);
    }
    public Elf convertToElf(){
        Elf elfo = new Elf(getLives(),getStrength(),getForce());
        elfo.setHealth(getHealth());
        return  elfo;

    }
}
