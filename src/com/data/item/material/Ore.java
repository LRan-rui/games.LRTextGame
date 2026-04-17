package com.data.item.material;

public class Ore {


    public enum S implements Material {
        MYSTIC_STEEL("✨\uD83E\uDEA8秘钢", ""),
        OBSIDIAN("✨\uD83E\uDEA8黑曜石", ""),
        CLINT_ORE("✨\uD83E\uDEA8砾石矿", ""),
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

        public String getInformation() {
            return information;
        }
    }


    public enum A implements Material {
        SILVER_ORE("✨\uD83E\uDEA8银矿", ""),
        TALC("✨\uD83E\uDEA8滑石", ""),
        MAGNET_CRYSTAL_ORE("✨\uD83E\uDEA8磁晶矿", ""),
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

        public String getInformation() {
            return information;
        }
    }

    public enum B implements Material {
        ANTHRACITE("\uD83E\uDEA8无烟煤", ""),
        QUARTZITE("\uD83E\uDEA8石英岩", ""),
        DARK_CRYSTAL_COAL("\uD83E\uDEA8暗晶煤", ""),
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

        public String getInformation() {
            return information;
        }
    }

    public enum C implements Material {
        TIN_ORE("\uD83E\uDEA8锡矿", ""),
        MARBLE("\uD83E\uDEA8大理石", ""),
        GLOWSTONE("\uD83E\uDEA8辉光岩", ""),
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

        public String getInformation() {
            return information;
        }
    }

    public enum D implements Material {
        COAL("\uD83E\uDEA8煤", ""),
        LIMESTONE("\uD83E\uDEA8石灰岩", ""),
        SHARD_STONE("\uD83E\uDEA8碎晶岩", ""),
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

        public String getInformation() {
            return information;
        }
    }
}
