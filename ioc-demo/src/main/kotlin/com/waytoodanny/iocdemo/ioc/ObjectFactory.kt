package com.waytoodanny.iocdemo.ioc

import com.waytoodanny.iocdemo.domain.Policeman
import com.waytoodanny.iocdemo.domain.impl.CommonPoliceman
import com.waytoodanny.iocdemo.ioc.config.Config
import com.waytoodanny.iocdemo.ioc.config.JavaConfig
import com.waytoodanny.iocdemo.ioc.postprocessing.BeanConfigurer
import com.waytoodanny.iocdemo.ioc.postprocessing.impl.InjectPropertyAnnotationBeanConfigurer

object ObjectFactory {

    private val config: Config = JavaConfig(
            "com.waytoodanny",
            mutableMapOf(Policeman::class.java to CommonPoliceman::class.java)
    )
    private val beanConfigurers: List<BeanConfigurer> = listOf(InjectPropertyAnnotationBeanConfigurer())

    fun <T> createObject(type: Class<T>): T {
        val implClass: Class<out T> = when (type.isInterface) {
            true -> config.getImplClass(type)
            false -> type
        }
        val originalBean: T = implClass.getDeclaredConstructor().newInstance()
        beanConfigurers.forEach { bc -> bc.configure(originalBean as Any) }
        return originalBean
    }
}