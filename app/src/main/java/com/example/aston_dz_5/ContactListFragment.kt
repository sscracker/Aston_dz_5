package com.example.aston_dz_5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aston_dz_5.databinding.FragmentContactListBinding
import java.util.*

class ContactListFragment: Fragment() {
    interface Callbacks{
        fun onContactSelected(contactId:UUID)
    }

    private var callbacks:Callbacks? = null
    private lateinit var contactRecyclerView:RecyclerView
    private var adapter: ContactAdapter? = null
    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding

    private val contactListViewModel: ContactListViewModel by lazy {
        ViewModelProvider(this)[ContactListViewModel::class.java]

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        val view = binding?.root
        if (view != null) {
            contactRecyclerView = view.findViewById(R.id.contactRecyclerView)
            contactRecyclerView.layoutManager = LinearLayoutManager(context)
        }
        updateUI()
        return view
    }

    private fun updateUI() {
        val contacts = contactListViewModel.contacts
        adapter = ContactAdapter(contacts)
        contactRecyclerView.adapter = adapter
    }

    private inner class ContactHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener{
        private lateinit var contact: Contact
        var titleTextView: TextView = itemView.findViewById(R.id.contactTitle)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(contact:Contact){
            this.contact = contact
            titleTextView.text = this.contact.name
        }

        override fun onClick(p0: View?) {
            callbacks?.onContactSelected(contact.id)
        }
    }

    private inner class ContactAdapter(var contacts:List<Contact>):RecyclerView.Adapter<ContactHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
            val view = layoutInflater.inflate(R.layout.list_item_contact,parent,false)
            return ContactHolder(view)
        }

        override fun onBindViewHolder(holder: ContactHolder, position: Int) {
            val contact = contacts[position]
            holder.bind(contact)
        }

        override fun getItemCount(): Int {
            return contacts.size
        }

    }

    companion object{
        fun newInstance():ContactListFragment{
            return ContactListFragment()
        }
    }

}