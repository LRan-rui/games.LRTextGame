package com.command;

import com.central.Signal;
import com.data.character.Arcana;
import com.save.SaveData;

import java.util.HashMap;

public class PlayerCharacterManager {

    private static final HashMap<String, Arcana> CHARACTERS = new HashMap<>();

    static {
        for (Arcana character : Arcana.values()) {
            CHARACTERS.put(character.getNameID(), character);
        }
    }

    public static Arcana getCharacter(String nameID) {
        return CHARACTERS.get(nameID) == null ? null : CHARACTERS.get(nameID);
    }

    public static String setCharacter(String characterNameID) {
        SaveData saveData = SaveData.getSaveData();

        if (saveData.getCharacter_Bag().get(characterNameID) == null) {
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        saveData.setPlayerCharacter(getCharacter(characterNameID));
        return String.format("成功设置角色【%s☆%d】", characterNameID, saveData.getCharacter_Bag().get(characterNameID));
    }
}
