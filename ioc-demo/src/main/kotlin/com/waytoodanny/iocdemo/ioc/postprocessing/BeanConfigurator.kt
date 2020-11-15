package com.waytoodanny.iocdemo.ioc.postprocessing

import com.waytoodanny.iocdemo.ioc.ApplicationContext

interface BeanConfigurator {
    fun configure(bean: Any, context: ApplicationContext)
}