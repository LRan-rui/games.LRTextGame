package com.example.lrtextgame.data;

import com.example.lrtextgame.data.character.CharacterManager;
import com.example.lrtextgame.data.item.ItemManager;
import com.example.lrtextgame.data.item.material.MaterialManager;

import java.util.HashMap;

/**
 * 东西管理
 * @author 凌然
 */
public class ThingManager {
    private static final HashMap<String,Thing> things = new HashMap<>();

    //初始化列表
    static {
        things.putAll(CharacterManager.getCharacterMap());

        things.putAll(ItemManager.getItems());

        things.putAll(MaterialManager.getMaterial());
    }

    public static HashMap<String,Thing> getThings() {
        return things;
    }

    public static Thing findThing(String thingName){
        return things.get(thingName);
    }
}
