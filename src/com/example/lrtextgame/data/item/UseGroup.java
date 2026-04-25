package com.example.lrtextgame.data.item;

import com.example.lrtextgame.save.SaveData;

public class UseGroup {
    private final int money;
    private final int jewel;
    private final int experiencePoints;
    private final int energy;

    public UseGroup(int money, int jewel, int experiencePoints, int energy){
        this.money=money;
        this.jewel=jewel;
        this.experiencePoints=experiencePoints;
        this.energy=energy;
    }

    public String toUse(){
        SaveData saveData = SaveData.getSaveData();
        saveData.setMoney(saveData.getMoney() + money);
        saveData.setJewel(saveData.getJewel() + jewel);
        saveData.setExperience_Points(saveData.getExperience_Points() + experiencePoints);
        saveData.setEnergy_Points(saveData.getEnergy_Points() + energy);
        return "获得了%s%s%s%s".formatted(
                money == 0? "": money+"金币 ",
                jewel == 0? "": jewel+"宝石 ",
                experiencePoints == 0? "": experiencePoints+"经验 ",
                energy == 0? "": energy+"体力"
        );
    }

    public String formatUseGroup(){
        return "使用后获得%s%s%s%s".formatted(
                money == 0? "": money+"金币 ",
                jewel == 0? "": jewel+"宝石 ",
                experiencePoints == 0? "": experiencePoints+"经验 ",
                energy == 0? "": energy+"体力"
        );
    }
}
