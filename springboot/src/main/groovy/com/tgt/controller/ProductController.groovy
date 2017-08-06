package com.tgt.controller

import com.tgt.facade.ProductFacade
import com.tgt.model.Product
import com.tgt.model.ProductRedSky
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.util.logging.Slf4j
import org.apache.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
@Slf4j
class ProductController {

    @Autowired
    ProductFacade productFacade;

    @RequestMapping(path= '/{id}',
            method = RequestMethod.GET,
            produces = 'application/json')
    public String view(@PathVariable("id") String id) {
        Product productResponse = null

        productResponse = productFacade.getProduct(id)

        def builder = new JsonBuilder()

        def root = builder.product {
            detail {
                product_id "${productResponse.productId}"
                description "${productResponse.productDesc}"
                buy_url "${productResponse.buyURL}"
                availability_status "${productResponse.availabilityStatus}"

            }

            current_value {
                price "${productResponse.price}"
                currency_code "${productResponse.currencyCode}"
            }
        }

        return builder.toPrettyString()
    }

    @RequestMapping(path= '/{id}',
            method = RequestMethod.PUT,
            produces = 'application/json')
    public String update(@PathVariable("id") String id, @RequestBody Map body) {
        Product productResponse = null

        String price = body.get("price")
        productResponse = productFacade.updatePrice(id, price)

        return ""
    }
}
