package com.example.chatappui.ui.chatlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chatappui.R
import com.example.chatappui.databinding.ItemMessageBinding
import com.example.chatappui.model.UserMessageModel
import com.example.chatappui.utils.ViewExtensions.gone
import com.example.chatappui.utils.ViewExtensions.visible

class MessageAdapter() : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null
    private val mList: ArrayList<UserMessageModel> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMessageBinding>(
            LayoutInflater.from(parent.context), R.layout.item_message, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
        holder.binding.ivProfile.setImageResource(data.image)
        holder.binding.tvName.text = data.userName
        holder.binding.tvMsg.text = data.lastMessage
        holder.binding.tvTime.text = data.timeStamp
        holder.binding.ivMsgStatus.visibility = if (data.isMsgRead) View.VISIBLE else View.GONE
        if (data.unreadMsgCount > 0) {
            holder.binding.tvUnreadMsgCount.text = data.unreadMsgCount.toString()
            holder.binding.tvUnreadMsgCount.visible()
        } else {
            holder.binding.tvUnreadMsgCount.gone()
        }
        holder.binding.root.setOnClickListener { itemClickListener?.onItemClick(data) }
    }

    override fun getItemCount(): Int = mList.size

    class ViewHolder(val binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateList(list: List<UserMessageModel>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(item: UserMessageModel)
    }
}
