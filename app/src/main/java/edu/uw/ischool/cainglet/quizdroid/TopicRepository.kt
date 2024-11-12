package edu.uw.ischool.cainglet.quizdroid

interface TopicRepository {
    fun retrieveTopics(): MutableList<Topic>
}