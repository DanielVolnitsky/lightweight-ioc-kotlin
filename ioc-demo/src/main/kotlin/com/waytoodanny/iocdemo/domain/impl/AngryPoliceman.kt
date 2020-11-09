package com.waytoodanny.iocdemo.domain.impl

import com.waytoodanny.iocdemo.domain.Policeman

class AngryPoliceman : Policeman {

    override fun makePeopleLeaveRoom() {
        println("Policeman: go out or I put out a gun!")
    }
}