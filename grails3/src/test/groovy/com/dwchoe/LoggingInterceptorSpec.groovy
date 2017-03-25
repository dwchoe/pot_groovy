package com.dwchoe


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoggingInterceptor)
class LoggingInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test logging interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"stock")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
