package com.example.lrtextgame.command;

import com.example.lrtextgame.save.SaveData;

import java.util.Random;

/**
 * 提供修炼相关方法
 */
public class Hone {
    /**
     * 修炼
     * <p>检查修炼结果，时间满足则结束修炼，不满足则提示时间未到，未开始则开始修炼
     * @return 修炼结果
     */
    public static String hone() {
        if (SaveData.getSaveData().isGetXP()) {
            long x = SaveData.getSaveData().getStart_Time();
            long y = System.currentTimeMillis();
            if (y - x < SaveData.getSaveData().getPlayerCharacter().getHoneTime()) {
                long timeSS = (SaveData.getSaveData().getPlayerCharacter().getHoneTime() - (y - x)) / 1000;
                long mm = timeSS / 60;
                long ss = timeSS % 60;
                return String.format("修炼时间未到，还差:%d分%02d秒", mm, ss);
            } else if (y - x >= SaveData.getSaveData().getPlayerCharacter().getHoneTime()) {
                return exit();
            }
        } else {
            return start();
        }
        return start();
    }

    /**
     * 强制结束修炼
     * @return 修炼结果
     */
    public static String exitHone() {
        if (SaveData.getSaveData().isGetXP()) {
            long x = SaveData.getSaveData().getStart_Time();
            long y = System.currentTimeMillis();
            if (y - x < SaveData.getSaveData().getPlayerCharacter().getHoneTime()) {
                long timeSS = (SaveData.getSaveData().getPlayerCharacter().getHoneTime() - (y - x)) / 1000;
                long mm = timeSS / 60;
                long ss = timeSS % 60;
                SaveData.getSaveData().setGetXP(false);
                return String.format("目标修炼时间未到，还差:%d分%02d秒\n已强制结束修炼", mm, ss);
            } else if (y - x >= SaveData.getSaveData().getPlayerCharacter().getHoneTime()) {
                return exit();
            }
        }
        return "你没有在修炼";
    }

    /**
     * 突破等级
     * @return 突破结果
     */
    public static String Breakthrough() {
        int x = SaveData.getSaveData().getExperience_Points() - getLevelRank() * 50;
        int y;
        if (x >= 0) {
            SaveData.getSaveData().setExperience_Points(x);
            y = SaveData.getSaveData().getPlayer_Level() + 1;
            SaveData.getSaveData().setPlayer_Level(y);
            return String.format("恭喜等级提升到 Lv.%d", y);
        } else {
            return String.format("突破失败：你还差%d点经验", -x);
        }
    }


    /**
     * 开始修炼
     * @return 修炼信息
     */
    private static String start() {
        SaveData saveData = SaveData.getSaveData();
        saveData.setStart_Time(System.currentTimeMillis());
        saveData.setGetXP(true);
        int x = saveData.getCharacter_Bag().get(saveData.getPlayerCharacter().getNameID()) - 1;
        int min = (int) (saveData.getPlayerCharacter().getHoneLoot()[Param.HONE_LOOT_MIN] * (1 + (x * 0.1)));
        int max = (int) (saveData.getPlayerCharacter().getHoneLoot()[Param.HONE_LOOT_MAX] * (1 + (x * 0.1)));

        long timeSS = saveData.getPlayerCharacter().getHoneTime() / 1000;
        long mm = timeSS / 60;
        long ss = timeSS % 60;
        return String.format("开始修炼，修理时间:%d分%02d秒，预计获得经验:[%d-%d]", mm, ss, min, max);
    }

    /**
     * 结束修炼，获得修炼奖励
     * @return 修炼结果
     */
    private static String exit() {
        SaveData saveData = SaveData.getSaveData();
        Random rand = new Random();
        int x = saveData.getCharacter_Bag().get(saveData.getPlayerCharacter().getNameID()) - 1;
        int min = (int) (saveData.getPlayerCharacter().getHoneLoot()[Param.HONE_LOOT_MIN] * (1 + (x * 0.1)));
        int max = (int) (saveData.getPlayerCharacter().getHoneLoot()[Param.HONE_LOOT_MAX] * (1 + (x * 0.1)));
        int z = rand.nextInt(max - min + 1) + min;

        int y = saveData.getExperience_Points();
        saveData.setExperience_Points(z + y);
        saveData.setGetXP(false);
        return String.format("修炼完成，获得经验:%d", z);
    }

    public static int getLevelRank() {
        return SaveData.getSaveData().getPlayer_Level() / 10 + 1;
    }
}
