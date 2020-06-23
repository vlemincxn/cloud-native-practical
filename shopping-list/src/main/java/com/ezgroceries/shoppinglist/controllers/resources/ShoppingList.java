package com.ezgroceries.shoppinglist.controllers.resources;

import java.util.List;
import java.util.UUID;

public class ShoppingList {

    private String name;
    private UUID shoppingListId;
    private List<String> ingredients;

    public ShoppingList(){}

    public ShoppingList(UUID shoppingListId, String name){
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    public ShoppingList(UUID shoppingListId, String name, List ingredients){
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
    }

    public ShoppingList(String name){
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
