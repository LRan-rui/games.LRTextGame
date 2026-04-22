package com.data.item;

import com.data.item.equipment.EquipmentManager;
import com.data.item.semiProduct.SemiProductManager;

import java.util.HashMap;

public class ItemManager {
    private static final HashMap<String,Item> Items = new HashMap<>();

    static {
        Items.putAll(EquipmentManager.getEQUIPMENT());
        Items.putAll(SemiProductManager.getSemiProducts());
    }

    public static HashMap<String,Item> getItems(){
        return Items;
    }
}
