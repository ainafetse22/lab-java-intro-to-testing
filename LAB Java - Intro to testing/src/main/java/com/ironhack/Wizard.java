package com.ironhack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Wizard extends Player{

    private int spell;
    public Wizard(int lives,int strength,int spell){
        super(lives,strength);
        setSpell(spell);
    }
    public Elf convertToElf(){
        Elf elfo = new Elf(getLives(),getStrength(),getSpell());
        elfo.setHealth(getHealth());
        return  elfo;

    }
}
