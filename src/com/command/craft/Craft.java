package com.command.craft;

import com.central.Signal;

import java.util.HashMap;

public class Craft {
    private static final HashMap<String, CraftingList> CRAFTS = new HashMap<>();

    static {
        for(CraftingList c : CraftingList.values()){
            CRAFTS.put(c.getNameID(),c);
        }
    }

    public static String craft(String param){
        CraftingList c = CRAFTS.get(param);
        if(c == null){
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        return c.toCraft();
    }

    public static String toCraft(String param){
        CraftingList c = CRAFTS.get(param);
        if(c == null){
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        return c.getRecipe().formatString();
    }
}
