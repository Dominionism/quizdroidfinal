package edu.uw.ischool.cainglet.quizdroid

import android.app.Application
import android.util.Log

class QuizApp: Application() {
    private val tag = QuizApp::class.java.canonicalName
    val topicList = TopicMemoryRepository().retrieveTopics()
    override fun onCreate() {
        super.onCreate()
        Log.i(tag, "Quiz Application Initiated!")
    }
}