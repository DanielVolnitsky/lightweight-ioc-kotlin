package com.waytoodanny.ioccontainer.domain.impl

import com.waytoodanny.ioccontainer.domain.Advertisement
import com.waytoodanny.ioccontainer.domain.Announcer
import com.waytoodanny.ioccontainer.ioc.annotation.InjectBean
import com.waytoodanny.ioccontainer.ioc.annotation.Singleton

@Singleton
class ConsoleAnnouncer : Announcer {

    @InjectBean
    private var advertisement: Advertisement? = null

    fun init(): Unit = println(this::class.toString() + " init method execution")

    override fun announce(message: String) {
        advertisement!!.advertise()
        println("Announcer: $message")
    }
}