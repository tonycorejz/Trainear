package com.example.trainear.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trainear.R
import com.example.trainear.viewModels.UserViewModel


class UprListChild : Fragment() {

    private val nav_directions by navArgs<UprListChildArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upr_list_child, container, false)

        // Recyclerview
        val adapter = UprListChildAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        if (nav_directions.currentDirection.isNotEmpty()) {

            adapter.setData(nav_directions.currentDirection.toList())

        }


        // UserViewModel

        //mTrainearViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        /* view.findViewById<Button>(R.id.button).setOnClickListener() {// Add Data to Database
             val user = Exercise(0, "sdf")
             mTrainearViewModel.addUser(user)
         }*/

        /*nav_directions.currentDirection.observe(viewLifecycleOwner, Observer { direction ->
            adapter.setData(direction)
        })*/

        return view
    }


}