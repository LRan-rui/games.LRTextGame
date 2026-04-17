package com.command.quest;

import com.central.Signal;
import com.data.item.material.Ore;

import java.util.HashMap;

public class NormalQuest {
    private static final HashMap<String, Quest> NormalQuest_List = new HashMap<>();

    static {
        for (Quest quest : QuestList.values()) {
            NormalQuest_List.put(quest.getNameID(), quest);
        }
    }

    public static HashMap<String, Quest> getNormalQuest_List() {
        return NormalQuest_List;
    }

    enum QuestList implements Quest {
        FIX_WALL("修补城墙", "", new ThingGroup(Ore.D.LIMESTONE, 10), new RewardGroup(10, 1, 5)),
        BUILD_WALL("修建城墙", "", new ThingGroup(Ore.C.MARBLE, 5), new RewardGroup(50, 2, 10)),
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
            return this.information;
        }

        @Override
        public String achieve() {
            if (this.needThings.turnInThings().equals(Signal.RIGHT.getSignal())) {
                this.rewards.getRewards();
                return String.format("完成任务【%s】获得奖励:\n%s", this.getNameID(), this.rewards.formatString());
            }
            return Signal.THING_NOT_ENOUGH.getSignal();
        }
    }
}
