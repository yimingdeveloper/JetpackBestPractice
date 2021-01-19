package com.example.jetpackbestpractice

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineDispatcher
import java.io.InputStream

class Repository(private val dispatcher: CoroutineDispatcher) {

    private var jsonString: String? = null

    private val list = MutableLiveData(mutableListOf<Question>())

    fun read_json(): MutableLiveData<MutableList<Question>> {

        val inputStream: InputStream = MyApp.getContext().assets.open("questionair.json")
        jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        val arr = JsonParser.parseString(jsonString) as JsonArray
        arr.forEach {1111
            val question = Gson().fromJson(it, Question::class.java)
            question.answer = ""
            list.value?.add(question)
        }

        return list
    }
}