package com.ezgroceries.shoppinglist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "shoppinglist")
public class ShoppingListEntity {
    @Id
    @Column(name ="id")
    private UUID uuid;
    @Column(name = "name")
    private String shoppingListName;

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


}
