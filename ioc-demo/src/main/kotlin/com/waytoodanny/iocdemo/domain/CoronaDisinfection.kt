package com.waytoodanny.iocdemo.domain

import com.waytoodanny.iocdemo.ObjectFactory

class CoronaDisinfection(private val announcer: Announcer = ObjectFactory.createObject(Announcer::class.java),
                         private val policeman: Policeman = ObjectFactory.createObject(Policeman::class.java)) {

    fun start(room: Room) {
        announcer.announce("Everybody out!")
        policeman.makePeopleLeaveRoom()
        disinfection(room)
        announcer.announce("You can risk and come back!")
    }

    private fun disinfection(room: Room) = println("Corona go away!")
}