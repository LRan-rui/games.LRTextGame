package com.example.lrtextgame.command.craft;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.data.Thing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 合成相关方法
 * @author 凌然
 */
public class Craft {
    private static final HashMap<String, CraftingList> CRAFTS = new HashMap<>();
    private static final HashMap<String, Set<String>> TO_CRAFT = new HashMap<>();

    //初始化合成表
    static {
        for(CraftingList c : CraftingList.values()){
            CRAFTS.put(c.getNameID(),c);

            for(Thing thing :c.getRecipe().getNeedThings().keySet()){
                TO_CRAFT.computeIfAbsent(thing.getNameID(),k -> new HashSet<>()).add(c.getNameID());
            }
        }
    }

    /**
     * 合成物品
     * @param param 要合成物品ID
     * @return 合成结果
     */
    public static String craft(String param){
        CraftingList c = CRAFTS.get(param);
        if(c == null){
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        return c.toCraft();
    }

    /**
     * 合成物品所需物品
     * @param param 待合成的物品
     * @return 配方
     */
    public static String toCraft(String param){
        CraftingList c = CRAFTS.get(param);
        if(c == null){
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        return c.getRecipe().formatString();
    }

    /**
     * 查找是否用于某一合成
     * @param param 材料名称ID
     * @return 查找结果
     */
    public static String[] findCraft(String param){
        return TO_CRAFT.get(param) == null ? new String[]{Signal.THING_NOT_FOUND_ERROR.getSignal()} : TO_CRAFT.get(param).toArray(new String[0]);
    }
}
