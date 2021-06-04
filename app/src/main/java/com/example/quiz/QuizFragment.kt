package com.example.quiz

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quiz.databinding.QuizFragmentBinding
import com.example.quiz.quiz.FirstQuestionFragment
import com.example.quiz.quiz.ScoreFragment
import com.example.quiz.quiz.SecondQuestionFragment
import com.example.quiz.quiz.ThirdQuestionFragment

class QuizFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var binding: QuizFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.quiz_fragment, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstQuestionFragment(),
            SecondQuestionFragment(),
            ThirdQuestionFragment(),
            ScoreFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            this
        )

        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false;

        return binding.root
    }

    fun nextQuestion() {
        binding.viewPager.currentItem = binding.viewPager.currentItem + 1
    }

}