package com.example.jetpackbestpractice

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionairViewModel: ViewModel() {

    var itemClickListener: ItemClickListener? = null
    var taskNavigator: TaskNavigator? = null

    val repository: Repository = Repository(Dispatchers.IO)

    var questions: MutableLiveData<MutableList<Question>>? = null
    val index = MutableLiveData(0)
    val answer = MutableLiveData<String>()

    val question = Transformations.map(index) {
        index.value?.let { it1 -> questions?.value?.get(it1)?.question }
    }

    fun next() {
        questions?.value?.get(index!!.value!!)?.answer = answer.value.toString()
        val size = questions?.value?.size
        if (size != null) {
            when(index.value) {
                size - 1 -> jump()
                else -> index.value = index.value?.plus(1)
            }
        }
        answer.value = questions?.value?.get(index.value!!)?.answer
    }

    fun jump() {
        taskNavigator?.showList()
    }

    fun pre() {
        questions?.value?.get(index!!.value!!)?.answer = answer.value.toString()
        when(index.value) {
            0 -> return
            else -> index.value = index.value?.minus(1)
        }
        answer.value = questions?.value?.get(index.value!!)?.answer
    }

    init {
        viewModelScope.launch {
            questions = repository.list
            repository.read_json()
        }
    }
}