package com.waytoodanny.iocdemo.domain

import com.waytoodanny.iocdemo.domain.impl.CommonPoliceman
import com.waytoodanny.iocdemo.domain.impl.ConsoleAnnouncer

class CoronaDisinfection(private val announcer: Announcer = ConsoleAnnouncer(),
                         private val policeman: Policeman = CommonPoliceman()) {

    fun start(room: Room) {
        announcer.announce("Everybody out!")
        policeman.makePeopleLeaveRoom()
        disinfection(room)
        announcer.announce("You can risk and come back!")
    }

    private fun disinfection(room: Room) = println("Corona go away!")
}