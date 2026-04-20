package com.data;

import com.data.character.CharacterManager;
import com.data.item.ItemManager;
import com.data.item.material.MaterialManager;

import java.util.HashMap;

public class ThingManager {
    private static final HashMap<String,Thing> things = new HashMap<>();

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
