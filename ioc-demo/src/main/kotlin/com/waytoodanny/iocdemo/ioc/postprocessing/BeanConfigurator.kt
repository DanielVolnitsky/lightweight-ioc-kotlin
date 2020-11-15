package com.waytoodanny.iocdemo.ioc.postprocessing

interface BeanConfigurator {
    fun configure(bean: Any)
}