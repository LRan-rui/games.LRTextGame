package com.data;

import com.command.quest.QuestManager;
import com.data.character.CharacterManager;
import com.data.item.ItemManager;
import com.data.item.material.MaterialManager;


import java.util.HashMap;

public class ZeroManager {
    private static final HashMap<String,Zero>  things = new HashMap<>();

    static {
        things.putAll(QuestManager.getQuest_List());

        things.putAll(CharacterManager.getCharacterMap());

        things.putAll(ItemManager.getItems());

        things.putAll(MaterialManager.getMaterial());
    }

    public static HashMap<String,Zero> getZeros() {
        return things;
    }
}
