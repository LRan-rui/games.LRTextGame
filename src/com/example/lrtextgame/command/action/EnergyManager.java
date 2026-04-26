package com.example.lrtextgame.command.action;

import com.example.lrtextgame.save.SaveData;

/**
 * 提供体力相关方法
 * @author 凌然
 */
public class EnergyManager {
    private static final long oneEnergyTime = 2 * 60 * 1000;

    /**
     * 回复体力的方法
     * <p>从SaveData获取上一次恢复体力的时间，并以此为依据提供体力，
     * 再将此时的时间戳存入SaveData
     * @return 休息的时间和回复的体力
     */
    public static String recoverEnergy() {
        SaveData saveData = SaveData.getSaveData();
        long now = System.currentTimeMillis();
        long timeSS = now - saveData.getLast_Energy_Time();
        if (timeSS < oneEnergyTime) {
            return "至少2分钟才能回复1体力";
        } else {
            int recovery = (int) (timeSS / oneEnergyTime);
            saveData.setLast_Energy_Time(now);
            saveData.setEnergy_Points(saveData.getEnergy_Points() + recovery);
            timeSS = timeSS / 1000;
            long mm = timeSS / 60;
            long ss = timeSS % 60;
            return String.format("你休息了%d分%02d秒，共回复了%d点体力", mm, ss, recovery);
        }
    }
}
