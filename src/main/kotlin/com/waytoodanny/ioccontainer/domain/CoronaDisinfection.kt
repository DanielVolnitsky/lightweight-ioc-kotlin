package com.waytoodanny.ioccontainer.domain

import com.waytoodanny.ioccontainer.ioc.annotation.InjectBean
import com.waytoodanny.ioccontainer.ioc.annotation.Singleton

@Singleton
class CoronaDisinfection {

    @InjectBean
    private var announcer: Announcer? = null
    @InjectBean
    private var policeman: Policeman? = null

    fun start(room: Room) {
        announcer!!.announce("Everybody out!")
        policeman!!.makePeopleLeaveRoom()
        disinfection(room)
        announcer!!.announce("You can risk and come back!")
    }

    private fun disinfection(room: Room) = println("Disinfection team: corona go away!")
}