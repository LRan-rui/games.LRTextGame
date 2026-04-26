package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.save.SaveData;

/**
 * 战斗相关方法
 * <p>也作为数据类
 * @author 凌然
 */
public class Fight {
    private final FightCharacter[] player;
    private final FightCharacter[] otherPlayers;

    private int turnNum = 0;
    private final FightMessage message = new FightMessage();

    private Fight(FightCharacter[] player, FightCharacter[] Others) {
        this.player = player;
        this.otherPlayers = Others.clone();
    }

    /**
     * 判断战斗是否结束
     * @return 是否结束
     */
    private boolean isEnd(){
        boolean playerEnd = true;
        boolean otherPlayerEnd = true;
        for(FightCharacter player : this.player) {
            if (player.isAlive()) {
                playerEnd = false;
                break;
            }
        }
        for (FightCharacter other : otherPlayers){
            if (other.isAlive()) {
                otherPlayerEnd = false;
                break;
            }
        }
        return playerEnd || otherPlayerEnd;
    }

    /**
     * 进行一场战斗
     * @param player 玩家方
     * @param enemy 敌人方
     * @return 战斗结果
     */
    public static FightMessage toFight(FightCharacter[] player, FightCharacter[] enemy) {
        Fight fight = new Fight(player,enemy);

        while (!fight.isEnd()){
            fight.addTurn();
            for(FightCharacter fightPlayer : fight.player){
                if (fightPlayer.isAlive()){
                    fightPlayer.attack(fight,enemy);
                }
            }
            if(fight.isEnd() && fight.message.getTitle() == Signal.FIGHT_WIN){
                fight.setMessage(player);
                break;
            }
            for (FightCharacter fightPlayer : fight.otherPlayers){
                if (fightPlayer.isAlive()){
                    fightPlayer.attack(fight,player);
                }
            }
            if(fight.isEnd() && fight.message.getTitle() == Signal.FIGHT_WIN){
                fight.setSignal(Signal.FIGHT_LOSS);
                fight.setMessage(enemy);
                break;
            }
        }
        FightMessage.saveMessage(fight.message);
        return  fight.message;
    }

    public void addTurn(){
        turnNum++;
    }

    public int getTurnNum(){
        return turnNum;
    }

    public void addLog(String log){
        message.addLog("第%d回合·%s".formatted(getTurnNum(),log));
    }

    public void setSignal(Signal signal) {
        message.setTitle(signal);
    }

    /**
     * 设置ToFight的返回结果
     * @param players 胜利方
     */
    public void setMessage(FightCharacter[] players) {
        StringBuilder sb = new StringBuilder();
        sb.append("第").append(this.turnNum).append("回合结束\n");
        for (FightCharacter player : players) {
            if (player.isAlive()) {
                sb.append(player.getName()).append(" 剩余血量").append(player.getHealth()).append("/").append(player.getMaxHealth()).append("\n");
            }
        }
        message.setBody(sb.toString());
    }

    public FightCharacter[] getOtherPlayers() {
        return otherPlayers;
    }

    public FightCharacter[] getPlayer() {
        return player;
    }
}
