package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.controllers.resources.*;
import com.ezgroceries.shoppinglist.persistence.entities.*;
import com.ezgroceries.shoppinglist.persistence.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingListResource createShoppingList(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity =
                new ShoppingListEntity(shoppingListResource.getUuid(), shoppingListResource.getShoppingListName());

        shoppingListEntity = shoppingListRepository.save(shoppingListEntity);

        return new ShoppingListResource(shoppingListEntity.getId(), shoppingListEntity.getName());
    }
}