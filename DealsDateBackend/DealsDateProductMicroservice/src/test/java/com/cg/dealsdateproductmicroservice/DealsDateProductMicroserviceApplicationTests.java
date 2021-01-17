package com.cg.dealsdateproductmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dealsdateproductmicroservice.dao.ProductDao;
import com.cg.dealsdateproductmicroservice.entity.ProductCategory;
import com.cg.dealsdateproductmicroservice.entity.ProductEntity;
import com.cg.dealsdateproductmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateproductmicroservice.model.ProductModel;
import com.cg.dealsdateproductmicroservice.service.ProductServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class DealsDateProductMicroserviceApplicationTests {

	@Autowired
	private ProductServiceImpl service;

	@MockBean
	private ProductDao repository;

	@Before
	public void init() {

	}

	/*
	 * To test addProduct()
	 */

	@Test
	void saveEventTest() throws ProductNotFoundException {

		ProductEntity entity = getProductEntity();
		when(repository.save(entity)).thenReturn(entity);

		ProductModel product = service.addProduct(entity);

		assertEquals(getProduct().getProductId(), product.getProductId());
	}

	/*
	 * To test addProduct() method when NullPointerException throw
	 */
	@Test
	public void testSaveProduct_NullPointerException() {

		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.addProduct(null);
		});
		assertEquals("Product Should not be null", exception.getMessage());
	}

	/*
	 * To test addProduct() method when event already exist
	 */
	@Test
	public void testSaveProduct_ProductAlreadyExist() {
		ProductEntity event = service.of(getProduct());

		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			when(repository.existsById(event.getProductId())).thenReturn(true);
			service.addProduct(event);
		});
		assertEquals("This Product already exist !", exception.getMessage());
	}
	
	/*
	 * To test findByOrderByProductPriceAsc() method to return list of products sorted in ascending order of price
	 */

	@Test
	public void getAllProductsOnTheBasisOfProductPriceSortingAscTest() {

		when(repository.findByOrderByProductPriceAsc())
				.thenReturn(Stream.of(getProductEntity(), getProductEntity()).collect(Collectors.toList()));

		assertEquals(2, service.getListOfProductsOntheBasisOfProductPriceSortingAsc().size());
	}
	
	/*
	 * To test findByOrderByProductPriceDesc() method to return list of products sorted in descending order of price
	 */

	@Test
	public void getAllProductsOnTheBasisOfProductPriceSortingDescTest() {

		when(repository.findByOrderByProductPriceDesc())
				.thenReturn(Stream.of(getProductEntity(), getProductEntity(),getProductEntity()).collect(Collectors.toList()));

		assertEquals(3, service.getListOfProductsOntheBasisOfProductPriceSortingDesc().size());
	}


	/*
	 * To test displayListOfProducts() method
	 */

	@Test
	public void getAllProductsTest() {

		when(repository.findAll())
				.thenReturn(Stream.of(getProductEntity(), getProductEntity()).collect(Collectors.toList()));

		assertEquals(2, service.displayListOfProducts().size());
	}

//     @Test
// 	public void testGetAllProductsByCategory() throws ProductNotFoundException {
//
//    	 ProductEntity entity=getProductEntity();
// 		when(repository.findListofProductsByCategories(entity.getProductCategory().HOME_AND_LIVING))
// 				.thenReturn(Stream.of(getProductEntity(), getProductEntity()).collect(Collectors.toList()));
//
// 		assertEquals(2, service.displayListOfProductByCategory(ProductCategory.HOME_AND_LIVING).size());
// 	}

	/*
	 * To test displayListOfProductByCategory() method when product category will
	 * not exist
	 */
	@Test
	public void getProductsByProductCategoryTestByCategoryNotExist() {
		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.displayListOfProductByCategory(ProductCategory.NOVELS);
		});
		assertEquals("Such Category does not exist", exception.getMessage());
	}

	/*
	 * To test displayListOfProductByCategory() method when product category will be
	 * blank
	 */
	@Test
	public void getProductsByProductCategoryTestByEmptyProductCategory() {

		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.displayListOfProductByCategory(null);
		});
		assertEquals("Product Category should not be null", exception.getMessage());
	}

	/*
	 * To test
	 * getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder()
	 * method when product category will be blank
	 */

	@Test
	public void getProductsByProductCategorySortingOnTheBasisOfPriceAscTestByEmptyProductCategory() {

		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder(null);
		});
		assertEquals("Product Category should not be null", exception.getMessage());
	}

	/*
	 * To test
	 * getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder()
	 * method when product category will not exist
	 */
	@Test
	public void getProductsByProductCategorySortingOnTheBasisOfPriceAscTestByCategoryNotExist() {
		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder(ProductCategory.NOVELS);
		});
		assertEquals("Such Category does not exist", exception.getMessage());
	}

	/*
	 * To test
	 * getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder()
	 * method when product category will be blank
	 */

	@Test
	public void getProductsByProductCategorySortingOnTheBasisOfPriceDescTestByEmptyProductCategory() {

		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder(null);
		});
		assertEquals("Product Category should not be null", exception.getMessage());
	}

	/*
	 * To test
	 * getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder()
	 * method when product category will not exist
	 */
	@Test
	public void getProductsByProductCategorySortingOnTheBasisOfPriceDescTestByCategoryNotExist() {
		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder(ProductCategory.NOVELS);
		});
		assertEquals("Such Category does not exist", exception.getMessage());
	}

	@Test
	public void testOfNotNull() {

		ProductEntity source = getProductEntity();
		ProductModel result = service.of(source);
		assertEquals(source.getProductId(), result.getProductId());
	}

	@Test
	public void testOf1() {
		ProductEntity source = null;
		ProductModel result = service.of(source);
		assertEquals(source, result);
	}

	@Test
	public void testOf2() {
		ProductModel source = null;
		ProductEntity result = service.of(source);
		assertEquals(source, result);
	}
	/*
	 * To test setProductId() ,setter to set value of productId
	 */
	
	@Test
	void testSetProductId() {
		int productId=1000;
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductId(productId);
		assertEquals(entityProduct.getProductId(),productId);
	}

	/*
	 * To test getProductId() ,getter to get value of productId
	 */
	
	@Test
	void testGetProductId() {
		
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductId(1000);
		int productId=1000;
		int result=entityProduct.getProductId();
		assertEquals(productId,result);
	}
	
	/*
	 * To test setProductName() ,setter to set value of product Name
	 */
	
	@Test
	void testSetProductName() {
		String name="Chocolate";//int ordeId=100;
		ProductEntity entityProduct=new ProductEntity();//OrderModel model=new OrderModel();
		entityProduct.setProductName(name);//model.setOrderId(100);
		assertEquals(entityProduct.getProductName(),name);//(model.getOrderId(),orderId)
	}


	/*
	 * To test getProductName() ,getter to get value of product Name
	 */
	
	@Test
	void testGetProductName() {
		
		ProductEntity entityProduct=new ProductEntity();//OrderModel model=new OrderModel();
		entityProduct.setProductName("Chocolate");//model.setOrderId(100);
		                         //int ordeId=100;
		String name="Chocolate";
		String result=entityProduct.getProductName();//int result=model.getOrderId();
		assertEquals(name,result);//(orderid,result)
	}
	
	
	/*
	 * To test setProductColor() ,setter to set value of product Color
	 */
	
	@Test
	void testSetProductColor() {
		String color="Brown";
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductColor(color);
		assertEquals(entityProduct.getProductColor(),color);
	}
	
	
	/*
	 * To test getProductColor() ,getter to get value of product Color
	 */
	
	@Test
	void testGetProductColor() {
		
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductColor("Brown");
		String color="Brown";
		String result=entityProduct.getProductColor();
		assertEquals(color,result);
	}
	
	/*
	 * To test setImageUrl() ,setter to set value of imageurl
	 */
	
	@Test
	void setImageUrlTest() {
		String url="http://chocolate/brown/truffle";
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setImageUrl(url);
		assertEquals(entityProduct.getImageUrl(),url);
	}
	
	/*
	 * To test getImageUrl() ,getter to get value of Image Url
	 */
	
	@Test
	void testGetImageUrl() {
		
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setImageUrl("http://chocolate/brown/truffle");
		String url="http://chocolate/brown/truffle";
		String result=entityProduct.getImageUrl();
		assertEquals(url,result);
	}
	
	/*
	 * To test setProductSpecification() ,setter to set value of description
	 */
	
	@Test
	void productSpecificationTest() {
		String description="Great in taste";
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductSpecification(description);
		assertEquals(entityProduct.getProductSpecification(),description);
	}
	
	/*
	 * To test getProductSpecification() ,getter to get value of ProductSpecification 
	 */
	
	@Test
	void testGetProductSpecification() {
		
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductSpecification("Great in Taste");
		String description="Great in Taste";
		String result=entityProduct.getProductSpecification();
		assertEquals(description,result);
	}
	
	/*
	 * To test setProductQuantity() ,setter to set value of quantity
	 */
	
	@Test
	void productQuantityTest() {
		int quantity=50;
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductQuantity(quantity);
		assertEquals(entityProduct.getProductQuantity(),quantity);
	}
	
	/*
	 * To test getProductQuantity() ,getter to get value of Product Quantity 
	 */
	
	@Test
	void testGetProductQuantity() {
		
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductQuantity(50);
		int quantity=50;
		int result=entityProduct.getProductQuantity();
		assertEquals(quantity,result);
	}
	
	/*
	 * To test setProductPrice() ,setter to set value of product Price
	 */
	
	@Test
	void productPriceTest() {
		double price=500;
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductPrice(price);
		assertEquals(entityProduct.getProductPrice(),price);
	}
	
	/*
	 * To test getProductPrice() ,getter to get value of Product Price 
	 */
	
	@Test
	void testGetProductPrice() {
		
		ProductEntity entityProduct=new ProductEntity();
		entityProduct.setProductPrice(500);
		double price=500;
		double result=entityProduct.getProductPrice();
		assertEquals(price,result);
	}
	
	/*
	 * To test deleteProduct() method when event does not null
	 */
	@Test
	public void deleteProductTest_ProductNotExistWithNull() {

		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
			service.deleteProduct(null);
		});

		assertEquals("Product id should not be null", exception.getMessage());
	}
	/*
	 * To test deleteProduct() method to delete product
	 */

	@Test
	public void deleteProductTest() throws ProductNotFoundException {
		when(repository.existsById(20)).thenReturn(true);
		boolean flag = service.deleteProduct(20);
		assertEquals(true, flag);
	}


//    @Test
// 	public void deleteProductTest_ProductNotExist() {
//
// 		int productId = 102;
//
// 		ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
//         	when(!repository.existsById(20)).thenReturn(false);
//         	service.deleteProduct(productId);
// 		}
//
// 		);
// 		assertEquals("Product does not exist !", exception.getMessage());
// 	}
//	
	public ProductEntity getProductEntity() {
		ProductEntity entity = new ProductEntity();
		entity.setImageUrl(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcScES4Rivb8x41g2BSCrWiw4lhQWrsGYn4h2g&usqp=CAU");
		entity.setProductCategory(ProductCategory.HOME_AND_LIVING);
		entity.setProductColor("Transparent");
		entity.setProductId(20);
		entity.setProductName("Evian Transparent water bottle");
		entity.setProductPrice(500);
		entity.setProductQuantity(15);
		entity.setProductSpecification(
				" The French water supplier collaborated with various highly esteemed perfume designers such as Jean Paul Gaultier or Issey Miyake. Transparent easilyu carriable bottle .");

		return entity;
	}

	public ProductModel getProduct() {
		ProductModel product = new ProductModel();
		product.setImageUrl(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcScES4Rivb8x41g2BSCrWiw4lhQWrsGYn4h2g&usqp=CAU");
		product.setProductCategory(ProductCategory.HOME_AND_LIVING);
		product.setProductColor("Transparent");
		product.setProductId(20);
		product.setProductName("Evian Transparent water bottle");
		product.setProductPrice(500);
		product.setProductQuantity(15);
		product.setProductSpecification(
				" The French water supplier collaborated with various highly esteemed perfume designers such as Jean Paul Gaultier or Issey Miyake. Transparent easilyu carriable bottle .");

		return product;
	}

}
