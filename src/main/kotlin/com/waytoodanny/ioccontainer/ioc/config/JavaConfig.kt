package com.waytoodanny.ioccontainer.ioc.config

import com.waytoodanny.ioccontainer.ioc.postprocessing.BeanConfigurator
import org.reflections.Reflections

class JavaConfig(packageToScan: String,
                 private val beanImplementations: MutableMap<Class<*>, Class<*>>) : Config {

    private val scanner: Reflections = Reflections(packageToScan)

    override fun <T> getImplClass(type: Class<T>): Class<out T> {
        val beanImplClass: Class<out Any> = beanImplementations.computeIfAbsent(type) { t ->
            val classSubtypes = scanner.getSubTypesOf(t)
            when (classSubtypes.size) {
                1 -> classSubtypes.iterator().next()
                else -> throw RuntimeException("$t has zero or more than one implementation")
            }
        }

        @Suppress("UNCHECKED_CAST")
        return beanImplClass as Class<T>
    }

    override fun beanConfigurators(): List<BeanConfigurator> =
            scanner.getSubTypesOf(BeanConfigurator::class.java)
                    .asIterable()
                    .map { c -> c.getDeclaredConstructor().newInstance() }
}