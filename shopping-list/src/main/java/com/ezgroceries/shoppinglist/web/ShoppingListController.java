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
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    private ShoppingListResource shoppingListResource;

    @Autowired
    public ShoppingListController(ShoppingListResource shoppingListResource){
        this.shoppingListResource = shoppingListResource;
    }

    @PostMapping(value = "/shopping-lists")
    public ShoppingList newShoppinglist(@RequestBody String shoppingListName){
        return shoppingListResource.newShoppingList(shoppingListName);
    }
}
