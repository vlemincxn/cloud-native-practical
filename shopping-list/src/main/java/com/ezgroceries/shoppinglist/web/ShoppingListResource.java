package com.ezgroceries.shoppinglist.web;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShoppingListResource {

    public ShoppingList newShoppingList(String shoppingListName){
        ShoppingList shoppingList = new ShoppingList(UUID.randomUUID(),shoppingListName);
        return shoppingList;
    }
}
