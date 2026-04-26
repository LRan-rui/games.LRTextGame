package com.example.lrtextgame.data.item.material;

import java.util.HashMap;

/**
 * 管理材料
 * @author 凌然
 */
public class MaterialManager {
    private static final HashMap<String, Material> MATERIALS = new HashMap<>();

    //初始化列表
    static {
        MATERIALS.putAll(OreGroup.getMap());
        MATERIALS.putAll(PlantGroup.getMap());
    }

    public static HashMap<String, Material> getMaterial() {
        return MATERIALS;
    }
}
