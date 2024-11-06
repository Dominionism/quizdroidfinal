package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Overview : AppCompatActivity() {
    private lateinit var beginButton: Button
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val score = intent.getIntExtra("score", 0)
        val topic = intent.getSerializableExtra("selectedTopicObject") as Topic
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        val topicTitle: TextView = findViewById(R.id.overview_title)
        topicTitle.text = topic.title
        val mathDescription: TextView = findViewById((R.id.long_description))
        mathDescription.text = topic.longDescription

        val numQuestions: TextView = findViewById(R.id.number_of_questions)
        numQuestions.text = "The ${topic.title} category has $totalQuestions questions."

        beginButton = findViewById(R.id.begin)
        beginButton.setOnClickListener {
            val firstQuestion = Intent(this, QuestionPage::class.java)
            firstQuestion.putExtra("totalQuestions", totalQuestions)
            firstQuestion.putExtra("score", score)
            firstQuestion.putExtra("topic", topic)
            startActivity(firstQuestion)
        }
    }
}