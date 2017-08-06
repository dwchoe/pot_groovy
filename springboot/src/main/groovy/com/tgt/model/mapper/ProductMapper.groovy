package com.tgt.model.mapper

import com.tgt.model.Product
import com.tgt.model.ProductMongo
import com.tgt.model.ProductRedSky


class ProductMapper {
    public Product generateProduct(ProductRedSky productRedSky, ProductMongo productMongo) {
        Product product = new Product()
        product.productId = productRedSky.productId
        product.productDesc = productRedSky.productDescription
        product.buyURL = productRedSky.buyURL
        product.availabilityStatus = productRedSky.availabilityStatus
        product.price = productMongo.price
        product.currencyCode = productMongo.currencyCode
        return product
    }
}
