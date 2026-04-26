package com.example.lrtextgame.command.action;

import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.data.item.material.Material;
import com.example.lrtextgame.data.item.material.PlantGroup;
import com.example.lrtextgame.save.SaveData;

import java.util.HashMap;
import java.util.Random;

/**
 * 采伐/砍树相关方法
 * @author 凌然
 */
public class Logging extends Action{
    private static final int ENERGY_USED = 5;

    /**
     * 采伐命令方法
     * <p>根据采集等级采集{@code data.item.material.PlantGroup}中的物品，
     * 会调用和写入SaveData.
     * @param param 采集次数
     * @return 采集结果
     */
    public static String logging(String param) {
        reNewLevel();
        int x;
        //将参数转化为整数，不合法则默认1
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
            //随机获取一个品阶的物品
            Material[] materials = materials();
            int rtnMaxNum = 0;
            //获取能获得的最大物品数量
            if (materials[0] == PlantGroup.S.values()[0]) rtnMaxNum = 1 + level / 5;
            if (materials[0] == PlantGroup.A.values()[0]) rtnMaxNum = 1 + level / 4;
            if (materials[0] == PlantGroup.B.values()[0]) rtnMaxNum = 1 + level / 3;
            if (materials[0] == PlantGroup.C.values()[0]) rtnMaxNum = 2 + level / 2;
            if (materials[0] == PlantGroup.D.values()[0]) rtnMaxNum = 3 + level;
            //随机获取一个物品
            Material material = materials[(int) (Math.random() * materials.length)];
            rand.setSeed(System.currentTimeMillis());
            //随机物品的数量
            int rtnNum = rand.nextInt(rtnMaxNum) + 1;
            saveData.addPlayer_Bag(material, rtnNum);
            map.merge(material, rtnNum, Integer::sum);
            saveData.getProperty_Pool().merge(Param.LOGGING_NUM, 1, Integer::sum);
            //刷新等级
            reNewLevel();
        }

        rtn.append(String.format("采伐完成，采伐等级:Lv.%d  (%d/%d)\n消耗体力%d点,获得:\n", level, num, (level + 1) * 100, x * ENERGY_USED));

        //格式化输出结果
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

    /**
     * 刷新等级状态
     * <p>获取已采集次数，满足升级条件便升级，减去升级用掉的次数
     */
    private static void reNewLevel() {
        SaveData saveData = SaveData.getSaveData();

        level = saveData.getProperty_Pool().get(Param.LOGGING_LEVEL);
        num = saveData.getProperty_Pool().get(Param.LOGGING_NUM);

        if (num >= (level + 1) * 100) {
            level++;
            num -= level * 100;
        }

        saveData.getProperty_Pool().put(Param.LOGGING_LEVEL, level);
        saveData.getProperty_Pool().put(Param.LOGGING_NUM, num);
    }

    /**
     * 从PlantGroup中按权随机获取一个品阶的物品数组
     * @return 该类型物品一个品阶的所有物品的数组
     */
    private static Material[] materials() {
        reNewLevel();
        PlantGroup.S[] S = PlantGroup.S.values();
        PlantGroup.A[] A = PlantGroup.A.values();
        PlantGroup.B[] B = PlantGroup.B.values();
        PlantGroup.C[] C = PlantGroup.C.values();
        PlantGroup.D[] D = PlantGroup.D.values();

        Material[] materials;

        int allWeight = s_weight + a_weight + b_weight + c_weight + d_weight + (add_weight * level * 5);

        Random rand = new Random();
        int x = rand.nextInt(allWeight);

        int y;
        if (x < (y = s_weight + (add_weight * level))) {
            materials = S;
        } else if (x < (y = y + a_weight + (add_weight * level))) {
            materials = A;
        } else if (x < (y = y + b_weight + (add_weight * level))) {
            materials = B;
        } else if (x < (y + c_weight + (add_weight * level))) {
            materials = C;
        } else {
            materials = D;
        }

        return materials;
    }
}
