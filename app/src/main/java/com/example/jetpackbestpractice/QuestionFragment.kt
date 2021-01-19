package com.example.jetpackbestpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackbestpractice.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.viewmodel2 = ViewModelProvider(requireActivity()).get(QuestionairViewModel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }
}