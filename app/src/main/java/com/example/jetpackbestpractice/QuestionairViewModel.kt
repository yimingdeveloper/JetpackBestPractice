package com.example.jetpackbestpractice

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers

class QuestionairViewModel: ViewModel() {

    var taskNavigator: TaskNavigator? = null

    val repository: Repository = Repository(Dispatchers.Main)
    var questions = MutableLiveData<MutableList<Question>>()

    var index = MutableLiveData(0)
    var answer = MutableLiveData<String>()

    var question = Transformations.map(index) {
        questions.value?.get(index.value!!)?.question
    }

    fun next() {
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
        taskNavigator?.showList()
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