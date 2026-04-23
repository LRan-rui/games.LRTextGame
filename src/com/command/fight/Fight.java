package com.command.fight;

public class Fight {
    private final FightCharacter player;
    private final FightCharacter[] otherPlayers;

    private Fight(FightCharacter player, FightCharacter... Others) {
        this.player = player;
        this.otherPlayers = Others.clone();
    }

    private boolean isEnd(){
        if (this.player.getHealth() <=0) return true;
        for (FightCharacter other : otherPlayers){
            if (other.getHealth() > 0) return false;
        }
        return true;
    }

    public static String toFight(FightCharacter player, FightCharacter... Others) {
        Fight fight = new Fight(player, Others);
        while (!fight.isEnd()){
            player.attack(fight,Others);
            for (FightCharacter other : Others) {
                other.attack(fight,player);
            }
        }
        return "%s".formatted(player.getHealth() >0 ? "胜利" : "失败");
    }

    public FightCharacter[] getOtherPlayers() {
        return otherPlayers;
    }

    public FightCharacter getPlayer() {
        return player;
    }
}
