package com.command;

import com.save.SaveData;
import com.save.SaveDataManager;

public class Central {
    public static String exit() {
        SaveDataManager.saveData(SaveData.getSaveData());
        System.exit(0);
        return null;
    }
}
