package com.central;

/**
 * 个个类之间通信用的标识
 */
public enum Signal {
    COMMAND_NOT_FOUND_ERROR("未找到此命令"),
    THING_NOT_FOUND_ERROR("未找到此物品"),
    THING_NOT_ENOUGH("物品数量不够"),
    MONEY_NOT_ENOUGH("金币不够"),
    EQUIPMENT_TOO_MUCH("装备栏已满"),
    DAY_QUEST_ACHIEVED("该任务今日已经完成过了"),
    QUEST_NOT_FOUND("未找到此任务"),
    RIGHT("正常"),
    NULL("null");

    private final String signal;

    Signal(String signal) {
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }
}
