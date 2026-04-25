package com.example.lrtextgame.data.item.equipment;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.save.SaveData;

import java.util.HashMap;

public class EquipmentManager {

    private static final HashMap<String, Equipment> EQUIPMENT = new HashMap<>();

    static {
        for (Equipment equipment : MinorArcana.Wands.values()) {
            EQUIPMENT.put(equipment.getNameID(), equipment);
        }
        for (Equipment equipment : MinorArcana.Cups.values()) {
            EQUIPMENT.put(equipment.getNameID(), equipment);
        }
        for (Equipment equipment : MinorArcana.Swords.values()) {
            EQUIPMENT.put(equipment.getNameID(), equipment);
        }
        for (Equipment equipment : MinorArcana.Pentacles.values()) {
            EQUIPMENT.put(equipment.getNameID(), equipment);
        }

        for (Equipment equipment : SwordCraft.values()) {
            EQUIPMENT.put(equipment.getNameID(), equipment);
        }
        for (Equipment equipment : Staff.values()) {
            EQUIPMENT.put(equipment.getNameID(), equipment);
        }
    }

    public static HashMap<String, Equipment> getEQUIPMENT() {
        return EQUIPMENT;
    }

    public static String isEquipment(String equipment) {
        Equipment equip = EQUIPMENT.get(equipment);
        return equip != null ? equip.getNameID() : Signal.THING_NOT_FOUND_ERROR.getSignal();
    }

    public static Equipment toEquipment(String equipment) {
        return EQUIPMENT.get(equipment);
    }


    public static String setEquipment(String equipment) {
        if (isEquipment(equipment).equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }

        SaveData saveData = SaveData.getSaveData();

        if (saveData.getPlayer_Bag().get(equipment) == null) {
            return Signal.THING_NOT_ENOUGH.getSignal();
        }

        int len = saveData.getEquipments().length;
        String[] rtnEquipment = saveData.getEquipments();
        for (int i = 0; i < len; i++) {
            if (rtnEquipment[i] == null) {
                rtnEquipment[i] = equipment;
                saveData.setEquipments(rtnEquipment);
                return String.format("已安装【%s】", equipment);
            }
        }
        return Signal.EQUIPMENT_TOO_MUCH.getSignal();
    }

    public static String removeEquipment(String equipment) {
        if (isEquipment(equipment).equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }

        SaveData saveData = SaveData.getSaveData();

        String[] rtnEquipment = saveData.getEquipments();
        int i = 0;
        for (String equip : saveData.getEquipments()) {
            if (equip.equals(equipment)) {
                rtnEquipment[i] = null;
                rtnEquipment = compactEquipments(rtnEquipment);
                saveData.setEquipments(rtnEquipment);
                return String.format("已卸下【%s】", equipment);
            }
            i++;
        }
        return String.format("你没有装备【%s】", equipment);
    }

    private static String[] compactEquipments(String[] equipments) {
        String[] rtnEquipment = new String[equipments.length];
        int i = 0;
        for (String equipment : equipments) {
            if (equipment == null) {
                continue;
            }
            rtnEquipment[i++] = equipment;
        }
        return rtnEquipment;
    }
}
