package com.data.equipment;

import com.central.Signal;

import java.util.HashMap;

public class AllEquipment {

    private static final HashMap<String, Equipment> EQUIPMENT = new HashMap<>();

    //初始化HashMap键值对
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
    }


    public static String isEquipment(String equipment) {
        Equipment equip = EQUIPMENT.get(equipment);
        return equip != null ? equip.getNameID() : Signal.THING_NOT_FOUND_ERROR.getSignal();
    }

    public static Equipment toEquipment(String equipment) {
        return EQUIPMENT.get(equipment);
    }


}
