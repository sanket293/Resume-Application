package com.sanketvagadiya.Constants


import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

import com.sanketvagadiya.R

object Constants {

    var PROJECT_URL = "https://api.myjson.com/bins/k3svw"
    var PAST_WORK_URL = "https://api.myjson.com/bins/1bsp2w"
    var PROFILE_URL = "https://api.myjson.com/bins/10b8tk"

    var GITHUB_URL = "https://github.com/sanket293"
    var LINKEDIN_URL = "https://www.linkedin.com/in/sanket-vagadiya"
    var PLAYSTORE_URL = "http://bit.ly/sanket-vagadiya"

    var PROJECT_JSONARRAY = "Projects"
    var PROJECT_JSON_PROJECTNAME = "projectName"
    var PROJECT_JSON_IMAGEURL = "imageUrl"
    var PROJECT_JSON_PROJECTURL = "projectUrl"

    var PAST_WORK_JSONARRAY = "PastWork"
    var PAST_WORK_JSON_ROLE_NAME = "roleName"
    var PAST_WORK_JSON_COMPANY_NAME = "companyName"
    var PAST_WORK_JSON_LOCATION = "CompanyLocation"
    var PAST_WORK_JSON_JOIN_FROM = "JoinFrom"
    var PAST_WORK_JSON_JOIN_TO = "JoinTo"
    var PAST_WORK_JSON_RESPONSIBILITY = "JobResponsibilities"
    var PAST_WORK_JSON_IMAGEURL = "imageUrl"

    var PROFILE_JSON_OBJECT = "MyProfile"
    var PROFILE_JSON_IMAGEURL = "imageUrl"
    var PROFILE_JSON_PROFILE_NAME = "profileName"
    var PROFILE_JSON_PROFILE_SUMMARY = "profileSummary"

    var SPLASH_SLEEP_TIME = 100

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val isConnected = cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected

        if (!isConnected) {
            Toast.makeText(context, context.resources.getString(R.string.err_no_internet), Toast.LENGTH_SHORT).show()
        }

        return isConnected
    }

}
