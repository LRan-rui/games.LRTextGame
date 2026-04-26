package com.example.lrtextgame.command.quest;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.data.item.material.OreGroup;

import java.util.HashMap;

/**
 * 日常任务
 * <p>允许一直提交
 * @author 凌然
 */
public class NormalQuest {
    private static final HashMap<String, Quest> NormalQuest_List = new HashMap<>();

    //初始化任务列表
    static {
        for (Quest quest : QuestList.values()) {
            NormalQuest_List.put(quest.getNameID(), quest);
        }
    }

    public static HashMap<String, Quest> getNormalQuest_List() {
        return NormalQuest_List;
    }

    /**
     * 日常任务枚举
     * @author 凌然
     */
    enum QuestList implements Quest {
        FIX_WALL("修补城墙", "为城墙修补工程提供材料", new ThingGroup(OreGroup.D.LIMESTONE, 10), new RewardGroup(10, 1, 5)),
        BUILD_WALL("修建城墙", "为城墙扩建项目提供材料", new ThingGroup(OreGroup.C.MARBLE, 5), new RewardGroup(50, 2, 10)),
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
        public String getOutPutName() {
            return this.nameID;
        }

        @Override
        public String getInformation() {
            return "%s\n%s\n任务要求:\n%s任务奖励:\n%s".formatted(this.nameID, this.information, this.needThings.formatString(), this.rewards.formatString());
        }

        @Override
        public String getQuestStat(){
            return "常驻任务";
        }

        /**
         * 提交任务
         * @return 提交结果
         */
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
