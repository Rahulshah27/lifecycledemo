package com.rahul.lifecycleexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val list: ArrayList<CustomData>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        internal var ivImage: ImageView
        internal var tvName: TextView
        internal var tvVersion: TextView
        internal var tvDesciption: TextView
        internal var tvSdk: TextView
        internal var tvReleaseOn: TextView

        init {
            ivImage = itemView.findViewById(R.id.iv_image)
            tvName = itemView.findViewById(R.id.tv_name)
            tvVersion = itemView.findViewById(R.id.tv_version)
            tvSdk = itemView.findViewById(R.id.tv_sdk)
            tvDesciption = itemView.findViewById(R.id.tv_desc)
            tvReleaseOn = itemView.findViewById(R.id.tv_release)
        }

        internal fun bind(position: Int) {
            ivImage.setImageResource(list[position].image)
            tvName.text = list[position].name
            tvVersion.text = list[position].version
            tvSdk.text = list[position].sdk
            tvDesciption.text = list[position].description
            tvReleaseOn.text = list[position].released_on
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}