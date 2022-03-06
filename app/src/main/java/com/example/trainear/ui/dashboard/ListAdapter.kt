package com.example.trainear.ui.dashboard

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.trainear.data.Exercise
import com.example.trainear.R
import com.example.trainear.data.ExerciseWithDirection
import com.example.trainear.data.UpDirectionWithDirection

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<UpDirectionWithDirection>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val viewHldr = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))

        return viewHldr
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.custom_title).text =  currentItem.upDirection.name

        holder.itemView.findViewById<LinearLayout>(R.id.rowLayout).setOnClickListener {
            Toast.makeText(holder.itemView.context, currentItem.upDirection.upDirectionId.toString(), Toast.LENGTH_SHORT).show()
            val action = UprListFragmentDirections.actionUprListFragmentToUprListChild2(currentItem.direction.toTypedArray())
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData(direction: List<UpDirectionWithDirection>){
        this.userList = direction
        notifyDataSetChanged()
    }
}