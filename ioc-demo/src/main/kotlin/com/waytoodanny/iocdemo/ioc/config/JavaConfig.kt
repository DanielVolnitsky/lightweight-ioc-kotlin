package com.waytoodanny.iocdemo.ioc.config

import org.reflections.Reflections

class JavaConfig(packageToScan: String) : Config {

    private val scanner: Reflections = Reflections(packageToScan)

    override fun <T> getImplClass(type: Class<T>): Class<out T> {
        val classSubtypes = scanner.getSubTypesOf(type)
        return when (classSubtypes.size) {
            1 -> classSubtypes.iterator().next()
            else -> throw RuntimeException("$type has zero or more than one implementation")
        }
    }
}