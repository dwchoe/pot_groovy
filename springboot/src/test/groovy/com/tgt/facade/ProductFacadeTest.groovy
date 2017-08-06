package com.tgt.facade

import com.tgt.model.Product
import com.tgt.model.ProductMongo
import com.tgt.model.ProductRedSky
import com.tgt.service.ProductRedSkyService
import org.junit.Assert;
import org.junit.Before
import org.mockito.Mock

import static org.mockito.Mockito.*;

import com.tgt.service.ProductMongoService
import org.junit.Test

class ProductFacadeTest {
    ProductMongoService productMongoService
    ProductRedSkyService productRedSkyService

    ProductFacade productFacade

    @Before
    public void setup() {
        productFacade = new ProductFacade()
        productRedSkyService = mock(ProductRedSkyService.class)
        productMongoService = mock(ProductMongoService.class)

        productFacade.productMongoService = productMongoService
        productFacade.productRedSkyService = productRedSkyService
    }

    @Test
    public void shouldReturnProduct() {
        String productId = "123"
        ProductRedSky productRedSky = new ProductRedSky("123","Coke","https://www.target.com","IN_STOCK")
        ProductMongo productMongo = new ProductMongo()
        productMongo.price = "12.50"
        productMongo.currencyCode = "USD"

        when(productRedSkyService.getProductInfo(productId)).thenReturn(productRedSky)
        when(productMongoService.getPrice(productId)).thenReturn(productMongo)

        Product product = productFacade.getProduct(productId)
        Assert.assertEquals("123",product.productId)
        Assert.assertEquals("Coke",product.productDesc)
        Assert.assertEquals("12.50",product.price)

    }
}

