package com.data.item.equipment;

import com.command.fight.SkillGroup;
import com.data.item.Item;

/**
 *
 */
public interface Equipment extends Item {

    int[] getEquipmentStat();

    SkillGroup getSkillGroup();
}
