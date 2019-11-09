package com.sanketvagadiya.ui.Profile

import androidx.lifecycle.ViewModelProviders

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sanketvagadiya.Constants.Constants
import com.sanketvagadiya.R

class ProfileFragment : Fragment() {

    private var profileViewModel: ProfileViewModel? = null
    private var tvProfileName: TextView? = null
    private var tvProfileSummary: TextView? = null
    private var ivProfileImage: ImageView? = null
    private var ivLinkedIn: ImageView? = null
    private var ivPlayStore: ImageView? = null
    private var ivGithub: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        val root = inflater.inflate(R.layout.profile_fragment, container, false)

        tvProfileName = root.findViewById(R.id.tvProfileName)
        tvProfileSummary = root.findViewById(R.id.tvProfileSummary)
        ivProfileImage = root.findViewById(R.id.ivProfileImage)

        ivLinkedIn = root.findViewById(R.id.ivLinkedIn)
        ivPlayStore = root.findViewById(R.id.ivPlayStore)
        ivGithub = root.findViewById(R.id.ivGithub)

        ivLinkedIn!!.setOnClickListener { goToUrl(Constants.LINKEDIN_URL) }
        ivPlayStore!!.setOnClickListener { goToUrl(Constants.PLAYSTORE_URL) }
        ivGithub!!.setOnClickListener { goToUrl(Constants.GITHUB_URL) }

        return root
    }

    private fun goToUrl(url: String) {
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (Constants.isNetworkConnected(context!!)) {
            setUi()
        }
    }

    private fun setUi() {
        tvProfileName!!.text = profileViewModel!!.profileName
        tvProfileSummary!!.text = profileViewModel!!.profileSummary

        Glide.with(context!!)
                .load(profileViewModel!!.imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfileImage!!)
    }

}
