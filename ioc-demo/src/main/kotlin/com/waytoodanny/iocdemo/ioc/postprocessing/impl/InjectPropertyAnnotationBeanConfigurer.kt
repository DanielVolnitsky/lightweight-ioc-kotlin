package com.waytoodanny.iocdemo.ioc.postprocessing.impl

import com.waytoodanny.iocdemo.ioc.annotation.InjectProperty
import com.waytoodanny.iocdemo.ioc.postprocessing.BeanConfigurer
import java.net.URI
import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.asSequence

class InjectPropertyAnnotationBeanConfigurer : BeanConfigurer {

    private val properties: Map<String, String>

    init {
        val propertiesURL: URI =
                ClassLoader.getSystemClassLoader().getResource("application.properties")?.toURI()
                        ?: throw RuntimeException("No 'application.properties' found")

        val fileLines = propertiesURL.let { Path.of(it) }.let { Files.lines(it) }.asSequence()
        this.properties = fileLines.associate { it.split("=").let { (k, v) -> k to v } }
    }

    override fun configure(bean: Any) {
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