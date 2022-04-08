package com.example.chatappui.ui.chatlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chatappui.R
import com.example.chatappui.model.UserMessageModel

class ChatListViewModel : ViewModel() {

    private var storyLiveData = MutableLiveData<ArrayList<Int>>()
    private var messageLiveData = MutableLiveData<ArrayList<UserMessageModel>>()

    val observeStoryData: LiveData<ArrayList<Int>>
        get() = storyLiveData

    val observeUserMessageData: LiveData<ArrayList<UserMessageModel>>
        get() = messageLiveData

    fun prepareStoryData() {
        val arrayList = arrayListOf(
            R.drawable.user_story,
            R.drawable.user_1,
            R.drawable.user_story_2,
            R.drawable.user_3,
            R.drawable.user_4,
            R.drawable.user_5,
            R.drawable.user_6,
            R.drawable.user_7,
            R.drawable.user_8,
        )
        storyLiveData.postValue(arrayList)
    }

    fun prepareMessageData() {
        val arrayList = arrayListOf(
            UserMessageModel(R.drawable.user_1, "Lara Mueller", "lorem ipsum dolor ",false,"17:33",0),
            UserMessageModel(R.drawable.user_2, "Cameron Williamson", "lorem ipsum dolor lorem ipsum lorem ipsum dolor lorem ipsum",false,"16:42",3),
            UserMessageModel(R.drawable.user_3, "Jenny Wilson", "lorem ipsum dolor",false,"14:32",0),
            UserMessageModel(R.drawable.user_4, "Aaron Zimmer", "lorem ipsum dolor",true,"Yesterday",0),
            UserMessageModel(R.drawable.user_5, "Annette Black", "lorem ipsum dolor",false,"Wednesday",3),
            UserMessageModel(R.drawable.user_6, "Jane Cooper", "loram ipsum dolor",false,"Wednesday",0),
            UserMessageModel(R.drawable.user_7, "Anna Newman", "lorem ipsum dolor",true,"Wednesday",0),
            UserMessageModel(R.drawable.user_8, "Dianne Russell", "loram ipsum dolor",false,"Tuesday",0),
        )
        messageLiveData.postValue(arrayList)
    }
}