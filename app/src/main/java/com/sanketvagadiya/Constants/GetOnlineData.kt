package com.sanketvagadiya.Constants

import android.os.AsyncTask
import android.util.Log

import org.json.JSONException
import org.json.JSONObject


import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class GetOnlineData(url: String) : AsyncTask<Void, Void, JSONObject>() {

     var url = ""
     var jsonStr= ""

     lateinit var jsonObject: JSONObject

    init {
        this.url = url
    }


    override fun doInBackground(vararg voids: Void): JSONObject {

        try {
            val url = URL(this.url)
            val httpURLConnection = url.openConnection() as HttpURLConnection
            val inputStream = httpURLConnection.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream))

            jsonStr = reader.readLine()

            jsonObject = JSONObject(jsonStr)
            Log.e("jsonObj GetOnlineData", ".$jsonObject")

        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return jsonObject
    }

}
