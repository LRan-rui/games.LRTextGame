package com.data;

import com.command.quest.DayQuest;
import com.command.quest.NormalQuest;
import com.data.character.CharacterManager;
import com.data.equipment.AllEquipment;
import com.data.item.material.Ore;

import java.util.HashMap;

public class ZeroManager {
    private static final HashMap<String,Zero>  things = new HashMap<>();

    static {
        things.putAll(NormalQuest.getNormalQuest_List());
        things.putAll(DayQuest.getDayQuest_List());

        things.putAll(CharacterManager.getCharacterMap());

        things.putAll(AllEquipment.getEQUIPMENT());

        things.putAll(Ore.getMap());
    }

    public static HashMap<String,Zero> getZeros() {
        return things;
    }
}
