package com.waytoodanny.iocdemo.ioc.annotation

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class InjectProperty(val value: String = "")
