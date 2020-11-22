package com.waytoodanny.ioccontainer.domain.impl

import com.waytoodanny.ioccontainer.domain.Policeman
import com.waytoodanny.ioccontainer.ioc.annotation.Singleton

@Singleton
class AngryPoliceman : Policeman {

    override fun makePeopleLeaveRoom() {
        println("Policeman: go out or I put out a gun!")
    }
}