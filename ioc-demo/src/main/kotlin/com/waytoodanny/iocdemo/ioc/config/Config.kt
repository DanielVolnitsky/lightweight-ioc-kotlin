package com.waytoodanny.iocdemo.ioc.config

interface Config {

    fun <T> getImplClass(type: Class<T>): Class<out T>
}
