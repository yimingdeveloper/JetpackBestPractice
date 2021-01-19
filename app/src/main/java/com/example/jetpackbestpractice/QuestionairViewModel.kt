package com.example.jetpackbestpractice

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionairViewModel: ViewModel() {

    private val repository: Repository = Repository(Dispatchers.Main)
    private var questions = MutableLiveData<MutableList<Question>>()

    private var index = MutableLiveData(0)

    var answer = MutableLiveData<String>()

    var question = Transformations.map(index) {
        questions.value?.get(index.value!!)?.question
    }

    fun next() {
        val size = questions.value?.size
        if (size != null) {
            when(index.value) {
                size - 1 -> jump()
                else -> index.postValue(index.value?.plus(1))
            }
        }
    }

    fun jump() {

    }

    fun pre() {
        when(index.value) {
            0 -> return
            else -> index.postValue(index.value?.minus(1))
        }
    }

    init {
        viewModelScope.launch {
            questions = repository.read_json()
        }
    }
}