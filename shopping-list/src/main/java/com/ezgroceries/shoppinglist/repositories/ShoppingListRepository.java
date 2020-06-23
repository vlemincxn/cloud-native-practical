package com.ezgroceries.shoppinglist.repositories;

import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import org.springframework.data.repository.Repository;


import java.util.UUID;

public interface ShoppingListRepository extends Repository<ShoppingListEntity, UUID> {
}
