package com.data.character;

public enum Arcana implements Character {
    THE_FOOL("愚者", 0, "", 30 * 60 * 1000, new int[]{10, 50}, new int[]{0, 0, 0, 0}),
    THE_MAGICIAN("魔术师", 1, "", 40 * 60 * 1000, new int[]{20, 70}, new int[]{10, 20, 0, 10}),
    THE_HIGH_PRIESTESS("女祭司", 2, "", 40 * 60 * 1000, new int[]{15, 80}, new int[]{0, 30, 0, 30}),
    THE_EMPRESS("皇后", 3, "", 60 * 60 * 1000, new int[]{60, 120}, new int[]{10, 10, 10, 10}),
    THE_EMPEROR("皇帝", 4, "", 60 * 60 * 1000, new int[]{80, 100}, new int[]{10, 10, 10, 10}),
    THE_HIEROPHANT("教皇", 5, "", 50 * 60 * 1000, new int[]{50, 100}, new int[]{10, 30, 0, 30}),
    THE_LOVERS("恋人", 6, "", 13 * 60 * 1000 + 14 * 1000, new int[]{5, 25}, new int[]{10, 10, 0, 0}),
    THE_CHARIOT("战车", 7, "", 30 * 60 * 1000, new int[]{10, 50}, new int[]{40, 0, 40, 0}),
    STRENGTH("力量", 8, "", 30 * 60 * 1000, new int[]{40, 50}, new int[]{50, 0, 30, 0}),
    THE_HERMIT("隐者", 9, "", 120 * 60 * 1000, new int[]{100, 300}, new int[]{10, 30, 30, 30}),
    THE_WHEEL_OF_FORTUNE("命运之轮", 10, "", 30 * 60 * 1000, new int[]{40, 100}, new int[]{50, 50, 50, 50}),
    JUSTICE("正义", 11, "", 50 * 60 * 1000, new int[]{60, 120}, new int[]{30, 10, 20, 10}),
    THE_HANGED_MAN("倒吊人", 12, "", 30 * 60 * 1000, new int[]{50, 90}, new int[]{10, 30, 0, 50}),
    DEATH("死神", 13, "", 5 * 60 * 1000, new int[]{5, 25}, new int[]{60, 60, 0, 0}),
    TEMPERANCE("节制", 14, "", 360 * 60 * 1000, new int[]{300, 600}, new int[]{10, 10, 50, 50}),
    THE_DEVIL("恶魔", 15, "", 25 * 60 * 1000, new int[]{6, 66}, new int[]{40, 50, 0, 40}),
    THE_TOWER("塔", 16, "", 20 * 60 * 1000, new int[]{10, 40}, new int[]{70, 0, 0, 0}),
    THE_STAR("星星", 17, "", 30 * 60 * 1000, new int[]{50, 60}, new int[]{20, 20, 20, 20}),
    THE_MOON("月亮", 18, "", 30 * 60 * 1000, new int[]{50, 70}, new int[]{20, 30, 20, 30}),
    THE_SUN("太阳", 19, "", 60 * 60 * 1000, new int[]{40, 100}, new int[]{30, 70, 10, 10}),
    JUDGEMENT("审判", 20, "", 44 * 60 * 1000 + 44 * 1000, new int[]{20, 70}, new int[]{0, 100, 0, 0}),
    THE_WORLD("世界", 21, "", 60 * 60 * 1000, new int[]{90, 100}, new int[]{10, 10, 70, 60}),
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
        return information;
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
