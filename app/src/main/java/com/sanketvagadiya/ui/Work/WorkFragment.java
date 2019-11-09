package com.sanketvagadiya.ui.Work;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sanketvagadiya.Constants.Constants;
import com.sanketvagadiya.Model.WorkModel;
import com.sanketvagadiya.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WorkFragment extends Fragment {

    private WorkViewModel workViewModel;
    private List<WorkModel> mWorkList = new ArrayList<>();
    private Context mContext;

    private JSONObject jsonObject = new JSONObject();
    private ListView lvWorkExperience;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.work_fragment, container, false);
        mContext = getContext();
        workViewModel = ViewModelProviders.of(this).get(WorkViewModel
                .class);
        lvWorkExperience = root.findViewById(R.id.lvWorkExperience);

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
        mWorkList = workViewModel.getWorkList();
        if (mWorkList.size() > 0) {
            WorkListAdapter adapter = new WorkListAdapter(mWorkList, mContext);
            lvWorkExperience.setAdapter(adapter);
        }
    }

}
