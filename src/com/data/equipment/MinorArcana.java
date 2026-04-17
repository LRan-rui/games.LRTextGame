package com.data.equipment;

public class MinorArcana {
    public enum Wands implements Equipment {
        ACE_OF_WANDS("权杖I", 1, "", new int[]{0, 0, 0, 0, 0, 0}),
        TWO_OF_WANDS("权杖II", 2, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        THREE_OF_WANDS("权杖III", 3, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FOUR_OF_WANDS("权杖IV", 4, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FIVE_OF_WANDS("权杖V", 5, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SIX_OF_WANDS("权杖VI", 6, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SEVEN_OF_WANDS("权杖VII", 7, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        EIGHT_OF_WANDS("权杖VIII", 8, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        NINE_OF_WANDS("权杖IX", 9, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TEN_OF_WANDS("权杖X", 10, "", new int[]{0, 0, 0, 0, 0, 0, 0}),

        PAGE_OF_WANDS("权杖侍从", 11, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KNIGHT_OF_WANDS("权杖骑士", 12, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        QUEEN_OF_WANDS("权杖王后", 13, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KING_OF_WANDS("权杖国王", 14, "", new int[]{0, 0, 0, 0, 0, 0, 0});

        private final String nameID;
        private final int value;
        private final String information;
        private final int[] equipmentStat;

        Wands(String nameID, int value, String information, int[] equipmentStat) {
            this.nameID = nameID;
            this.value = value;
            this.information = information;
            this.equipmentStat = equipmentStat;
        }

        public String getNameID() {
            return nameID;
        }

        public int getValue() {
            return value;
        }

        public int[] getEquipmentStat() {
            return equipmentStat;
        }

        public String getInformation() {
            return information;
        }
    }

    public enum Cups implements Equipment {
        ACE_OF_CUPS("圣杯I", 1, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TWO_OF_CUPS("圣杯II", 2, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        THREE_OF_CUPS("圣杯III", 3, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FOUR_OF_CUPS("圣杯IV", 4, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FIVE_OF_CUPS("圣杯V", 5, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SIX_OF_CUPS("圣杯VI", 6, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SEVEN_OF_CUPS("圣杯VII", 7, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        EIGHT_OF_CUPS("圣杯VIII", 8, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        NINE_OF_CUPS("圣杯IX", 9, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TEN_OF_CUPS("圣杯X", 10, "", new int[]{0, 0, 0, 0, 0, 0, 0}),

        PAGE_OF_CUPS("圣杯侍从", 11, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KNIGHT_OF_CUPS("圣杯骑士", 12, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        QUEEN_OF_CUPS("圣杯王后", 13, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KING_OF_CUPS("圣杯国王", 14, "", new int[]{0, 0, 0, 0, 0, 0, 0});

        private final String nameID;
        private final int value;
        private final String information;
        private final int[] equipmentStat;

        Cups(String nameID, int value, String information, int[] equipmentStat) {
            this.nameID = nameID;
            this.value = value;
            this.information = information;
            this.equipmentStat = equipmentStat;
        }

        public String getNameID() {
            return nameID;
        }

        public int getValue() {
            return value;
        }

        public int[] getEquipmentStat() {
            return equipmentStat;
        }

        public String getInformation() {
            return information;
        }
    }

    public enum Swords implements Equipment {
        ACE_OF_SWORDS("宝剑I", 1, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TWO_OF_SWORDS("宝剑II", 2, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        THREE_OF_SWORDS("宝剑III", 3, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FOUR_OF_SWORDS("宝剑IV", 4, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FIVE_OF_SWORDS("宝剑V", 5, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SIX_OF_SWORDS("宝剑VI", 6, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SEVEN_OF_SWORDS("宝剑VII", 7, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        EIGHT_OF_SWORDS("宝剑VIII", 8, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        NINE_OF_SWORDS("宝剑IX", 9, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TEN_OF_SWORDS("宝剑X", 10, "", new int[]{0, 0, 0, 0, 0, 0, 0}),

        PAGE_OF_SWORDS("宝剑侍从", 11, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KNIGHT_OF_SWORDS("宝剑骑士", 12, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        QUEEN_OF_SWORDS("宝剑王后", 13, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KING_OF_SWORDS("宝剑国王", 14, "", new int[]{0, 0, 0, 0, 0, 0, 0});

        private final String nameID;
        private final int value;
        private final String information;
        private final int[] equipmentStat;

        Swords(String nameID, int value, String information, int[] equipmentStat) {
            this.nameID = nameID;
            this.value = value;
            this.information = information;
            this.equipmentStat = equipmentStat;
        }

        public String getNameID() {
            return nameID;
        }

        public int getValue() {
            return value;
        }

        public int[] getEquipmentStat() {
            return equipmentStat;
        }

        public String getInformation() {
            return information;
        }
    }

    public enum Pentacles implements Equipment {
        ACE_OF_PENTACLES("星币I", 1, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TWO_OF_PENTACLES("星币II", 2, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        THREE_OF_PENTACLES("星币III", 3, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FOUR_OR_PENTACLES("星币IV", 4, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        FIVE_OF_PENTACLES("星币V", 5, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SIX_OF_PENTACLES("星币VI", 6, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        SEVEN_OF_PENTACLES("星币VII", 7, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        EIGHT_OF_PENTACLES("星币VIII", 8, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        NINE_OF_PENTACLES("星币IX", 9, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        TEN_OF_PENTACLES("星币X", 10, "", new int[]{0, 0, 0, 0, 0, 0, 0}),

        PAGE_OF_PENTACLES("星币侍从", 11, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KNIGHT_OF_PENTACLES("星币骑士", 12, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        QUEEN_OF_PENTACLES("星币王后", 13, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        KING_OF_PENTACLES("星币国王", 14, "", new int[]{0, 0, 0, 0, 0, 0, 0}),
        ;

        private final String nameID;
        private final int value;
        private final String information;
        private final int[] equipmentStat;

        Pentacles(String nameID, int value, String information, int[] equipmentStat) {
            this.nameID = nameID;
            this.value = value;
            this.information = information;
            this.equipmentStat = equipmentStat;
        }

        public String getNameID() {
            return nameID;
        }

        public int getValue() {
            return value;
        }

        public int[] getEquipmentStat() {
            return equipmentStat;
        }

        public String getInformation() {
            return information;
        }
    }
}

