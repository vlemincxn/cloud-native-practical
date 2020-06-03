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

    @Autowired
    private ShoppingListManager shoppingListManager;
    //private Counter counter;

/*    @Autowired
    public ShoppingListController(ShoppingListManager shoppingListManager, MeterRegistry registry){
        this.shoppingListManager = shoppingListManager;
        this.counter = registry.counter("shoppingList.fetch", "type", "fromCode");

    }*/

    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ShoppingList createShoppinglist(@RequestBody String shoppingListName){
        return shoppingListManager.newShoppingList(shoppingListName);
    }
}
