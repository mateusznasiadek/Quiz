package com.example.quiz

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.quiz.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {

    private lateinit var viewModel: MenuViewModel
    private lateinit var binding: MenuFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.menu_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        binding.startBTN.setOnClickListener { goToQuiz() }

        return binding.root
    }

    private fun goToQuiz() {
        val action = MenuFragmentDirections.actionMenuFragmentToQuizFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}