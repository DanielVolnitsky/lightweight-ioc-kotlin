package com.waytoodanny.iocdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IocDemoApplication

fun main(args: Array<String>) {
    runApplication<IocDemoApplication>(*args)
}
