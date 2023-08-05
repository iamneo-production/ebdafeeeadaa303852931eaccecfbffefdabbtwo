// ProductControllerTest.java
package com.example.springapp;

import com.example.springapp.controller.ProductController;
import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;

public class SpringappApplicationTests {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct_ValidInput_ReturnsProductWithId() {
        // Arrange
        Product inputProduct = new Product("Product A", 10.99, 100);

        when(productService.createProduct(any(Product.class))).thenReturn(inputProduct);

        // Act
        ResponseEntity<Product> response = productController.createProduct(inputProduct);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(inputProduct.getName(), response.getBody().getName());
        assertEquals(inputProduct.getPrice(), response.getBody().getPrice());
        assertEquals(inputProduct.getQuantity(), response.getBody().getQuantity());
    }

    @Test
    public void testCreateProduct_InvalidInput_ReturnsBadRequest() {
        // Arrange
        Product inputProduct = new Product(null, 10.99, 100);

        // Act
        ResponseEntity<Product> response = productController.createProduct(inputProduct);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetProductById_ValidId_ReturnsProduct() {
        // Arrange
        Long productId = 1L;
        Product product = new Product("Product A", 10.99, 100);
        product.setId(productId);

        when(productService.getProductById(productId)).thenReturn(product);

        // Act
        ResponseEntity<Product> response = productController.getProduct(productId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product.getName(), response.getBody().getName());
        assertEquals(product.getPrice(), response.getBody().getPrice());
        assertEquals(product.getQuantity(), response.getBody().getQuantity());
    }

    @Test
    public void testGetProductById_InvalidId_ReturnsNotFound() {
        // Arrange
        Long invalidId = 999L;

        when(productService.getProductById(invalidId)).thenReturn(null);

        // Act
        ResponseEntity<Product> response = productController.getProduct(invalidId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

 @Test

    public void controllerfolder() {

        String directoryPath = "src/main/java/com/example/springapp/controller"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

	@Test

    public void controllerfile() {

        String filePath = "src/main/java/com/example/springapp/controller/ProductController.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


	@Test

    public void testModelFolder() {

        String directoryPath = "src/main/java/com/example/springapp/model"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

	@Test

    public void testModelFile() {

        String filePath = "src/main/java/com/example/springapp/model/Product.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

	@Test

    public void testrepositoryfolder() {

        String directoryPath = "src/main/java/com/example/springapp/repository"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testrepositoryFile() {

        String filePath = "src/main/java/com/example/springapp/repository/InMemoryProductRepository.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

     @Test

    public void testrepositoryFile1() {

        String filePath = "src/main/java/com/example/springapp/repository/ProductRepository.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


    @Test

    public void testServiceFolder() {

        String directoryPath = "src/main/java/com/example/springapp/service"; 

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testServieFile() {

        String filePath = "src/main/java/com/example/springapp/service/ProductService.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }




	


}
