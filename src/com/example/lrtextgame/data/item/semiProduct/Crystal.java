package com.example.lrtextgame.data.item.semiProduct;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.command.craft.Craft;
import com.example.lrtextgame.data.item.UseGroup;
import com.example.lrtextgame.save.SaveData;

public enum Crystal implements SemiProduct{
    CRYSTAL_SHARD("碎晶","碎晶岩筛选好的晶体碎片，含有微弱的能量",new UseGroup(0,0,20,0));

    private final String nameID;
    private final String information;
    private final UseGroup useGroup;

    Crystal(String nameID, String information) {
        this.nameID = nameID;
        this.information = information;
        this.useGroup = null;
    }

    Crystal(String nameID, String information, UseGroup useGroup) {
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
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }
        SaveData.getSaveData().removePlayer_Bag(this,1);
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
        return getOutPutName() + "\n" + information +(useGroup == null ? "" : "\n"+useGroup.formatUseGroup())+ crafts;
    }
}
