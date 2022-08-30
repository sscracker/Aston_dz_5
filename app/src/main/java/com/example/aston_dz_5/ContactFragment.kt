package com.example.aston_dz_5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aston_dz_5.databinding.FragmentContactBinding


class ContactFragment: Fragment() {
    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding
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
        _binding = FragmentContactBinding.inflate(inflater,container,false)
        val view = binding?.root


            binding?.nameTextView?.text = contact.name
            binding?.surnameTextView?.text = contact.surName
            binding?.contactTextView?.text = contact.phone




        return view

    }
}