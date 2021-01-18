package com.example.jetpackbestpractice

import androidx.lifecycle.ViewModel

class QuestionairViewModel: ViewModel() {

    val repository: Repository = Repository()

    fun getJsonString() {
        repository.read_json()
    }
}