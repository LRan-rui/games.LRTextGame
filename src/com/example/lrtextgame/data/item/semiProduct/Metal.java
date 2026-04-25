package com.example.lrtextgame.data.item.semiProduct;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.craft.Craft;
import com.example.lrtextgame.data.item.UseGroup;
import com.example.lrtextgame.save.SaveData;

public enum Metal implements SemiProduct {
    TIN_INGOT("锡锭","由锡矿冶炼而来的金属锭"),
    SILVER_INGOT("银锭","由银矿冶炼而来的贵金属，具有不低的价值",new UseGroup(1000,20,0,0));

    private final String nameID;
    private final String information;
    private final UseGroup useGroup;

    Metal(String nameID, String information) {
        this.nameID = nameID;
        this.information = information;
        this.useGroup = null;
    }

    Metal(String nameID, String information, UseGroup useGroup) {
        this.nameID = nameID;
        this.information = information;
        this.useGroup = useGroup;
    }

    @Override
    public String getOutPutName() {
        return "【%s】".formatted(nameID);
    }

    @Override
    public String toUse() {
        if(useGroup == null){
            return Signal.THING_CANNOT_USE.getSignal();
        }if(SaveData.getSaveData().getPlayer_Bag().get(this.nameID) == null){
            SaveData.getSaveData().getPlayer_Bag().remove(this.nameID);
        }
        return useGroup.toUse();
    }

    @Override
    public String getNameID() {
        return this.nameID;
    }

    @Override
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
        return "%s\n%s%s%s".formatted(
                getOutPutName(),
                information,
                useGroup == null ? "" : "\n" + useGroup.formatUseGroup(),
                crafts);
    }
}
