package com.example.lrtextgame.command.quest;

import com.example.lrtextgame.central.Signal;

import java.util.HashMap;

/**
 * 任务管理类
 */
public class QuestManager {

    private static final HashMap<String, Quest> Quest_List = new HashMap<>();

    //初始化任务列表
    static {
        Quest_List.putAll(DayQuest.getDayQuest_List());
        Quest_List.putAll(NormalQuest.getNormalQuest_List());
    }

    /**
     * 提交任务
     * @param questID 任务ID
     * @return 提交结果
     */
    public static String achieveQuest(String questID) {
        Quest quest = Quest_List.get(questID);
        if (quest != null) {
            return quest.achieve();
        }
        return Signal.QUEST_NOT_FOUND.getSignal();
    }

    /**
     * 获取任务列表
     * @return 任务列表
     */
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
