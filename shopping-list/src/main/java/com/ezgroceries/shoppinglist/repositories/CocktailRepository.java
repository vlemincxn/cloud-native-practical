package com.ezgroceries.shoppinglist.repositories;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends Repository<CocktailEntity, UUID> {

    List<CocktailEntity> findByIdDrinkIn(List<String> idDrinks);

    CocktailEntity save(CocktailEntity cocktailEntity);
}
