package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.web.ShoppingListController;
import com.ezgroceries.shoppinglist.web.ShoppingListResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.client.RestTemplate;

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
