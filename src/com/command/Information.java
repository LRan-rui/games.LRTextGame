package com.command;

import com.save.SaveData;

import java.util.Map;

public class Information {
    public static String[] getPlayerInformationArray() {
        SaveData saveData = SaveData.getSaveData();
        String[] rtn = new String[12];
        rtn[0] = saveData.getPlayer_ID();
        rtn[1] = saveData.getPlayerCharacter().getNameID() + "☆" + saveData.getCharacter_Bag().get(saveData.getPlayerCharacter().getNameID());
        rtn[2] = String.valueOf(saveData.getPlayer_Level());
        rtn[3] = String.valueOf(saveData.getExperience_Points());
        rtn[4] = String.valueOf(Hone.getLevelRank() * 50);
        rtn[5] = String.valueOf(saveData.getEnergy_Points());
        rtn[6] = String.valueOf(saveData.getMoney());
        rtn[7] = String.valueOf(saveData.getJewel());
        //↓↓↓示例：【权杖I☆3】
        rtn[8] = saveData.getEquipments()[0] == null ? "" : "【" + saveData.getEquipments()[0] + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[0]) + "】";
        rtn[9] = saveData.getEquipments()[1] == null ? "" : "【" + saveData.getEquipments()[1] + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[1]) + "】";
        rtn[10] = saveData.getEquipments()[2] == null ? "" : "【" + saveData.getEquipments()[2] + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[2]) + "】";
        rtn[11] = saveData.getEquipments()[3] == null ? "" : "【" + saveData.getEquipments()[3] + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[3]) + "】";
        return rtn;
    }

    public static String getPlayerInformation() {
        String[] rtn = getPlayerInformationArray();
        return String.format(" ☆%s☆\n 身份:【%s】  等级:Lv.%s  经验值:%s/%s\n 体力值%s\n 金币:%s  宝石:%s\n 装备\n------------------------\n %s   %s\n %s   %s\n------------------------",
                rtn[0], rtn[1], rtn[2], rtn[3], rtn[4], rtn[5], rtn[6], rtn[7], rtn[8], rtn[9], rtn[10], rtn[11]);
    }

    public static String getBoxInformation() {
        SaveData saveData = SaveData.getSaveData();
        StringBuilder rtn = new StringBuilder("我的背包\n------------------------\n");
        boolean x = true;
        for (Map.Entry<String, Integer> entry : saveData.getPlayer_Bag().entrySet()) {
            rtn.append("【").append(entry.getKey()).append("】x").append(entry.getValue());
            if (x) {
                x = false;
                rtn.append("   ");
            } else {
                x = true;
                rtn.append("\n");
            }
        }
        if (x) {
            rtn.append("------------------------");
        } else {
            rtn.append("\n------------------------");
        }
        return rtn.toString();
    }

    public static String getCharactersInformation() {
        SaveData saveData = SaveData.getSaveData();
        StringBuilder rtn = new StringBuilder("我的角色\n------------------------\n");
        boolean x = true;
        for (Map.Entry<String, Integer> entry : saveData.getCharacter_Bag().entrySet()) {
            rtn.append("【").append(entry.getKey()).append("】x").append(entry.getValue());
            if (x) {
                x = false;
                rtn.append("   ");
            } else {
                x = true;
                rtn.append("\n");
            }
        }
        if (x) {
            rtn.append("------------------------");
        } else {
            rtn.append("\n------------------------");
        }
        return rtn.toString();
    }

    public static String setPlayerID(String newPlayerID) {
        if (newPlayerID.isBlank()) {
            return "请输入要改成的名字";
        }
        SaveData saveData = SaveData.getSaveData();
        saveData.setPlayer_ID(newPlayerID);
        return String.format("已修改名字为:%s", saveData.getPlayer_ID());
    }
}
