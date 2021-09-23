package com.rahul.lifecycleexample

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class CrudAdapter(val c: Context, val itemList: ArrayList<CrCustomData>):
    RecyclerView.Adapter<CrudAdapter.CrudViewHolder>() {

        inner class CrudViewHolder(private val v: View): RecyclerView.ViewHolder(v) {
            var nameText: TextView
            var releasedOn: TextView
            var sdkName: TextView
            var versionName: TextView
            var description: TextView
            var mMenus: ImageView

            init {
                nameText= v.findViewById(R.id.tv_name)
                releasedOn= v.findViewById(R.id.tv_release)
                sdkName= v.findViewById(R.id.tv_sdk)
                versionName= v.findViewById(R.id.tv_version)
                description= v.findViewById(R.id.tv_desc)
                mMenus = v.findViewById(R.id.mMenus)
                mMenus.setOnClickListener { popMenus(it) }
            }

            @SuppressLint("NotifyDataSetChanged")
            private fun popMenus(v: View) {
                val position = itemList[adapterPosition]

                val poppupMenus = PopupMenu(c, v)
                poppupMenus.inflate(R.menu.show_menu)
                poppupMenus.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.m_update -> {
                            val v = LayoutInflater.from(c).inflate(R.layout.d_custom_session4,null)
                            val mName = v.findViewById<TextView>(R.id.d_version_name)
                            val mReleased = v.findViewById<TextView>(R.id.d_released)
                            val mVersion = v.findViewById<Spinner>(R.id.d_version_spin)
                            val mDescription = v.findViewById<TextView>(R.id.d_description)
                            val mSdk = v.findViewById<Spinner>(R.id.d_minimum_sdk_spin)
                            AlertDialog.Builder(c)
                                .setView(v)
                                .setPositiveButton("Ok"){
                                        dialog,_->
                                    position.name = mName.text.toString()
                                    position.released_on = mReleased.text.toString()
                                    position.description = mDescription.text.toString()
                                    notifyDataSetChanged()
                                    Toast.makeText(c,"User Information is Edited",Toast.LENGTH_SHORT).show()
                                    dialog.dismiss()

                                }
                                  .setNegativeButton("Cancel"){
                                        dialog,_->
                                    dialog.dismiss()

                                }
                                .create()
                                .show()
                            true
                        }
                        R.id.m_delete -> {
                            AlertDialog.Builder(c)
                                .setTitle("Delete")
                                .setIcon(R.drawable.ic_delete)
                                .setMessage("Are you sure delete this Item?")
                                .setPositiveButton("Yes"){
                                        dialog,_->
                                    itemList.removeAt(adapterPosition)
                                    notifyDataSetChanged()
                                    Toast.makeText(c,"Deleted the Information",Toast.LENGTH_SHORT).show()
                                    dialog.dismiss()
                                }
                                .setNegativeButton("No"){
                                        dialog,_->
                                    dialog.dismiss()
                                }
                                .create()
                                .show()
                            true
                        }
                        else -> true
                    }
                }

                poppupMenus.show()
                val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                popup.isAccessible = true
                val menu = popup.get(poppupMenus)
                menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(menu, true)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrudViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_rv_items_rcud, parent, false)
        return CrudViewHolder(v)
    }

    override fun onBindViewHolder(holder: CrudViewHolder, position: Int) {
        val newList = itemList[position]
        holder.nameText.text = newList.name
        holder.releasedOn.text = newList.released_on
        holder.versionName.text = newList.version
        holder.sdkName.text = newList.sdk
        holder.description.text = newList.description
    }

    override fun getItemCount(): Int = itemList.size
}
