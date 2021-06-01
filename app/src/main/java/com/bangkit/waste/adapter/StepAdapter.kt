package com.bangkit.waste.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.waste.R


class StepAdapter(private val context: Context, private val steps: List<String>) : RecyclerView.Adapter<StepAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberText: TextView = view.findViewById(R.id.number_text)
        val stepText: TextView = view.findViewById(R.id.step_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.step_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = steps[position]
        holder.numberText.text = "${position + 1}"
        holder.stepText.text = steps[position]
        
    }

    override fun getItemCount() = steps.size
}