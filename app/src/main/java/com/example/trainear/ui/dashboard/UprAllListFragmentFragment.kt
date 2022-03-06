package com.example.trainear.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trainear.R
import com.example.trainear.data.ExerciseWithDirection
import com.example.trainear.viewModels.UserViewModel

class UprAllListFragmentFragment : Fragment() {

    private lateinit var mTrainearViewModel: UserViewModel
    private val nav_direction by navArgs<UprAllListFragmentFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upr_all_list_fragment, container, false)

        val adapter = UprAllListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mTrainearViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val experimental: LiveData<List<ExerciseWithDirection>> = mTrainearViewModel.getExerciseById(nav_direction.curentDirection.directionId)

        experimental.observe(viewLifecycleOwner, Observer { direction ->
            adapter.setData(direction)
        })

        return view
    }


}