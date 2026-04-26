package com.example.lrtextgame.save;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.data.Thing;
import com.example.lrtextgame.data.character.Character;

/**
 * 单例类
 *
 * <p>玩家的相关数据
 */
public class SaveData extends Data {

    private static final SaveData saveData = new SaveData();

    private SaveData() {
    }

    /**
     * 初始化存档
     */
    public static void Start() {
        SaveDataManager.setSaveData(saveData);
        System.out.println("存档初始化……");
    }

    public static SaveData getSaveData() {
        return saveData;
    }


    public void addCharacter(Character character) {
        Character_Bag.merge(character.getNameID(), 1, Integer::sum);
    }

    public Signal removeCharacter(Character character, int number) {
        if (!Character_Bag.containsKey(character.getNameID())) {
            return Signal.THING_NOT_FOUND_ERROR;
        } else if (Character_Bag.get(character.getNameID()) < number) {
            return Signal.THING_NOT_ENOUGH;
        } else if (Character_Bag.get(character.getNameID()) == number) {
            Character_Bag.remove(character.getNameID());
        } else if (Character_Bag.get(character.getNameID()) > number) {
            Character_Bag.put(character.getNameID(), Character_Bag.get(character.getNameID()) - number);
        }
        return Signal.RIGHT;
    }

    public void addPlayer_Bag(Thing thing) {
        Player_Bag.merge(thing.getNameID(), 1, Integer::sum);
    }

    public void addPlayer_Bag(Thing thing, int number) {
        Player_Bag.merge(thing.getNameID(), number, Integer::sum);
    }

    public Signal removePlayer_Bag(Thing thing, int number) {
        if (!Player_Bag.containsKey(thing.getNameID())) {
            return Signal.THING_NOT_FOUND_ERROR;
        } else if (Player_Bag.get(thing.getNameID()) < number) {
            return Signal.THING_NOT_ENOUGH;
        } else if (Player_Bag.get(thing.getNameID()) == number) {
            Player_Bag.remove(thing.getNameID());
        } else if (Player_Bag.get(thing.getNameID()) > number) {
            Player_Bag.put(thing.getNameID(), Player_Bag.get(thing.getNameID()) - number);
        }
        return Signal.RIGHT;
    }

    public void addProperty_Pool(String property_name) {
        Property_Pool.merge(property_name, 1, Integer::sum);
    }

    public Signal removeProperty_Pool(String property_name, int number) {
        if (!Property_Pool.containsKey(property_name)) {
            return Signal.THING_NOT_FOUND_ERROR;
        } else if (Property_Pool.get(property_name) < number) {
            return Signal.THING_NOT_ENOUGH;
        } else if (Property_Pool.get(property_name) == number) {
            Property_Pool.remove(property_name);
        } else if (Property_Pool.get(property_name) > number) {
            Property_Pool.put(property_name, Property_Pool.get(property_name) - number);
        }
        return Signal.RIGHT;
    }
}
















