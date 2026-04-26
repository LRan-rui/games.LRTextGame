package com.example.lrtextgame.data.item.material;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.craft.Craft;

import java.util.HashMap;

/**
 * 植物类
 * @author 凌然
 */
public class PlantGroup {
    private static final HashMap<String, Material> map = new HashMap<>();

    static {
        for(Material material: PlantGroup.S.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: PlantGroup.A.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: PlantGroup.B.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: PlantGroup.C.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: PlantGroup.D.values()){
            getMap().put(material.getNameID(), material);
        }
    }

    public static HashMap<String, Material> getMap() {
        return map;
    }



    public enum S implements Plant {
        BLOODWOOD("血檀", "心材呈深红色的稀有硬木，仅产于偏远雨林老树。"),
        DRAGON_TREE_RESIN("龙血树脂", "龙血树分泌的深红色树脂，凝固后如红宝石。"),
        GOLDEN_NANMU("金丝楠", "木纹含天然金色丝光的珍稀木材，古代仅限皇家使用。"),
        ;

        private final String nameID;
        private final String information;

        S(String name, String information) {
            this.nameID = name;
            this.information = information;
        }

        @Override
        public String getNameID() {
            return this.nameID;
        }

        public String getOutPutName() {
            return getLevel()+"级∙✨\uD83E\uDEB5"+this.nameID;
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }

        public String getLevel() {
            return "S";
        }

        public String getInformation() {
            StringBuilder crafts = new StringBuilder();
            if (!Craft.findCraft(this.nameID)[0].equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
                crafts.append("\n用于合成:\n");
                int x  = 0;
                for(String string :Craft.findCraft(this.nameID)){
                    x++;
                    crafts.append("【%s】 ".formatted(string));
                    if(x % 4 == 0){
                        crafts.append("\n");
                    }
                }
            }
            return getOutPutName() + "\n" + information + crafts;
        }
    }

    public enum A implements Plant {
        BURLYWOOD("阴沉木", "埋藏于河床或沼泽地下的千年古木，半石半木。"),
        IRONWOOD("铁梨木", "密度极高、沉水的热带硬木，需专用工具加工。"),
        FIR_KNOT("冷杉结", "冷杉树干上形成的硬质瘤结，纹理致密。"),
        ;

        private final String nameID;
        private final String information;

        A(String name, String information) {
            this.nameID = name;
            this.information = information;
        }

        @Override
        public String getNameID() {
            return this.nameID;
        }

        public String getOutPutName() {
            return getLevel()+"级∙✨\uD83E\uDEB5"+this.nameID;
        }

        public String getLevel() {
            return "A";
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }

        public String getInformation() {
            StringBuilder crafts = new StringBuilder();
            if (!Craft.findCraft(this.nameID)[0].equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
                crafts.append("\n用于合成:\n");
                int x  = 0;
                for(String string :Craft.findCraft(this.nameID)){
                    x++;
                    crafts.append("【%s】 ".formatted(string));
                    if(x % 4 == 0){
                        crafts.append("\n");
                    }
                }
            }
            return getOutPutName() + "\n" + information + crafts;
        }
    }

    public enum B implements Plant {
        EBONY("乌木", " 黑色致密木材，仅产于特定气候的森林。"),
        MAPLE_RESIN("枫脂", "糖枫树受损伤后流出的琥珀色胶液，是不错的粘合剂。"),
        DARK_VINE("魔藤", "生长于阴湿洞穴的灰紫色藤蔓，表面有微弱荧光。"),
        ;

        private final String nameID;
        private final String information;

        B(String name, String information) {
            this.nameID = name;
            this.information = information;
        }

        @Override
        public String getNameID() {
            return this.nameID;
        }
        public String getOutPutName() {
            return getLevel()+"级∙\uD83E\uDEB5"+nameID;
        }

        public String getLevel() {
            return "B";
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }

        public String getInformation() {
            StringBuilder crafts = new StringBuilder();
            if (!Craft.findCraft(this.nameID)[0].equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
                crafts.append("\n用于合成:\n");
                int x  = 0;
                for(String string :Craft.findCraft(this.nameID)){
                    x++;
                    crafts.append("【%s】 ".formatted(string));
                    if(x % 4 == 0){
                        crafts.append("\n");
                    }
                }
            }
            return getOutPutName() + "\n" + information + crafts;
        }
    }

    public enum C implements Plant {
        HARDWOOD("硬木", "密度较大的木材，比普通木头硬的多。"),
        BRIAR("荆条", "带刺的灌木枝条，十分扎手。"),
        BIRCH("桦木", "浅色细腻的木材，易于雕刻。"),
        ;

        private final String nameID;
        private final String information;

        C(String name, String information) {
            this.nameID = name;
            this.information = information;
        }

        @Override
        public String getNameID() {
            return this.nameID;
        }

        public String getOutPutName() {
            return getLevel()+"级∙\uD83E\uDEB5"+this.nameID;
        }

        public String getLevel() {
            return "C";
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }

        public String getInformation() {
            StringBuilder crafts = new StringBuilder();
            if (!Craft.findCraft(this.nameID)[0].equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
                crafts.append("\n用于合成:\n");
                int x  = 0;
                for(String string :Craft.findCraft(this.nameID)){
                    x++;
                    crafts.append("【%s】 ".formatted(string));
                    if(x % 4 == 0){
                        crafts.append("\n");
                    }
                }
            }
            return getOutPutName() + "\n" + information + crafts;
        }
    }

    public enum D implements Plant {
        WOOD("木材", "最常见的植物材料，可制作基础工具手柄或建筑框架。"),
        VINE("藤蔓", "柔软的攀爬植物，可编绳或捆扎。"),
        BARK("树皮", "粗糙的树干外层，可制作低级护甲。"),
        ;

        private final String nameID;
        private final String information;

        D(String name, String information) {
            this.nameID = name;
            this.information = information;
        }

        @Override
        public String getNameID() {
            return this.nameID;
        }

        public String getOutPutName() {
            return getLevel()+"级∙\uD83E\uDEB5"+this.nameID;
        }

        public String getLevel() {
            return "D";
        }

        @Override
        public String toUse() {
            return Signal.THING_CANNOT_USE.getSignal();
        }

        public String getInformation() {
            StringBuilder crafts = new StringBuilder();
            if (!Craft.findCraft(this.nameID)[0].equals(Signal.THING_NOT_FOUND_ERROR.getSignal())) {
                crafts.append("\n用于合成:\n");
                int x  = 0;
                for(String string :Craft.findCraft(this.nameID)){
                    x++;
                    crafts.append("【%s】 ".formatted(string));
                    if(x % 4 == 0){
                        crafts.append("\n");
                    }
                }
            }
            return getOutPutName() + "\n" + information + crafts;
        }
    }
}
