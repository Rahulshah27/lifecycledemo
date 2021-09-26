package com.rahul.lifecycleexample


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_rv_items_rcud.view.*

class CrudAdapter (val callback: (CrCustomData?, Int) -> Unit, val deleteCallback:
    (Int) -> Unit ): RecyclerView.Adapter<CrudAdapter.VH>() {

   var versionListItems:ArrayList<CrCustomData>?=null
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.list_rv_items_rcud, parent, false))


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(versionListItems?.get(position))
    }

    override fun getItemCount() = versionListItems?.size ?: 0

    inner class VH(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            with(itemView) {
                itemView.setOnClickListener {
                    callback.invoke(versionListItems?.get(adapterPosition), adapterPosition)
                }
                m_delete1.setOnClickListener {
                    deleteCallback.invoke(adapterPosition)
                }
            }
        }

        fun bind(data: CrCustomData?) {
            //itemView.tag = data
            with(itemView){
                tv_name.text = data?.name.toString()
                tv_release.text = data?.released_on.toString()
                tv_version.text = data?.version.toString()
                tv_sdk.text = data?.sdk.toString()
                tv_desc.text = data?.description.toString()
            }
        }
    }

    fun updateItem(position: Int,model: CrCustomData){
        versionListItems?.set(position,model)
    }
    fun insertItem(position: Int,model: CrCustomData){
        versionListItems?.add(position,model)
    }

    fun deleteItem(position: Int){
        versionListItems?.removeAt(position)
    }

}

