package com.data;

import com.command.quest.QuestManager;

import java.util.HashMap;

public class ZeroManager {
    private static final HashMap<String,Zero>  things = new HashMap<>();

    static {
        things.putAll(QuestManager.getQuest_List());

        things.putAll(ThingManager.getThings());
    }

    public static HashMap<String,Zero> getZeros() {
        return things;
    }
}
