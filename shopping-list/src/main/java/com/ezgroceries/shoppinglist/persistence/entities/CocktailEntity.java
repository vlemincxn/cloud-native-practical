package com.ezgroceries.shoppinglist.persistence.entities;

import com.ezgroceries.shoppinglist.persistence.StringSetConverter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class CocktailEntity {
    @Id
    private UUID id;
    private String idDrink;
    private String name;

    @ManyToMany(mappedBy = "cocktails")
    private Set<ShoppingListEntity> shoppingLists = new HashSet<>();

    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<ShoppingListEntity> getShoppingLists() {
        return shoppingLists;
    }

    @Transient
    public void addCocktailToShoppingList(ShoppingListEntity shoppingListEntity) {
        shoppingListEntity.getCocktails().add(this);
        this.shoppingLists.add(shoppingListEntity);
    }


}
