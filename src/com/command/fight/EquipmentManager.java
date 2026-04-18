package com.command.fight;

import com.central.Signal;
import com.data.item.equipment.AllEquipment;
import com.save.SaveData;

public class EquipmentManager {
    public static String setEquipment(String equipment) {
        if (AllEquipment.isEquipment(equipment).equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
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
        if (AllEquipment.isEquipment(equipment).equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
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
