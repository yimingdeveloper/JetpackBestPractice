package com.example.recyclerview_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackbestpractice.R
import com.example.jetpackbestpractice.databinding.QuestionnaireItemLayoutBinding

class QuestionnaireAdapter(private val context: Context?) :
    RecyclerView.Adapter<QuestionnaireViewHolder>() {

    private var dataList: List<Question>?=null

    fun setDataList(dataList: List<Question>?) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionnaireViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.questionnaire_item_layout, parent, false)
        return QuestionnaireViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: QuestionnaireViewHolder, position: Int) {
        dataList?.takeIf { it.isNotEmpty() }?.let {
            holder.bind(it[position])
        }
    }
}


class QuestionnaireViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mBinding: QuestionnaireItemLayoutBinding? = null
    fun bind(question: Question) {
        mBinding = DataBindingUtil.bind(itemView)
        mBinding?.apply {
            viewModel = QuestionItemViewModel()
            questionTitle.text = viewModel?.getQuestionText(question)?:""
        }

    }
}