package com.waytoodanny.ioccontainer.ioc.postprocessing.impl

import com.waytoodanny.ioccontainer.ioc.ApplicationContext
import com.waytoodanny.ioccontainer.ioc.annotation.InjectBean
import com.waytoodanny.ioccontainer.ioc.postprocessing.BeanConfigurator

class InjectBeanAnnotationConfigurator : BeanConfigurator {

    override fun configure(bean: Any, context: ApplicationContext) {
        bean.javaClass.declaredFields
                .filter { field -> field.isAnnotationPresent(InjectBean::class.java) }
                .forEach { field ->
                    field.trySetAccessible()
                    field.set(bean, context.getObject(field.type))
                }
    }
}