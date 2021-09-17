package com.rahul.lifecycleexample

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter(private val context: Activity, private val arrayList: ArrayList<CustomData>):
    ArrayAdapter<CustomData>(context, R.layout.list_rv_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_rv_item, null)

        val image: ImageView = view.findViewById(R.id.iv_image)
        val name: TextView = view.findViewById(R.id.tv_name)
        val versionName: TextView = view.findViewById(R.id.tv_version)
        val sdkName: TextView = view.findViewById(R.id.tv_sdk)
        val releaseOn: TextView = view.findViewById(R.id.tv_release)
        val description: TextView = view.findViewById(R.id.tv_desc)

        image.setImageResource(arrayList[position].image)
        name.text = arrayList[position].name
        versionName.text = arrayList[position].version
        sdkName.text = arrayList[position].sdk
        releaseOn.text = arrayList[position].released_on
        description.text = arrayList[position].description

        return view

    }

}