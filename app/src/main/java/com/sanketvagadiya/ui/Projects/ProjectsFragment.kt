package com.sanketvagadiya.ui.Projects

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView

import com.sanketvagadiya.Constants.Constants
import com.sanketvagadiya.Model.ProjectModel
import com.sanketvagadiya.R

import java.util.ArrayList

class ProjectsFragment : Fragment() {

    private var projectsViewModel: ProjectsViewModel? = null
    private var mContext: Context? = null
    private var projectList: List<ProjectModel> = ArrayList()

    private var adapter: ListAdapter? = null
    private var lvProjectList: ListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mContext = activity
        projectsViewModel = ViewModelProviders.of(this).get(ProjectsViewModel::class.java)

        val root = inflater.inflate(R.layout.projects_fragment, container, false)

        lvProjectList = root.findViewById(R.id.lvProjectList)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (Constants.isNetworkConnected(context!!)) {
            setUi()
        }
    }

    private fun setUi() {
        projectList = projectsViewModel!!.projectList
        if (projectList.size > 0) {
            adapter = ProjectListAdapter(mContext!!, projectList)
            lvProjectList!!.adapter = adapter
        }
    }


}
