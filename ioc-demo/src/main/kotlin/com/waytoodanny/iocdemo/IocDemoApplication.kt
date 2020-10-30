package com.waytoodanny.iocdemo

import com.waytoodanny.iocdemo.domain.CoronaDisinfection
import com.waytoodanny.iocdemo.domain.Room
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class IocDemoApplication

fun main(args: Array<String>) {
    val coronaDisinfection = CoronaDisinfection()
    coronaDisinfection.start(Room())
}
