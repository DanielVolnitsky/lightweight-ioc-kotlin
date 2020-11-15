package com.waytoodanny.iocdemo.ioc

import com.waytoodanny.iocdemo.ioc.config.Config
import com.waytoodanny.iocdemo.ioc.config.JavaConfig

object Application {

    fun run(packageToScan: String,
            beanImplementations: MutableMap<Class<*>, Class<out Any>>): ApplicationContext {

        val config: Config = JavaConfig(packageToScan, beanImplementations)
        val context = ApplicationContext(config)
        val objectFactory = ObjectFactory(context)
        context.objectFactory = objectFactory
        return context
    }
}