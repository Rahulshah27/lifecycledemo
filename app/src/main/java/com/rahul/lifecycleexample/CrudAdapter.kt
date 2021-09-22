package com.rahul.lifecycleexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CrudAdapter(val c: Context, private val listItem: ArrayList<CrCustomData>):
    RecyclerView.Adapter<CrudAdapter.CrudViewHolder>() {

        inner class CrudViewHolder(val v: View): RecyclerView.ViewHolder(v) {
            val nametext= v.findViewById<TextView>(R.id.tv_name)
            val versionImage = v.findViewById<ImageView>(R.id.iv_image)
            val releasedOn= v.findViewById<TextView>(R.id.tv_release)
            val versionName= v.findViewById<TextView>(R.id.tv_version)
            val sdkName= v.findViewById<TextView>(R.id.tv_sdk)
            val description= v.findViewById<TextView>(R.id.tv_desc)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrudViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_rv_items_rcud, parent, false)
        return CrudViewHolder(v)
    }

    override fun onBindViewHolder(holder: CrudViewHolder, position: Int) {
        val newList = listItem[position]
        holder.nametext.text = newList.name
        holder.versionImage.setImageResource(newList.image)
        holder.releasedOn.text = newList.released_on
        holder.versionName.text = newList.version
        holder.sdkName.text = newList.sdk
        holder.description.text = newList.description
    }

    override fun getItemCount(): Int = listItem.size
}
