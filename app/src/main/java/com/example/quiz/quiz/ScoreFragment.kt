package com.example.quiz.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.NavHostFragment
import com.example.quiz.QuizFragment
import com.example.quiz.QuizFragmentDirections
import com.example.quiz.QuizViewModel
import com.example.quiz.R
import com.example.quiz.databinding.FragmentFirstQuestionBinding
import com.example.quiz.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)

        viewModel =
            ViewModelProvider(parentFragment as ViewModelStoreOwner).get(QuizViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.scoreValueTV.text = resources.getString(R.string.score_points, viewModel.score)
        setButton()

        return binding.root
    }

    private fun setButton() {
        binding.playAgainBTN.setOnClickListener {
            val action = QuizFragmentDirections.actionQuizFragmentToMenuFragment()
            parentFragment?.let { it1 -> NavHostFragment.findNavController(it1).navigate(action) }
        }
    }
}