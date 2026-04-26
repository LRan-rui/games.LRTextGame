package com.example.lrtextgame.command.shop;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.save.SaveData;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopManager {
    private static final HashMap<String, ShopItem> shopItems = new HashMap<>();
    private static final Pattern pattern = Pattern.compile("^(.*?)(\\d+)");

    static {
        for (ShopItem shopItem : ShopItem.values()) {
            shopItems.put(shopItem.getThing() != null ? shopItem.getThing().getNameID() : "体力", shopItem);
        }
    }

    public static String shopInformation() {
        return "";
    }

    public static String buyShopItem(String param) {
        String thingName;
        int number;
        Matcher matcher = pattern.matcher(param);

        if (matcher.find()) {
            thingName = matcher.group(1);
            number = Integer.parseInt(matcher.group(2));
        } else {
            thingName = param;
            number = 1;
        }

        //判断商品是否存在
        ShopItem shopItem = shopItems.get(thingName);
        if (shopItem == null) {
            return Signal.THING_NOT_FOUND_ERROR.getSignal();
        }

        SaveData saveData = SaveData.getSaveData();

        //判断金币是否足够
        if ((long) number * shopItem.getPrice() > saveData.getMoney()) {
            return Signal.MONEY_NOT_ENOUGH.getSignal();
        }

        //单独判断特殊商品体力
        if (shopItem == ShopItem.ENERGY) {
            saveData.setEnergy_Points(saveData.getEnergy_Points() + number);
            saveData.setMoney(saveData.getMoney() - ((long) number * shopItem.getPrice()));
            return String.format("购买了 体力×%d", number);
        }

        saveData.addPlayer_Bag(shopItem.getThing(), number);
        saveData.setMoney(saveData.getMoney() - ((long) number * shopItem.getPrice()));

        return String.format("购买了【%s】×%d", shopItem.getThing().getNameID(), number);
    }
}
