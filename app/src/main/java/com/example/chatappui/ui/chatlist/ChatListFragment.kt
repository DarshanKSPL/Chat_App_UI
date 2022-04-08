package com.example.chatappui.ui.chatlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.chatappui.R
import com.example.chatappui.databinding.FragmentChatListBinding
import com.example.chatappui.model.UserMessageModel

class ChatListFragment : Fragment(), MessageAdapter.OnItemClickListener {

    private lateinit var binding: FragmentChatListBinding
    private val viewModel by viewModels<ChatListViewModel>()
    private val storyAdapter by lazy { StoryAdapter() }
    private val messageAdapter by lazy { MessageAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCompat()
    }

    private fun initCompat() {
        binding.rvStories.adapter = storyAdapter
        binding.rvMessages.adapter = messageAdapter
        messageAdapter.setOnItemClickListener(this)
        viewModel.observeStoryData.observe(viewLifecycleOwner) {
            storyAdapter.updateList(it)
        }
        viewModel.observeUserMessageData.observe(viewLifecycleOwner) {
            messageAdapter.updateList(it)
        }
        viewModel.prepareStoryData()
        viewModel.prepareMessageData()
    }

    override fun onItemClick(item: UserMessageModel) {
        findNavController().navigate(
            ChatListFragmentDirections.actionChatListFragmentToUserProfileFragment(item)
        )
    }
}