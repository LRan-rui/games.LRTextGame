package com.save;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class setFile {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String SAVE_FILE = "save.json";

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
