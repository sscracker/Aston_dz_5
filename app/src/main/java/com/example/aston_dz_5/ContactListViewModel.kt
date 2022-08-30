package com.example.aston_dz_5

import androidx.lifecycle.ViewModel

class ContactListViewModel: ViewModel() {
    val contacts = mutableListOf<Contact>()

    init {
        for (i in 0 until 4){
            val contact = Contact()
            contact.name = "Contact #$i"
            contacts += contact
        }
    }
}