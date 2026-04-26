package com.example.lrtextgame.command;

import com.example.lrtextgame.save.SaveData;
import com.example.lrtextgame.save.SaveDataManager;

/**
 * 提供控制方法
 * @author 凌然
 */
public class Central {

    /**
     * 退出程序
     * @return 退出程序
     */
    public static String exit() {
        SaveDataManager.saveData(SaveData.getSaveData());
        System.exit(0);
        return null;
    }
}
