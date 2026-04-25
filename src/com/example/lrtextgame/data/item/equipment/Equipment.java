package com.example.lrtextgame.data.item.equipment;

import com.example.lrtextgame.command.fight.SkillGroup;
import com.example.lrtextgame.data.item.Item;

/**
 *
 */
public interface Equipment extends Item {

    int[] getEquipmentStat();

    SkillGroup getSkillGroup();
}
