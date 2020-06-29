package com.ezgroceries.shoppinglist.controllers.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingListCreateResource {
    private UUID uuid;
    private String shoppingListName;
    private List ingredients;

    public ShoppingListCreateResource() {
    }

    public ShoppingListCreateResource(UUID uuid, String shoppingListName, List<String> ingredients) {
        this.uuid = uuid;
        this.shoppingListName = shoppingListName;
        this.ingredients = ingredients;
    }

    public ShoppingListCreateResource(UUID uuid, String shoppingListName) {
        this.uuid = uuid;
        this.shoppingListName = shoppingListName;
        this.ingredients = new ArrayList<>();
    }

    public ShoppingListCreateResource(String shoppingListName){
        this.shoppingListName = shoppingListName;
        this.uuid = UUID.randomUUID();
        this.shoppingListName = shoppingListName;
        this.ingredients = new ArrayList<>();
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
