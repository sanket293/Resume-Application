package com.sanketvagadiya.ui.Projects

import android.util.Log

import androidx.lifecycle.ViewModel

import com.sanketvagadiya.Constants.Constants
import com.sanketvagadiya.Constants.GetOnlineData
import com.sanketvagadiya.Model.ProjectModel

import org.json.JSONArray
import org.json.JSONObject

import java.util.ArrayList
import java.util.concurrent.ExecutionException

class ProjectsViewModel : ViewModel() {

    var projectList: ArrayList<ProjectModel> = ArrayList();

    private val json: JSONObject?
        get() {
            var jsonObject: JSONObject? = null
            val getOnlineData = GetOnlineData(Constants.PROJECT_URL).execute() as GetOnlineData
            try {
                jsonObject = getOnlineData.get()
                if (jsonObject != null) {
                    setJsonData(jsonObject)
                }
            } catch (e: ExecutionException) {
                Log.e("err", "err$e")
            } catch (e: InterruptedException) {
                e.printStackTrace()
                Log.e("err", "err$e")
            }

            return jsonObject
        }

    init {
        json
    }

    private fun setJsonData(jsonObject: JSONObject) {
        try {
            val jsonArray = jsonObject.getJSONArray(Constants.PROJECT_JSONARRAY)

            for (i in 0 until jsonArray.length()) {
                val jsonObj = jsonArray.getJSONObject(i)
                val projectName = jsonObj.getString(Constants.PROJECT_JSON_PROJECTNAME)
                val imageUrl = jsonObj.getString(Constants.PROJECT_JSON_IMAGEURL)
                val projectUrl = jsonObj.getString(Constants.PROJECT_JSON_PROJECTURL)
                projectList.add(ProjectModel(projectName, imageUrl, projectUrl))
            }
            if (projectList.size > 0) {
                setProjectList(projectList)
            }

        } catch (e: Exception) {
            Log.e("ProjectsViewModel err", "err$e")
        }

    }

    fun getProjectList(): List<ProjectModel> {
        return projectList
    }

    fun setProjectList(projectList: List<ProjectModel>) {
        this.projectList = projectList as ArrayList<ProjectModel>
    }
}

