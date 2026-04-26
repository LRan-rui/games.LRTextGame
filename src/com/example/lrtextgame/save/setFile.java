package com.example.lrtextgame.save;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件相关方法
 * @author 凌然
 */
public class setFile {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String SAVE_FILE = "save.json";

    /**
     * 读取存档，若无存档则返回新的存档类
     * @return 存档中间层
     */
    public static SaveDataManager readSaveDataManager() {
        SaveDataManager saveDataManager;
        File saveDir = new File("save");
        if (!saveDir.exists()) {
            saveDataManager = new SaveDataManager();
            return saveDataManager;
        }
        Path path = Paths.get(saveDir.getPath(), SAVE_FILE);
        String jsonString;
        try {
            jsonString = Files.readString(path);
        } catch (IOException e) {
            return new SaveDataManager();
        }
        saveDataManager = gson.fromJson(jsonString, SaveDataManager.class);
        //System.out.println("读取存档成功:\n"+jsonString);
        return saveDataManager;
    }

    /**
     * 保存存档至文件
     * @param saveDataManager 要保存的存档数据
     */
    public static void saveSaveDataManager(SaveDataManager saveDataManager) {
        String json = gson.toJson(saveDataManager);
        File dir = new File("save");
        if (!dir.exists()) dir.mkdir();
        Path path = Paths.get(dir.getPath(), SAVE_FILE);
        try {
            Files.writeString(path, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
