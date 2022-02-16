package de.neuefische.mokitotest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopControllerTest {

    @Test
    void expectToGet2Products(){
        ProductRepo repoMock = mock(ProductRepo.class);
        OrderRepo orderMock = mock(OrderRepo.class);

        ShopService shopService = new ShopService(repoMock, orderMock);

        Product product1 = new ToyProduct("Barbie", 1);
        Product product2 = new ToyProduct("Batman", 2);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        shopService.addProduct(product1);
        shopService.addProduct(product2);


        when(repoMock.getProducts()).thenReturn(productList);

        //verify(repoMock).getProducts();

        assertEquals(productList, shopService.getAllProducts());
    }
    @Test
    void shouldCreate1Product(){
        ProductRepo repoMock = mock(ProductRepo.class);
        OrderRepo orderMock = mock(OrderRepo.class);

        ShopService shopService = new ShopService(repoMock, orderMock);

        Product product1 = new ToyProduct("Barbie", 1);
        Product product2 = new ToyProduct("Batman", 2);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        shopService.addProduct(product1);
        //shopService.addProduct(product2);


        //when(repoMock.getProducts()).thenReturn(productList);

        verify(repoMock).add(product1);

        //assertEquals(productList, shopService.getAllProducts());
    }

}