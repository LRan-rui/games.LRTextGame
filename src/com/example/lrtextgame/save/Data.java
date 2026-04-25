package com.example.lrtextgame.save;

import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.data.character.Arcana;

import java.util.HashMap;

public class Data {
    //当前角色
    Arcana PlayerCharacter;
    //玩家ID
    java.lang.String Player_ID;
    //玩家等级
    int Player_Level;
    //玩家经验值
    int Experience_Points;
    //玩家上次开始修炼的时间戳
    long Start_Time;
    //是否修炼中
    boolean isGetXP;
    //玩家体力值
    int Energy_Points;
    //玩家上次回复体力的时间戳
    long Last_Energy_Time;
    //玩家金币
    long Money;
    //玩家宝石
    long Jewel;

    //玩家装备栏
    String[] equipments;
    //玩家角色池
    HashMap<java.lang.String, Integer> Character_Bag;
    //玩家背包
    HashMap<java.lang.String, Integer> Player_Bag;
    //属性对，用于扩展
    HashMap<java.lang.String, Integer> Property_Pool;
    //每日任务完成记录
    HashMap<java.lang.String, String> DayQuest_Last_Time;

    Data() {
        this.PlayerCharacter = Arcana.THE_FOOL;
        this.Player_ID = "玩家";
        this.Player_Level = 0;
        this.Experience_Points = 0;
        this.Start_Time = System.currentTimeMillis();
        this.isGetXP = false;
        this.Energy_Points = 100;
        this.Last_Energy_Time = System.currentTimeMillis();
        this.Money = 1000;
        this.Jewel = 10;
        this.equipments = new String[4];
        this.Character_Bag = new HashMap<>();
        this.Player_Bag = new HashMap<>();
        this.Property_Pool = new HashMap<>();
        this.DayQuest_Last_Time = new HashMap<>();
        this.Character_Bag.put(Arcana.THE_FOOL.getNameID(), 1);

        this.Property_Pool.put(Param.MINING_LEVEL, 0);
        this.Property_Pool.put(Param.MINING_NUM, 0);
        this.Property_Pool.put(Param.LOGGING_LEVEL,0);
        this.Property_Pool.put(Param.LOGGING_NUM, 0);

    }

    public Arcana getPlayerCharacter() {
        return PlayerCharacter;
    }

    public void setPlayerCharacter(Arcana player) {
        PlayerCharacter = player;
    }

    public java.lang.String getPlayer_ID() {
        return Player_ID;
    }

    public void setPlayer_ID(java.lang.String player_ID) {
        Player_ID = player_ID;
    }

    public int getPlayer_Level() {
        return Player_Level;
    }

    public void setPlayer_Level(int player_Level) {
        Player_Level = player_Level;
    }

    public int getExperience_Points() {
        return Experience_Points;
    }

    public void setExperience_Points(int experience_Points) {
        Experience_Points = experience_Points;
    }

    public long getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(long start_Time) {
        Start_Time = start_Time;
    }

    public boolean isGetXP() {
        return isGetXP;
    }

    public void setGetXP(boolean getXP) {
        isGetXP = getXP;
    }

    public int getEnergy_Points() {
        return Energy_Points;
    }

    public void setEnergy_Points(int energy_Points) {
        Energy_Points = energy_Points;
    }

    public long getLast_Energy_Time() {
        return Last_Energy_Time;
    }

    public void setLast_Energy_Time(long last_Energy_Time) {
        Last_Energy_Time = last_Energy_Time;
    }

    public long getMoney() {
        return Money;
    }

    public void setMoney(long money) {
        Money = money;
    }

    public long getJewel() {
        return Jewel;
    }

    public void setJewel(long jewel) {
        Jewel = jewel;
    }

    public String[] getEquipments() {
        return equipments;
    }

    public void setEquipments(String[] equipments) {
        this.equipments = equipments;
    }

    public HashMap<java.lang.String, Integer> getCharacter_Bag() {
        return Character_Bag;
    }

    public void setCharacter_Bag(HashMap<java.lang.String, Integer> character_Bag) {
        Character_Bag = character_Bag;
    }

    public HashMap<java.lang.String, Integer> getPlayer_Bag() {
        return Player_Bag;
    }

    public void setPlayer_Bag(HashMap<java.lang.String, Integer> player_Bag) {
        Player_Bag = player_Bag;
    }

    public HashMap<java.lang.String, Integer> getProperty_Pool() {
        return Property_Pool;
    }

    public void setProperty_Pool(HashMap<java.lang.String, Integer> property_Pool) {
        Property_Pool = property_Pool;
    }

    public HashMap<java.lang.String, String> getDayQuest_Last_Time() {
        return DayQuest_Last_Time;
    }
}
