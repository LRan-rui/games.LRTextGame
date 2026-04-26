package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.command.Hone;
import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.data.item.equipment.EquipmentManager;
import com.example.lrtextgame.save.SaveData;

/**
 * 属性类
 * @author 凌然
 */
public class Stat {

    private static final int HEALTH_BASIC = 1000;
    private static final int ATTACK_BASIC = 200;
    private static final int MAGIC_ATTACK_BASIC = 50;
    private static final int HEALTH_ADDITIONAL_BASIC = 100;
    private static final int ATTACK_ADDITIONAL_BASIC = 30;
    private static final int MAGIC_ATTACK_ADDITIONAL_BASIC = 20;


    /**
     * 格式化输出当前角色属性
     * @return 角色属性
     */
    public static String getStatInformation() {
        SaveData saveData = SaveData.getSaveData();

        String character = saveData.getPlayerCharacter().getNameID();
        int characterNum = saveData.getCharacter_Bag().get(character);
        int level = saveData.getPlayer_Level();

        String[] equipments = new String[4];
        equipments[0] = saveData.getEquipments()[0] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[0]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[0]) + "】";
        equipments[1] = saveData.getEquipments()[1] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[1]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[1]) + "】";
        equipments[2] = saveData.getEquipments()[2] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[2]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[2]) + "】";
        equipments[3] = saveData.getEquipments()[3] == null ? "" : "【" + (EquipmentManager.toEquipment(saveData.getEquipments()[3]).getOutPutName()) + "☆" + saveData.getPlayer_Bag().get(saveData.getEquipments()[3]) + "】";

        int[] stats = getStatArray();
        return String.format(
                "【%s☆%d】   Lv.%d\n 生命值:%d\n 物攻:%d 物理属性:%d 物抗:%d\n 法攻:%d 魔法属性:%d 法抗:%d\n------------------------------\n %s   %s\n %s   %s\n------------------------------\n%s%s",
                character,
                characterNum,
                level,
                stats[Param.STAT_HEALTH],
                stats[Param.STAT_ATTACK],
                stats[Param.STAT_PHYSICAL],
                stats[Param.STAT_PHYSICAL_RESISTANCE],
                stats[Param.STAT_MAGIC_ATTACK],
                stats[Param.STAT_MAGIC],
                stats[Param.STAT_MAGIC_RESISTANCE],
                equipments[0],
                equipments[1],
                equipments[2],
                equipments[3],
                getSkillGroup().formatSkillGroup().isEmpty() ? "" : "我的",
                getSkillGroup().formatSkillGroup()
        );
    }

    /**
     * 获取对象属性数组
     * @return 属性数组
     */
    public static int[] getStatArray() {
        int[] rtn = new int[7];
        rtn[Param.STAT_PHYSICAL] = getOne(Param.STAT_PHYSICAL);
        rtn[Param.STAT_MAGIC] = getOne(Param.STAT_MAGIC);
        rtn[Param.STAT_PHYSICAL_RESISTANCE] = getOne(Param.STAT_PHYSICAL_RESISTANCE);
        rtn[Param.STAT_MAGIC_RESISTANCE] = getOne(Param.STAT_MAGIC_RESISTANCE);
        rtn[Param.STAT_HEALTH] = getHealth();
        rtn[Param.STAT_ATTACK] = getAttack();
        rtn[Param.STAT_MAGIC_ATTACK] = getMagicAttack();
        return rtn;
    }

    /**
     * 计算玩家生命值
     * <p>计算公式：[基础值]+[等级]*[每等级加成]*[玩家阶层加成]+[装备提供的额外值]
     * @return 生命值
     */
    public static int getHealth() {
        SaveData saveData = SaveData.getSaveData();
        int level = saveData.getPlayer_Level();

        int additionalHealth = 0;
        for (String equipment : saveData.getEquipments()) {
            if (equipment == null) {
                continue;
            }
            additionalHealth += (int) (EquipmentManager.toEquipment(equipment).getEquipmentStat()[Param.STAT_HEALTH] * (1 + (saveData.getPlayer_Bag().get(equipment) * 0.1)));
        }

        return (int) (HEALTH_BASIC + additionalHealth + (HEALTH_ADDITIONAL_BASIC * (level) * (1 + (0.2 * (Hone.getLevelRank() - 1)))));
    }

    /**
     * 计算玩家物理攻击力
     * <p>计算公式：[基础值]+[等级]*[每等级加成]*[玩家阶层加成]+[装备提供的额外值]
     * @return 物理攻击力
     */
    public static int getAttack() {
        SaveData saveData = SaveData.getSaveData();
        int level = saveData.getPlayer_Level();

        int additionalAttack = 0;
        for (String equipment : saveData.getEquipments()) {
            if (equipment == null) {
                continue;
            }
            additionalAttack += (int) (EquipmentManager.toEquipment(equipment).getEquipmentStat()[Param.STAT_ATTACK] * (1 + (saveData.getPlayer_Bag().get(equipment) * 0.1)));
        }

        return (int) (ATTACK_BASIC + additionalAttack + (ATTACK_ADDITIONAL_BASIC * (level) * (1 + (0.1 * (Hone.getLevelRank() - 1)))));
    }

    /**
     * 计算玩家魔法攻击力
     * <p>计算公式：[基础值]+[等级]*[每等级加成]*[玩家阶层加成]+[装备提供的额外值]
     * @return 魔法攻击力
     */
    public static int getMagicAttack() {
        SaveData saveData = SaveData.getSaveData();
        int level = saveData.getPlayer_Level();

        int additionalMagicAttack = 0;
        for (String equipment : saveData.getEquipments()) {
            if (equipment == null) {
                continue;
            }
            additionalMagicAttack += (int) (EquipmentManager.toEquipment(equipment).getEquipmentStat()[Param.STAT_MAGIC_ATTACK] * (1 + (saveData.getPlayer_Bag().get(equipment) * 0.1)));
        }

        return (int) (MAGIC_ATTACK_BASIC + additionalMagicAttack + (MAGIC_ATTACK_ADDITIONAL_BASIC * (level) * (1 + (0.1 * (Hone.getLevelRank() - 1)))));
    }

    /**
     * 计算玩家的属性值
     * <p>计算公式：[基础值]*(1+[角色星级]/10)+[装备提供的额外值]
     * @param param 属性类型
     * @return 属性值
     */
    private static int getOne(int param) {
        SaveData saveData = SaveData.getSaveData();

        int rtn = 0;
        int characterNum = saveData.getCharacter_Bag().get(saveData.getPlayerCharacter().getNameID()) - 1;

        rtn += (int) (saveData.getPlayerCharacter().getStatNum()[param] * (1 + (characterNum * 0.1)));

        for (String equipment : saveData.getEquipments()) {
            if (equipment == null) {
                continue;
            }
            rtn += (int) (EquipmentManager.toEquipment(equipment).getEquipmentStat()[param] * (1 + (saveData.getPlayer_Bag().get(equipment) * 0.1)));
        }

        return rtn;
    }

    /**
     * 获取玩家的所有技能
     * @return 技能组
     */
    public static SkillGroup getSkillGroup() {
        SaveData saveData = SaveData.getSaveData();
        SkillGroup rtn = new SkillGroup();
        for (String equipment : saveData.getEquipments()) {
            if (EquipmentManager.toEquipment(equipment) != null && EquipmentManager.toEquipment(equipment).getSkillGroup() != null) {
                rtn.addSkillGroup(EquipmentManager.toEquipment(equipment).getSkillGroup());
            }
        }
        return rtn;
    }
}
