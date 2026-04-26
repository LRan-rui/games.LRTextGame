package com.example.lrtextgame.command.quest;

import com.example.lrtextgame.data.Zero;

/**
 * 任务接口
 */
public interface Quest extends Zero {
    String getQuestStat();
    String achieve();
}
