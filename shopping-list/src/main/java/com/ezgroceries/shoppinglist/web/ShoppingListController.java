package com.ezgroceries.shoppinglist.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ShoppingListController {

    private ShoppingListResource shoppingListResource;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/shopping-lists", produces = "application/json")
    public ShoppingList newShoppinglist(@RequestBody ShoppingList shoppingList){
        ShoppingListResource shoppingListResource = new ShoppingListResource();

        return shoppingListResource.newShoppingList(shoppingList);
    }



}
