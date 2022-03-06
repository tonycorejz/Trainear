package com.example.trainear.ui.dashboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trainear.R
import com.example.trainear.data.Exercise
import com.example.trainear.viewModels.UserViewModel

class UprListFragment : Fragment() {

    companion object {
        fun newInstance() = UprListFragment()
    }


    private lateinit var mTrainearViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.upr_list_fragment, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())



        // UserViewModel
        mTrainearViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mTrainearViewModel.getUpDirections.observe(viewLifecycleOwner, Observer { direction ->
            adapter.setData(direction)
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(UprListViewModel::class.java)
        // TODO: Use the ViewModel

    }

}