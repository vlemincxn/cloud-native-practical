package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.controllers.resources.AddCocktailToListResource;
import com.ezgroceries.shoppinglist.controllers.resources.ShoppingListCreateResource;
import com.ezgroceries.shoppinglist.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RestController
public class ShoppingListController {
    private ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService){
        this.shoppingListService = shoppingListService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/shopping-lists", produces = "application/json")
    public ShoppingListCreateResource newShoppinglist(@RequestBody ShoppingListCreateResource shoppingListCreateResource){
        return shoppingListService.createShoppingList(
                new ShoppingListCreateResource(
                        shoppingListCreateResource.getShoppingListName()
                )
        );
    }

    @PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails")
    public List<AddCocktailToListResource> addCocktails(@PathVariable UUID shoppingListId,
                                                        @RequestBody List<AddCocktailToListResource> cocktails){
        shoppingListService.addCocktailsToShoppinglist(shoppingListId, cocktails);

        return cocktails;
    }

    @GetMapping
    public List<ShoppingListCreateResource> getAllShoppingLists(){
        return shoppingListService.getAllShoppingLists();
    }

    @GetMapping(value = "/shopping-lists/{shoppingListId}")
    public ShoppingListCreateResource getAShoppingList (@PathVariable UUID shoppingListId) {
        return shoppingListService.getAShoppingList(shoppingListId);
    }


//    @GetMapping(value = "/shopping-lists/{shoppingListId}")
//    public ShoppingListResource getShoppingListDetails(@PathVariable UUID shoppingListId){
//        return getDummyShoppingList(shoppingListId);
//    }
//
//    public ShoppingListResource getDummyShoppingList(UUID shoppingListId) {
//        ShoppingListResource shoppingListResource =
//                new ShoppingListResource(
//                        shoppingListId,
//                        "Stephanie's birthday",
//                        Arrays.asList("Tequila", "Triple sec", "Lime juice","Salt","Blue Curacao")
//                );
//        return shoppingListResource;
//    }






//    @GetMapping(value = "/shopping-lists")
//    public List <ShoppingListResource> getAllShoppingLists(){
//        return getDummyShoppingLists();
//    }

    private List <ShoppingListCreateResource> getDummyShoppingLists(){
        return Arrays.asList(
                new ShoppingListCreateResource(
                        UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"),
                        "Stephanie's birthday",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice","Salt","Blue Curacao")),
                new ShoppingListCreateResource(
                        UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"),
                        "My birthday",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice","Salt","Blue Curacao")
        ));
    }

}
