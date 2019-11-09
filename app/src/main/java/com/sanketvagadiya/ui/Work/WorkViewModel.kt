package com.sanketvagadiya.ui.Work

import android.util.Log

import androidx.lifecycle.ViewModel

import com.sanketvagadiya.Constants.Constants
import com.sanketvagadiya.Constants.GetOnlineData
import com.sanketvagadiya.Model.ProjectModel
import com.sanketvagadiya.Model.WorkModel

import org.json.JSONArray
import org.json.JSONObject

import java.util.ArrayList
import java.util.concurrent.ExecutionException

class WorkViewModel : ViewModel() {
    var workList = ArrayList<WorkModel>()

    private val json: JSONObject?
        get() {
            var jsonObject: JSONObject? = null
            val getOnlineData = GetOnlineData(Constants.PAST_WORK_URL).execute() as GetOnlineData
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
            val jsonArray = jsonObject.getJSONArray(Constants.PAST_WORK_JSONARRAY)

            for (i in 0 until jsonArray.length()) {
                val jsonObj = jsonArray.getJSONObject(i)
                val roleName = jsonObj.getString(Constants.PAST_WORK_JSON_ROLE_NAME)
                val companyName = jsonObj.getString(Constants.PAST_WORK_JSON_COMPANY_NAME)
                val companyLocation = jsonObj.getString(Constants.PAST_WORK_JSON_LOCATION)
                val joinFrom = jsonObj.getString(Constants.PAST_WORK_JSON_JOIN_FROM)
                val joinTo = jsonObj.getString(Constants.PAST_WORK_JSON_JOIN_TO)
                val jobResponsibilities = jsonObj.getString(Constants.PAST_WORK_JSON_RESPONSIBILITY)

                val imageUrl = jsonObj.getString(Constants.PAST_WORK_JSON_IMAGEURL)

                workList.add(WorkModel(roleName, companyName, companyLocation, joinFrom, joinTo, jobResponsibilities, imageUrl
                ))
            }
            if (workList.size > 0) {
                setWorkList(workList)
            }
        } catch (e: Exception) {
            Log.e("WorkViewModel err", "err:$e")
        }

    }

    fun getWorkList(): List<WorkModel> {
        return workList
    }

    fun setWorkList(workList: List<WorkModel>) {
        this.workList = workList as ArrayList<WorkModel>



    }

}
