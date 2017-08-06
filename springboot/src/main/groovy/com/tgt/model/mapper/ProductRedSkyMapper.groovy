package com.tgt.model.mapper

import com.tgt.model.ProductRedSky
import groovy.util.logging.Slf4j

@Slf4j
class ProductRedSkyMapper {
    public ProductRedSky generateProductRedSky(def productMap) {
        Objects.requireNonNull(productMap)

        String productId = (String)productMap.product.item.tcin
        String productDesc = (String)productMap.product.item.product_description.title
        String buyURL = (String)productMap.product.item.buy_url
        String availabilityStatus = (String)productMap.product.available_to_promise_network.availability_status

        ProductRedSky productRedSky = new ProductRedSky(productId, productDesc, buyURL, availabilityStatus)
    }
}
