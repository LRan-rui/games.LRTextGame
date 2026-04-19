package com.data.item.semiProduct;

import java.util.HashMap;

public class SemiProductManager {
    private static final HashMap<String, SemiProduct> semiProducts = new HashMap<>();

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
