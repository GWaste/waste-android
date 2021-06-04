package com.bangkit.waste.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.waste.R


class IngredientAdapter(private val context: Context, private val ingredients: List<String>) : RecyclerView.Adapter<IngredientAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ingredientText: TextView = view.findViewById(R.id.ingredient_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.ingredient_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = ingredients[position]
        holder.ingredientText.text = item
        
    }

    override fun getItemCount() = ingredients.size
}