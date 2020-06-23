package com.ezgroceries.shoppinglist.controllers.resources;

import java.util.List;
import java.util.UUID;

public class ShoppingListResource {
    private UUID uuid;
    private String shoppingListName;
    private List ingredients;

    public ShoppingListResource() {
    }

    public ShoppingListResource(UUID uuid, String shoppingListName, List ingredients) {
        this.uuid = uuid;
        this.shoppingListName = shoppingListName;
        this.ingredients = ingredients;
    }

    public ShoppingListResource(UUID uuid, String shoppingListName) {
        this.uuid = uuid;
        this.shoppingListName = shoppingListName;
    }

    public ShoppingListResource(String shoppingListName){
        this.shoppingListName = shoppingListName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public List getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }



}
