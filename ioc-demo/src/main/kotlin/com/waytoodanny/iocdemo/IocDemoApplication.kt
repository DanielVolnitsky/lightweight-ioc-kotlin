package com.waytoodanny.iocdemo

import com.waytoodanny.iocdemo.domain.CoronaDisinfection
import com.waytoodanny.iocdemo.domain.Policeman
import com.waytoodanny.iocdemo.domain.Room
import com.waytoodanny.iocdemo.domain.impl.CommonPoliceman
import com.waytoodanny.iocdemo.ioc.Application
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class IocDemoApplication

fun main(args: Array<String>) {
    val applicationContext = Application.run(
            "com.waytoodanny",
            mutableMapOf(Policeman::class.java to CommonPoliceman::class.java)
    )

    applicationContext
            .getObject(CoronaDisinfection::class.java)
            .start(Room())
}
