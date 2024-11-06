package edu.uw.ischool.cainglet.quizdroid

import java.io.Serializable

data class Topic(val title: String, val shortDescription: String, val longDescription: String, val questions: MutableList<Question>): Serializable