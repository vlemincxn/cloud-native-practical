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

    public ShoppingListService(ShoppingListRepository shoppingListRepository, CocktailRepository cocktailRepository) {
        this.shoppingListRepository = shoppingListRepository;
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


    public void addCocktailsToShoppinglist(UUID shoppingListId,
                                           List<CocktailId> cocktailIds){

        //Lookup the shoppinglist by ShoppingListId
        ShoppingListEntity shoppingListEntity = shoppingListRepository.getAShoppingListById(shoppingListId);

        for(CocktailId cocktailId : cocktailIds){
            //findById is van type optional. met .get() achteraan de methode gaan we ervan uit dat er altijd
            //een object is om terug te krijgen.
            //Men kan hier een exceptie rond bouwen zodaning er een 'NULL' pointer kan worden opgevangen

            CocktailEntity cocktailEntity = cocktailRepository.findById(cocktailId.getCocktailId()).get();
            shoppingListEntity.addCocktailToShoppingList(cocktailEntity);

        }

        shoppingListRepository.save(shoppingListEntity);

    }

}

