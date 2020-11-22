package com.waytoodanny.ioccontainer.ioc.annotation

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class InjectProperty(val value: String = "")
