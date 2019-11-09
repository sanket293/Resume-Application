package com.sanketvagadiya.Constants;


import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.sanketvagadiya.R;

public class Constants {

    public static String PROJECT_URL = "https://api.myjson.com/bins/k3svw";
    public static String PAST_WORK_URL = "https://api.myjson.com/bins/1bsp2w";
    public static String PROFILE_URL = "https://api.myjson.com/bins/10b8tk";

    public static String GITHUB_URL = "https://github.com/sanket293";
    public static String LINKEDIN_URL = "https://www.linkedin.com/in/sanket-vagadiya";
    public static String PLAYSTORE_URL = "http://bit.ly/sanket-vagadiya";

    public static String PROJECT_JSONARRAY = "Projects";
    public static String PROJECT_JSON_PROJECTNAME = "projectName";
    public static String PROJECT_JSON_IMAGEURL = "imageUrl";
    public static String PROJECT_JSON_PROJECTURL = "projectUrl";

    public static String PAST_WORK_JSONARRAY = "PastWork";
    public static String PAST_WORK_JSON_ROLE_NAME = "roleName";
    public static String PAST_WORK_JSON_COMPANY_NAME = "companyName";
    public static String PAST_WORK_JSON_LOCATION = "CompanyLocation";
    public static String PAST_WORK_JSON_JOIN_FROM = "JoinFrom";
    public static String PAST_WORK_JSON_JOIN_TO = "JoinTo";
    public static String PAST_WORK_JSON_RESPONSIBILITY = "JobResponsibilities";
    public static String PAST_WORK_JSON_IMAGEURL = "imageUrl";

    public static String PROFILE_JSON_OBJECT = "MyProfile";
    public static String PROFILE_JSON_IMAGEURL = "imageUrl";
    public static String PROFILE_JSON_PROFILE_NAME = "profileName";
    public static String PROFILE_JSON_PROFILE_SUMMARY = "profileSummary";

    public static int SPLASH_SLEEP_TIME = 100;

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean isConnected = cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();

        if (!isConnected) {
            Toast.makeText(context, context.getResources().getString(R.string.err_no_internet), Toast.LENGTH_SHORT).show();
        }

        return isConnected;
    }

}
