package com.tgt.model


class ProductRedSky implements Serializable{
    String productId
    String productDescription
    String buyURL
    String availabilityStatus

    ProductRedSky(String productId, String productDescription, String buyURL, String availabilityStatus) {
        this.productId = productId
        this.productDescription = productDescription
        this.buyURL = buyURL
        this.availabilityStatus = availabilityStatus
    }
}
