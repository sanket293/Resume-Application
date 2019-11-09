package com.sanketvagadiya.ui.Work;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.sanketvagadiya.Constants.Constants;
import com.sanketvagadiya.Constants.GetOnlineData;
import com.sanketvagadiya.Model.WorkModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WorkViewModel extends ViewModel {
    private List<WorkModel> workList = new ArrayList<>();

    public WorkViewModel() {
        getJson();
    }

    private JSONObject getJson() {
        JSONObject jsonObject = null;
        GetOnlineData getOnlineData = (GetOnlineData) new GetOnlineData(Constants.PAST_WORK_URL).execute();
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
            JSONArray jsonArray = jsonObject.getJSONArray(Constants.PAST_WORK_JSONARRAY);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String roleName = jsonObj.getString(Constants.PAST_WORK_JSON_ROLE_NAME);
                String companyName = jsonObj.getString(Constants.PAST_WORK_JSON_COMPANY_NAME);
                String companyLocation = jsonObj.getString(Constants.PAST_WORK_JSON_LOCATION);
                String joinFrom = jsonObj.getString(Constants.PAST_WORK_JSON_JOIN_FROM);
                String joinTo = jsonObj.getString(Constants.PAST_WORK_JSON_JOIN_TO);
                String jobResponsibilities = jsonObj.getString(Constants.PAST_WORK_JSON_RESPONSIBILITY);

                String imageUrl = jsonObj.getString(Constants.PAST_WORK_JSON_IMAGEURL);

                workList.add(new WorkModel(roleName
                        , companyName, companyLocation, joinFrom
                        , joinTo, jobResponsibilities
                        , imageUrl
                ));
            }
            if (workList.size() > 0) {
                setWorkList(workList);
            }
        } catch (Exception e) {
            Log.e("WorkViewModel err", "err:" + e);
        }
    }

    public List<WorkModel> getWorkList() {
        return workList;
    }

    public void setWorkList(List<WorkModel> workList) {
        this.workList = workList;
    }

}
