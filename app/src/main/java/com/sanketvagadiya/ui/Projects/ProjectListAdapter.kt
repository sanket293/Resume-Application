package com.sanketvagadiya.ui.Projects

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sanketvagadiya.Model.ProjectModel
import com.sanketvagadiya.R

import java.util.ArrayList

class ProjectListAdapter(private val mContext: Context, projectList: List<ProjectModel>) : BaseAdapter() {
    private var projectList = ArrayList<ProjectModel>()

    init {
        this.projectList = projectList as ArrayList<ProjectModel>
    }

    override fun getCount(): Int {
        return projectList.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {
        var convertView = convertView

        val holder: ViewHolder

        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            holder = ViewHolder()

            convertView = inflater.inflate(R.layout.project_listview_adapter, viewGroup, false)

            holder.tvProjectName = convertView!!.findViewById(R.id.tvProjectName)
            holder.ivProjectImage = convertView.findViewById(R.id.ivProjectImage)

            holder.tvProjectName!!.text = projectList[i].projectName

            Glide.with(mContext)
                    .load(projectList[i].imageUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.ivProjectImage!!)


            convertView.setOnClickListener {
                val uri = Uri.parse(projectList[i].projectUrl)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                mContext.startActivity(intent)
            }


            convertView.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
        }

        return convertView

    }


    inner class ViewHolder {
        internal var tvProjectName: TextView? = null
        internal var ivProjectImage: ImageView? = null
    }
}