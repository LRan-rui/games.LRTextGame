package com.command.craft;

import com.central.Signal;
import com.data.item.material.Ore;
import com.data.item.semiProduct.Crystal;
import com.data.item.semiProduct.Metal;

public enum CraftingList {
    CRAFT_TIN_INGOT(new Recipe(Metal.TIN_INGOT,Ore.C.TIN_ORE,2,Ore.D.COAL,5)),
    CRAFT_SLIVER_INGOT(new Recipe(Metal.SILVER_INGOT,Ore.A.SILVER_ORE,1,Ore.B.ANTHRACITE,5)),

    CRAFT_CRYSTAL_SHARD(new Recipe(Crystal.CRYSTAL_SHARD,Ore.D.SHARD_STONE,10))
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
