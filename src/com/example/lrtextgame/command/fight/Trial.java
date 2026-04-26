package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.save.SaveData;

/**
 * 试炼玩法类
 * @author 凌然
 */
public class Trial {

    private static final int HEALTH_BASIC = 1500;
    private static final int ATTACK_BASIC = 200;
    private static final int MAGIC_ATTACK_BASIC = 50;
    private static final int HEALTH_ADDITIONAL_BASIC = 100;
    private static final int ATTACK_ADDITIONAL_BASIC = 30;
    private static final int MAGIC_ATTACK_ADDITIONAL_BASIC = 20;

    private static final int MINION = 0;
    private static final int WARLOCK = 1;
    private static final int TITAN = 2;

    private static final Skill[] skills = {
            new Skill("抓挠", Param.D,2,0,120,1),
            new Skill("魔弹", Param.D,2,200,0,1),
            new Skill("撞击", Param.D,3,0,200,3),
    };

    /**
     * 开始试炼
     * @return 试炼结果
     */
    public static String fightTrialTower(){
        SaveData saveData = SaveData.getSaveData();
        //获取已挑战层数
        int floor = saveData.getProperty_Pool().getOrDefault(Param.TOWER_FLOOR,0);
        //挑战下一层
        floor++;
        //计算生成的敌人数量
        int num = Math.min(((floor / 10) + 1),10);
        FightCharacter[] fightCharacters = new FightCharacter[num];
        for(int i=0;i<num;i++){
            //生成敌人，类型交替
            fightCharacters[i] = getNowFightCharacter(floor,i % 3);
        }
        //导入玩家对象
        FightCharacter player = new FightCharacter(saveData.getPlayer_ID(),Stat.getStatArray(),Stat.getSkillGroup());
        //战斗
        FightMessage fightMessage = Fight.toFight(new FightCharacter[]{player},fightCharacters);

        //胜利奖励
        if(fightMessage.getTitle() == Signal.FIGHT_WIN) {
            saveData.getProperty_Pool().put(Param.TOWER_FLOOR, floor);
            saveData.setMoney(saveData.getMoney() + 100);
            saveData.setJewel(saveData.getJewel() + 10);
            saveData.setExperience_Points(saveData.getExperience_Points() + 50);
        }

        return "%s 第%d层 [战斗日志]\n%s%s".formatted(
                fightMessage.getTitle() == Signal.FIGHT_WIN ? "战斗胜利！": "战斗失败！",
                floor,
                fightMessage.getBody(),
                fightMessage.getTitle() == Signal.FIGHT_WIN ? "获得100金币 10宝石 50经验" : ""
                );
    }

    /**
     * 根据层数生成不同强度的敌人
     * @param floor 层数
     * @param type 敌人的类型
     * @return 敌人对象
     */
    private static FightCharacter getNowFightCharacter(int floor,int type) {
        int physical = Math.min(floor,100);
        int magic = Math.min(floor,100);
        int physicalResistance = Math.min(floor,99);
        int magicResistance = Math.min(floor,99);
        int health = HEALTH_BASIC + HEALTH_ADDITIONAL_BASIC * floor;
        int attack = ATTACK_BASIC + ATTACK_ADDITIONAL_BASIC * floor;
        int magicAttack = MAGIC_ATTACK_BASIC + MAGIC_ATTACK_ADDITIONAL_BASIC * floor;

        String name = "";

        switch (type) {
            case MINION:{
                health = (int) ( health * 1.2);
                physical = physical + 20;
                name = "爪牙";
                break;
            }
            case WARLOCK:{
                magic = magic + 20;
                name = "术士";
                break;
            }
            case TITAN:{
                health = health * 2;
                physicalResistance = physicalResistance + 20;
                name = "泰坦";
                break;
            }
        }

        return new FightCharacter(name,physical,magic,physicalResistance,magicResistance,health,attack,magicAttack,new SkillGroup(skills[type]));
    }
}
