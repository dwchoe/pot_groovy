package com.tgt.model


class Product {
    String productId
    String productDesc
    String buyURL
    String availabilityStatus
    String price
    String currencyCode


    public String toString() {
        StringBuffer sb = new StringBuffer()
        sb.append("productId:" + productId + ",")
        sb.append("productDesc:" + productDesc + ",")
        sb.append("buyURL:" + buyURL + ",")
        sb.append("availabilityStatus" + availabilityStatus + ",")
        sb.append("price:" + price + ",")
        sb.append("currencyCode:" + currencyCode)
        return sb.toString()
    }
}
