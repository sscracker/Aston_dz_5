package com.example.aston_dz_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class ContactActivity : AppCompatActivity(),ContactListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null){
            val fragment = ContactListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }

    override fun onContactSelected(contactId: UUID) {
        val fragment = ContactFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()

    }
}