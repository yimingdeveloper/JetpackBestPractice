package com.example.jetpackbestpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackbestpractice.databinding.FragmentShowCaseBinding

class ShowCaseFragment : Fragment(), ItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShowCaseBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(QuestionairViewModel::class.java)
        viewModel.itemClickListener = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.recShowcase.adapter = ShowCaseAdapter(viewModel.questions?.value ?: mutableListOf(), this)
        binding.recShowcase.layoutManager = LinearLayoutManager(context)
        binding.recShowcase.setHasFixedSize(false)
        return binding.root
    }

    override fun onItemClick(view: View, question: Question, position: Int) {
        Toast.makeText(requireContext(), question.question, Toast.LENGTH_LONG).show()
    }
}