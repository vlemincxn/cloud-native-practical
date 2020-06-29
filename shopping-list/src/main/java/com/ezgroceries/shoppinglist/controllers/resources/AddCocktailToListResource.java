package com.ezgroceries.shoppinglist.controllers.resources;

import java.util.UUID;

public class AddCocktailToListResource {
    private UUID cocktailId;

    public AddCocktailToListResource(){}

    public AddCocktailToListResource(UUID cocktailId){
        this.cocktailId = cocktailId;
    }


    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }


}
