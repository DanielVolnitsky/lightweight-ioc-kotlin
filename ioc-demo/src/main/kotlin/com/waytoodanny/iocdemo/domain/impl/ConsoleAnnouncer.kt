package com.waytoodanny.iocdemo.domain.impl

import com.waytoodanny.iocdemo.domain.Advertisement
import com.waytoodanny.iocdemo.domain.Announcer
import com.waytoodanny.iocdemo.ioc.ObjectFactory

class ConsoleAnnouncer : Announcer {

    private var advertisement: Advertisement = ObjectFactory.createObject(Advertisement::class.java)

    override fun announce(message: String) {
        advertisement.advertise()
        println("Announcer: $message")
    }
}