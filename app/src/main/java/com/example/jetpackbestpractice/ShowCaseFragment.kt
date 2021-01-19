package com.example.jetpackbestpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackbestpractice.databinding.FragmentShowCaseBinding

class ShowCaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShowCaseBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(QuestionairViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.recShowcase.adapter = ShowCaseAdapter(viewModel.questions?.value ?: mutableListOf())
        binding.recShowcase.layoutManager = LinearLayoutManager(context)
        binding.recShowcase.setHasFixedSize(false)
        return binding.root
    }
}