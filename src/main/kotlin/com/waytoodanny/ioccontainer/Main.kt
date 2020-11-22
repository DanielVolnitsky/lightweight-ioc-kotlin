package com.waytoodanny.ioccontainer

import com.waytoodanny.ioccontainer.domain.CoronaDisinfection
import com.waytoodanny.ioccontainer.domain.Policeman
import com.waytoodanny.ioccontainer.domain.Room
import com.waytoodanny.ioccontainer.domain.impl.CommonPoliceman
import com.waytoodanny.ioccontainer.ioc.Application

fun main(args: Array<String>) {
    val applicationContext = Application.run(
            "com.waytoodanny",
            mutableMapOf(Policeman::class.java to CommonPoliceman::class.java)
    )

    applicationContext
            .getObject(CoronaDisinfection::class.java)
            .start(Room())
}

