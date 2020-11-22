package com.waytoodanny.iocdemo.ioc

class ObjectFactory(private val context: ApplicationContext) {

    fun <T> createObject(type: Class<T>): T =
            type.getDeclaredConstructor().newInstance()
                    .apply {
                        configure(this)
                        callSecondPhaseConstructors(type, this)
                    }

    private fun <T> configure(bean: T) {
        context.beanConfigurators.forEach {
            it.configure(bean as Any, context)
        }
    }

    private fun <T> callSecondPhaseConstructors(type: Class<T>, bean: T) {
        type.methods
                .filter { "init" == it.name }
                .forEach { it.invoke(bean) }
    }
}