package com.example.lrtextgame.data.character;

import java.util.HashMap;

public class CharacterManager {
    private static final HashMap<String, Character> characterMap = new HashMap<>();

    static {
        for (Character character : Arcana.values()){
            characterMap.put(character.getNameID(),character);
        }
    }

    public static HashMap<String, Character> getCharacterMap(){
        return characterMap;
    }
}
