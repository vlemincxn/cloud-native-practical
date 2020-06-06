package com.ezgroceries.shoppinglist.web;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ShoppingListController {

    private ShoppingListResource shoppingListResource;

    @PostMapping(value = "/shopping-lists", produces = "application/json", consumes = "application/json")
    public ShoppingList newShoppinglist(@RequestBody String shoppingListName){
        ShoppingListResource shoppingListResource = new ShoppingListResource();

        return shoppingListResource.newShoppingList(shoppingListName);
    }
}
