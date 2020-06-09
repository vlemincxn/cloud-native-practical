package com.ezgroceries.shoppinglist.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping(value = "/shopping-lists/{shoppingListId}")
    public ShoppingListResource getShoppingListDetails(@PathVariable UUID shoppingListId){
        return getDummyShoppingList(shoppingListId);
    }

    public ShoppingListResource getDummyShoppingList(UUID shoppingListId) {
        ShoppingListResource shoppingListResource =
                new ShoppingListResource(
                        shoppingListId,
                        "Stephanie's birthday",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice","Salt","Blue Curacao")
                );
        return shoppingListResource;
    }
}
