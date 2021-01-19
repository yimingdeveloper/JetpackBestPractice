package com.example.jetpackbestpractice

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.InputStream

class Repository(private val dispatcher: CoroutineDispatcher) {

    private var jsonString: String? = null

    val list = MutableLiveData(mutableListOf<Question>())

    suspend fun read_json() {

        withContext(dispatcher) {
            list.value?.clear()
            val inputStream: InputStream = MyApp.getContext().assets.open("questionair.json")
            jsonString = inputStream.bufferedReader().use {
                it.readText()
            }
            val arr = JsonParser.parseString(jsonString) as JsonArray
            arr.forEach {
                val question = Gson().fromJson(it, Question::class.java)
                question.answer = ""
                list.value?.add(question)
            }
        }
    }
}