package com.data.item.material;

import java.util.HashMap;

public class MaterialManager {
    private static final HashMap<String, Material> MATERIALS = new HashMap<>();

    static {
        MATERIALS.putAll(Ore.getMap());
        MATERIALS.putAll(Plant.getMap());
    }

    public static HashMap<String, Material> getMaterial() {
        return MATERIALS;
    }
}
