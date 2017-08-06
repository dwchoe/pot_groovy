package com.tgt.facade

import com.tgt.model.Product
import com.tgt.model.ProductMongo
import com.tgt.model.ProductRedSky
import com.tgt.model.mapper.ProductMapper
import com.tgt.service.ProductMongoService
import com.tgt.service.ProductRedSkyService
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
class ProductFacade {
    @Autowired
    ProductMongoService productMongoService

    @Autowired
    ProductRedSkyService productRedSkyService

    public Product getProduct(String productId) {
        log.info("get product:${productId}")

        ProductMapper mapper = new ProductMapper()
        Product product = new Product()

        // TODO: async
        ProductRedSky productRedSky = productRedSkyService.getProductInfo(productId)
        ProductMongo productMongo = productMongoService.getPrice(productId)

        return mapper.generateProduct(productRedSky,productMongo)
    }

    public void updatePrice(String productId, String price) {
        productMongoService.updatePrice(productId, price)
    }
}
