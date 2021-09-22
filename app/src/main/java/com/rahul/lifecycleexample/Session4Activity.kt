package com.rahul.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_session4.*
import kotlinx.android.synthetic.main.d_custom_session4.view.*

class Session4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session4)


        add_recycle.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.d_custom_session4, null)
            val mBuilder = AlertDialog.Builder(this).also {
                it.setView(mDialogView)
            }
            val mDialog = mBuilder.show()
            mDialogView.btn_crud_add.setOnClickListener {
                addCrudCustom()
                mDialog.dismiss()
            }
        }


    }

    private fun addCrudCustom() {

    }
}