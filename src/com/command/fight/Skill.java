package com.command.fight;

import com.command.Param;

public class Skill {
    private final String nameID;
    private final String level;
    private final int cooldownTime;
    private final int damageType;
    private final int damagePercent;
    private final int damageNum;

    public static final int PHYSICAL = 0;
    public static final int MAGIC = 1;

    public  Skill(String nameID, String level, int cooldownTime, int damageType, int damagePercent, int damageNum) {
        this.nameID = nameID;
        this.level = level;
        this.cooldownTime = cooldownTime;
        this.damageType = damageType;
        this.damagePercent = damagePercent;
        this.damageNum = damageNum;
    }

    public Skill(String nameID, String level, int cooldownTime, int damageType, int damagePercent) {
        this(nameID,level,cooldownTime,damageType,damagePercent,1);
    }

    public String getNameID() {
        return nameID;
    }

    public String formatSkill(){
        return "◆【%s级·%s】%s\n%s造成%s%%的%s伤害".formatted(
                this.level,
                this.nameID,
                this.cooldownTime == 1 ? "": " 冷却"+this.cooldownTime+"回合",
                this.damageNum == 1 ? "": this.damageNum == 0 ? "对所有目标" : "对"+this.damageNum+"个目标",
                this.damagePercent,
                this.damageType == PHYSICAL ? "物理" : "魔法"
        );
    }

    public static void main(String[] args) {
        System.out.println(new Skill("剑气", Param.B, 2, PHYSICAL, 300, 3).formatSkill());
        System.out.println(new Skill("湮没", Param.S, 6, MAGIC, 500, 0).formatSkill());
    }
}
