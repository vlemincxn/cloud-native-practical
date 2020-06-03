package com.ezgroceries.shoppinglist.web;

import java.util.UUID;

public class ShoppingListResource {

    public ShoppingList newShoppingList(ShoppingList shoppingList){
        //shoppingList.setListName(shoppingList);
        shoppingList.setListId(UUID.randomUUID());
        return shoppingList;
    }
}
