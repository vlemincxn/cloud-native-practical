package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.controllers.resources.CocktailId;
import com.ezgroceries.shoppinglist.controllers.resources.ShoppingListResource;
import com.ezgroceries.shoppinglist.persistence.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.persistence.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.persistence.repositories.CocktailRepository;
import com.ezgroceries.shoppinglist.persistence.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final CocktailRepository cocktailRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public CocktailService(CocktailRepository cocktailRepository){
        this.cocktailRepository = cocktailRepository;
    }

    public ShoppingListResource createShoppingList(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity =
                new ShoppingListEntity(shoppingListResource.getUuid(), shoppingListResource.getShoppingListName());

        shoppingListEntity = shoppingListRepository.save(shoppingListEntity);

        return new ShoppingListResource(shoppingListEntity.getId(), shoppingListEntity.getName());
    }

    public List<ShoppingListResource> getAllShoppingLists(){
        List<ShoppingListEntity> shoppingListEntities = shoppingListRepository.getAllShoppingLists();
        List<ShoppingListResource> shoppingListResources = new ArrayList<>();

        for (ShoppingListEntity shoppingListEntity : shoppingListEntities) {
            shoppingListResources.add(new ShoppingListResource(shoppingListEntity.getId(), shoppingListEntity.getName()));
        }

        return  shoppingListResources;
    }

    public ShoppingListResource getAShoppingList(UUID shoppingListId){
        ShoppingListEntity shoppingListEntity = shoppingListRepository.getAShoppingListById(shoppingListId);
        ShoppingListResource shoppingListResource = new ShoppingListResource(shoppingListEntity.getName());
        shoppingListResource.setUuid(shoppingListEntity.getId());

        return shoppingListResource;
    }

    public ShoppingListResource addCocktailsToShoppinglist(UUID shoppingListId, List<CocktailId> cocktailId){
        //Lookup the shoppinglist by ShoppingListId
        ShoppingListEntity shoppingListEntity = shoppingListRepository.getAShoppingListById(shoppingListId);

        List<CocktailEntity> cocktailEntities = cocktailRepository.findByIdDrink;
        List<CocktailId> cocktailIds = new ArrayList<>();

        for(CocktailEntity cocktailEntity : cocktailIds)

    }

}

