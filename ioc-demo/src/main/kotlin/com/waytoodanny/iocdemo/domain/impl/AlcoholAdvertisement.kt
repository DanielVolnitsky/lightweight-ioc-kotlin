package com.waytoodanny.iocdemo.domain.impl

import com.waytoodanny.iocdemo.domain.Advertisement
import com.waytoodanny.iocdemo.ioc.annotation.InjectProperty

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