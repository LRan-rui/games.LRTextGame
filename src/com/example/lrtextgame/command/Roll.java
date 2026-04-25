package com.example.lrtextgame.command;

import com.example.lrtextgame.data.Thing;
import com.example.lrtextgame.data.character.Arcana;
import com.example.lrtextgame.data.character.Character;
import com.example.lrtextgame.data.item.equipment.MinorArcana;
import com.example.lrtextgame.save.SaveData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Roll {

    public static final int PRICE = 10;
    private static final List<Thing> pool = new ArrayList<>();
    private static final List<Character> character_pool = new ArrayList<>();

    static {
        Collections.addAll(pool, MinorArcana.Wands.values());
        Collections.addAll(pool, MinorArcana.Cups.values());
        Collections.addAll(pool, MinorArcana.Swords.values());
        Collections.addAll(pool, MinorArcana.Pentacles.values());

        Collections.addAll(character_pool, Arcana.values());
    }

    public static String roll() {
        return "---------------------------\n抽卡\n单抽10%几率抽到大阿卡纳，\n十连保底一张大阿卡纳\n\n [单抽]10宝石 [十连]88宝石\n---------------------------";
    }

    public static String soloRoll() {
        long x = SaveData.getSaveData().getJewel() - PRICE;
        if (x < 0) {
            return String.format("宝石不够,还差%d个宝石", -x);
        } else {
            SaveData.getSaveData().setJewel(x);
            String str = rollOneToAllArcana().getOutPutName();
            return String.format("你抽到了\n---------------------------\n    【%s】\n---------------------------", str);
        }
    }

    public static String multiRoll() {
        long x = (long) (SaveData.getSaveData().getJewel() - PRICE * 8.8);
        if (x < 0) {
            return String.format("宝石不够,还差%d个宝石", -x);
        } else {
            SaveData.getSaveData().setJewel(x);
            String[] str = new String[10];
            Random rand = new Random();
            Thing thing = character_pool.get(rand.nextInt(character_pool.size()));
            SaveData.getSaveData().addCharacter((Character) thing);
            str[0] = thing.getOutPutName();
            for (int i = 1; i < 10; i++) {
                thing = rollOneToAllArcana();
                str[i] = thing.getOutPutName();
            }
            return String.format("你抽到了\n---------------------------\n  【%s】    【%s】\n  【%s】    【%s】\n  【%s】    【%s】\n  【%s】    【%s】\n  【%s】    【%s】\n---------------------------", str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9]);
        }
    }

    private static Thing rollOneToAllArcana() {
        Random rand = new Random();
        if (rand.nextDouble() <= 0.1) {
            Character thing = character_pool.get(rand.nextInt(character_pool.size()));
            SaveData.getSaveData().addCharacter(thing);
            return thing;
        } else {
            Thing thing = pool.get(rand.nextInt(pool.size()));
            SaveData.getSaveData().addPlayer_Bag(thing);
            return thing;
        }
    }
}
