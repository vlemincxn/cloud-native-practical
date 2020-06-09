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

    @GetMapping(value = "/shopping-lists")
    public List <ShoppingListResource> getAllShoppingLists(){
        return getDummyShoppingLists();
    }

    private List <ShoppingListResource> getDummyShoppingLists(){
        return Arrays.asList(
                new ShoppingListResource(
                        UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"),
                        "Stephanie's birthday",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice","Salt","Blue Curacao")),
                new ShoppingListResource(
                        UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"),
                        "My birthday",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice","Salt","Blue Curacao")
        ));
    }
}
