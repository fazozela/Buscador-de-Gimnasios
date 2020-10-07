package com.example.sucrefitness.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sucrefitness.R
import com.example.sucrefitness.model.GymList
import kotlinx.android.synthetic.main.item_gym.view.*
import kotlinx.android.synthetic.main.item_gym.view.img_gym_list
import kotlinx.android.synthetic.main.item_gym_list.view.*
import java.lang.IllegalArgumentException

class GymListAdapter(
    val context: Context,
    val gymListList: List<GymList>
) : RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return GymListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gym_list, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is GymListViewHolder -> holder.bind(gymListList[position], position)
            else -> throw IllegalArgumentException("No se reconoce el holder")
        }
    }

    override fun getItemCount(): Int {
        return gymListList.size
    }

    inner class GymListViewHolder(itemView: View): BaseViewHolder<GymList>(itemView){
        override fun bind(item: GymList, position: Int) {
            Glide.with(context).load(item.img).into(itemView.img_gym_list_list)
        }

    }
}



