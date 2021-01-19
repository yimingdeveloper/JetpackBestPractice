package com.example.jetpackbestpractice

data class Questions(
        val questions: List<Question>
)

data class Question(
        var question: String,
        val imageUrl: String,
        var answer: String
)