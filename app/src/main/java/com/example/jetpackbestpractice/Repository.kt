package com.example.jetpackbestpractice

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import java.io.InputStream

class Repository {

    var jsonString: String? = null

    val list = mutableListOf<Question>()

    fun read_json() {
        val inputStream: InputStream = MyApp.getContext().assets.open("questionair.json")
        jsonString = inputStream.bufferedReader().use{
            it.readText()
        }
        val arr = JsonParser.parseString(jsonString) as JsonArray
        for (item in arr) {
            list.add(Gson().fromJson(item, Question::class.java))
        }
    }
}