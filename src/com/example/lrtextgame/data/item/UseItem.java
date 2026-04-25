package com.example.lrtextgame.data.item;

import com.example.lrtextgame.central.Signal;

public class UseItem {
    public static String useItem(String itemName){
        Item item = ItemManager.getItems().get(itemName);
        if(item == null){
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        return item.toUse();
    }
}
