package com.ezgroceries.shoppinglist.web;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public interface ShoppingListManager {
    public List<ShoppingList> getAllShoppingLists();
    public ShoppingList getShoppingList(UUID listId);
    public ShoppingList newShoppingList(String shoppingListName);

}
