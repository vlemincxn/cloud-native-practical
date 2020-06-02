package com.ezgroceries.shoppinglist.web;

import org.springframework.http.HttpEntity;

import java.util.UUID;

public class ShoppingListResource{
    private String shoppingListName;
    private UUID shoppingListId;

    public ShoppingListResource(String shoppingListName){
        this.shoppingListName = shoppingListName;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public ShoppingListResource(UUID shoppingListId, String shoppingListName){
        this.shoppingListId = shoppingListId;
        this.shoppingListName = shoppingListName;
    }

}
