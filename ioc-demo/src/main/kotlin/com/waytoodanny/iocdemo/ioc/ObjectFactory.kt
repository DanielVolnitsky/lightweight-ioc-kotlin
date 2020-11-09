package com.waytoodanny.iocdemo.ioc

import com.waytoodanny.iocdemo.domain.Policeman
import com.waytoodanny.iocdemo.domain.impl.CommonPoliceman
import com.waytoodanny.iocdemo.ioc.config.Config
import com.waytoodanny.iocdemo.ioc.config.JavaConfig

object ObjectFactory {

    private val config: Config = JavaConfig(
            "com.waytoodanny",
            mutableMapOf(Policeman::class.java to CommonPoliceman::class.java)
    )

    fun <T> createObject(type: Class<T>): T {
        val implClass: Class<out T> = when (type.isInterface) {
            true -> config.getImplClass(type)
            false -> type
        }
        return implClass.getDeclaredConstructor().newInstance()
    }
}