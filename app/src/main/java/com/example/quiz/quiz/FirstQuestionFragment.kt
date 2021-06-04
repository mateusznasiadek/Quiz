package com.example.quiz.quiz

import android.content.res.ColorStateList
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.quiz.QuizFragment
import com.example.quiz.QuizViewModel
import com.example.quiz.R
import com.example.quiz.databinding.FragmentFirstQuestionBinding


class FirstQuestionFragment : Fragment() {

    private lateinit var binding: FragmentFirstQuestionBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first_question, container, false)

        viewModel =
            ViewModelProvider(parentFragment as ViewModelStoreOwner).get(QuizViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        setButtons()

        return binding.root
    }

    private fun setButtons() {
        binding.answer1BTN.setOnClickListener {
            it.isSelected = true
            it.isPressed = true
            setCorrectButton()
            setDisabled()
            nextQuestion()
        }
        binding.answer2BTN.setOnClickListener {
            viewModel.score += 1
            setCorrectButton()
            setDisabled()
            nextQuestion()
        }
        binding.answer3BTN.setOnClickListener {
            it.isSelected = true
            it.isPressed = true
            setCorrectButton()
            setDisabled()
            nextQuestion()
        }
    }

    private fun nextQuestion() {
        Thread.sleep(1500)
        (parentFragment as QuizFragment).nextQuestion()
    }

    private fun setDisabled(){
        binding.answer1BTN.isEnabled = false
        binding.answer2BTN.isEnabled = false
        binding.answer3BTN.isEnabled = false
    }

    private fun setCorrectButton(){
        binding.answer2BTN.isSelected = true
        binding.answer2BTN.isPressed = true
    }
}