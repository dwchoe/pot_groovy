package com.dwchoe


class LoggingInterceptor {
    public LoggingInterceptor() {
        match controller: 'stock'
    }

    boolean before() {
        println 'LoggingInterceptor - before'
        true
    }

    boolean after() {
        println 'LoggingInterceptor - after'
        true
    }

    void afterView() {
        println 'LoggingInterceptor - after view'
    }
}
