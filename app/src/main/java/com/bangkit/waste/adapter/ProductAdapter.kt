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
import com.bangkit.waste.model.Product
import com.bangkit.waste.ui.ProductActivity


class ProductAdapter(private val context: Context, private val dataset: List<Product>) : RecyclerView.Adapter<ProductAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemCard: CardView = view.findViewById(R.id.item_card)
        val nameText: TextView = view.findViewById(R.id.name_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameText.text = item.name
        
        holder.itemCard.setOnClickListener {
            val b = Bundle()
            b.putInt("product_id", item.id)
            // b.putString("product_name", item.name)

            val i = Intent(context, ProductActivity::class.java)
            i.putExtras(b)

            context.startActivity(i)
        }
    }

    override fun getItemCount() = dataset.size
}