package com.waytoodanny.iocdemo.ioc.config

import com.waytoodanny.iocdemo.ioc.postprocessing.BeanConfigurator

interface Config {

    fun <T> getImplClass(type: Class<T>): Class<out T>

    fun beanConfigurators(): List<BeanConfigurator>
}
