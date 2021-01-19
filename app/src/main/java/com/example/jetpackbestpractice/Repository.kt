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

    private val list = MutableLiveData(mutableListOf<Question>())

    suspend fun read_json(): MutableLiveData<MutableList<Question>> {
        withContext(dispatcher) {
            val inputStream: InputStream = MyApp.getContext().assets.open("questionair.json")
            jsonString = inputStream.bufferedReader().use{
                it.readText()
            }
            val arr = JsonParser.parseString(jsonString) as JsonArray
            for (item in arr) {
                list.value?.add(Gson().fromJson(item, Question::class.java))
            }
        }
        return list
    }
}