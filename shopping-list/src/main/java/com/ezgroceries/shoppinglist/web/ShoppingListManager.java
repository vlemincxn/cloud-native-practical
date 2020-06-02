package com.ezgroceries.shoppinglist.web;

public interface ShoppingListManager {
    public String getShoppingLists();
    public ShoppingListResource newShoppingList(ShoppingListResource shoppingListResource);
}
