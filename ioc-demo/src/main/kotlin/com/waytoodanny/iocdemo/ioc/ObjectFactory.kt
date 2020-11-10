package com.waytoodanny.iocdemo.ioc

import com.waytoodanny.iocdemo.domain.Policeman
import com.waytoodanny.iocdemo.domain.impl.CommonPoliceman
import com.waytoodanny.iocdemo.ioc.annotation.InjectProperty
import com.waytoodanny.iocdemo.ioc.config.Config
import com.waytoodanny.iocdemo.ioc.config.JavaConfig
import java.lang.reflect.Field
import java.net.URI
import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.asSequence

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
        val originalBean: T = implClass.getDeclaredConstructor().newInstance()

        val declaredFields: Array<Field> = implClass.declaredFields
        declaredFields.forEach { f ->
            val annotation = f.getAnnotation(InjectProperty::class.java)
            if (annotation != null) {
                val propertiesURL: URI? = ClassLoader.getSystemClassLoader().getResource("application.properties")?.toURI()
                val fileLines = propertiesURL?.let { Path.of(it) }?.let { Files.lines(it) }?.asSequence()
                val properties = fileLines?.associate { it.split("=").let { (k, v) -> k to v } }
                val value =
                        if (annotation.value.isNotEmpty()) properties?.get(annotation.value)
                        else properties?.get(f.name)
                f.trySetAccessible()
                f.set(originalBean, value)
            }
        }

        return originalBean
    }
}