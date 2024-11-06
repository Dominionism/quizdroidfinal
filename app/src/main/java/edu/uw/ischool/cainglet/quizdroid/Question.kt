package edu.uw.ischool.cainglet.quizdroid

import java.io.Serializable

data class Question(val questionText: String, val options: List<String>, val correctOptionIndex: Int): Serializable