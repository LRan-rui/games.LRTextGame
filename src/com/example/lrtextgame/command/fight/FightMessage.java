package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.central.Signal;

import java.util.ArrayList;

/**
 * 战斗结果信息
 * @author 凌然
 */
public class FightMessage {
    private Signal title;
    private String body;

    //缓存的战斗日志
    private static FightMessage fightMessage =  new FightMessage();

    public static void saveMessage(FightMessage message){
        fightMessage = message;
    }

    public static FightMessage getMessage(){
        return fightMessage;
    }

    //日志列表
    private final ArrayList<String> logText = new ArrayList<>();

    public FightMessage() {
        title = Signal.NULL;
        body = "";
    }

    public String[]  getLogList() {
        return logText.toArray(new String[0]);
    }

    public String getLogText(){
        StringBuilder s = new StringBuilder();
        for (String line : logText){
            s.append(line).append("\n");
        }
        return s.toString();
    }

    public void addLog(String log){
        logText.add(log);
    }

    public void  setTitle(Signal title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Signal getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
