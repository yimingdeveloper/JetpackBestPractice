package com.example.jetpackbestpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.jetpackbestpractice.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment(), TaskNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuestionBinding.inflate(inflater, container, false)
        val viewmodel = ViewModelProvider(requireActivity()).get(QuestionairViewModel::class.java)
        viewmodel.taskNavigator = this
        binding.viewmodel2 = viewmodel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun showList() {
        findNavController().navigate(R.id.goto_showcase)
    }
}