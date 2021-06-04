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
import com.example.quiz.databinding.FragmentThirdQuestionBinding


class ThirdQuestionFragment : Fragment() {

    private lateinit var binding: FragmentThirdQuestionBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_third_question, container, false)

        viewModel =
            ViewModelProvider(parentFragment as ViewModelStoreOwner).get(QuizViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        setButtons()

        return binding.root
    }

    private fun setButtons() {
        binding.answer7BTN.setOnClickListener {
            it.isSelected = true
            it.isPressed = true
            setDisabled()
            setCorrectButton()
            nextQuestion()
        }
        binding.answer8BTN.setOnClickListener {
            it.isSelected = true
            it.isPressed = true
            setDisabled()
            setCorrectButton()
            nextQuestion()
        }
        binding.answer9BTN.setOnClickListener {
            viewModel.score += 1
            setCorrectButton()
            setDisabled()
            nextQuestion()
        }
    }

    private fun nextQuestion() {
        Thread.sleep(1500)
        (parentFragment as QuizFragment).nextQuestion()
    }

    private fun setDisabled() {
        binding.answer7BTN.isEnabled = false
        binding.answer8BTN.isEnabled = false
        binding.answer9BTN.isEnabled = false
    }

    private fun setCorrectButton() {
        binding.answer9BTN.isSelected = true
        binding.answer9BTN.isPressed = true
    }

}