package com.example.baseball.game.baseballcounts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballAdapter(
    baseballCountItems: List<BaseballCountItem> = listOf()
) : RecyclerView.Adapter<BaseballViewHolder>() {

    private val _baseballCountUiModels = baseballCountItems.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseballViewHolder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseballViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseballViewHolder, position: Int) {
        holder.bind(_baseballCountUiModels[position])
    }

    override fun getItemCount(): Int = _baseballCountUiModels.size

    fun submitList(baseballCountItems: List<BaseballCountItem>) {
        _baseballCountUiModels.clear()
        _baseballCountUiModels.addAll(baseballCountItems)
        notifyDataSetChanged()
    }
}
