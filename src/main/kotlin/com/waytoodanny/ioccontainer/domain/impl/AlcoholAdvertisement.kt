package com.waytoodanny.ioccontainer.domain.impl

import com.waytoodanny.ioccontainer.domain.Advertisement
import com.waytoodanny.ioccontainer.ioc.annotation.InjectProperty
import com.waytoodanny.ioccontainer.ioc.annotation.Singleton

@Singleton
class AlcoholAdvertisement : Advertisement {

    @field:InjectProperty
    var alcohol: String? = null

    override fun advertise() {
        println(
                if (alcohol != null)
                    "Advertisement: $alcohol is the best protection from corona!"
                else
                    "Advertisement: There might have been your ad."
        )
    }
}