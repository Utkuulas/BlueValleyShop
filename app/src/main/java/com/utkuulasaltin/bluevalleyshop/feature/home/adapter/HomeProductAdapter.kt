package com.utkuulasaltin.bluevalleyshop.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.utkuulasaltin.bluevalleyshop.R
import com.utkuulasaltin.bluevalleyshop.data.model.ProductDTO
import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponseItem
import com.utkuulasaltin.bluevalleyshop.databinding.ItemProductLayoutBinding
import com.utkuulasaltin.bluevalleyshop.utils.BindingAdapter

class HomeProductAdapter(private val listener: OnProductClickListener) :
    ListAdapter<ProductDTO, HomeProductAdapter.ProductViewHolder>(ProductDiffUtil()) {

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
        fun bind(data: ProductDTO, listener: OnProductClickListener) {
            binding.dataHolder = data
        }
    }


}

class ProductDiffUtil : DiffUtil.ItemCallback<ProductDTO>() {
    override fun areItemsTheSame(oldItem: ProductDTO, newItem: ProductDTO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductDTO, newItem: ProductDTO): Boolean {
        return oldItem == newItem
    }
}

interface OnProductClickListener {
    fun onProductClick(id: Int?)
}