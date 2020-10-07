package com.example.sucrefitness.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sucrefitness.R
import com.example.sucrefitness.model.Opinion
import kotlinx.android.synthetic.main.item_opinion.view.*
import java.lang.IllegalArgumentException

class OpinionAdapter(
    val context: Context,
    val opinionList: List<Opinion>
) : RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return OpinionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_opinion,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is OpinionViewHolder -> holder.bind(opinionList[position], position)
            else -> throw IllegalArgumentException("No se reconoce el holder")
        }
    }

    override fun getItemCount(): Int {
        return opinionList.size
    }

    inner class OpinionViewHolder(itemView: View): BaseViewHolder<Opinion>(itemView){
        override fun bind(item: Opinion, position: Int) {
            itemView.txt_user_name.text = item.userName
            itemView.txt_user_opinion.text = item.userOpinion
        }

    }


}