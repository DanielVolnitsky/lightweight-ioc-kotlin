package com.waytoodanny.ioccontainer.domain.impl

import com.waytoodanny.ioccontainer.domain.Policeman
import com.waytoodanny.ioccontainer.ioc.annotation.Singleton

@Singleton
class CommonPoliceman : Policeman {

    override fun makePeopleLeaveRoom() = println("Policeman: go out!")
}
