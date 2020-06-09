package com.ezgroceries.shoppinglist.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class ShoppingListController {

    private ShoppingListResource shoppingListResource;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/shopping-lists", produces = "application/json")
    public ShoppingList newShoppinglist(@RequestBody ShoppingList shoppingList){
        ShoppingListResource shoppingListResource = new ShoppingListResource();

        return shoppingListResource.newShoppingList(shoppingList);
    }

    @PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails")
    public List<CocktailId> addCocktails(@PathVariable UUID shoppingListId, @RequestBody List<CocktailId> cocktails){
        return cocktails;
    }

}
