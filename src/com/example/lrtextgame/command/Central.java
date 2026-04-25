package com.example.lrtextgame.command;

import com.example.lrtextgame.save.SaveData;
import com.example.lrtextgame.save.SaveDataManager;

public class Central {
    public static String exit() {
        SaveDataManager.saveData(SaveData.getSaveData());
        System.exit(0);
        return null;
    }
}
