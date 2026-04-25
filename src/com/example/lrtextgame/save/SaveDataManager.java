package com.example.lrtextgame.save;

public class SaveDataManager extends Data {

    public static void setSaveData(SaveData saveData) {
        SaveDataManager saveDataManager = getSaveDataManager();
        saveData.setPlayerCharacter(saveDataManager.getPlayerCharacter());
        saveData.setPlayer_ID(saveDataManager.getPlayer_ID());
        saveData.setPlayer_Level(saveDataManager.getPlayer_Level());
        saveData.setExperience_Points(saveDataManager.getExperience_Points());
        saveData.setStart_Time(saveDataManager.getStart_Time());
        saveData.setGetXP(saveDataManager.isGetXP());
        saveData.setEnergy_Points(saveDataManager.getEnergy_Points());
        saveData.setLast_Energy_Time(saveDataManager.getLast_Energy_Time());
        saveData.setMoney(saveDataManager.getMoney());
        saveData.setJewel(saveDataManager.getJewel());
        saveData.setEquipments(saveDataManager.getEquipments());
        saveData.setCharacter_Bag(saveDataManager.getCharacter_Bag());
        saveData.setPlayer_Bag(saveDataManager.getPlayer_Bag());
        saveData.setProperty_Pool(saveDataManager.getProperty_Pool());
    }

        public SaveDataManager() {
            super();
        }

        public SaveDataManager(SaveData saveData) {
            this.PlayerCharacter = saveData.getPlayerCharacter();
            this.Player_ID = saveData.getPlayer_ID();
            this.Player_Level = saveData.getPlayer_Level();
            this.Experience_Points = saveData.getExperience_Points();
            this.Start_Time = SaveData.getSaveData().getStart_Time();
            this.isGetXP = saveData.isGetXP();
            this.Energy_Points = saveData.getEnergy_Points();
            this.Last_Energy_Time = SaveData.getSaveData().getLast_Energy_Time();
            this.Money = saveData.getMoney();
            this.Jewel = saveData.getJewel();
            this.equipments = saveData.getEquipments();
            this.Character_Bag = saveData.getCharacter_Bag();
            this.Player_Bag = saveData.getPlayer_Bag();
            this.Property_Pool = saveData.getProperty_Pool();
        }



    private static SaveDataManager getSaveDataManager() {
        return setFile.readSaveDataManager();
    }

    public static void saveData(SaveData saveData) {
        SaveDataManager saveDataManager = new SaveDataManager(saveData);
        setFile.saveSaveDataManager(saveDataManager);
    }


}
