package com.waytoodanny.iocdemo.domain.impl

import com.waytoodanny.iocdemo.domain.Announcer

class ConsoleAnnouncer : Announcer {

    override fun announce(message: String) = println(message)
}