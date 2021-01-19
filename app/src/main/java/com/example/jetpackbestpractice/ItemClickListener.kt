package com.example.jetpackbestpractice

import android.view.View

interface ItemClickListener {
    fun onItemClick(view: View, question: Question, position: Int)
}