package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.Param;

import java.util.HashMap;

/**
 * 战斗对象类
 * @author 凌然
 */
public class FightCharacter {
    private final String name;
    private final int physical;
    private final int magic;
    private final int physical_resistance;
    private final int magic_resistance;
    private final int maxHealth;
    private final int attack;
    private final int magic_attack;

    private final HashMap<Skill, Integer> skills = new HashMap<>();

    private int health;
    private boolean alive;

    private final Skill normalSkill = new Skill("普攻", Param.D, 1, 0, 100, 1);

    public FightCharacter(String name, int physical, int magic, int physical_resistance, int magic_resistance, int maxHealth, int attack, int magic_attack, SkillGroup skillGroup) {
        this.name = name;
        this.physical = physical;
        this.magic = magic;
        this.physical_resistance = physical_resistance;
        this.magic_resistance = magic_resistance;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.magic_attack = magic_attack;
        this.skills.put(normalSkill, 1);
        for (Skill skill : skillGroup.getSkills()) {
            this.skills.put(skill, skill.getCooldownTime());
        }

        this.health = maxHealth;
        this.alive = true;
    }

    public FightCharacter(String name,int physical, int magic, int physical_resistance, int magic_resistance, int maxHealth, int attack, int magic_attack) {
        this(name,physical, magic, physical_resistance, magic_resistance, maxHealth, attack, magic_attack, new SkillGroup());
    }

    public FightCharacter(String name,int[] stat) {
        this(name,stat[0], stat[1], stat[2], stat[3], stat[4], stat[5], stat[6], new SkillGroup());
    }

    public FightCharacter(String name,int[] stat, SkillGroup skillGroup) {
        this(name,stat[0], stat[1], stat[2], stat[3], stat[4], stat[5], stat[6], skillGroup);
    }


    /**
     * 攻击敌方
     * <p>选择造成伤害最多的技能使用，
     * 对敌方造成相应的伤害
     * @param fight 战斗数据类
     * @param other 敌方
     */
    public void attack(Fight fight, FightCharacter other) {
        attack(fight,new FightCharacter[]{other});
    }

    /**
     * 攻击敌方
     * <p>选择造成伤害最多的技能使用，
     * 对敌方造成相应的伤害
     * @param fight 战斗数据类
     * @param others 敌方
     */
    public void attack(Fight fight, FightCharacter[] others) {

        int enemyNum = 0;
        for (FightCharacter other : others) {
            if (other.isAlive()) {
                enemyNum++;
            }
        }

        if (enemyNum == 0) return;

        Skill toUseSkill = normalSkill;
        int maxDamage = 0;
        //选择伤害量最大的技能
        for (Skill skill : skills.keySet()) {
            if (skills.get(skill) != 1) {
                continue;
            }
            int x = computeDamage(skill,others,enemyNum);
            if(x > maxDamage) {
                maxDamage = x;
                toUseSkill = skill;
            }
        }
        useSkill(toUseSkill,others,enemyNum,fight);

        //刷新技能冷却
        refresh();
        //判断是否全歼敌方
        for (FightCharacter other : others) {
            if (other.isAlive()) {
                return;
            }
        }
        //告诉战斗已经结束
        fight.setSignal(Signal.FIGHT_WIN);
    }

    /**
     * 计算技能能造成的伤害量
     * @param skill 技能
     * @param enemy 敌方
     * @param enemyNum 敌方的数量
     * @return 伤害量
     */
    private int computeDamage(Skill skill, FightCharacter[] enemy, int enemyNum) {
        int damage = 0;
        if (skill.getDamageNum() != 0 && skill.getDamageNum() < enemyNum) {
            enemyNum = skill.getDamageNum();
        }
        for (int i = 0; i < enemyNum; i++) {
            damage += (getAttack() * (Math.max(100 + getPhysical() - enemy[i].getPhysical(), 0)) * skill.getDamagePercent() / 10000)
                    + (getMagic_attack() * (Math.max(100 + getMagic() - enemy[i].getMagic(), 0)) * skill.getDamagePercentMagic() / 10000);
        }
        return damage;
    }

    /**
     * 使用技能对敌方造成伤害
     * @param skill 技能
     * @param enemy 敌方
     * @param enemyNum 敌方的数量
     * @param fight 战斗数据类
     */
    public void useSkill(Skill skill, FightCharacter[] enemy, int enemyNum,Fight fight) {
        StringBuilder logText = new StringBuilder("%s使用了【%s】,".formatted(this.getName(),skill.getOutPutName()));

        skills.put(skill,skill.getCooldownTime());

        if (skill.getDamageNum() != 0 && skill.getDamageNum() < enemyNum) {
            enemyNum = skill.getDamageNum();
        }

        int damage = 0;
        int damageMagic = 0;
        int j = 0;
        for (int i = 0; j < enemyNum; i++) {
            if(!enemy[i].isAlive()) {continue;}
            //计算物理伤害
            damage = (getAttack() * (Math.max(100 + getPhysical() - enemy[i].getPhysical_resistance(), 0)) * skill.getDamagePercent() / 10000);
            //计算魔法伤害
            damageMagic = (getMagic_attack() * (Math.max(100 + getMagic() - enemy[i].getMagic_resistance(), 0)) * skill.getDamagePercentMagic() / 10000);
            //施加伤害
            enemy[i].subHealth(damage + damageMagic);
            //可用append优化字符串拼接
            logText.append("对%s造成了%s%s，剩余血量%s".formatted(
                    enemy[i].getName(),
                    skill.getDamagePercent() == 0 ? "" :
                            "%d点(%d%%)物理伤害%s".formatted(
                                    damage,
                                    (Math.max(100 + getPhysical() - enemy[i].getPhysical_resistance(), 0) * skill.getDamagePercent() / 100),
                                    skill.getDamagePercentMagic() == 0 ? "" : "和"
                            ),
                    skill.getDamagePercentMagic() == 0 ? "" :
                            "%d点(%d%%)魔法伤害".formatted(
                                    damageMagic,
                                    (Math.max(100 + getMagic() - enemy[i].getMagic_resistance(), 0) * skill.getDamagePercentMagic() / 100)
                            ),
                    "%d/%d%s%s".formatted(
                            enemy[i].getHealth(),
                            enemy[i].getMaxHealth(),
                            enemy[i].getHealth() == 0 ? "·已阵亡" : "",
                            i == enemyNum - 1 ? "。" : "，"
                            )
            ));
            j++;
        }
        fight.addLog(logText.toString());
    }

    /**
     * 刷新技能冷却
     */
    private void refresh(){
        for (Skill skill : skills.keySet()) {
            if(skills.get(skill) != 1){
                skills.put(skill,skills.get(skill) - 1);
            }
        }
    }

    public int getMagic() {
        return magic;
    }

    public int getPhysical() {
        return physical;
    }

    public int getPhysical_resistance() {
        return physical_resistance;
    }

    public int getMagic_resistance() {
        return magic_resistance;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getMagic_attack() {
        return magic_attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * 受到伤害
     * @param subHealth 伤害量
     */
    public void subHealth(int subHealth) {
        this.health -= subHealth;
        if (this.health <= 0) {
            this.alive = false;
            health = 0;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }
}
