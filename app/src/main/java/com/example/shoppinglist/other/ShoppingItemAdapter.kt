package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItems = items[position]

        holder.itemView.tvName.text = currentShoppingItems.name
        holder.itemView.tvAmount.text = "${currentShoppingItems.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItems)
        }

        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItems.amount++
            viewModel.upsert(currentShoppingItems)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (currentShoppingItems.amount > 0 ){
                currentShoppingItems.amount--
                viewModel.upsert(currentShoppingItems)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}