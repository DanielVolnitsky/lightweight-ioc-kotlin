package com.waytoodanny.iocdemo.domain.impl

import com.waytoodanny.iocdemo.domain.Advertisement
import com.waytoodanny.iocdemo.domain.Announcer
import com.waytoodanny.iocdemo.ioc.annotation.InjectBean
import com.waytoodanny.iocdemo.ioc.annotation.Singleton

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