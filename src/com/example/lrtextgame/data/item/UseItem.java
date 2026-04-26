package com.example.lrtextgame.data.item;

import com.example.lrtextgame.central.Signal;

/**
 * 管理使用物品
 * @author 凌然
 */
public class UseItem {
    /**
     * 使用物品，获得收益
     * @param itemName 要使用的物品ID
     * @return 使用效果
     */
    public static String useItem(String itemName){
        Item item = ItemManager.getItems().get(itemName);
        if(item == null){
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        return item.toUse();
    }
}
