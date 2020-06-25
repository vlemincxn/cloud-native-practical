package com.ezgroceries.shoppinglist.persistence.repositories;

import com.ezgroceries.shoppinglist.persistence.entities.CocktailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface CocktailRepository extends JpaRepository<CocktailEntity, UUID> {

    Set<CocktailEntity> findByIdDrinkIn(List<String> idDrinks);

    CocktailEntity save(CocktailEntity cocktailEntity);
}
