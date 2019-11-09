package com.sanketvagadiya.ui.Profile;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.sanketvagadiya.Constants.Constants;
import com.sanketvagadiya.Constants.GetOnlineData;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ProfileViewModel extends ViewModel {
    String profileName = "", imageUrl = "", profileSummary = "";

    public ProfileViewModel() {
        getJson();
    }

    private JSONObject getJson() {
        JSONObject jsonObject = null;
        GetOnlineData getOnlineData = (GetOnlineData) new GetOnlineData(Constants.PROFILE_URL).execute();
        try {
            jsonObject = getOnlineData.get();
            if (jsonObject != null) {
                setJsonData(jsonObject);
            }
        } catch (ExecutionException e) {
            Log.e("err", "err" + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("err", "err" + e);
        }
        return jsonObject;
    }

    private void setJsonData(JSONObject jsonObject) {
        try {
            JSONObject object = jsonObject.getJSONObject(Constants.PROFILE_JSON_OBJECT);
            setProfileName(object.getString(Constants.PROFILE_JSON_PROFILE_NAME));
            setImageUrl(object.getString(Constants.PROFILE_JSON_IMAGEURL));
            setProfileSummary(object.getString(Constants.PROFILE_JSON_PROFILE_SUMMARY));
        } catch (Exception e) {
            Log.e("ProfileViewModel err", "err:" + e);
        }
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
    }


}
