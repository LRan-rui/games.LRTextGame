package com.example.lrtextgame.command.action;

/*下面方法的依赖
import com.data.item.material.Material;

import java.util.ArrayList;
import java.util.List;
*/
public abstract class Action {

    protected static int s_weight = 1;
    protected static int a_weight = 30;
    protected static int b_weight = 180;
    protected static int c_weight = 540;
    protected static int d_weight = 1610;

    protected static int add_weight = 30;

    protected static int level = 0;
    protected static int num = 0;


/*目前看起来没用的代码片段，功能为返回实现该方法的类的所有内部枚举的枚举值
    private Material[] materials;

    protected synchronized Material[] getMaterialAllValues() {
        if(materials == null) {
            List<Material> list = new ArrayList<>();
            Class<?>[] declaredClasses = getClass().getDeclaredClasses();
            for(Class<?> clazz : declaredClasses) {
                if(Enum.class.isAssignableFrom(clazz) && Material.class.isAssignableFrom(clazz)) {
                    @SuppressWarnings("unchecked")
                    Class<? extends Enum<?>> enumClass = (Class<? extends Enum<?>>) clazz;
                    for(Enum<?> e : enumClass.getEnumConstants()) {
                        list.add((Material) e);
                    }
                }
            }
            materials = list.toArray(new Material[0]);
        }
        return materials;
    }
*/

}
