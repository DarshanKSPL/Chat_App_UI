package com.example.chatappui.utils

import android.view.View

object ViewExtensions {

    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.visible() {
        this.visibility = View.VISIBLE
    }
}