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

    public static String getQuestList(){
        StringBuilder rtn = new StringBuilder();
        for (String questName : Quest_List.keySet()) {
            rtn.append("[").append(Quest_List.get(questName).getQuestStat()).append("]").append(questName).append("\n");
        }
        return rtn.toString();
    }

    public static HashMap<String,Quest> getQuest_List(){
        return Quest_List;
    }
}
