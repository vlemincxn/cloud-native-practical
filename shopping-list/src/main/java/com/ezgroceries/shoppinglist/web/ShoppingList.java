package com.ezgroceries.shoppinglist.web;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShoppingList {

    private String listName;
    private UUID listId;

    public ShoppingList(){}

    public ShoppingList(UUID listId, String listName){
        this.listId = listId;
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public UUID getListId() {
        return listId;
    }

    public void setListId(UUID listId) {
        this.listId = listId;
    }



}
