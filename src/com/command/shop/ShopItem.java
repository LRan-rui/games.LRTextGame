package com.command.shop;

import com.data.Thing;

public enum ShopItem {
    ENERGY(2, null);

    private final int price;
    private final Thing thing;

    ShopItem(int price, Thing thing) {
        this.price = price;
        this.thing = thing;
    }

    public int getPrice() {
        return price;
    }

    public Thing getThing() {
        return thing;
    }
}
