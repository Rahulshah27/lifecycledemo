package com.rahul.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*

class ActivityDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        simpleDialog1()
        simpleDialog2()
        singleChoiceDialog()
        multiChoiceDialog()
    }

    private fun multiChoiceDialog() {

    }


    private fun simpleDialog1() {
        btn_simple_dialog1.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this)
            mAlertDialog.apply {
                setTitle("Simple Dialog")
                setMessage("This is a simple message")
                setIcon(R.drawable.ic_sentiment)
                show()
            }
        }
    }

    private fun simpleDialog2() {
        btn_simple_dialog2.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this)
            mAlertDialog.apply {
                setTitle("Simple Dialog")
                setMessage("This is a simple message")
                setIcon(R.drawable.ic_sentiment)
                setPositiveButton("OK") { dialog, id ->
                    Toast.makeText(this@ActivityDialog, "OK Clicked!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("Cancel") { dialog, id ->
                    dialog.dismiss()
                    Toast.makeText(this@ActivityDialog, "Cancel Clicked!", Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }
    }

    private fun singleChoiceDialog() {
        btn_single_choice_dialog.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this)
            val listItems = resources.getStringArray(R.array.single_choice_item)
            mAlertDialog.apply {
                setTitle("Choose an Item")
                setSingleChoiceItems(listItems, -1) { dialog, i ->
                    val position = (dialog as AlertDialog).listView.checkedItemPosition

                    if (position != -1) {
                        val selectedItem = listItems[position]
                        Toast.makeText(this@ActivityDialog, "item: $selectedItem", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                }
                setCancelable(false)
                create()
                show()
            }
        }
    }



}