package com.example.lrtextgame.data.item.semiProduct;

import java.util.HashMap;

/**
 * 半成品管理
 * @author 凌然
 */
public class SemiProductManager {
    private static final HashMap<String, SemiProduct> semiProducts = new HashMap<>();

    //初始化列表
    static {
        for (SemiProduct s: Metal.values()){
            semiProducts.put(s.getNameID(),s);
        }
        for (SemiProduct s: Crystal.values()){
            semiProducts.put(s.getNameID(),s);
        }
    }

    public static HashMap<String, SemiProduct> getSemiProducts(){
        return semiProducts;
    }
}
