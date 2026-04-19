package com.command.craft;

import com.central.Signal;
import com.data.Thing;
import com.data.Zero;
import com.data.character.Character;
import com.save.SaveData;

import java.util.HashMap;

public class Recipe {
    private final HashMap<Thing, Integer> needThings = new HashMap<>();
    private final Zero craftingOutPut;

    Recipe(Zero zero, Object... param) {
        if (param != null && param.length > 0) {
            if (param.length % 2 == 1) {
                throw new IllegalArgumentException("除第一个参数外，参数必须成对出现：Thing，Integer，Thing,Integer...");
            }
            for (int i = 0; i < param.length; i += 2) {
                if (!(param[i] instanceof Thing)) {
                    throw new IllegalArgumentException("第" + (i + 2) + "个参数应该为 Thing 类型，实际为：" + param[i].getClass().getSimpleName());
                }
                if (!(param[i + 1] instanceof Integer)) {
                    throw new IllegalArgumentException("第" + (i + 3) + "个参数应该为 Integer 类型，实际为：" + param[i + 1].getClass().getSimpleName());
                }
                int value;
                try {
                    value = (Integer) param[i + 1];
                } catch (Exception e) {
                    throw new IllegalArgumentException("第" + (i + 3) + "个参数无法解析为整数：" + param[i + 1]);
                }
                if (value <= 0) {
                    throw new IllegalArgumentException("第" + (i + 3) + "个参数应该为正整数：" + value);
                }
                this.needThings.put((Thing) param[i], value);
            }
        }
        this.craftingOutPut = zero;
    }

    public String isEnoughThing() {
        SaveData saveData = SaveData.getSaveData();
        for (Thing thing : this.needThings.keySet()) {
            if (saveData.getPlayer_Bag().get(thing.getNameID()) == null) {
                return Signal.THING_NOT_ENOUGH.getSignal();
            } else if (saveData.getPlayer_Bag().get(thing.getNameID()) < this.needThings.get(thing)) {
                return Signal.THING_NOT_ENOUGH.getSignal();
            }
        }
        return Signal.RIGHT.getSignal();
    }

    public String craftThings() {
        if (isEnoughThing().equals(Signal.RIGHT.getSignal())) {
            SaveData saveData = SaveData.getSaveData();
            for (Thing thing : this.needThings.keySet()) {
                saveData.removePlayer_Bag(thing, this.needThings.get(thing));
            }
            if(craftingOutPut instanceof Character){
                saveData.addCharacter((Character) craftingOutPut);
            }else {
                saveData.addPlayer_Bag((Thing) craftingOutPut);
            }
            return Signal.RIGHT.getSignal();
        }
        return Signal.THING_NOT_ENOUGH.getSignal();
    }

    public String formatString(){
        StringBuilder rtn = new StringBuilder("合成【%s】，需要：\n".formatted(this.craftingOutPut.getNameID()));
        for (Thing thing : this.needThings.keySet()) {
            rtn.append("【").append(thing.getNameID()).append("】×").append(needThings.get(thing)).append("\n");
        }
        return rtn.toString();
    }

    public Zero getCraftingOutPut() {
        return this.craftingOutPut;
    }

    public HashMap<Thing, Integer> getNeedThings() {
        return this.needThings;
    }
}
