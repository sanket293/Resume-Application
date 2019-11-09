package com.sanketvagadiya.ui.Work

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sanketvagadiya.Model.WorkModel
import com.sanketvagadiya.R

import java.util.ArrayList

class WorkListAdapter(mWorkList: List<WorkModel>, private val mContext: Context) : BaseAdapter() {

    private var mWorkList = ArrayList<WorkModel>()

    init {
        this.mWorkList = mWorkList as ArrayList<WorkModel>
    }

    override fun getCount(): Int {
        return mWorkList.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        val holder: ViewHolder

        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        if (view == null) {
            holder = ViewHolder()

            view = inflater.inflate(R.layout.work_listview_adapter, viewGroup, false)

            view!!.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        holder.tvWorkAdapterRoleName = view.findViewById(R.id.tvWorkAdapterRoleName)
        holder.tvWorkAdapterCompanyName = view.findViewById(R.id.tvWorkAdapterCompanyName)
        holder.tvWorkAdapterCompanyLocation = view.findViewById(R.id.tvWorkAdapterCompanyLocation)
        holder.tvWorkAdapterJoinFrom = view.findViewById(R.id.tvWorkAdapterJoinFrom)
        holder.tvWorkAdapterJoinTo = view.findViewById(R.id.tvWorkAdapterJoinTo)
        holder.tvWorkAdapterJobResponsibilities = view.findViewById(R.id.tvWorkAdapterJobResponsibilities)
        holder.ivCompanyImage = view.findViewById(R.id.ivCompanyImage)

        setData(holder, i)


        return view
    }

    private fun setData(holder: ViewHolder, i: Int) {

        holder.tvWorkAdapterRoleName!!.text = mWorkList[i].roleName
        holder.tvWorkAdapterCompanyName!!.text = mWorkList[i].companyName
        holder.tvWorkAdapterCompanyLocation!!.text = mWorkList[i].companyLocation
        holder.tvWorkAdapterJoinFrom!!.text = mWorkList[i].joinFrom
        holder.tvWorkAdapterJoinTo!!.text = mWorkList[i].joinTo
        holder.tvWorkAdapterJobResponsibilities!!.text = mWorkList[i].jobResponsibilities

        Glide.with(mContext)
                .load(mWorkList[i].imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivCompanyImage!!)

    }


    inner class ViewHolder {

        internal var tvWorkAdapterRoleName: TextView? = null
        internal var tvWorkAdapterCompanyName: TextView? = null
        internal var tvWorkAdapterCompanyLocation: TextView? = null
        internal var tvWorkAdapterJoinFrom: TextView? = null
        internal var tvWorkAdapterJoinTo: TextView? = null
        internal var tvWorkAdapterJobResponsibilities: TextView? = null
        internal var ivCompanyImage: ImageView? = null

    }
}