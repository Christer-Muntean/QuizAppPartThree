package com.example.quizapppartthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapppartthree.model.QuestionOption
import com.example.quizapppartthree.model.QuizQuestion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val quizQuestions = listOf(
            QuizQuestion("How big is an elephant?", "4", "3", "3"),
            QuizQuestion("Who is CEO of Tesla?", "Elon Musk", "Elton John", "Elon Musk"),
            QuizQuestion("Who is the girlfriend of Mikkey Mouse?", "Minnie mouse", "Donald Duck", "Minnie Mouse")
    )

    var currentQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNewQuestionText()

        alternative_one_button.setOnClickListener {
            if(isAnswerCorrect(QuestionOption.ONE)){
                setNewQuestionText()
            }
        }

        alternative_two_button.setOnClickListener {
            if(isAnswerCorrect(QuestionOption.TWO)){
                setNewQuestionText()
            }
        }
    }

    private fun isAnswerCorrect(selectedOption: QuestionOption) : Boolean {

        var option = quizQuestions[currentQuestion].optionOne

        if(selectedOption == QuestionOption.ONE){
            option = quizQuestions[currentQuestion].optionOne
        } else if (selectedOption == QuestionOption.TWO) {
            option = quizQuestions[currentQuestion].optionTwo
        }

        if(option.toLowerCase() == quizQuestions[currentQuestion].answer.toLowerCase()) {
            status_textView.text = "Correct!"

            if(currentQuestion < (quizQuestions.size - 1)){
                currentQuestion++
            }

            return true
        } else {
            status_textView.text = "Wrong answer :("
            return false
        }
    }

    private fun setNewQuestionText() {
        question_textView.text = quizQuestions[currentQuestion].question
        alternative_one_button.text = "Alternative A: ${quizQuestions[currentQuestion].optionOne}"
        alternative_two_button.text = "Alternative B: ${quizQuestions[currentQuestion].optionTwo}"
    }
}