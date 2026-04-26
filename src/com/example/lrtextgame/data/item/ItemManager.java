package com.example.lrtextgame.data.item;

import com.example.lrtextgame.data.item.equipment.EquipmentManager;
import com.example.lrtextgame.data.item.semiProduct.SemiProductManager;

import java.util.HashMap;

/**
 * 物品管理
 * @author 凌然
 */
public class ItemManager {
    private static final HashMap<String,Item> Items = new HashMap<>();

    //初始化列表
    static {
        Items.putAll(EquipmentManager.getEQUIPMENT());
        Items.putAll(SemiProductManager.getSemiProducts());
    }

    public static HashMap<String,Item> getItems(){
        return Items;
    }
}
