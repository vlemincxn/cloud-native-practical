package com.ezgroceries.shoppinglist.web;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.clients.CocktailDBResponse;
import com.ezgroceries.shoppinglist.resources.CocktailResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private CocktailDBClient cocktailDBClient;

    CocktailController(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }


    @GetMapping
    public List<CocktailResource> get(@RequestParam String search) {
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);

        // Dummy list to be filled up after iteration
        List <CocktailResource> cocktailResourceList = new ArrayList<>();

        // Fill up list of the DBResponse
        List <CocktailDBResponse.DrinkResource> drinkResourceList = cocktailDBResponse.getDrinks();

        // For each entry object drinkResource in the returned list drinkResourceList,
        // Create a new object of CocktailResource, populate the fields
        for (CocktailDBResponse.DrinkResource drinkResource : drinkResourceList){
            CocktailResource cocktailResource = new CocktailResource();

            cocktailResource.setCocktailId(drinkResource.getIdDrink());
            cocktailResource.setName(drinkResource.getStrDrink());
            cocktailResource.setGlass(drinkResource.getStrGlass());
            cocktailResource.setInstructions(drinkResource.getStrInstructions());
            cocktailResource.setImage(drinkResource.getStrDrinkThumb());

            cocktailResource.setIngredients(this.listIngredients(drinkResource));

            cocktailResourceList.add(cocktailResource);
        }

        return cocktailResourceList;

        //return getDummyResources();
    }

    private List<String> listIngredients(CocktailDBResponse.DrinkResource drinkResource){
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

/*    private List<CocktailResource> getDummyResources() {
        return Arrays.asList(
                new CocktailResource(
                        UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"), "Margerita",
                        "Cocktail glass",
                        "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                        "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt")),
                new CocktailResource(
                        UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"), "Blue Margerita",
                        "Cocktail glass",
                        "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                        "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                        Arrays.asList("Tequila", "Blue Curacao", "Lime juice", "Salt")));
    }*/
}
