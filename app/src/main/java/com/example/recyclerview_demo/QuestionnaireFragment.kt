package com.oceanlong.moment.recyclerview_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.oceanlong.moment.databinding.QuestionnaireListLayoutBinding

class QuestionnaireFragment : Fragment() {

    var mBinding: QuestionnaireListLayoutBinding? = null
    var mAdapter: QuestionnaireAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = QuestionnaireListLayoutBinding.inflate(inflater)
        mBinding?.viewModel = ViewModelProviders.of(this).get(QuestionnaireViewModel::class.java)
        mBinding?.lifecycleOwner = this
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding?.let { binding ->
            binding.viewModel?.questionListModel?.observe(this, Observer { model ->
                val dataList = model.questionList
                mAdapter?.apply {
                    setDataList(dataList)
                }

            })
            initView(binding)
            binding.viewModel?.refresh()
        }
    }

    private fun initView(binding: QuestionnaireListLayoutBinding) {
        mAdapter = QuestionnaireAdapter(context)
        binding.recyclerView.adapter = mAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.refreshBtn.setOnClickListener {
            binding.viewModel?.refresh()
        }
    }

}