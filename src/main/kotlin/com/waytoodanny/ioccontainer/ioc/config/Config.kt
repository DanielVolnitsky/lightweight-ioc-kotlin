package com.waytoodanny.ioccontainer.ioc.config

import com.waytoodanny.ioccontainer.ioc.postprocessing.BeanConfigurator

interface Config {

    fun <T> getImplClass(type: Class<T>): Class<out T>

    fun beanConfigurators(): List<BeanConfigurator>
}
