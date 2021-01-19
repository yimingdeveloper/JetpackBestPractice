package com.example.jetpackbestpractice

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionairViewModel: ViewModel() {

    val repository: Repository = Repository(Dispatchers.Main)
    var questions = MutableLiveData<MutableList<Question>>()

    var index = MutableLiveData(0)

    var answer = MutableLiveData<String>()

    var question = Transformations.map(index) {
        questions.value?.get(index.value!!)?.question
    }

    fun next() {111
        questions.value?.get(index!!.value!!)?.answer = answer.value.toString()


        val size = questions.value?.size
        if (size != null) {
            when(index.value) {
                size - 1 -> jump()
                else -> index.value = index.value?.plus(1)
            }
        }
        answer.value = questions.value?.get(index.value!!)?.answer
    }

    fun jump() {

    }

    fun pre() {
        questions.value?.get(index!!.value!!)?.answer = answer.value.toString()
        when(index.value) {
            0 -> return
            else -> index.value = index.value?.minus(1)
        }
        answer.value = questions.value?.get(index.value!!)?.answer
    }

    init {
        questions = repository.read_json()
    }
}