package com.ezgroceries.shoppinglist.web;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ShoppingListController {

    private ShoppingListManager shoppingListManager;
    private Counter counter;

    @Autowired
    public ShoppingListController(ShoppingListManager shoppingListManager, MeterRegistry registry){
        this.shoppingListManager = shoppingListManager;
        this.counter = registry.counter("shoppingList.fetch", "type", "fromCode");

    }

    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ShoppingListResource createShoppinglist(@RequestBody ShoppingListResource shoppingListResource){
        return shoppingListManager.newShoppingList(shoppingListResource);
    }
}
