package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class QuestionPage : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var optionOne: RadioButton
    private lateinit var optionTwo: RadioButton
    private lateinit var optionThree: RadioButton
    private lateinit var optionFour: RadioButton
    private lateinit var question: TextView
    private lateinit var selectedButton: RadioButton
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)
        var score = intent.getIntExtra("score", 0)
        val topic = intent.getSerializableExtra("topic") as Topic
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        question = findViewById(R.id.question)
        question.text = topic.questions[0].questionText
        val correctAnswerIndex = topic.questions[0].correctOptionIndex

        optionOne = findViewById(R.id.option_one)
        optionTwo = findViewById(R.id.option_two)
        optionThree = findViewById(R.id.option_three)
        optionFour = findViewById(R.id.option_four)

        optionOne.text = topic.questions[0].options[0]
        optionTwo.text = topic.questions[0].options[1]
        optionThree.text = topic.questions[0].options[2]
        optionFour.text = topic.questions[0].options[3]

        submitButton = findViewById(R.id.submit)
        submitButton.isEnabled = false

        optionOne.setOnClickListener {
            selectedButton = optionOne
            submitButton.isEnabled = true
        }

        optionTwo.setOnClickListener {
            selectedButton = optionTwo
            submitButton.isEnabled = true
        }

        optionThree.setOnClickListener {
            selectedButton = optionThree
            submitButton.isEnabled = true
        }

        optionFour.setOnClickListener {
            selectedButton = optionFour
            submitButton.isEnabled = true
        }

        submitButton.setOnClickListener {
            if (selectedButton.text == topic.questions[0].options[correctAnswerIndex]) {
                score += 1
            }

            val answerPage = Intent(this, AnswerPage::class.java)
            answerPage.putExtra("score", score)
            answerPage.putExtra("chosen", selectedButton.text)
            answerPage.putExtra("totalQuestions", totalQuestions)
            answerPage.putExtra("answer", topic.questions[0].options[correctAnswerIndex])
            answerPage.putExtra("topic", topic)
            startActivity(answerPage)
        }
    }
}