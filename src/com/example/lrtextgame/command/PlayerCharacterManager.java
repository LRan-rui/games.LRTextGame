package com.example.lrtextgame.command;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.data.character.Arcana;
import com.example.lrtextgame.save.SaveData;

import java.util.HashMap;

/**
 * 提供玩家角色管理相关方法
 * @author 凌然
 */
public class PlayerCharacterManager {

    private static final HashMap<String, Arcana> CHARACTERS = new HashMap<>();

    //初始化角色列表
    static {
        for (Arcana character : Arcana.values()) {
            CHARACTERS.put(character.getNameID(), character);
        }
    }

    /**
     * 获取角色对象
     * @param nameID 角色ID
     * @return 角色对象
     */
    public static Arcana getCharacter(String nameID) {
        return CHARACTERS.get(nameID) == null ? null : CHARACTERS.get(nameID);
    }

    /**
     * 设置玩家角色
     * @param characterNameID 角色ID
     * @return 设置结果
     */
    public static String setCharacter(String characterNameID) {
        SaveData saveData = SaveData.getSaveData();

        if (saveData.getCharacter_Bag().get(characterNameID) == null) {
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        saveData.setPlayerCharacter(getCharacter(characterNameID));
        return String.format("成功设置角色【%s☆%d】", characterNameID, saveData.getCharacter_Bag().get(characterNameID));
    }
}
