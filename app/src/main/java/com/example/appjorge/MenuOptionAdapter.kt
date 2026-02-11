package com.example.appjorge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appjorge.databinding.ItemMenuOptionBinding

class MenuOptionAdapter(
    private val options: List<MenuOption>,
    private val onClick: (MenuOption) -> Unit
) : RecyclerView.Adapter<MenuOptionAdapter.MenuOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuOptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuOptionBinding.inflate(inflater, parent, false)
        return MenuOptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuOptionViewHolder, position: Int) {
        val option = options[position]
        holder.bind(option)
    }

    override fun getItemCount(): Int = options.size

    inner class MenuOptionViewHolder(
        private val binding: ItemMenuOptionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(option: MenuOption) {
            binding.tvCardTitle.text = option.title
            binding.tvCardDescription.text = option.description
            binding.root.setOnClickListener { onClick(option) }
        }
    }
}
