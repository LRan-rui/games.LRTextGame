package com.example.lrtextgame.command.fight;

import com.example.lrtextgame.central.Signal;

import java.util.ArrayList;

public class FightMessage {
    private Signal title;
    private String body;

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
