package com.ezgroceries.shoppinglist.web;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShoppingList {

    private String name;
    private UUID shoppingListId;

    public ShoppingList(){}

    public ShoppingList(UUID shoppingListId, String name){
        this.shoppingListId = shoppingListId;
        this.name = name;
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
        this.shoppingListId = shoppingListId;
    }



}
