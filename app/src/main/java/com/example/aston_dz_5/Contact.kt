package com.example.aston_dz_5

import java.util.*

data class Contact(val id: UUID = UUID.randomUUID(),
                   var name: String = "Vladimir",
                   var surName:String = "asf",
                   var phone: String = "89013457123"){

    init {
        setRandomName()
        setRandomSurnameName()
        setRandomPhone()
    }



    private fun setRandomName(){
        var random = Random()
        var dict: String = "abcsdfsdnfgdjgdfmg"
        var char2: Char = dict[random.nextInt(dict.length)]
        var char3: Char = dict[random.nextInt(dict.length)]
        var char4: Char = dict[random.nextInt(dict.length)]
        var char1: Char = dict[random.nextInt(dict.length)]
        var sum = "Name: $char1$char2$char3$char4"
        name = sum


    }

    private fun setRandomSurnameName(){
        var random = Random()
        var dict: String = "abcsdfsdnfgdjgdfmg"
        var char2: Char = dict[random.nextInt(dict.length)]
        var char3: Char = dict[random.nextInt(dict.length)]
        var char4: Char = dict[random.nextInt(dict.length)]
        var char1: Char = dict[random.nextInt(dict.length)]
        var sum = "Surname: $char1$char2$char3$char4"
        surName = sum


    }

    private fun setRandomPhone(){
        var random = Random()
        var dict: String = "1234567890"
        var char2: Char = dict[random.nextInt(dict.length)]
        var char3: Char = dict[random.nextInt(dict.length)]
        var char4: Char = dict[random.nextInt(dict.length)]
        var char1: Char = dict[random.nextInt(dict.length)]
        var sum = "Phone: $char1$char2$char3$char4"
        phone = sum


    }


}
