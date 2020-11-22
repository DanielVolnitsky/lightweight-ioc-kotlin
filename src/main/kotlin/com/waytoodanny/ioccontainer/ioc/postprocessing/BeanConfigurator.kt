package com.waytoodanny.ioccontainer.ioc.postprocessing

import com.waytoodanny.ioccontainer.ioc.ApplicationContext

interface BeanConfigurator {
    fun configure(bean: Any, context: ApplicationContext)
}