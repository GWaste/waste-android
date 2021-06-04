package com.bangkit.waste.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.waste.R
import com.bangkit.waste.model.Category
import com.bangkit.waste.model.CategoryResult
import com.bangkit.waste.ui.camera.ProductsActivity


class CategoryAdapter(
    private val context: Context,
    private val result: List<CategoryResult>,
    private val dataset: List<Category>
) :
    RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemCard: CardView = view.findViewById(R.id.item_card)
        val nameText: TextView = view.findViewById(R.id.name_text)
        val confidentText: TextView = view.findViewById(R.id.confident_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset.first { 
            it.name.lowercase() == result[position].name.lowercase()
        }
        holder.nameText.text = item.name
        holder.confidentText.text = String.format("%.2f", result[position].confident * 100) + "%"
        

        holder.itemCard.setOnClickListener {
            val b = Bundle()
            b.putInt("category_id", item.id)
            b.putString("category_name", item.name)

            val i = Intent(context, ProductsActivity::class.java)
            i.putExtras(b)

            context.startActivity(i)
        }
    }

    override fun getItemCount() = result.size
}