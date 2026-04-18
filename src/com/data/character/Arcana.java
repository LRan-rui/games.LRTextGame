package com.data.character;

import com.command.Param;

public enum Arcana implements Character {
    THE_FOOL("愚者", 0, "代表开始、天真与冒险，象征踏上未知旅程的初心。", 30 * 60 * 1000, new int[]{10, 50}, new int[]{0, 0, 0, 0}),
    THE_MAGICIAN("魔术师", 1, "代表创造力与行动力，能将意念转化为现实。", 40 * 60 * 1000, new int[]{20, 70}, new int[]{10, 20, 0, 10}),
    THE_HIGH_PRIESTESS("女祭司", 2, "代表直觉与内在智慧，需要静默与聆听才能领悟。", 40 * 60 * 1000, new int[]{15, 80}, new int[]{0, 30, 0, 30}),
    THE_EMPRESS("皇后", 3, "代表丰饶、母性与自然之美，体现物质世界的富足。", 60 * 60 * 1000, new int[]{60, 120}, new int[]{10, 10, 10, 10}),
    THE_EMPEROR("皇帝", 4, "代表丰饶、母性与自然之美，体现物质世界的富足。", 60 * 60 * 1000, new int[]{80, 100}, new int[]{10, 10, 10, 10}),
    THE_HIEROPHANT("教皇", 5, "代表传统、信仰与精神指引，是道德与教义的传递者。", 50 * 60 * 1000, new int[]{50, 100}, new int[]{10, 30, 0, 30}),
    THE_LOVERS("恋人", 6, "代表选择、爱情与价值观的考验，常面临两难抉择。", 13 * 60 * 1000 + 14 * 1000, new int[]{5, 25}, new int[]{10, 10, 0, 0}),
    THE_CHARIOT("战车", 7, "代表意志力与胜利，通过控制对立力量达成目标。", 30 * 60 * 1000, new int[]{10, 50}, new int[]{40, 0, 40, 0}),
    STRENGTH("力量", 8, "代表勇气与耐心，以柔克刚，用内心征服外在冲动。", 30 * 60 * 1000, new int[]{40, 50}, new int[]{50, 0, 30, 0}),
    THE_HERMIT("隐者", 9, "代表反省与孤独中的智慧，通过内省寻找答案。", 120 * 60 * 1000, new int[]{100, 300}, new int[]{10, 30, 30, 30}),
    THE_WHEEL_OF_FORTUNE("命运之轮", 10, "代表运势变化与循环，暗示人生起落无常。", 30 * 60 * 1000, new int[]{40, 100}, new int[]{50, 50, 50, 50}),
    JUSTICE("正义", 11, "代表公平、因果与真相，需要理性判断与诚实。", 50 * 60 * 1000, new int[]{60, 120}, new int[]{30, 10, 20, 10}),
    THE_HANGED_MAN("倒吊人", 12, "代表牺牲与换位思考，通过暂停与舍弃获得新视角。", 30 * 60 * 1000, new int[]{50, 90}, new int[]{10, 30, 0, 50}),
    DEATH("死神", 13, "代表结束与转变，旧事物的消亡为新生腾出空间。", 5 * 60 * 1000, new int[]{5, 25}, new int[]{60, 60, 0, 0}),
    TEMPERANCE("节制", 14, "代表平衡、调和与耐心，通过适度达成融合。", 360 * 60 * 1000, new int[]{300, 600}, new int[]{10, 10, 50, 50}),
    THE_DEVIL("恶魔", 15, "代表束缚、物质欲望与执念，揭示自己造出的牢笼。", 25 * 60 * 1000, new int[]{6, 66}, new int[]{40, 50, 0, 40}),
    THE_TOWER("塔", 16, "代表突变与崩溃，旧有结构被外力摧毁后重建。", 20 * 60 * 1000, new int[]{10, 40}, new int[]{70, 0, 0, 0}),
    THE_STAR("星星", 17, "代表希望、宁静与灵感，在混乱后迎来恢复。", 30 * 60 * 1000, new int[]{50, 60}, new int[]{20, 20, 20, 20}),
    THE_MOON("月亮", 18, "代表不安、幻觉与潜意识，需要穿越迷雾才能看清真相。", 30 * 60 * 1000, new int[]{50, 70}, new int[]{20, 30, 20, 30}),
    THE_SUN("太阳", 19, "代表成功、活力与快乐，一切明朗，充满生机。", 60 * 60 * 1000, new int[]{40, 100}, new int[]{30, 70, 10, 10}),
    JUDGEMENT("审判", 20, "代表觉醒与救赎，聆听内心召唤，获得重生。", 44 * 60 * 1000 + 44 * 1000, new int[]{20, 70}, new int[]{0, 100, 0, 0}),
    THE_WORLD("世界", 21, "代表完成与整合，达成圆满，一个周期的终点。", 60 * 60 * 1000, new int[]{90, 100}, new int[]{10, 10, 70, 60}),
    ;

    private final String NameID;
    private final int numID;
    private final String information;
    private final long HoneTime;
    private final int[] HoneLoot;

    private final int[] StatNum;

    Arcana(String name, int id, String information, long honeTime, int[] honeLoot, int[] statNum) {
        this.NameID = name;
        this.numID = id;
        this.information = information;
        this.HoneTime = honeTime;
        this.HoneLoot = honeLoot;
        this.StatNum = statNum;
    }

    public String getNameID() {
        return NameID;
    }

    public int getNumID() {
        return numID;
    }

    public String getInformation() {
        return "【%s】 %s\n------------------------\n%s\n------------------------\n修炼时间:%d分%d秒  [%d-%d]\n物理属性:%d 魔法属性:%d 物抗:%d 法抗:%d".formatted(NameID, Param.ROMAN_NUMERALS[getNumID()],information,HoneTime/60000,(HoneTime%60000)/1000,HoneLoot[0],HoneLoot[1],StatNum[0],StatNum[1],StatNum[2],StatNum[3]);
    }

    public long getHoneTime() {
        return HoneTime;
    }

    public int[] getHoneLoot() {
        return HoneLoot;
    }

    public int[] getStatNum() {
        return StatNum;
    }


}
