package com.data.item.material;

import com.data.item.Item;

public interface Material extends Item {

    default Material getRandomOneMaterial() {
        Class<?> clazz = this.getClass();
        if (!clazz.isEnum()) {
            throw new UnsupportedOperationException("getRandomOneMaterial()方法只能由枚举调用，但现在调用者是：" + clazz.getName());
        }
        Object[] enums = clazz.getEnumConstants();
        if (enums == null || enums.length == 0) return null;
        int rand = (int) (Math.random() * enums.length);
        return (Material) enums[rand];
    }
}
