package com.sanketvagadiya.ui.Projects;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.sanketvagadiya.Constants.Constants;
import com.sanketvagadiya.Constants.GetOnlineData;
import com.sanketvagadiya.Model.ProjectModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProjectsViewModel extends ViewModel {

    private List<ProjectModel> projectList = new ArrayList<>();

    public ProjectsViewModel() {
        getJson();
    }

    private JSONObject getJson() {
        JSONObject jsonObject = null;
        GetOnlineData getOnlineData = (GetOnlineData) new GetOnlineData(Constants.PROJECT_URL).execute();
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
            JSONArray jsonArray = jsonObject.getJSONArray(Constants.PROJECT_JSONARRAY);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String projectName = jsonObj.getString(Constants.PROJECT_JSON_PROJECTNAME);
                String imageUrl = jsonObj.getString(Constants.PROJECT_JSON_IMAGEURL);
                String projectUrl = jsonObj.getString(Constants.PROJECT_JSON_PROJECTURL);
                projectList.add(new ProjectModel(projectName, imageUrl, projectUrl));
            }
            if(projectList.size()>0){
                setProjectList(projectList);
            }

        } catch (Exception e) {
            Log.e("ProjectsViewModel err", "err" + e);
        }
    }

    public List<ProjectModel> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectModel> projectList) {
        this.projectList = projectList;
    }
}

