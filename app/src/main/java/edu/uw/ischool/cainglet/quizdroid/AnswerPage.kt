package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class AnswerPage : AppCompatActivity() {
    private lateinit var chosenAnswerView: TextView
    private lateinit var correctAnswerView: TextView
    private lateinit var currentScoreView: TextView
    private lateinit var nextButton: Button
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_page)
        val chosenAnswer = intent.getStringExtra("chosen")
        val correctAnswer = intent.getStringExtra("answer")
        val score = intent.getIntExtra("score", 0)
        val topic = intent.getSerializableExtra("topic") as Topic
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        topic.questions.removeAt(0)

        chosenAnswerView = findViewById(R.id.chosen_answer)
        correctAnswerView = findViewById(R.id.correct_answer)
        currentScoreView = findViewById(R.id.current_score)

        chosenAnswerView.text = "Chosen Answer: $chosenAnswer"
        correctAnswerView.text = "Correct Answer: $correctAnswer"
        currentScoreView.text = "You have $score out of $totalQuestions correct"

        nextButton = findViewById(R.id.next)
        if (topic.questions.isEmpty()) {
            nextButton.text = "Finish"
            nextButton.setOnClickListener {
                val homepage = Intent(this, MainActivity::class.java)
                startActivity(homepage)
                finish()
            }
        } else {
            nextButton.setOnClickListener {
                val secondQuestion = Intent(this, QuestionPage::class.java)
                secondQuestion.putExtra("totalQuestions", totalQuestions)
                secondQuestion.putExtra("score", score)
                secondQuestion.putExtra("topic", topic)
                startActivity(secondQuestion)
                finish()
            }
        }
    }
}