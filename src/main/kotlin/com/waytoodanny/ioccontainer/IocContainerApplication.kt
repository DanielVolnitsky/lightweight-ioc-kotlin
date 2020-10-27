package com.waytoodanny.ioccontainer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IocContainerApplication

fun main(args: Array<String>) {
    runApplication<IocContainerApplication>(*args)
}
