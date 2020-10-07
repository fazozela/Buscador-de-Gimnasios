package com.example.sucrefitness.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sucrefitness.GymActivity
import com.example.sucrefitness.R
import com.example.sucrefitness.model.Gym
import kotlinx.android.synthetic.main.item_gym.view.*
import java.lang.IllegalArgumentException

class GymAdapter(
    val context: Context,
    val gymList: List<Gym>
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return GymViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gym, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is GymViewHolder -> holder.bind(gymList[position], position)
            else -> throw IllegalArgumentException("No se reconoce el holder")
        }
    }

    override fun getItemCount(): Int {
        return gymList.size
    }

    inner class GymViewHolder(itemView: View): BaseViewHolder<Gym>(itemView){
        override fun bind(item: Gym, position: Int) {
            Glide.with(context).load(item.img).into(itemView.img_gym_list)
            itemView.txt_gym_list.text = item.name
        }

        init {
            itemView.setOnClickListener {v: View ->

                val intentToGym = Intent(itemView.context, GymActivity::class.java)
                var gymName = v.txt_gym_list.text.toString()
                intentToGym.putExtra("gymName", gymName)
                itemView.context.startActivity(intentToGym)

            }
        }

    }
}