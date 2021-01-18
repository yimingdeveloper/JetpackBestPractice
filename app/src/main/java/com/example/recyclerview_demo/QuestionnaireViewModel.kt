package com.example.recyclerview_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionnaireViewModel:ViewModel() {
    val questionListModel:MutableLiveData<QuestionListModel> = MutableLiveData()

    fun refresh(){
        val model = fetchData()
        questionListModel.value = model
    }

    private fun fetchData():QuestionListModel{
        val json = "{.....}" // 这是一个json
        // todo 一通解析 获取一个 QuestionListModel
        val questionList = List<Question>( 30){index ->
            val num = index+Math.random()
            Question("question : ${num}" , "http://xxxxx")
        }
        return QuestionListModel(questionList)
    }

}