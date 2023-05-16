package com.example.produktapi.service;

import com.example.produktapi.exception.BadRequestException;
import com.example.produktapi.model.Product;
import com.example.produktapi.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;

    //Author: PRIYANKA
    @Test
    public void getAllCategoriesTest() {
        String Category1 = "kids clothing";
        String Category2 = "beauty products";

        List<String> mockCategoryList = new ArrayList<>();
        mockCategoryList.add(Category1);
        mockCategoryList.add(Category2);

        when(repository.findAllCategories())
                .thenReturn(mockCategoryList);

        List<String> categoryList = service.getAllCategories();

        Assertions.assertEquals(2, categoryList.size());
    }
    
    //Author: PRIYANKA
    @Test
    public void testGetAllProducts() {

        Product productA = new Product("ProductA", 110.10, "jewelery", "beautiful", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");

        List<Product> mockProductList = new ArrayList<>();
        mockProductList.add(productA);

        when(repository.findAll())
                .thenReturn(mockProductList);

        List<Product> productList = service.getAllProducts();

        Assertions.assertEquals(1, productList.size());
        Assertions.assertEquals("ProductA", productList.get(0).getTitle());
    }

    // Author: Jim
    @Test
    void test_addProduct() {
        Product mockHatProduct = new Product("Green hat", 10.0, "Hats", "A green hat", "http://imagelink");
        when(repository.save(mockHatProduct))
                .thenReturn(mockHatProduct);
        assertEquals(mockHatProduct, service.addProduct(mockHatProduct));
    }

    // Author: Jim
    @Test
    void test_addProductException() {
        Product mockProduct = mock(Product.class);
        when(repository.save(mockProduct))
                .thenThrow(BadRequestException.class);
        assertThrows(BadRequestException.class, () -> {
            service.addProduct(mockProduct);
        });
    }
}
