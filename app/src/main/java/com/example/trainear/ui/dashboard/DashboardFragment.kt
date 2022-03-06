package com.example.trainear.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.trainear.R
import com.example.trainear.viewModels.UserViewModel


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var mUserViewModel: UserViewModel
    private var counter = 0
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        root.findViewById<Button>(R.id.upr_button).setOnClickListener(){
            /*if (activity != null) {
                val ma = activity as MainActivity?
                ma?.toast()
            }*/
            findNavController().navigate(R.id.action_navigation_dashboard_to_upr_list_fragment)
        }


        /*dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        /*mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val all_edds = arrayListOf<View>();
        val linear:LinearLayout = root.findViewById(R.id.linear);
        root.findViewBd<Button>(R.id.add_btn).setOnClickListener {
        counter++;

        insertDataToDatabase();

        val view: View = layoutInflater.inflate(R.layout.custom, null)

        val workout_list_item_text = workout_list_item.findViewById<View>(R.id.textView) as TextView
        val text = view.findViewById<View>(R.id.day_title) as TextView
        text.text = text.text.toString() + counter.toString()
        all_edds.add(view);
        linear.addView(view);
        for (i in 1..5) {
        workout_list_item_text.text = workout_list_item_text.text.toString() + i.toString()
        val workout_list_item: View = layoutInflater.inflate(R.layout.home_workout_list_item, null);
        all_edds.add(workout_list_item);
        linear.addView(workout_list_item);

        }

        //добавляем елементы в linearlayout

        }*/
        return root
    }


}