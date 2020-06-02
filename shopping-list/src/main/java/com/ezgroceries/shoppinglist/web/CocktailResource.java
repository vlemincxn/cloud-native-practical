package com.ezgroceries.shoppinglist.web;

import java.util.List;
import java.util.UUID;

public class CocktailResource {

    private UUID cocktailId;
    //            "cocktailId": "23b3d85a-3928-41c0-a533-6538a71e17c4",
    private String name;
    //            "name": "Margerita",
    private String glass;
    //            "glass": "Cocktail glass",
    private String instructions;
    //            "instructions": "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
    private String image;
    //            "image": "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
    private List ingredients;
//            "ingredients": [
//            "Tequila",
//            "Triple sec",
//            "Lime juice",
//            "Salt"
//            ]

    public CocktailResource(UUID cocktailId,
                            String name,
                            String glass,
                            String instructions,
                            String image,
                            List ingredients){
        this.cocktailId = cocktailId;
        this.name = name;
        this.glass = glass;
        this.instructions = instructions;
        this.image = image;
        this.ingredients = ingredients;

    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }


}
