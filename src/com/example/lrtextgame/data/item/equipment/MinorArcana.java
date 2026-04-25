package com.example.lrtextgame.data.item.equipment;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.Param;
import com.example.lrtextgame.command.fight.SkillGroup;

public class MinorArcana {
    public enum Wands implements Equipment {
        ACE_OF_WANDS("权杖I", 1, "新行动或事业的开始，充满创造潜力与能量。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        TWO_OF_WANDS("权杖II", 2, "在已有基础上规划下一步，权衡冒险与保守。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        THREE_OF_WANDS("权杖III", 3, "远见带来初步成功，等待合作或贸易的回报。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        FOUR_OF_WANDS("权杖IV", 4, "稳固的庆祝，团队或家庭的和谐与安全感。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        FIVE_OF_WANDS("权杖V", 5, "相互竞争或混战，为规则或领导权争斗。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        SIX_OF_WANDS("权杖VI", 6, "胜利与公开认可，带着荣耀凯旋。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        SEVEN_OF_WANDS("权杖VII", 7, "防守优势地位，顶住压力不退让。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        EIGHT_OF_WANDS("权杖VIII", 8, "快速行动，消息或事件迅速抵达。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        NINE_OF_WANDS("权杖IX", 9, "疲惫的守卫状态，警惕最后一次攻击。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        TEN_OF_WANDS("权杖X", 10, "负担过重，为了责任辛苦支撑。", new int[]{0, 5, 0, 0, 0, 0, 0}),

        PAGE_OF_WANDS("权杖侍从", 11, "热情的新消息，学习机会，好奇心能量。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        KNIGHT_OF_WANDS("权杖骑士", 12, "火热的行动力，奔赴目标或战争，冒险精神。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        QUEEN_OF_WANDS("权杖王后", 13, "明亮独立的气质，专注的事业掌控力。", new int[]{0, 5, 0, 0, 0, 0, 0}),
        KING_OF_WANDS("权杖国王", 14, "成熟的领导力，丰富的经验与创业精神。", new int[]{0, 5, 0, 0, 0, 0, 0});

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

        @Override
        public SkillGroup getSkillGroup() {
            return null;
        }

        public String getInformation() {
            return "【%s】\n%s\n%s%s%s%s%s%s%s".formatted(
                    getOutPutName(),
                    information,
                    (equipmentStat[Param.STAT_PHYSICAL] == 0 ? "":"物理属性+"+equipmentStat[Param.STAT_PHYSICAL]+" "),
                    (equipmentStat[Param.STAT_MAGIC] == 0 ? "":"魔法属性+"+equipmentStat[Param.STAT_MAGIC]+" "),
                    (equipmentStat[Param.STAT_PHYSICAL_RESISTANCE] == 0 ? "":"物抗+"+equipmentStat[Param.STAT_PHYSICAL_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_MAGIC_RESISTANCE] == 0 ? "":"法抗+"+equipmentStat[Param.STAT_MAGIC_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_HEALTH] == 0 ? "":"生命值+"+equipmentStat[Param.STAT_HEALTH]+" "),
                    (equipmentStat[Param.STAT_ATTACK] == 0 ? "":"物攻+"+equipmentStat[Param.STAT_ATTACK]+" "),
                    (equipmentStat[Param.STAT_MAGIC_ATTACK] == 0 ? "":"法攻+"+equipmentStat[Param.STAT_MAGIC_ATTACK])
            );
        }

        @Override
        public String getOutPutName() {
            return "♣️%s".formatted(nameID);
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }
    }

    public enum Cups implements Equipment {
        ACE_OF_CUPS("圣杯I", 1, "情感的新开始，爱意或直觉的涌现。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        TWO_OF_CUPS("圣杯II", 2, "平等的关系，爱情或友谊的结合。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        THREE_OF_CUPS("圣杯III", 3, "欢庆与团聚，朋友间的喜悦与互助。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        FOUR_OF_CUPS("圣杯IV", 4, "对现状不满，厌倦或反思已有的情感。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        FIVE_OF_CUPS("圣杯V", 5, "沉浸在失落与悲伤中，忽视留下的东西。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        SIX_OF_CUPS("圣杯VI", 6, "怀旧与馈赠，童年或过往的美好回忆。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        SEVEN_OF_CUPS("圣杯VII", 7, "面对众多幻象，难以抉择真正的愿望。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        EIGHT_OF_CUPS("圣杯VIII", 8, "离开不满意的环境，寻找更高目标。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        NINE_OF_CUPS("圣杯IX", 9, "愿望达成，情感上的满足与自豪。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        TEN_OF_CUPS("圣杯X", 10, "家庭和谐，圆满的情感与幸福。", new int[]{0, 0, 5, 0, 0, 0, 0}),

        PAGE_OF_CUPS("圣杯侍从", 11, "温柔的消息，情感上的好奇，艺术灵感。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        KNIGHT_OF_CUPS("圣杯骑士", 12, "浪漫的追求能量，理想与艺术气质。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        QUEEN_OF_CUPS("圣杯王后", 13, "敏感与同情心，强大的直觉力。", new int[]{0, 0, 5, 0, 0, 0, 0}),
        KING_OF_CUPS("圣杯国王", 14, "情感成熟，慈悲且有掌控力。", new int[]{0, 0, 5, 0, 0, 0, 0});

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

        @Override
        public SkillGroup getSkillGroup() {
            return null;
        }

        public String getInformation() {
            return "【%s】\n%s\n%s%s%s%s%s%s%s".formatted(
                    getOutPutName(),
                    information,
                    (equipmentStat[Param.STAT_PHYSICAL] == 0 ? "":"物理属性+"+equipmentStat[Param.STAT_PHYSICAL]+" "),
                    (equipmentStat[Param.STAT_MAGIC] == 0 ? "":"魔法属性+"+equipmentStat[Param.STAT_MAGIC]+" "),
                    (equipmentStat[Param.STAT_PHYSICAL_RESISTANCE] == 0 ? "":"物抗+"+equipmentStat[Param.STAT_PHYSICAL_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_MAGIC_RESISTANCE] == 0 ? "":"法抗+"+equipmentStat[Param.STAT_MAGIC_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_HEALTH] == 0 ? "":"生命值+"+equipmentStat[Param.STAT_HEALTH]+" "),
                    (equipmentStat[Param.STAT_ATTACK] == 0 ? "":"物攻+"+equipmentStat[Param.STAT_ATTACK]+" "),
                    (equipmentStat[Param.STAT_MAGIC_ATTACK] == 0 ? "":"法攻+"+equipmentStat[Param.STAT_MAGIC_ATTACK])
            );
        }

        @Override
        public String getOutPutName() {
            return "♥️%s".formatted(nameID);
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }
    }

    public enum Swords implements Equipment {
        ACE_OF_SWORDS("宝剑I", 1, "清晰的理智，新观念或决断的胜利。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        TWO_OF_SWORDS("宝剑II", 2, "自我防卫，拒绝面对真相，内心矛盾。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        THREE_OF_SWORDS("宝剑III", 3, "心碎与痛苦，悲伤与分离的打击。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        FOUR_OF_SWORDS("宝剑IV", 4, "暂时的休息，冥想或疗愈中的安静。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        FIVE_OF_SWORDS("宝剑V", 5, "自私的胜利，赢得争执但失去尊重。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        SIX_OF_SWORDS("宝剑VI", 6, "缓慢的疗愈，离开困境走向平静。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        SEVEN_OF_SWORDS("宝剑VII", 7, "隐秘的行动，欺骗或巧计获取所需。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        EIGHT_OF_SWORDS("宝剑VIII", 8, "自我束缚，感觉被困但实际有出路。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        NINE_OF_SWORDS("宝剑IX", 9, "深夜的噩梦，焦虑与内疚折磨。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        TEN_OF_SWORDS("宝剑X", 10, "彻底的结束，跌入谷底后等待新生。", new int[]{5, 0, 0, 0, 0, 0, 0}),

        PAGE_OF_SWORDS("宝剑侍从", 11, "警觉的观察力，带来新消息或警惕。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        KNIGHT_OF_SWORDS("宝剑骑士", 12, "锐利的言辞，快速行动，冲动的战斗力。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        QUEEN_OF_SWORDS("宝剑王后", 13, "独立理性，诚实且公正的决断力。", new int[]{5, 0, 0, 0, 0, 0, 0}),
        KING_OF_SWORDS("宝剑国王", 14, "权威的思想力，理性与纪律的代表。", new int[]{5, 0, 0, 0, 0, 0, 0});

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

        @Override
        public SkillGroup getSkillGroup() {
            return null;
        }

        public String getInformation() {
            return "【%s】\n%s\n%s%s%s%s%s%s%s".formatted(
                    getOutPutName(),
                    information,
                    (equipmentStat[Param.STAT_PHYSICAL] == 0 ? "":"物理属性+"+equipmentStat[Param.STAT_PHYSICAL]+" "),
                    (equipmentStat[Param.STAT_MAGIC] == 0 ? "":"魔法属性+"+equipmentStat[Param.STAT_MAGIC]+" "),
                    (equipmentStat[Param.STAT_PHYSICAL_RESISTANCE] == 0 ? "":"物抗+"+equipmentStat[Param.STAT_PHYSICAL_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_MAGIC_RESISTANCE] == 0 ? "":"法抗+"+equipmentStat[Param.STAT_MAGIC_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_HEALTH] == 0 ? "":"生命值+"+equipmentStat[Param.STAT_HEALTH]+" "),
                    (equipmentStat[Param.STAT_ATTACK] == 0 ? "":"物攻+"+equipmentStat[Param.STAT_ATTACK]+" "),
                    (equipmentStat[Param.STAT_MAGIC_ATTACK] == 0 ? "":"法攻+"+equipmentStat[Param.STAT_MAGIC_ATTACK])
            );
        }

        @Override
        public String getOutPutName() {
            return "♠️%s".formatted(nameID);
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }
    }

    public enum Pentacles implements Equipment {
        ACE_OF_PENTACLES("星币I", 1, "物质的新机会，财富或健康的开端。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        TWO_OF_PENTACLES("星币II", 2, "金钱或事务的平衡，应对波动与变化。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        THREE_OF_PENTACLES("星币III", 3, "团队合作，技艺的打磨与初步成果。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        FOUR_OR_PENTACLES("星币IV", 4, "紧握财富，固执保守或吝啬的控制。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        FIVE_OF_PENTACLES("星币V", 5, "贫困与孤独，物质或精神上的匮乏。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        SIX_OF_PENTACLES("星币VI", 6, "慷慨与施舍，财富分配或慈善行为。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        SEVEN_OF_PENTACLES("星币VII", 7, "等待收获，评估投资与后续努力。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        EIGHT_OF_PENTACLES("星币VIII", 8, "专注工作，技能的精进与勤奋劳作。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        NINE_OF_PENTACLES("星币IX", 9, "自足与奢华，通过努力获得舒适生活。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        TEN_OF_PENTACLES("星币X", 10, "家族财富，物质传承与长期稳定。", new int[]{0, 0, 0, 5, 0, 0, 0}),

        PAGE_OF_PENTACLES("星币侍从", 11, "学习财务或手艺的机会，务实的新消息。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        KNIGHT_OF_PENTACLES("星币骑士", 12, "踏实稳健的行动，缓慢但持续前进。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        QUEEN_OF_PENTACLES("星币王后", 13, "务实与慷慨，关注自然与物质安全感。", new int[]{0, 0, 0, 5, 0, 0, 0}),
        KING_OF_PENTACLES("星币国王", 14, "富有的实业能量，稳定与财富的掌控力。", new int[]{0, 0, 0, 5, 0, 0, 0}),
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

        @Override
        public SkillGroup getSkillGroup() {
            return null;
        }

        public String getInformation() {
            return "【%s】\n%s\n%s%s%s%s%s%s%s".formatted(
                    getOutPutName(),
                    information,
                    (equipmentStat[Param.STAT_PHYSICAL] == 0 ? "":"物理属性+"+equipmentStat[Param.STAT_PHYSICAL]+" "),
                    (equipmentStat[Param.STAT_MAGIC] == 0 ? "":"魔法属性+"+equipmentStat[Param.STAT_MAGIC]+" "),
                    (equipmentStat[Param.STAT_PHYSICAL_RESISTANCE] == 0 ? "":"物抗+"+equipmentStat[Param.STAT_PHYSICAL_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_MAGIC_RESISTANCE] == 0 ? "":"法抗+"+equipmentStat[Param.STAT_MAGIC_RESISTANCE]+" "),
                    (equipmentStat[Param.STAT_HEALTH] == 0 ? "":"生命值+"+equipmentStat[Param.STAT_HEALTH]+" "),
                    (equipmentStat[Param.STAT_ATTACK] == 0 ? "":"物攻+"+equipmentStat[Param.STAT_ATTACK]+" "),
                    (equipmentStat[Param.STAT_MAGIC_ATTACK] == 0 ? "":"法攻+"+equipmentStat[Param.STAT_MAGIC_ATTACK])
            );
        }

        @Override
        public String getOutPutName() {
            return "♦️%s".formatted(nameID);
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }
    }
}

