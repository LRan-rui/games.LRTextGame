package com.command.quest;

import com.central.Signal;
import com.save.SaveData;

import java.time.LocalDate;
import java.util.HashMap;

public class DayQuest {

    private static final HashMap<String, Quest> DayQuest_List = new HashMap<>();

    static {
        for (Quest quest : QuestList.values()) {
            DayQuest_List.put(quest.getNameID(), quest);
        }
    }

    public static HashMap<String, Quest> getDayQuest_List() {
        return DayQuest_List;
    }

    private enum QuestList implements Quest {
        EVERYDAY_QUEST("每日补给", "每日签到任务", new ThingGroup(), new RewardGroup(200, 20, 0)),
        ;

        private final String nameID;
        private final String information;
        private final ThingGroup needThings;
        private final RewardGroup rewards;

        QuestList(String nameID, String information, ThingGroup needThings, RewardGroup rewards) {
            this.nameID = nameID;
            this.information = information;
            this.needThings = needThings;
            this.rewards = rewards;
        }

        @Override
        public String getNameID() {
            return this.nameID;
        }

        @Override
        public String getInformation() {
            return "%s\n%s\n任务要求:\n%s任务奖励:\n%s".formatted(this.nameID, this.information, this.needThings.formatString(), this.rewards.formatString());
        }

        @Override
        public String getQuestStat(){
            return "每日任务";
        }

        @Override
        public String achieve() {
            if (SaveData.getSaveData().getDayQuest_Last_Time().get(this.nameID) != null && SaveData.getSaveData().getDayQuest_Last_Time().get(this.nameID).equals(LocalDate.now().toString())) {
                return Signal.DAY_QUEST_ACHIEVED.getSignal();
            }
            if (this.needThings.turnInThings().equals(Signal.RIGHT.getSignal())) {
                this.rewards.getRewards();
                SaveData.getSaveData().getDayQuest_Last_Time().put(this.nameID, LocalDate.now().toString());
                return String.format("完成任务【%s】获得奖励:\n%s", this.getNameID(), this.rewards.formatString());
            }
            return Signal.THING_NOT_ENOUGH.getSignal();
        }
    }
}
