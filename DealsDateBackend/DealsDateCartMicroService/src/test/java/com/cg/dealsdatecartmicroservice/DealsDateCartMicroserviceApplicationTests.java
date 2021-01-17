package com.cg.dealsdatecartmicroservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dealsdatecartmicroservice.dao.CartDao;
import com.cg.dealsdatecartmicroservice.entity.Cart;
import com.cg.dealsdatecartmicroservice.exception.CartException;
import com.cg.dealsdatecartmicroservice.model.ProductModel;
import com.cg.dealsdatecartmicroservice.model.CartModel;
import com.cg.dealsdatecartmicroservice.service.ProductProxyService;
import com.cg.dealsdatecartmicroservice.service.CartImpl;
import com.cg.dealsdatecartmicroservice.service.CartIntf;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DealsDateCartMicroserviceApplicationTests {

	@Autowired
	CartIntf cartService;

	@Autowired
	CartImpl cart;

	@MockBean
	CartDao cartDao;

	@MockBean
	private ProductProxyService productProxyService;

	@BeforeEach
	public void init() {

	}

	@Test
	public void contextLoads() {
		boolean res = true;
		assertEquals(true, res);
	}

	@Test
	public void getCartTest() throws CartException {
		List<Cart> list = new ArrayList<Cart>();
		list.add(new Cart(101, 1, "Photo",11608248,150000d,50,"Blue","NOVELS","GOOD","url"));
		when(cartDao.findAll()).thenReturn(list);
		List<Cart> cart = cartService.getCart();

		assertEquals(1, cart.size());
	}

	@Test
	public void getCartTest1() throws CartException {
		List<Cart> list = new ArrayList<Cart>();
		list.add(new Cart(101, 1, "Photo",11608248,150000d,50,"Blue","NOVELS","GOOD","url"));

		when(cartDao.findAll()).thenReturn(list);
		List<Cart> cart = cartService.getCart();

		verify(cartDao, times(1)).findAll();
		assertEquals(1, cart.size());
	}

	@Test
	public void removeFromCartTest() throws CartException {
		int cartId = 101;
		when(cartDao.existsById(anyInt())).thenReturn(true);
		boolean flag = cartService.removeFromCart(cartId);
		assertEquals(true, flag);
	}

	@Test
	public	void removeFromCartTest_cartNotExit() {
		int cartId = 108;
		CartException exception = assertThrows(CartException.class, () -> {
			when(!cartDao.existsById(anyInt())).thenReturn(false);
			cartService.removeFromCart(cartId);
		});
		assertEquals("Failed to remove product", exception.getMessage());
	}

	private Cart getCartEntity() {
		Cart result = new Cart();
		result.setCartId(2020101);
		result.setProductId(101);
		result.setUserId(11608248);
		return result;
	}

	private CartModel getCartModel() {

		CartModel cart = new CartModel();
		cart.setProductId(101);
		cart.setCartId(2020100);
		cart.setUserId(11608248);

		ProductModel product = productProxyService.getProduct(101);
		if (product != null) {
			cart.setProductName("photo");
			cart.setProductPrice(150000d);
			cart.setProductQuantity(5);
			cart.setProductColor("Blue");
			cart.setProductCategory("NOVELS");
			cart.setProductSpecification("4X4");
			cart.setImageUrl("SSSS");
		}
		return cart;
	}

	@Test
	public void testOf1() {
		Cart source = null;
		CartModel result = cart.of(source);
		assertEquals(source, result);
	}

	@Test
	public void testOf2() {
		CartModel source = null;
		Cart result = cart.of(source);
		assertEquals(source, result);
	}

	@Test
	public void testSetProductId() {
		int productId = 101;
		Cart entityCart = new Cart();
		entityCart.setProductId(productId);
		assertEquals(entityCart.getProductId(), productId);
	}

	@Test
	public void testGetCartId() {
		Cart entityCart = new Cart();
		entityCart.setCartId(2020100);
		int cartId = 2020100;
		int result = entityCart.getCartId();
		assertEquals(cartId, result);
	}

	@Test
	public void testGetProductId() {
		Cart entityCart = new Cart();
		entityCart.setProductId(1000);
		int productId = 1000;
		int result = entityCart.getProductId();
		assertEquals(productId, result);
	}

	@Test
	public void testGetUserId() {
		Cart entityCart = new Cart();
		entityCart.setUserId(11600000);
		int userId = 11600000;
		int result = entityCart.getUserId();
		assertEquals(userId, result);
	}

	@Test
	public void testGetProductName() {
		CartModel model = new CartModel();
		model.setProductName("Photo");
		String productName = "Photo";
		String result = model.getProductName();
		assertEquals(productName, result);
	}

	@Test
	public void testGetProductQuantity() {
		CartModel model = new CartModel();
		model.setProductQuantity(50);
		int quantity = 50;
		int result = model.getProductQuantity();
		assertEquals(quantity, result);
	}

	@Test
	public void testGetProductDescription() {
		CartModel model = new CartModel();
		model.setProductSpecification("4X4");
		String productDescription = "4X4";
		String result = model.getProductSpecification();
		assertEquals(productDescription, result);
	}

	@Test
	public void testGetProductCategory() {
		CartModel model = new CartModel();
		model.setProductCategory("NOVELS");
		String productCategory = "NOVELS";
		String result = model.getProductCategory();
		assertEquals(productCategory, result);
	}

	@Test
	public void testGetProductColor() {
		CartModel model = new CartModel();
		model.setProductColor("BLUE");
		String productColor = "BLUE";
		String result = model.getProductColor();
		assertEquals(productColor, result);
	}

	@Test
	public void testImageUerl() {
		CartModel model = new CartModel();
		model.setImageUrl("GooGle");
		String imageUrl = "GooGle";
		String result = model.getImageUrl();
		assertEquals(imageUrl, result);
	}

	@Test
	public void testSetProductName() {
		String name = "Chocolate";
		CartModel model = new CartModel();
		model.setProductName(name);
		assertEquals(model.getProductName(), name);
	}

	@Test
	public void testSetProductColor() {
		String color = "Brown";
		CartModel model = new CartModel();
		model.setProductColor(color);
		assertEquals(model.getProductColor(), color);
	}

	@Test
	public void setImageUrlTest() {
		String url = "http://chocolate/brown/truffle";
		CartModel model = new CartModel();
		model.setImageUrl(url);
		assertEquals(model.getImageUrl(), url);
	}

	@Test
	public void productSpecificationTest() {
		String description = "Great in taste";
		CartModel model = new CartModel();
		model.setProductSpecification(description);
		assertEquals(model.getProductSpecification(), description);
	}

	@Test
	public void productQuantityTest() {
		int quantity = 50;
		CartModel model = new CartModel();
		model.setProductQuantity(quantity);
		assertEquals(model.getProductQuantity(), quantity);
	}

	@Test
	public void setProductIdTest() {
		int productId = 101;
		CartModel model = new CartModel();
		model.setProductId(productId);
		assertEquals(model.getProductId(), productId);
	}

	@Test
	public void testSetProductId1() {
		int productId = 1000;
		ProductModel product = new ProductModel();
		product.setProductId(productId);
		assertEquals(product.getProductId(), productId);
	}

	/*
	 * To test getProductId() ,getter to get value of productId
	 */

	@Test
	public void testGetProductId1() {

		ProductModel product = new ProductModel();
		;
		product.setProductId(1000);
		int productId = 1000;
		int result = product.getProductId();
		assertEquals(productId, result);
	}

	/*
	 * To test setProductName() ,setter to set value of product Name
	 */

	@Test
	public void testSetProductName1() {
		String name = "Chocolate";// int orderId=100;
		ProductModel product = new ProductModel();// OrderModel model=new OrderModel();
		product.setProductName(name);// model.setOrderId(100);
		assertEquals(product.getProductName(), name);// (model.getOrderId(),orderId)
	}

	@Test
	public void testGetProductName1() {

		ProductModel product = new ProductModel();// OrderModel model=new OrderModel();
		product.setProductName("Chocolate");// model.setOrderId(100);
		// int ordeId=100;
		String name = "Chocolate";
		String result = product.getProductName();// int result=model.getOrderId();
		assertEquals(name, result);// (orderid,result)
	}

	/*
	 * To test setProductColor() ,setter to set value of product Color
	 */

	@Test
	public void testSetProductColor1() {
		String color = "Brown";
		ProductModel product = new ProductModel();
		product.setProductColor(color);
		assertEquals(product.getProductColor(), color);
	}

	/*
	 * To test getProductColor() ,getter to get value of product Color
	 */

	@Test
	public void testGetProductColor1() {

		ProductModel product = new ProductModel();
		product.setProductColor("Brown");
		String color = "Brown";
		String result = product.getProductColor();
		assertEquals(color, result);
	}

	/*
	 * To test setImageUrl() ,setter to set value of imageurl
	 */

	@Test
	public void setImageUrlTest1() {
		String url = "http://chocolate/brown/truffle";
		ProductModel product = new ProductModel();
		product.setImageUrl(url);
		assertEquals(product.getImageUrl(), url);
	}

	/*
	 * To test getImageUrl() ,getter to get value of Image Url
	 */

	@Test
	public void testGetImageUrl() {
		ProductModel product = new ProductModel();
		product.setImageUrl("http://chocolate/brown/truffle");
		String url = "http://chocolate/brown/truffle";
		String result = product.getImageUrl();
		assertEquals(url, result);
	}

	@Test
	public void productSpecificationTest1() {
		String description = "Great in taste";
		ProductModel product = new ProductModel();
		product.setProductSpecification(description);
		assertEquals(product.getProductSpecification(), description);
	}

	/*
	 * To test getProductSpecification() ,getter to get value of
	 * ProductSpecification
	 */

	@Test
	public void testGetProductSpecification() {

		ProductModel product = new ProductModel();
		product.setProductSpecification("Great in Taste");
		String description = "Great in Taste";
		String result = product.getProductSpecification();
		assertEquals(description, result);
	}

	/*
	 * To test setProductQuantity() ,setter to set value of quantity
	 */

	@Test
	public void productQuantityTest1() {
		int quantity = 50;
		ProductModel product = new ProductModel();
		product.setProductQuantity(quantity);
		assertEquals(product.getProductQuantity(), quantity);
	}

	/*
	 * To test getProductQuantity() ,getter to get value of Product Quantity
	 */

	@Test
	public void testGetProductQuantity1() {

		ProductModel product = new ProductModel();
		product.setProductQuantity(50);
		int quantity = 50;
		int result = product.getProductQuantity();
		assertEquals(quantity, result);
	}



}