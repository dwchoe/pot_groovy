package com.tgt.controller

import com.tgt.model.Product
import org.junit.Before
import org.springframework.test.web.servlet.MockMvc

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

import org.springframework.test.web.servlet.result.StatusResultMatchers;
import com.tgt.facade.ProductFacade
import org.junit.Test
import org.mockito.Mock


class ProductControllerTest {
    ProductFacade productFacadeMock = mock(ProductFacade.class)

    ProductController controller

    private MockMvc mvc

    @Before
    public void setup() {
        productFacadeMock = mock(ProductFacade.class)

        controller = new ProductController()
        controller.productFacade = productFacadeMock

        mvc = standaloneSetup(controller).build()
    }

    @Test
    public void shouldBeSuccessful() {
        when(productFacadeMock.getProduct("123")).thenReturn(new Product())

        controller.view("123")
    }
}
