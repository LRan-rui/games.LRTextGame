package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.save.SaveData;

public class Fight {
    private final FightCharacter[] player;
    private final FightCharacter[] otherPlayers;

    private int turnNum = 0;
    private final FightMessage message = new FightMessage();

    private Fight(FightCharacter[] player, FightCharacter[] Others) {
        this.player = player;
        this.otherPlayers = Others.clone();
    }

    private boolean isEnd(){
        for(FightCharacter player : this.player) {
            if (player.isAlive()) return false;
        }
        for (FightCharacter other : otherPlayers){
            if (other.isAlive()) return false;
        }
        return true;
    }

//返回值待定
    public static FightMessage toFight(FightCharacter[] player, FightCharacter[] enemy) {
        Fight fight = new Fight(player,enemy);

        while (!fight.isEnd()){
            for(FightCharacter fightPlayer : fight.player){
                if (fightPlayer.isAlive()){
                    fightPlayer.attack(fight,enemy);
                }
            }
            if(fight.isEnd() && fight.message.getTitle() == Signal.FIGHT_WIN){
                fight.setMessage(player);
            }
            for (FightCharacter fightPlayer : fight.otherPlayers){
                if (fightPlayer.isAlive()){
                    fightPlayer.attack(fight,player);
                }
            }
            if(fight.isEnd() && fight.message.getTitle() == Signal.FIGHT_WIN){
                fight.setSignal(Signal.FIGHT_LOSS);
                fight.setMessage(player);
            }
        }
        return  fight.message;
    }

    public int addTurn(){
        turnNum++;
        return turnNum;
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

    public void setMessage(FightCharacter[] players) {
        StringBuilder sb = new StringBuilder();
        sb.append("第").append(this.turnNum).append("回合\n");
        for (FightCharacter player : players) {
            if (player.isAlive()) {
                sb.append(player.getName()).append(player.getHealth()).append("/").append(player.getMaxHealth()).append("\n");
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

    public static void main(String[] args) {
        SaveData.Start();
        SaveData saveData = SaveData.getSaveData();
        System.out.println(toFight(
                new FightCharacter[]{new FightCharacter(saveData.getPlayer_ID(),Stat.getStatArray(),Stat.getSkillGroup())},
                new FightCharacter[]{new FightCharacter("敌人1",new int[]{10,10,10,10,2000,200,100}),
                        new FightCharacter("敌人2",new int[]{10,10,10,10,2000,200,100}),
                        new FightCharacter("敌人3",new int[]{10,10,10,10,2000,200,100})}));
    }
}
