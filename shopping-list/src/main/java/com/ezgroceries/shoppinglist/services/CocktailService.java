package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.clients.CocktailDBResponse;
import com.ezgroceries.shoppinglist.controllers.resources.CocktailResource;
import com.ezgroceries.shoppinglist.persistence.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.persistence.repositories.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CocktailService {

    private CocktailRepository cocktailRepository;
    private CocktailDBClient cocktailDBClient;

    public List<CocktailResource> searchCocktails(String search) {
        List<CocktailResource> cocktailResourceList = new ArrayList<>();

        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        if (null == cocktailDBResponse) return new ArrayList<>();

        List<CocktailDBResponse.DrinkResource> drinkResourceList = cocktailDBResponse.getDrinks();

        return this.mergeCocktails(drinkResourceList);
    }




    public List<CocktailResource> mergeCocktails(List<CocktailDBResponse.DrinkResource> drinks) {
        //Get all the idDrink attributes
        List<String> ids = drinks.stream().map(CocktailDBResponse.DrinkResource::getIdDrink).collect(Collectors.toList());

        //Get all the ones we already have from our DB, use a Map for convenient lookup
        Map<String, CocktailEntity> existingEntityMap = cocktailRepository.findByIdDrinkIn(ids)
                                                            .stream()
                                                            .collect(Collectors
                                                                    .toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Stream over all the drinks, map them to the existing ones, persist a new one if not existing
        Map<String, CocktailEntity> allEntityMap = drinks.stream().map(drinkResource -> {
            CocktailEntity cocktailEntity = existingEntityMap.get(drinkResource.getIdDrink());
            if (cocktailEntity == null) {
                CocktailEntity newCocktailEntity = new CocktailEntity();
                newCocktailEntity.setId(UUID.randomUUID());
                newCocktailEntity.setIdDrink(drinkResource.getIdDrink());
                newCocktailEntity.setName(drinkResource.getStrDrink());
                cocktailEntity = cocktailRepository.save(newCocktailEntity);
            }
            return cocktailEntity;
        }).collect(Collectors.toMap(CocktailEntity::getIdDrink, o -> o, (o, o2) -> o));

        //Merge drinks and our entities, transform to CocktailResource instances
        return mergeAndTransform(drinks, allEntityMap);
    }

    private List<CocktailResource> mergeAndTransform(List<CocktailDBResponse.DrinkResource> drinks,
                                                     Map<String, CocktailEntity> allEntityMap) {
        return drinks.stream().map(drinkResource ->
                new CocktailResource(
                        allEntityMap.get(
                                    drinkResource.getIdDrink()).getId(),
                                    drinkResource.getStrDrink(),
                                    drinkResource.getStrGlass(),
                                    drinkResource.getStrInstructions(),
                                    drinkResource.getStrDrinkThumb(),
                                    getIngredients(drinkResource)
                                    )
                                ).collect(Collectors.toList());
    }

    private List<String> getIngredients(CocktailDBResponse.DrinkResource drinkResource) {
        List <String> list = new ArrayList<>();

        if(drinkResource.getStrIngredient1() != null) list.add(drinkResource.getStrIngredient1());
        if(drinkResource.getStrIngredient2() != null) list.add(drinkResource.getStrIngredient2());
        if(drinkResource.getStrIngredient3() != null) list.add(drinkResource.getStrIngredient3());
        if(drinkResource.getStrIngredient4() != null) list.add(drinkResource.getStrIngredient4());
        if(drinkResource.getStrIngredient5() != null) list.add(drinkResource.getStrIngredient5());
        if(drinkResource.getStrIngredient6() != null) list.add(drinkResource.getStrIngredient6());
        if(drinkResource.getStrIngredient7() != null) list.add(drinkResource.getStrIngredient7());
        if(drinkResource.getStrIngredient8() != null) list.add(drinkResource.getStrIngredient8());
        if(drinkResource.getStrIngredient9() != null) list.add(drinkResource.getStrIngredient9());
        if(drinkResource.getStrIngredient10() != null) list.add(drinkResource.getStrIngredient10());
        if(drinkResource.getStrIngredient11() != null) list.add(drinkResource.getStrIngredient11());
        if(drinkResource.getStrIngredient12() != null) list.add(drinkResource.getStrIngredient12());
        if(drinkResource.getStrIngredient13() != null) list.add(drinkResource.getStrIngredient13());
        if(drinkResource.getStrIngredient14() != null) list.add(drinkResource.getStrIngredient14());
        if(drinkResource.getStrIngredient15() != null) list.add(drinkResource.getStrIngredient15());

        return list;

    }
}
