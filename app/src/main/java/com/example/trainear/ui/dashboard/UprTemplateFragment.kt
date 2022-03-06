package com.example.trainear.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.trainear.R
import com.example.trainear.viewModels.UprTemplateViewModel
import java.util.Observer

class UprTemplateFragment : Fragment() {

    private val exercise by navArgs<UprTemplateFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upr_template, container, false)

        val img: Int = getResources().getIdentifier(exercise.currentExercise.image, "drawable", activity?.packageName);

        view.findViewById<TextView>(R.id.uprazneniya_title).text = exercise.currentExercise.name
        view.findViewById<ImageView>(R.id.uprazneniya_main_img).setImageResource(img)
        view.findViewById<TextView>(R.id.uprazneniya_about).text = exercise.currentExercise.about
        view.findViewById<TextView>(R.id.uprazneniya_important_points).text = exercise.currentExercise.important_points

        println(exercise.currentExercise.about)

        //for (direction in mTrainearViewModel.getUpDirections.toTypedArray())
        //println(nav_direction.currentDirectionId.directionId.toString())



        /*view.findViewById<ImageView>(R.id.uprazneniya_main_img).drawable =

        val experimental: LiveData<List<ExerciseWithDirection>> = mTrainearViewModel.getExerciseById(nav_direction.currentDirectionId.directionId)
        //println(experimental.toTypeArray())
        mUprTemplateViewModel.observe(viewLifecycleOwner, Observer { exercice ->
            setData(exercice, view)
        })*/


        return view
    }



    /*suspend fun getExercise(id: Int): LiveData<List<ExerciseWithDirection>> {
        return
    }*/

}