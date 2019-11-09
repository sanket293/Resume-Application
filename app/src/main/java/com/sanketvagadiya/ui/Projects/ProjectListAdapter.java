package com.sanketvagadiya.ui.Projects;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sanketvagadiya.Model.ProjectModel;
import com.sanketvagadiya.R;

import java.util.ArrayList;
import java.util.List;

public class ProjectListAdapter extends BaseAdapter {
    private Context mContext;
    private List<ProjectModel> projectList = new ArrayList<>();

    public ProjectListAdapter(Context mContext, List<ProjectModel> projectList) {
        this.mContext = mContext;
        this.projectList = projectList;
    }

    @Override
    public int getCount() {
        return projectList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        final ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.project_listview_adapter, viewGroup, false);

            holder.tvProjectName = convertView.findViewById(R.id.tvProjectName);
            holder.ivProjectImage = convertView.findViewById(R.id.ivProjectImage);

            holder.tvProjectName.setText(projectList.get(i).getProjectName());

            Glide.with(mContext)
                    .load(projectList.get(i).getImageUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.ivProjectImage);


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse(projectList.get(i).getProjectUrl());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(intent);
                }
            });


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;

    }


    public class ViewHolder {
        TextView tvProjectName;
        ImageView ivProjectImage;
    }
}