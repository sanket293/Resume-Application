package com.sanketvagadiya.ui.Profile

import android.util.Log

import androidx.lifecycle.ViewModel

import com.sanketvagadiya.Constants.Constants
import com.sanketvagadiya.Constants.GetOnlineData

import org.json.JSONObject

import java.util.concurrent.ExecutionException

class ProfileViewModel : ViewModel() {
    var profileName = ""
    var imageUrl = ""
    var profileSummary = ""

    val json: JSONObject?
        get() {
            var jsonObject: JSONObject? = null
            val getOnlineData = GetOnlineData(Constants.PROFILE_URL).execute() as GetOnlineData
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
            val `object` = jsonObject.getJSONObject(Constants.PROFILE_JSON_OBJECT)
            profileName = `object`.getString(Constants.PROFILE_JSON_PROFILE_NAME)
            imageUrl = `object`.getString(Constants.PROFILE_JSON_IMAGEURL)
            profileSummary = `object`.getString(Constants.PROFILE_JSON_PROFILE_SUMMARY)
        } catch (e: Exception) {
            Log.e("ProfileViewModel err", "err:$e")
        }

    }


}
