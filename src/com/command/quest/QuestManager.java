package com.command.quest;

import com.central.Signal;

import java.util.HashMap;

public class QuestManager {

    private static final HashMap<String, Quest> Quest_List = new HashMap<>();

    static {
        Quest_List.putAll(DayQuest.getDayQuest_List());
        Quest_List.putAll(NormalQuest.getNormalQuest_List());
    }

    public static String achieveQuest(String questID) {
        Quest quest = Quest_List.get(questID);
        if (quest != null) {
            return quest.achieve();
        }
        return Signal.QUEST_NOT_FOUND.getSignal();
    }
}
