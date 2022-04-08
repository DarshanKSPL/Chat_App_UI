package com.example.chatappui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserMessageModel(
    val image: Int,
    val userName: String,
    val lastMessage: String,
    val isMsgRead: Boolean,
    val timeStamp: String,
    val unreadMsgCount: Int
) : Parcelable
