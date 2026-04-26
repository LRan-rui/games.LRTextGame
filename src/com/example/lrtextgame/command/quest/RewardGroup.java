package com.example.lrtextgame.command.quest;

import com.example.lrtextgame.save.SaveData;

/**
 * 任务奖励组
 * @author 凌然
 */
public class RewardGroup {
    private final int money;
    private final int jewel;
    private final int experiencePoints;

    public RewardGroup(int money, int jewel, int experiencePoints) {
        this.money = money;
        this.jewel = jewel;
        this.experiencePoints = experiencePoints;
    }

    /**
     * 获取奖励
     */
    public void getRewards() {
        SaveData saveData = SaveData.getSaveData();
        saveData.setMoney(saveData.getMoney() + money);
        saveData.setJewel(saveData.getJewel() + jewel);
        saveData.setExperience_Points(saveData.getExperience_Points() + experiencePoints);
    }

    public String formatString() {
        return String.format("金币:%d 宝石:%d 经验值:%d", money, jewel, experiencePoints);
    }
}
