package edu.uw.ischool.cainglet.quizdroid

import android.util.Log
import org.json.JSONArray
import java.io.InputStream

class TopicMemoryRepository : TopicRepository {
    private val topicList: MutableList<Topic> = mutableListOf()
    private val tag = TopicMemoryRepository::class.java.canonicalName
    private fun read() {
        Log.i(tag, "The read function was executed.")
        try {
            val inputStream: InputStream = QuizApp.appContext.assets.open("questions.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }

            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val currentTopicObject = jsonArray.getJSONObject(i)
                val topicName = currentTopicObject.getString("title")
                val topicDescription = currentTopicObject.getString("desc")
                val questionArray = currentTopicObject.getJSONArray("questions")
                val questionList: MutableList<Question> = mutableListOf()

                for (j in 0 until questionArray.length()) {
                    val currentQuestionObject = questionArray.getJSONObject(j)
                    val questionText = currentQuestionObject.getString("text")
                    val answerIndex = currentQuestionObject.getString("answer").toInt()
                    val questionOptions = currentQuestionObject.getJSONArray("answers")

                    val optionsList: MutableList<String> = mutableListOf()
                    for (k in 0 until questionOptions.length()) {
                        optionsList.add(questionOptions.getString(k))
                    }
                    questionList.add(Question(questionText, optionsList, answerIndex))
                }

                topicList.add(Topic(topicName, topicDescription, questionList))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun retrieveTopics(): MutableList<Topic> {
        read()
        return topicList
    }
}