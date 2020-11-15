package com.waytoodanny.iocdemo.ioc

import com.waytoodanny.iocdemo.domain.Policeman
import com.waytoodanny.iocdemo.domain.impl.CommonPoliceman
import com.waytoodanny.iocdemo.ioc.config.Config
import com.waytoodanny.iocdemo.ioc.config.JavaConfig
import com.waytoodanny.iocdemo.ioc.postprocessing.BeanConfigurator
import com.waytoodanny.iocdemo.ioc.postprocessing.impl.InjectPropertyAnnotationBeanConfigurator

object ObjectFactory {

    private val config: Config = JavaConfig(
            "com.waytoodanny",
            mutableMapOf(Policeman::class.java to CommonPoliceman::class.java)
    )
    private val BEAN_CONFIGURATORS: List<BeanConfigurator> = listOf(InjectPropertyAnnotationBeanConfigurator())

    fun <T> createObject(type: Class<T>): T {
        return beanImplementation(type).let { impl ->
            impl.getDeclaredConstructor().newInstance().apply {
                BEAN_CONFIGURATORS.forEach { bc -> bc.configure(this as Any) }
            }
        }
    }

    private fun <T> beanImplementation(type: Class<T>): Class<out T> {
        return when (type.isInterface) {
            true -> config.getImplClass(type)
            false -> type
        }
    }
}