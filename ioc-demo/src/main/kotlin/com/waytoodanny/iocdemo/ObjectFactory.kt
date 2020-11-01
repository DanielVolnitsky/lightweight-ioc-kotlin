package com.waytoodanny.iocdemo

object ObjectFactory {

    fun <T> createObject(type: Class<T>): T {
        val classImpl: Class<T> = type
        if(type.isInterface) {

        }
    }
}