package com.bangkit.waste.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.waste.R
import com.bangkit.waste.model.Category
import com.bangkit.waste.ui.camera.ProductsActivity


class CategoryAdapter(private val context: Context, private val dataset: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.name_text)
        val moreButton: TextView = view.findViewById(R.id.more_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameText.text = item.name

        holder.moreButton.setOnClickListener {
            val b = Bundle()
            b.putInt("category_id", item.id)
            b.putString("category_name", item.name)
            
            val i = Intent(context, ProductsActivity::class.java)
            i.putExtras(b)
            
            context.startActivity(i)
        }
    }

    override fun getItemCount() = dataset.size
}