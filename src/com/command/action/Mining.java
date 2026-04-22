package com.command.action;

import com.command.Param;
import com.data.item.material.Material;
import com.data.item.material.OreGroup;
import com.save.SaveData;

import java.util.HashMap;
import java.util.Random;

public class Mining extends Action {
    private static final int ENERGY_USED = 5;

    public static String mining(String param) {
        reNewLevel();
        int x;
        try {
            x = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            x = 1;
        }

        SaveData saveData = SaveData.getSaveData();
        int y = saveData.getEnergy_Points() - (x * ENERGY_USED);
        if (y < 0) {
            return String.format("体力不够，还差%d点体力", -y);
        }
        saveData.setEnergy_Points(y);

        StringBuilder rtn = new StringBuilder();
        Random rand = new Random();

        HashMap<Material, Integer> map = new HashMap<>();
        for (int i = 0; i < x; i++) {
            Material[] materials = materials();
            int rtnMaxNum = 0;
            if (materials[0] == OreGroup.S.values()[0]) rtnMaxNum = 1 + level / 5;
            if (materials[0] == OreGroup.A.values()[0]) rtnMaxNum = 1 + level / 4;
            if (materials[0] == OreGroup.B.values()[0]) rtnMaxNum = 1 + level / 3;
            if (materials[0] == OreGroup.C.values()[0]) rtnMaxNum = 2 + level / 2;
            if (materials[0] == OreGroup.D.values()[0]) rtnMaxNum = 3 + level;

            Material material = materials[(int) (Math.random() * materials.length)];
            rand.setSeed(System.currentTimeMillis());
            int rtnNum = rand.nextInt(rtnMaxNum) + 1;
            saveData.addPlayer_Bag(material, rtnNum);
            map.merge(material, rtnNum, Integer::sum);
            saveData.getProperty_Pool().merge(Param.MINING_NUM, 1, Integer::sum);
            reNewLevel();
        }

        rtn.append(String.format("挖矿完成，挖矿等级:Lv.%d  (%d/%d)\n消耗体力%d点,获得:\n", level, num, (level + 1) * 100, x * ENERGY_USED));

        boolean isEnter = false;
        for (Material material : map.keySet()) {
            rtn.append(material.getOutPutName()).append("×").append(map.get(material));
            if (isEnter) {
                rtn.append("\n");
                isEnter = false;
            } else {
                rtn.append("   ");
                isEnter = true;
            }
        }


        return rtn.toString();
    }


    private static void reNewLevel() {
        SaveData saveData = SaveData.getSaveData();

        level = saveData.getProperty_Pool().get(Param.MINING_LEVEL);
        num = saveData.getProperty_Pool().get(Param.MINING_NUM);

        if (num >= (level + 1) * 100) {
            level++;
            num -= level * 100;
        }

        saveData.getProperty_Pool().put(Param.MINING_LEVEL, level);
        saveData.getProperty_Pool().put(Param.MINING_NUM, num);
    }

    private static Material[] materials() {
        reNewLevel();
        OreGroup.S[] oreS = OreGroup.S.values();
        OreGroup.A[] oreA = OreGroup.A.values();
        OreGroup.B[] oreB = OreGroup.B.values();
        OreGroup.C[] oreC = OreGroup.C.values();
        OreGroup.D[] oreD = OreGroup.D.values();

        Material[] materials;

        int allWeight = s_weight + a_weight + b_weight + c_weight + d_weight + (add_weight * level * 5);

        Random rand = new Random();
        int x = rand.nextInt(allWeight);

        int y;
        if (x < (y = s_weight + (add_weight * level))) {
            materials = oreS;
        } else if (x < (y = y + a_weight + (add_weight * level))) {
            materials = oreA;
        } else if (x < (y = y + b_weight + (add_weight * level))) {
            materials = oreB;
        } else if (x < (y + c_weight + (add_weight * level))) {
            materials = oreC;
        } else {
            materials = oreD;
        }

        return materials;
    }
}
