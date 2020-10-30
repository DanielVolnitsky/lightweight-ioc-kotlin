package com.waytoodanny.ioc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IocApplication

fun main(args: Array<String>) {
    runApplication<IocApplication>(*args)
}
