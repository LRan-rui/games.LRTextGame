package com.example.lrtextgame.data.item.equipment;

import com.example.lrtextgame.command.fight.SkillGroup;
import com.example.lrtextgame.data.item.Item;

/**
 *装备接口
 * @author 凌然
 */
public interface Equipment extends Item {

    int[] getEquipmentStat();

    SkillGroup getSkillGroup();
}
