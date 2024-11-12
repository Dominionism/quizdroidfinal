package edu.uw.ischool.cainglet.quizdroid

import java.io.Serializable

data class Topic(val title: String, val description: String, val questions: MutableList<Question>): Serializable