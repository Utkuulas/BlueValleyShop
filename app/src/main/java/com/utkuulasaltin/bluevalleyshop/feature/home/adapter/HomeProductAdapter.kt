package com.utkuulasaltin.bluevalleyshop.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.utkuulasaltin.bluevalleyshop.R
import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponseItem
import com.utkuulasaltin.bluevalleyshop.databinding.ItemProductLayoutBinding

class HomeProductAdapter(private val listener: OnProductClickListener) :
    ListAdapter<ProductResponseItem, HomeProductAdapter.ProductViewHolder>(ProductDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProductViewHolder {
        return ProductViewHolder(
            ItemProductLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ProductViewHolder(private val binding: ItemProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ProductResponseItem, listener: OnProductClickListener) {
            binding.dataHolder = data
            binding.ivProductImage
        }
    }


}

class ProductDiffUtil : DiffUtil.ItemCallback<ProductResponseItem>() {
    override fun areItemsTheSame(oldItem: ProductResponseItem, newItem: ProductResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductResponseItem, newItem: ProductResponseItem): Boolean {
        return oldItem == newItem
    }
}

interface OnProductClickListener {
    fun onProductClick(id: String)
}