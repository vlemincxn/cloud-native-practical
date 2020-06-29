package com.ezgroceries.shoppinglist.controllers.resources;

import java.util.List;
import java.util.UUID;

public class ShoppingListResponseResource {

    private String name;
    private UUID shoppingListId;
    private List<String> ingredients;

    public ShoppingListResponseResource(){}

    public ShoppingListResponseResource(UUID shoppingListId, String name){
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    public ShoppingListResponseResource(UUID shoppingListId, String name, List ingredients){
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
    }

    public ShoppingListResponseResource(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "name='" + name + '\'' +
                ", shoppingListId=" + shoppingListId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID listId) {
        this.shoppingListId = UUID.randomUUID();
    }



}
