package com.example.lrtextgame.data.character;

import java.util.HashMap;

/**
 * 角色管理
 * @author 凌然
 */
public class CharacterManager {
    private static final HashMap<String, Character> characterMap = new HashMap<>();

    //初始化角色列表
    static {
        for (Character character : Arcana.values()){
            characterMap.put(character.getNameID(),character);
        }
    }

    public static HashMap<String, Character> getCharacterMap(){
        return characterMap;
    }
}
