package com.data.item.semiProduct;

public enum Metal implements SemiProduct {
    TIN_INGOT("锡锭","由锡矿冶炼而来的金属锭"),
    SILVER_INGOT("银锭","由银矿冶炼而来的半成品");

    private final String nameID;
    private final String information;

    Metal(String nameID, String information) {
        this.nameID = nameID;
        this.information = information;
    }

    @Override
    public String getOutPutName() {
        return "";
    }

    @Override
    public String getNameID() {
        return this.nameID;
    }

    @Override
    public String getInformation() {
        return "【%s】\n%s".formatted(this.nameID,this.information);
    }
}
