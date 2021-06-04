package com.example.quiz.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.quiz.QuizFragment
import com.example.quiz.QuizViewModel
import com.example.quiz.R
import com.example.quiz.databinding.FragmentFirstQuestionBinding
import com.example.quiz.databinding.FragmentSecondQuestionBinding

class SecondQuestionFragment : Fragment() {


    private lateinit var binding: FragmentSecondQuestionBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_second_question, container, false)

        viewModel =
            ViewModelProvider(parentFragment as ViewModelStoreOwner).get(QuizViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        setButtons()

        return binding.root
    }

    private fun setButtons() {
        binding.answer4BTN.setOnClickListener {
            viewModel.score += 1

            setCorrectButton()
            setDisabled()
            nextQuestion()
        }
        binding.answer5BTN.setOnClickListener {
            it.isSelected = true
            it.isPressed = true
            setDisabled()
            setCorrectButton()
            nextQuestion()
        }
        binding.answer6BTN.setOnClickListener {
            it.isSelected = true
            it.isPressed = true
            setDisabled()
            setCorrectButton()
            nextQuestion()
        }
    }

    private fun nextQuestion() {
        Thread.sleep(1500)
        (parentFragment as QuizFragment).nextQuestion()
    }

    private fun setDisabled() {
        binding.answer4BTN.isEnabled = false
        binding.answer5BTN.isEnabled = false
        binding.answer6BTN.isEnabled = false
    }

    private fun setCorrectButton() {
        binding.answer4BTN.isSelected = true
        binding.answer4BTN.isPressed = true
    }
}