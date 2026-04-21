package com.command.fight;

public class FightCharacter {
    private final int physical;
    private final int magic;
    private final int physical_resistance;
    private final int magic_resistance;
    private final int health;
    private final int attack;
    private final int magic_attack;

    private final SkillGroup skillGroup;

    public FightCharacter(int physical,int magic,int physical_resistance,int magic_resistance,int health,int attack,int magic_attack,SkillGroup skillGroup){
        this.physical = physical;
        this.magic = magic;
        this.physical_resistance = physical_resistance;
        this.magic_resistance = magic_resistance;
        this.health = health;
        this.attack = attack;
        this.magic_attack = magic_attack;
        this.skillGroup = skillGroup;
    }

    public FightCharacter(int physical,int magic,int physical_resistance,int magic_resistance,int health,int attack,int magic_attack){
        this(physical,magic,physical_resistance,magic_resistance,health,attack,magic_attack,new SkillGroup());
    }

    public FightCharacter(int[] stat){
        this(stat[0],stat[1],stat[2],stat[3],stat[4],stat[5],stat[6],new SkillGroup());
    }

}
