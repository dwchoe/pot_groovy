package com.dwchoe.filter

/**
 * Created by z0019mz on 12/24/15.
 */
class SecurityFilter {
    def filters = {
        check(controller: '(stock)', action: '(*)') {
            before = {
                println 'SecurityFilter - start'
            }
        }
    }
}
