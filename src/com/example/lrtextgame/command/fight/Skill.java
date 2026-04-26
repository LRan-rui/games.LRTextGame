package com.example.lrtextgame.command.fight;

/**
 * 技能类
 * @author 凌然
 */
public class Skill {
    private final String nameID;
    private final String level;
    //冷却时间
    private final int cooldownTime;
    private final int damagePercentMagic;
    private final int damagePercent;
    //目标数，为零表示全体伤害
    private final int damageNum;


    public  Skill(String nameID, String level, int cooldownTime, int damagePercentMagic, int damagePercent, int damageNum) {
        this.nameID = nameID;
        this.level = level;
        this.cooldownTime = cooldownTime;
        this.damagePercentMagic = damagePercentMagic;
        this.damagePercent = damagePercent;
        this.damageNum = damageNum;
    }

    public Skill(String nameID, String level, int cooldownTime, int damagePercentMagic, int damagePercent) {
        this(nameID,level,cooldownTime, damagePercentMagic,damagePercent,1);
    }

    public String getNameID() {
        return nameID;
    }

    public String getOutPutName(){
        return "%s级·%s".formatted(level,nameID);
    }

    public String formatSkill(){
        return "◆【%s级·%s】%s\n%s造成%s%s伤害".formatted(
                this.level,
                this.nameID,
                this.cooldownTime == 1 ? "" : " 冷却"+this.cooldownTime+"回合",
                this.damageNum == 1 ? "" : this.damageNum == 0 ? "对所有目标" : "对"+this.damageNum+"个目标",
                this.damagePercent == 0? "": this.damagePercent + "%物理",
                this.damagePercentMagic == 0 ? "" : this.damagePercent == 0 ? this.damagePercentMagic+"%魔法" : "和"+this.damagePercentMagic+"%魔法"
        );
    }

    public int getCooldownTime() {
        return cooldownTime;
    }

    public  int getDamagePercentMagic() {
        return damagePercentMagic;
    }

    public  int getDamagePercent() {
        return damagePercent;
    }

    public  int getDamageNum() {
        return damageNum;
    }
}
