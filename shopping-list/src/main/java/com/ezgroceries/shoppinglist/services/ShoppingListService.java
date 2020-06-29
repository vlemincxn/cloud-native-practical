package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.controllers.resources.AddCocktailToListResource;
import com.ezgroceries.shoppinglist.controllers.resources.ShoppingListCreateResource;
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

    public ShoppingListService(ShoppingListRepository shoppingListRepository, CocktailRepository cocktailRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.cocktailRepository = cocktailRepository;
    }

    public ShoppingListCreateResource createShoppingList(ShoppingListCreateResource shoppingListCreateResource) {
        ShoppingListEntity shoppingListEntity =
                new ShoppingListEntity(shoppingListCreateResource.getUuid(), shoppingListCreateResource.getShoppingListName());

        shoppingListEntity = shoppingListRepository.save(shoppingListEntity);

        return new ShoppingListCreateResource(shoppingListEntity.getId(), shoppingListEntity.getName());
    }

    public List<ShoppingListCreateResource> getAllShoppingLists(){
        List<ShoppingListEntity> shoppingListEntities = shoppingListRepository.getAllShoppingLists();
        List<ShoppingListCreateResource> shoppingListCreateResources = new ArrayList<>();

        for (ShoppingListEntity shoppingListEntity : shoppingListEntities) {
            shoppingListCreateResources.add(new ShoppingListCreateResource(shoppingListEntity.getId(), shoppingListEntity.getName()));
        }

        return shoppingListCreateResources;
    }

    public ShoppingListCreateResource getAShoppingList(UUID shoppingListId){
        ShoppingListEntity shoppingListEntity = shoppingListRepository.getAShoppingListById(shoppingListId);
        ShoppingListCreateResource shoppingListCreateResource = new ShoppingListCreateResource(shoppingListEntity.getName());
        shoppingListCreateResource.setUuid(shoppingListEntity.getId());

        return shoppingListCreateResource;
    }


    public void addCocktailsToShoppinglist(UUID shoppingListId,
                                           List<AddCocktailToListResource> addCocktailToListResources){

        //Lookup the shoppinglist by ShoppingListId
        ShoppingListEntity shoppingListEntity = shoppingListRepository.getAShoppingListById(shoppingListId);

        for(AddCocktailToListResource addCocktailToListResource : addCocktailToListResources){
            //findById is van type optional. met .get() achteraan de methode gaan we ervan uit dat er altijd
            //een object is om terug te krijgen.
            //Men kan hier een exceptie rond bouwen zodaning er een 'NULL' pointer kan worden opgevangen

            CocktailEntity cocktailEntity = cocktailRepository.findById(addCocktailToListResource.getCocktailId()).get();
            shoppingListEntity.addCocktailToShoppingList(cocktailEntity);

        }

        shoppingListRepository.save(shoppingListEntity);

    }

}

