package com.waytoodanny.ioccontainer.ioc.postprocessing.impl

import com.waytoodanny.ioccontainer.ioc.ApplicationContext
import com.waytoodanny.ioccontainer.ioc.annotation.InjectProperty
import com.waytoodanny.ioccontainer.ioc.postprocessing.BeanConfigurator
import java.net.URI
import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.asSequence

class InjectPropertyAnnotationBeanConfigurator : BeanConfigurator {

    private val properties: Map<String, String>

    init {
        val propertiesURI: URI =
                ClassLoader.getSystemClassLoader().getResource("application.properties")?.toURI()
                        ?: throw RuntimeException("No 'application.properties' found")

        val fileLines = propertiesURI.let { Path.of(it) }.let { Files.lines(it) }.asSequence()
        this.properties = fileLines.associate { it.split("=").let { (k, v) -> k to v } }
    }

    override fun configure(bean: Any, context: ApplicationContext) {
        bean.javaClass.declaredFields.forEach { field ->
            field.getAnnotation(InjectProperty::class.java)?.let { annotation ->
                val value = if (annotation.value.isNotEmpty()) properties[annotation.value] else properties[field.name]
                with(field) {
                    this.trySetAccessible()
                    this.set(bean, value)
                }
            }
        }
    }
}