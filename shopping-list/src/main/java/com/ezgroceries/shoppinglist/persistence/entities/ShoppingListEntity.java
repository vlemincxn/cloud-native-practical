package com.ezgroceries.shoppinglist.persistence.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "SHOPPING_LIST")
public class ShoppingListEntity {
    @Id
    @Column(name ="id")
    private UUID uuid;

    @Column(name = "name")
    private String shoppingListName;

    @ManyToMany(mappedBy = "shoppingLists")
    private Set<CocktailEntity> cocktails = new HashSet<>();

    //

    public ShoppingListEntity(UUID uuid, String shoppingListName) {
        this.uuid = uuid;
        this.shoppingListName = shoppingListName;
    }

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return shoppingListName;
    }

    public void setName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public Set<CocktailEntity> getCocktails() {
        return cocktails;
    }

    @Transient
    public void addCocktailToShoppingList(CocktailEntity cocktailEntity) {
        cocktailEntity.getShoppingLists().add(this);
        this.cocktails.add(cocktailEntity);
    }

}