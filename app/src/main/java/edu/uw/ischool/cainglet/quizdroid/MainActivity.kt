package edu.uw.ischool.cainglet.quizdroid

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val topics = QuizApp()
    private val model = topics.topicList
    private lateinit var quizTopics: ListView
    private var currentScore = 0
    private var attemptedQuestions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizTopics = findViewById((R.id.view_primary))
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, model.map { it.title + " - " + it.shortDescription })
        quizTopics.adapter = adapter

        quizTopics.setOnItemClickListener { _, _, position, _ ->
            val selectedTopicObject = model[position]
            val totalQuestions = selectedTopicObject.questions.size
            val intent = Intent(this, Overview::class.java)
            intent.putExtra("score", currentScore)
            intent.putExtra("selectedTopicObject", selectedTopicObject)
            intent.putExtra("totalQuestions", totalQuestions)
            intent.putExtra("attemptedQuestions", attemptedQuestions)
            startActivity(intent)
        }
    }
}