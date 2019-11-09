package com.sanketvagadiya.ui.Profile;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sanketvagadiya.Constants.Constants;
import com.sanketvagadiya.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private TextView tvProfileName;
    private TextView tvProfileSummary;
    private ImageView ivProfileImage, ivLinkedIn, ivPlayStore, ivGithub;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel
                .class);

        View root = inflater.inflate(R.layout.profile_fragment, container, false);

        tvProfileName = root.findViewById(R.id.tvProfileName);
        tvProfileSummary = root.findViewById(R.id.tvProfileSummary);
        ivProfileImage = root.findViewById(R.id.ivProfileImage);

        ivLinkedIn = root.findViewById(R.id.ivLinkedIn);
        ivPlayStore = root.findViewById(R.id.ivPlayStore);
        ivGithub = root.findViewById(R.id.ivGithub);

        ivLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl(Constants.LINKEDIN_URL);
            }
        });
        ivPlayStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl(Constants.PLAYSTORE_URL);
            }
        });
        ivGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl(Constants.GITHUB_URL);
            }
        });

        return root;
    }

    private void goToUrl(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (Constants.isNetworkConnected(getContext())) {
            setUi();
        }
    }

    private void setUi() {
        tvProfileName.setText(profileViewModel.getProfileName());
        tvProfileSummary.setText(profileViewModel.getProfileSummary());

        Glide.with(getContext())
                .load(profileViewModel.getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfileImage);
    }

}
