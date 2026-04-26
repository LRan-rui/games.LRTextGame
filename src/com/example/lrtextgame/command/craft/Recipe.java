package com.example.lrtextgame.command.craft;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.data.Thing;
import com.example.lrtextgame.data.Zero;
import com.example.lrtextgame.data.character.Character;
import com.example.lrtextgame.save.SaveData;

import java.util.HashMap;

/**
 * 配方类
 * @author 凌然
 */
public class Recipe {
    private final HashMap<Thing, Integer> needThings = new HashMap<>();
    private final Zero craftingOutPut;

    /**
     * 声明一个配方
     * @param zero 要合成的物品
     * @param param 需要的材料和数量，参数必须成对出现：Thing，Integer，Thing,Integer...
     */
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

    /**
     * 检查背包中材料是否足够
      * @return 检查结果（{@code Signal.getSignal()}）
     */
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

    /**
     * 依据配方合成物品
     * @return 合成结果
     */
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

    /**
     * 输出格式化后的配方
     * @return 字符串
     */
    public String formatString(){
        StringBuilder rtn = new StringBuilder("合成【%s】，需要：".formatted(this.craftingOutPut.getOutPutName()));
        int x = 0;
        for (Thing thing : this.needThings.keySet()) {
            if (x++ % 2 == 0){
                rtn.append("\n");
            }else {
                rtn.append(" ");
            }
            rtn.append("【").append(thing.getOutPutName()).append("】×").append(needThings.get(thing));
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
