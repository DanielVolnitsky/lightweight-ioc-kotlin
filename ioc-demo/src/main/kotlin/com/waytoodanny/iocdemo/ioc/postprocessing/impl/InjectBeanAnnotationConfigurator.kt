package com.waytoodanny.iocdemo.ioc.postprocessing.impl

import com.waytoodanny.iocdemo.ioc.ApplicationContext
import com.waytoodanny.iocdemo.ioc.annotation.InjectBean
import com.waytoodanny.iocdemo.ioc.postprocessing.BeanConfigurator

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