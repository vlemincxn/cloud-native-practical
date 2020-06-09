package com.ezgroceries.shoppinglist.web;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public class ShoppingListResource {

    public ShoppingList newShoppingList(ShoppingList shoppingList){
        shoppingList.setShoppingListId(UUID.randomUUID());
        shoppingList.setName(shoppingList.getName());
        return shoppingList;
    }


}
