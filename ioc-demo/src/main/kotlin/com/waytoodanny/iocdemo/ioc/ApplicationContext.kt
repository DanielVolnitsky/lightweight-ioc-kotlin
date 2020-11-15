package com.waytoodanny.iocdemo.ioc

import com.waytoodanny.iocdemo.ioc.config.Config
import com.waytoodanny.iocdemo.ioc.postprocessing.BeanConfigurator
import java.util.concurrent.ConcurrentHashMap

class ApplicationContext(private val config: Config) {

    //TODO add get
    val beanConfigurators: List<BeanConfigurator> = config.beanConfigurators()

    //TODO
    var objectFactory: ObjectFactory? = null

    private val beanCache: MutableMap<Class<*>, Any?> = ConcurrentHashMap()

    fun <T> getObject(type: Class<T>): T {
        val bean =
                if (beanCache[type] != null) beanCache[type]
                else {
                    with(fetchObject(type)) {
                        beanCache[type] = this
                        return this
                    }
                }

        @Suppress("UNCHECKED_CAST")
        return bean as T
    }

    private fun <T> fetchObject(type: Class<T>): T =
            beanImplementationClass(type)
                    .let { objectFactory!!.createObject(it) }

    private fun <T> beanImplementationClass(type: Class<T>): Class<out T> =
            if (type.isInterface) config.getImplClass(type) else type
}