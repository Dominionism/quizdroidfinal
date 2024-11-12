package edu.uw.ischool.cainglet.quizdroid

import android.app.Application
import android.content.Context
import android.util.Log

class QuizApp: Application() {

    companion object {
        lateinit var appContext: Context
        private set
    }

    private val tag = QuizApp::class.java.canonicalName
    val topicList = TopicMemoryRepository().retrieveTopics()
    override fun onCreate() {
        super.onCreate()
        Log.i(tag, "Quiz Application Initiated!")
        appContext = applicationContext
    }
}