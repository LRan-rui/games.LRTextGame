package com.command.craft;

import com.central.Signal;
import com.data.Thing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Craft {
    private static final HashMap<String, CraftingList> CRAFTS = new HashMap<>();
    private static final HashMap<String, Set<String>> TO_CRAFT = new HashMap<>();

    static {
        for(CraftingList c : CraftingList.values()){
            CRAFTS.put(c.getNameID(),c);

            for(Thing thing :c.getRecipe().getNeedThings().keySet()){
                TO_CRAFT.computeIfAbsent(thing.getNameID(),k -> new HashSet<>()).add(c.getNameID());
            }
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

    public static String[] findCraft(String param){
        return TO_CRAFT.get(param) == null ? new String[]{Signal.THING_NOT_FOUND_ERROR.getSignal()} : TO_CRAFT.get(param).toArray(new String[0]);
    }
}
