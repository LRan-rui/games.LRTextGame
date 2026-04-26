package com.example.lrtextgame.command.craft;

import com.example.lrtextgame.central.Signal;
import com.example.lrtextgame.data.item.equipment.Staff;
import com.example.lrtextgame.data.item.equipment.SwordCraft;
import com.example.lrtextgame.data.item.material.OreGroup;
import com.example.lrtextgame.data.item.material.PlantGroup;
import com.example.lrtextgame.data.item.semiProduct.Crystal;
import com.example.lrtextgame.data.item.semiProduct.Metal;

/**
 * 合成表枚举及相关方法
 * @author 凌然
 */
public enum CraftingList {
    CRAFT_TIN_INGOT(new Recipe(Metal.TIN_INGOT, OreGroup.C.TIN_ORE,2, OreGroup.D.COAL,5)),
    CRAFT_SLIVER_INGOT(new Recipe(Metal.SILVER_INGOT, OreGroup.A.SILVER_ORE,1, OreGroup.B.ANTHRACITE,5)),

    CRAFT_CRYSTAL_SHARD(new Recipe(Crystal.CRYSTAL_SHARD, OreGroup.D.SHARD_STONE,10)),

    CRAFT_TIN_SWORD(new Recipe(SwordCraft.TIN_SWORD,Metal.TIN_INGOT,2, PlantGroup.D.VINE,1, PlantGroup.D.WOOD,1)),
    CRAFT_SILVER_SWORD(new Recipe(SwordCraft.SILVER_SWORD,Metal.SILVER_INGOT,2, PlantGroup.A.BURLYWOOD,1, PlantGroup.B.MAPLE_RESIN,1, PlantGroup.B.DARK_VINE,1)),

    CRAFT_SHARDSTONE_STAFF(new Recipe(Staff.SHARDSTONE_STAFF,Crystal.CRYSTAL_SHARD,1,PlantGroup.D.VINE,2,PlantGroup.D.WOOD,1)),
    CRAFT_GLOWSTONE_STAFF(new Recipe(Staff.GLOWSTONE_STAFF,OreGroup.C.GLOWSTONE,5,Crystal.CRYSTAL_SHARD,1,PlantGroup.C.HARDWOOD,1,PlantGroup.D.VINE,1)),
    CRAFT_DARK_CRYSTAL_STAFF(new Recipe(Staff.DARK_CRYSTAL_STAFF,OreGroup.B.DARK_CRYSTAL_COAL,5,Crystal.CRYSTAL_SHARD,2,PlantGroup.B.DARK_VINE ,1,PlantGroup.B.EBONY,1)),
    CRAFT_OBSIDIAN_STAFF(new Recipe(Staff.OBSIDIAN_STAFF,OreGroup.S.OBSIDIAN,2)),
    CRAFT_DRAGON_BLOOD_STAFF(new Recipe(Staff.DRAGON_BLOOD_STAFF,PlantGroup.S.DRAGON_TREE_RESIN,1,PlantGroup.S.BLOODWOOD,1)),
    GOLDEN_NANMU_SCEPTRE(new Recipe(Staff.GOLDEN_NANMU_SCEPTRE,PlantGroup.S.GOLDEN_NANMU,1,OreGroup.S.MYSTIC_STEEL,1)),
    OBSIDIAN_DRAGON_STAFF(new Recipe(Staff.OBSIDIAN_DRAGON_STAFF,
            OreGroup.S.OBSIDIAN,1,OreGroup.S.MYSTIC_STEEL,1,PlantGroup.S.DRAGON_TREE_RESIN,1,PlantGroup.S.BLOODWOOD,1,PlantGroup.S.GOLDEN_NANMU,1,OreGroup.S.CLINT_ORE,1)),
    ;

    private final Recipe recipe;
    private final String nameID;

    /**
     * 声明一个配方
     * @param recipe 配方对象
     */
    CraftingList(Recipe recipe) {
        this.recipe = recipe;
        this.nameID = recipe.getCraftingOutPut().getNameID();
    }

    /**
     * 合成物品
     * @return 合成结果
     */
    public String toCraft(){
        String rtn = recipe.craftThings();
        return rtn.equals(Signal.RIGHT.getSignal()) ? "你合成了:%s".formatted(recipe.getCraftingOutPut().getNameID()) : Signal.THING_NOT_ENOUGH.getSignal();
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public String getNameID() {
        return nameID;
    }
}
