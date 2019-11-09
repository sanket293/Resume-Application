package com.sanketvagadiya.ui.Work

import androidx.lifecycle.ViewModelProviders

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.sanketvagadiya.Constants.Constants
import com.sanketvagadiya.Model.WorkModel
import com.sanketvagadiya.R

import org.json.JSONObject

import java.util.ArrayList

class WorkFragment : Fragment() {

    private var workViewModel: WorkViewModel? = null
    private var mWorkList: List<WorkModel> = ArrayList()
    private var mContext: Context? = null

    private val jsonObject = JSONObject()
    private var lvWorkExperience: ListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.work_fragment, container, false)
        mContext = context
        workViewModel = ViewModelProviders.of(this).get(WorkViewModel::class.java)
        lvWorkExperience = root.findViewById(R.id.lvWorkExperience)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (Constants.isNetworkConnected(context!!)) {
            setUi()
        }

    }

    private fun setUi() {
        mWorkList = workViewModel!!.workList
        if (mWorkList.size > 0) {
            val adapter = mContext?.let { WorkListAdapter(mWorkList, it) }
            lvWorkExperience!!.adapter = adapter
        }
    }

}
