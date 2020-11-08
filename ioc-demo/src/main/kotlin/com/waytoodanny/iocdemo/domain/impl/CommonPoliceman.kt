package com.waytoodanny.iocdemo.domain.impl

import com.waytoodanny.iocdemo.domain.Policeman

class CommonPoliceman : Policeman {

    override fun makePeopleLeaveRoom() = println("Making people leave room")
}
