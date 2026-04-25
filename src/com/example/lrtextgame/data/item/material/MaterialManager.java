package com.example.lrtextgame.data.item.material;

import java.util.HashMap;

public class MaterialManager {
    private static final HashMap<String, Material> MATERIALS = new HashMap<>();

    static {
        MATERIALS.putAll(OreGroup.getMap());
        MATERIALS.putAll(PlantGroup.getMap());
    }

    public static HashMap<String, Material> getMaterial() {
        return MATERIALS;
    }
}
