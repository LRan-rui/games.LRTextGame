package com.command.craft;

import com.central.Signal;
import com.data.item.material.Ore;
import com.data.item.semiProduct.Metal;

public enum CraftingList {
    CRAFT_TIN_INGOT(new Recipe(Metal.TIN_INGOT,Ore.C.TIN_ORE,2,Ore.D.COAL,5));

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
