package com.tgt.service

import com.tgt.model.ProductRedSky
import com.tgt.model.mapper.ProductRedSkyMapper
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Slf4j
@Component
class ProductRedSkyService {

    @Autowired
    public RestTemplate redSkyService

    ProductRedSkyService() {}

    @Cacheable("productCache")
    public ProductRedSky getProductInfo(String id) {
        String product = redSkyService.getForObject("http://redsky.target.com/v2/pdp/tcin/${id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics",String.class)
        ProductRedSkyMapper mapper = new ProductRedSkyMapper()
        log.info("product:" + product)

        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(product)

        ProductRedSky productRedSky = mapper.generateProductRedSky(object)
        return productRedSky
    }
}

