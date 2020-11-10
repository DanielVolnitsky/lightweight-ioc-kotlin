package com.waytoodanny.iocdemo.ioc.postprocessing

interface BeanConfigurer {
    fun configure(bean: Any)
}