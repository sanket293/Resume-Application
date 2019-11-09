package com.sanketvagadiya.ui.Projects;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.sanketvagadiya.Constants.Constants;
import com.sanketvagadiya.Model.ProjectModel;
import com.sanketvagadiya.R;

import java.util.ArrayList;
import java.util.List;

public class ProjectsFragment extends Fragment {

    private ProjectsViewModel projectsViewModel;
    private Context mContext;
    private List<ProjectModel> projectList = new ArrayList<>();

    private ListAdapter adapter;
    private ListView lvProjectList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        projectsViewModel = ViewModelProviders.of(this).get(ProjectsViewModel
                .class);

        View root = inflater.inflate(R.layout.projects_fragment, container, false);

        lvProjectList = root.findViewById(R.id.lvProjectList);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (Constants.isNetworkConnected(getContext())) {
            setUi();
        }
    }

    private void setUi() {
        projectList = projectsViewModel.getProjectList();
        if (projectList.size() > 0) {
            adapter = new ProjectListAdapter(mContext, projectList);
            lvProjectList.setAdapter(adapter);
        }
    }


}
