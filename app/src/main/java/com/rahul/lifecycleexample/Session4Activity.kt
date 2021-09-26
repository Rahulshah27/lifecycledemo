package com.rahul.lifecycleexample

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_session4.*
import kotlinx.android.synthetic.main.d_custom_session4.*
import java.util.*

class Session4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session4)
        initView()
//        loadData()
        initClicks()
    }

//    private fun loadData() {
//        (rvCrud.adapter as CrudAdapter).versionListItems =  CrudDataProvider.getAndroidDetails()
//    }

    private fun initClicks() {
        add_recycle.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun initView() {
        rvCrud.apply {
            layoutManager = LinearLayoutManager(this@Session4Activity)
            adapter = CrudAdapter(::onItemClicked, ::showDeleteAlert)
        }
    }

    private fun showDeleteAlert(deleteItemPosition: Int) {

    }

    private fun onItemClicked(crCustomData: CrCustomData?, position: Int) {
//        Toast.makeText(this, crCustomData, Toast.LENGTH_SHORT).show()
    }

    private fun showCustomDialog() {
        with(Dialog(this)) {
            var selectedItemSdk = ""
            var selectedVersion = ""
            val versionItems = resources.getStringArray(R.array.version_item)
            val sdkItems = resources.getStringArray(R.array.sdk_item)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.d_custom_session4)
            val name = d_version_name
            val description = d_description
            val releasedDate = d_released

            val versionAdapter = ArrayAdapter(this@Session4Activity,
                android.R.layout.simple_spinner_item, versionItems)
            versionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            d_version_spin.adapter = versionAdapter

            d_version_spin?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedVersion = versionItems[position]
                }

            }


            val sdkAdapter = ArrayAdapter(this@Session4Activity,
                android.R.layout.simple_spinner_item, sdkItems)
            sdkAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            d_minimum_sdk_spin.adapter = sdkAdapter

            d_minimum_sdk_spin?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedItemSdk = sdkItems[position]
                }

            }
            findViewById<AppCompatButton>(R.id.btn_crud_add).setOnClickListener {
                if(name.text.toString().trim().isEmpty())
                    name.error = "Name is required" // change message as per the field!
                if (description.text.toString().trim().isEmpty())
                    description.error = "Description is required"
                if (releasedDate.text.toString().trim().isEmpty())
                    releasedDate.error = "Released Date is required"
                else {

                        val data = CrCustomData(
                            name.text.toString().trim(),
                            selectedVersion,
                            "Released On: ${releasedDate.text.toString().trim()}",
                            selectedItemSdk,
                            description.text.toString().trim())

                    (rvCrud.adapter as CrudAdapter).notifyItemInserted(0)
                    (rvCrud.adapter as CrudAdapter).insertItem(0,data)
                    Snackbar.make(rvCrud, "Item inserted at ${0}",Snackbar.LENGTH_SHORT).show()
                    dismiss()

                }
            }
            window?.apply {
                setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            show()
        }
    }

}