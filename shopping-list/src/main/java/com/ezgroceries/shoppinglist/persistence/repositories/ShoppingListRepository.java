package com.ezgroceries.shoppinglist.persistence.repositories;

import com.ezgroceries.shoppinglist.persistence.entities.ShoppingListEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface ShoppingListRepository extends Repository<ShoppingListEntity, UUID> {

    ShoppingListEntity save(ShoppingListEntity shoppingListEntity);

    ShoppingListEntity getAShoppingListById(UUID shoppingListId);

    List<ShoppingListEntity> getAllShoppingLists();


    }

