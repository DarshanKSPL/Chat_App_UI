package com.example.chatappui.ui.chatlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chatappui.R
import com.example.chatappui.databinding.ItemStoryBinding

class StoryAdapter() : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    private val mList: ArrayList<Int> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemStoryBinding>(
            LayoutInflater.from(parent.context), R.layout.item_story, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.ivStory.setImageResource(mList[position])
    }

    override fun getItemCount(): Int = mList.size

    class ViewHolder(val binding: ItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateList(list: List<Int>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }
}
