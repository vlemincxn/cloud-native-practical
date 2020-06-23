package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.controllers.ShoppingListController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ShoppingListApplicationTests {
	private ShoppingListController controller;


	@Test
	void contextLoads() {
	}

/*	@Test
	public void testCreateShoppingList(){
		ShoppingListResource newShoppingList = new ShoppingListResource("Stephanie's Birthday");


		//HttpEntity<?> result = controller.createShoppinglist(newShoppingList);

		//assertNotNull(result);
	}*/

}
