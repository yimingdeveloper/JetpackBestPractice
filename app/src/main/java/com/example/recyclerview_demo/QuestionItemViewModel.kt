package com.oceanlong.moment.recyclerview_demo

import androidx.lifecycle.ViewModel

class QuestionItemViewModel:ViewModel() {

    fun getQuestionText(model:Question):String{
        return model.question
    }
}