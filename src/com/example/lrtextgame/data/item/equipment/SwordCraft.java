package com.example.lrtextgame.data.item.equipment;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.command.fight.Skill;
import com.example.lrtextgame.command.fight.SkillGroup;


public enum SwordCraft implements Equipment{
    TIN_SWORD(Param.C,"锡剑","用锡打造的剑，质地较软，是较易获得的武器",new int[]{0,0,0,0,0,100,0},true),
    SILVER_SWORD(Param.A,"银剑","用银打造的利器，具有不俗的杀伤力",new int[]{10,10,0,0,0,1000,500},true,
            new SkillGroup(new Skill("斩魔",Param.B,1,100,100,1),
                    new Skill("破魔",Param.A,4,200,200,3))),

    ;

    private final String nameID;
    private final String level;
    private final String information;
    private final int[] equipmentStat;
    private final boolean canCraft;
    private final SkillGroup skillGroup;

    SwordCraft(String level,String nameID,String information,int[] equipmentStat){
        this(level,nameID,information,equipmentStat,false,new SkillGroup());
    }

    SwordCraft(String level,String nameID,String information,int[] equipmentStat,boolean canCraft,SkillGroup skillGroup){
        this.nameID = nameID;
        this.level = level;
        this.information = information;
        this.equipmentStat = equipmentStat;
        this.canCraft = canCraft;
        this.skillGroup = skillGroup;
    }

    SwordCraft(String level,String nameID,String information,int[] equipmentStat,boolean canCraft){
        this(level,nameID,information,equipmentStat,canCraft,new SkillGroup());
    }

    @Override
    public int[] getEquipmentStat() {
        return this.equipmentStat;
    }

    @Override
    public SkillGroup getSkillGroup() {
        return skillGroup;
    }

    @Override
    public String getOutPutName() {
        return "%s级·%s🗡%s".formatted(level,(level.equals(Param.S) | level.equals(Param.A) ? "✨": ""),nameID);
    }

    @Override
    public String toUse() {
        return Signal.THING_CANNOT_USE.getSignal();
    }

    @Override
    public String getNameID() {
        return this.nameID;
    }

    @Override
    public String getInformation() {
        return "【%s】%s\n%s\n%s%s%s%s%s%s%s%s".formatted(
                getOutPutName(),
                canCraft ? "  来源·合成":"",
                information,
                (equipmentStat[Param.STAT_PHYSICAL] == 0 ? "":"物理属性+"+equipmentStat[Param.STAT_PHYSICAL]+" "),
                (equipmentStat[Param.STAT_MAGIC] == 0 ? "":"魔法属性+"+equipmentStat[Param.STAT_MAGIC]+" "),
                (equipmentStat[Param.STAT_PHYSICAL_RESISTANCE] == 0 ? "":"物抗+"+equipmentStat[Param.STAT_PHYSICAL_RESISTANCE]+" "),
                (equipmentStat[Param.STAT_MAGIC_RESISTANCE] == 0 ? "":"法抗+"+equipmentStat[Param.STAT_MAGIC_RESISTANCE]+" "),
                (equipmentStat[Param.STAT_HEALTH] == 0 ? "":"生命值+"+equipmentStat[Param.STAT_HEALTH]+" "),
                (equipmentStat[Param.STAT_ATTACK] == 0 ? "":"物攻+"+equipmentStat[Param.STAT_ATTACK]+" "),
                (equipmentStat[Param.STAT_MAGIC_ATTACK] == 0 ? "":"法攻+"+equipmentStat[Param.STAT_MAGIC_ATTACK]),
                skillGroup.formatSkillGroup().equals("技能:") ? "" : "\n"+skillGroup.formatSkillGroup()
        );
    }
}
