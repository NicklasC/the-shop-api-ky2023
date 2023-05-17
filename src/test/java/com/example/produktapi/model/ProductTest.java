package com.example.produktapi.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product;
    private Product createTestProduct() {
        Product product = new Product("Golden ring", 25.1, "jewelery", "A beautiful ring", "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg");
        product.setId(25);
        return product;
    }

    @Test
    public void testGetId(){
        product = createTestProduct();
        Assert.assertEquals("25",product.getId().toString());
    }
    @Test
    public void testSetId(){
        product = createTestProduct();
        product.setId(34);
        Assert.assertEquals("34",product.getId().toString());
    }

    @Test
    public void testGetTitle(){
        product = createTestProduct();
        Assert.assertEquals("Golden ring",product.getTitle());
    }
    @Test
    public void testSetTitle(){
        product = createTestProduct();
        product.setTitle("New test title");
        Assert.assertEquals("New test title",product.getTitle());
    }
    @Test
    public void testGetPrice(){
        product = createTestProduct();
        Double expectedResult=25.1;

        Double actualResult = product.getPrice();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetPrice(){
        product = createTestProduct();
        Double newPrice = 54.3;

        product.setPrice(newPrice);
        Double actualResult = product.getPrice();

        Assert.assertEquals(newPrice,actualResult);
    }

    @Test
    public void testGetCategory(){
        product = createTestProduct();
        Assert.assertEquals("jewelery",product.getCategory());
    }

    @Test
    public void testSetCategory(){
        product = createTestProduct();
        product.setCategory("Test category");
        Assert.assertEquals("Test category",product.getCategory());
    }


    @Test
    public void testGetDescription(){
        product = createTestProduct();
        Assert.assertEquals("A beautiful ring",product.getDescription());
    }

    @Test
    public void testSetDescription(){
        product = createTestProduct();
        product.setDescription("This is a new description");
        Assert.assertEquals("This is a new description",product.getDescription());
    }

    @Test
    public void testGetImage(){
        product = createTestProduct();
        Assert.assertEquals("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",product.getImage());
    }

    @Test
    public void testSetImage(){
        product = createTestProduct();
        product.setImage("https://someurl.com/test.jpg");
        Assert.assertEquals("https://someurl.com/test.jpg",product.getImage());
    }



}
