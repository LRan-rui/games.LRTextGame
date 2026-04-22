package com.data.item.material;

import com.central.Signal;
import com.command.craft.Craft;

import java.util.HashMap;

public class OreGroup {
    private static final HashMap<String, Material> map = new HashMap<>();

    static {
        for(Material material: S.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: A.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: B.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: C.values()){
            getMap().put(material.getNameID(), material);
        }
        for(Material material: D.values()){
            getMap().put(material.getNameID(), material);
        }
    }

    public static HashMap<String, Material> getMap() {
        return map;
    }


    public enum S implements Ore {
        MYSTIC_STEEL("秘钢", "铁与魔法精华融合而成的深青色合金，兼具硬度与魔力传导性。"),
        OBSIDIAN("黑曜石", "火山玻璃质岩石，断口锋利无比，适合制作高级切割工具或魔法阵的基底。"),
        CLINT_ORE("砾石矿", "内部封存着闪烁光能的矿石，受到敲击时会爆发出耀眼的闪光。"),
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
            return getLevel()+"级∙✨\uD83E\uDEA8"+this.nameID;
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


    public enum A implements Ore {
        SILVER_ORE("银矿", "闪耀银白色光泽的贵金属矿石，熔炼后得到银，对灵体与魔物有克制效果。"),
        TALC("滑石", "质地极软的矿物，手触有油腻感，磨成粉末可用作耐高温润滑剂或陶瓷原料。"),
        MAGNET_CRYSTAL_ORE("磁晶矿", "蕴含天然磁力的结晶矿体，由蕴含丰富能量的晶体构成。"),
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
            return getLevel()+"级∙✨\uD83E\uDEA8"+this.nameID;
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

    public enum B implements Ore {
        ANTHRACITE("无烟煤", "高品位的煤，火焰洁净且热量极高，是精炼金属的理想燃料。"),
        QUARTZITE("石英岩", "由石英颗粒紧密胶结而成的坚硬岩石，纯度极高，是制造玻璃或水晶器皿的原料。"),
        DARK_CRYSTAL_COAL("暗晶煤", "煤与暗能量结晶的混合矿，燃烧时释放阴冷的幽蓝色火焰。"),
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
            return getLevel()+"级∙\uD83E\uDEA8"+nameID;
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

    public enum C implements Ore {
        TIN_ORE("锡矿", "银白色金属矿石，熔炼后得到柔软的锡，适合制造初级容器与合金。"),
        MARBLE("大理石", "纹理美观的变质岩，经打磨后光亮如镜，是雕刻与高级建筑的常用石材。"),
        GLOWSTONE("辉光岩", "自然发出冷光的坚硬岩石，常用于制作永久的照明设施或魔法灯。"),
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
            return getLevel()+"级∙\uD83E\uDEA8"+this.nameID;
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

    public enum D implements Ore {
        COAL("煤", "地表常见的黑色可燃岩石，是初期最基础的燃料来源。"),
        LIMESTONE("石灰岩", "灰白色沉积岩，可用于建筑，是基础的矿物材料。"),
        SHARD_STONE("碎晶岩", "夹杂着脆弱发光晶体的沉积岩，敲碎后可获得微弱的能量碎片。"),
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
            return getLevel()+"级∙\uD83E\uDEA8"+this.nameID;
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
