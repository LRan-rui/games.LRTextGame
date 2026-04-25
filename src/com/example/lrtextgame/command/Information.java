package com.example.lrtextgame.command;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.fight.Stat;
import com.example.lrtextgame.command.quest.QuestManager;
import com.example.lrtextgame.data.ThingManager;
import com.example.lrtextgame.data.ZeroManager;
import com.example.lrtextgame.data.Zero;
import com.example.lrtextgame.data.item.Item;
import com.example.lrtextgame.data.item.equipment.Equipment;
import com.example.lrtextgame.data.item.equipment.EquipmentManager;
import com.example.lrtextgame.data.item.equipment.SwordCraft;
import com.example.lrtextgame.data.item.material.Material;
import com.example.lrtextgame.data.item.material.Ore;
import com.example.lrtextgame.data.item.material.Plant;
import com.example.lrtextgame.data.item.semiProduct.Crystal;
import com.example.lrtextgame.data.item.semiProduct.Metal;
import com.example.lrtextgame.data.item.semiProduct.SemiProduct;
import com.example.lrtextgame.save.SaveData;

import java.util.HashMap;
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
        rtn[8] = saveData.getEquipments()[0] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[0]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[0]) + "】";
        rtn[9] = saveData.getEquipments()[1] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[1]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[1]) + "】";
        rtn[10] = saveData.getEquipments()[2] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[2]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[2]) + "】";
        rtn[11] = saveData.getEquipments()[3] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[3]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[3]) + "】";
        return rtn;
    }

    public static String getPlayerInformation() {
        String[] rtn = getPlayerInformationArray();
        return String.format(" ☆%s☆\n 身份:【%s】  等级:Lv.%s  经验值:%s/%s\n 体力值%s\n 金币:%s  宝石:%s\n 装备\n------------------------\n %s   %s\n %s   %s\n------------------------",
                rtn[0], rtn[1], rtn[2], rtn[3], rtn[4], rtn[5], rtn[6], rtn[7], rtn[8], rtn[9], rtn[10], rtn[11]);
    }


    private static final HashMap<String,Class<?>> TYPE = new HashMap<>();

    static {
        TYPE.put("物品", Item.class);
        TYPE.put("背包", Item.class);
        TYPE.put("装备", Equipment.class);
        TYPE.put("刀剑", SwordCraft.class);
        TYPE.put("原材料", Material.class);
        TYPE.put("矿石", Ore.class);
        TYPE.put("植物", Plant.class);
        TYPE.put("半成品", SemiProduct.class);
        TYPE.put("晶体", Crystal.class);
        TYPE.put("金属", Metal.class);
    }

    public static String getBoxInformation(String param) {
        SaveData saveData = SaveData.getSaveData();
        StringBuilder rtn = new StringBuilder();

        if (param.equals("角色")){
            return getCharactersInformation();
        }else if(param.equals("任务")){
            return QuestManager.getQuestList();
        }else if(param.equals("信息")){
            return getPlayerInformation();
        }else if(param.equals("属性")){
            return Stat.getStatInformation();
        }

        Class<?> type = TYPE.get(param);
        if(param.isBlank()){
            return "请输入参数。例子：【我的背包】，我的+%s".formatted(TYPE.keySet().toString());
        }else if (type == null) {
            return "参数错误。例子：【我的背包】，我的+%s".formatted(TYPE.keySet().toString());
        }

        boolean x = true;
        for (Map.Entry<String, Integer> entry : saveData.getPlayer_Bag().entrySet()) {
            if(type.isInstance(ThingManager.findThing(entry.getKey()))){
                rtn.append("【").append(ThingManager.findThing(entry.getKey()).getOutPutName()).append("】x").append(entry.getValue());
                if (x) {
                    x = false;
                    rtn.append("   ");
                } else {
                    x = true;
                    rtn.append("\n");
                }
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
            rtn.append("【").append(ThingManager.findThing(entry.getKey()).getOutPutName()).append("】x").append(entry.getValue());
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

    public static String getThingInformation(String nameID) {
        Zero zero = ZeroManager.getZeros().get(nameID);
        return zero != null ? zero.getInformation() : Signal.THING_NOT_FOUND_ERROR.getSignal();
    }
}
