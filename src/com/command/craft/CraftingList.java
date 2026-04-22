package com.command.craft;

import com.central.Signal;
import com.data.item.equipment.SwordCraft;
import com.data.item.material.OreGroup;
import com.data.item.material.PlantGroup;
import com.data.item.semiProduct.Crystal;
import com.data.item.semiProduct.Metal;

public enum CraftingList {
    CRAFT_TIN_INGOT(new Recipe(Metal.TIN_INGOT, OreGroup.C.TIN_ORE,2, OreGroup.D.COAL,5)),
    CRAFT_SLIVER_INGOT(new Recipe(Metal.SILVER_INGOT, OreGroup.A.SILVER_ORE,1, OreGroup.B.ANTHRACITE,5)),

    CRAFT_CRYSTAL_SHARD(new Recipe(Crystal.CRYSTAL_SHARD, OreGroup.D.SHARD_STONE,10)),

    CRAFT_TIN_SWORD(new Recipe(SwordCraft.TIN_SWORD,Metal.TIN_INGOT,2, PlantGroup.D.VINE,1, PlantGroup.D.WOOD,1)),
    CRAFT_SILVER_SWORD(new Recipe(SwordCraft.SILVER_SWORD,Metal.SILVER_INGOT,2, PlantGroup.A.BURLYWOOD,1, PlantGroup.B.MAPLE_RESIN,1, PlantGroup.B.DARK_VINE,1)),

    ;

    private final Recipe recipe;
    private final String nameID;

    CraftingList(Recipe recipe) {
        this.recipe = recipe;
        this.nameID = recipe.getCraftingOutPut().getNameID();
    }

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
