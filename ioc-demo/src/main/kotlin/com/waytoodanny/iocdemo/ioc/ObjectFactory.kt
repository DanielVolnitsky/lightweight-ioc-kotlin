package com.waytoodanny.iocdemo.ioc

class ObjectFactory(private val context: ApplicationContext) {

    fun <T> createObject(type: Class<T>): T =
            type.getDeclaredConstructor().newInstance().apply {
                context.beanConfigurators.forEach { it.configure(this as Any, context) }
            }
}