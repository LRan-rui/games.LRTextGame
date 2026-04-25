package com.example.lrtextgame.data.item.equipment;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.command.fight.Skill;
import com.example.lrtextgame.command.fight.SkillGroup;

public enum Staff implements Equipment{
    SHARDSTONE_STAFF(Param.D,"碎晶法杖","杖顶嵌碎晶，敲击迸发锐利光屑，灼伤目标。",new int[]{0,0,0,0,0,0,50},true,
            new SkillGroup(new Skill("光之攻击",Param.D,1,100,0,1))),
    GLOWSTONE_STAFF(Param.C,"辉光法杖","杖头固定辉光岩，持续发光，亦可甩出光斑击眼。",new int[]{0,5,0,0,0,0,100},true,
            new SkillGroup(new Skill("辉光",Param.C,1,110,0,1))),
    DARK_CRYSTAL_STAFF(Param.B,"黯晶法杖","固定着暗晶煤的精华，甩出幽焰，附着燃烧。",new int[]{0,10,0,0,0,0,200},true,
            new SkillGroup(new Skill("黯默",Param.B,1,150,0,1),
                    new Skill("黯焰",Param.B,3,100,0,3))),
    OBSIDIAN_STAFF(Param.S,"黑曜石法杖","纯粹的黑曜石打造，朴实无华的力量",new int[]{0,35,0,10,0,0,1000},true,
            new SkillGroup(new Skill("黑曜石之力",Param.S,1,400,0,1))),
    DRAGON_BLOOD_STAFF(Param.S,"龙血杖","血檀木浸润龙血树脂，释放炎爆，点燃区域。",new int[]{0,40,0,0,0,0,1000},true,
            new SkillGroup(new Skill("血色",Param.S,1,250,0,1),
                    new Skill("君焰",Param.S,2,200,0,0))),
    GOLDEN_NANMU_SCEPTRE(Param.S,"金丝楠权杖","金丝楠与秘钢合制，传导能量，发射高能冲击。",new int[]{0,50,0,0,0,0,1000},true,
            new SkillGroup(new Skill("权力",Param.S,1,300,100,1),
                    new Skill("皇权",Param.S,5,1000,400,1))),
    OBSIDIAN_DRAGON_STAFF(Param.S,"玄龙权杖","你能想象到的最高法力。",new int[]{0,100,0,0,0,0,2000},true,
            new SkillGroup(new Skill("黑龙吟",Param.S,1,500,0,1),
                    new Skill("血色将至",Param.S,3,500,0,0),
                    new Skill("血色已至",Param.S,7,2500,0,0))),
    ;

    private final String nameID;
    private final String level;
    private final String information;
    private final int[] equipmentStat;
    private final boolean canCraft;
    private final SkillGroup skillGroup;

    Staff(String level,String nameID,String information,int[] equipmentStat){
        this(level,nameID,information,equipmentStat,false,new SkillGroup());
    }

    Staff(String level,String nameID,String information,int[] equipmentStat,boolean canCraft,SkillGroup skillGroup){
        this.nameID = nameID;
        this.level = level;
        this.information = information;
        this.equipmentStat = equipmentStat;
        this.canCraft = canCraft;
        this.skillGroup = skillGroup;
    }

    Staff(String level,String nameID,String information,int[] equipmentStat,boolean canCraft){
        this(level,nameID,information,equipmentStat,canCraft,new SkillGroup());
    }

    @Override
    public int[] getEquipmentStat() {
        return this.equipmentStat;
    }

    @Override
    public SkillGroup getSkillGroup() {
        return this.skillGroup;
    }

    @Override
    public String toUse() {
        return Signal.THING_CANNOT_USE.getSignal();
    }

    @Override
    public String getOutPutName() {
        return "%s级·%s🗡%s".formatted(level,(level.equals(Param.S) | level.equals(Param.A) ? "✨": ""),nameID);
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
