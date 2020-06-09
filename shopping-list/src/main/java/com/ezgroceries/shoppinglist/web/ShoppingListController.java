package com.ezgroceries.shoppinglist.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<CocktailResource> addCocktail(@PathVariable UUID shoppingListId, @RequestBody List<CocktailResource> cocktails){
        return cocktails;
    }



}
