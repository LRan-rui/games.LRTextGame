package com.example.lrtextgame.data;

import com.example.lrtextgame.command.quest.QuestManager;

import java.util.HashMap;

/**
 * 元管理
 * @author 凌然
 */
public class ZeroManager {
    private static final HashMap<String,Zero>  things = new HashMap<>();

    //初始化列表
    static {
        things.putAll(QuestManager.getQuest_List());

        things.putAll(ThingManager.getThings());
    }

    public static HashMap<String,Zero> getZeros() {
        return things;
    }
}
