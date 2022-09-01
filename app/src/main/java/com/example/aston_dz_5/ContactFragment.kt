package com.example.aston_dz_5

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide
import com.example.aston_dz_5.databinding.FragmentContactBinding
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt
import kotlin.random.nextInt


class ContactFragment: Fragment() {
    private lateinit var nameTextView: TextView
    private lateinit var surnameTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var photoImageView: ImageView
    private lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contact = Contact()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_contact,
            container, false
        )
        nameTextView = view.findViewById(R.id.nameTextView)
        nameTextView.text = contact.name

        surnameTextView = view.findViewById(R.id.surnameTextView)
        surnameTextView.text = contact.surName

        phoneTextView = view.findViewById(R.id.contactTextView)
        phoneTextView.text = contact.phone

        photoImageView = view.findViewById(R.id.photoImageView)
        photoImageView.load(setUrl())

        return view

    }


    fun setUrl():String {
        val id = Random.nextInt(0..1100)
        val url = "https://picsum.photos/id/$id/200/300"
        Log.d("url",url)
        return url

    }

}