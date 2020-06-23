package com.ezgroceries.shoppinglist.persistence.repositories;

import com.ezgroceries.shoppinglist.persistence.entities.*;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface ShoppingListRepository extends Repository<ShoppingListEntity, UUID> {

    ShoppingListEntity save(ShoppingListEntity shoppingListEntity);
}
