package com.rahul.lifecycleexample

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import java.util.*

class ActivityDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        simpleDialog1()
        simpleDialog2()
        singleChoiceDialog()
        multiChoiceDialog()
        progressDialog1()
        datePickerDialog()
        timePickerDialog()
    }

    private fun timePickerDialog() {
        btn_time_picker_dialog.setOnClickListener {
            val mTimePicker: TimePickerDialog
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mcurrentTime.get(Calendar.MINUTE)

            mTimePicker = TimePickerDialog(this,
                { _, hourOfDay, minute ->
                    val selectedTime = String.format("%d : %d", hourOfDay, minute)
                    toast(selectedTime)
                }, hour, minute, false)
            mTimePicker.show()
        }
    }

    private fun datePickerDialog() {
        btn_date_picker_dialog.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, {
                    _, mYear, monthOfYear, dayOfMonth ->
                toast("$dayOfMonth/${monthOfYear+1}/$mYear")
            }, year, month, day)
            dpd.show()
        }

    }

    private fun progressDialog1() {
        btn_progress_dialog1.setOnClickListener {
            val dialog = ProgressDialog(this)
            dialog.run {
                setTitle("Hello!")
                setMessage("Please Wait..")
                show()
            }
        }
    }

    private fun multiChoiceDialog() {
        btn_multi_choice_dialog.setOnClickListener {
            val listItems = resources.getStringArray(R.array.single_choice_item)
            val arrayChecked = booleanArrayOf(true,false,true,false,false,false)
            val mAlertDialog = AlertDialog.Builder(this)
            mAlertDialog.apply {
                setMultiChoiceItems(listItems, arrayChecked) { _, which, isChecked ->
                    arrayChecked[which] = isChecked

                }
                setPositiveButton("Submit") {_, _ ->
                    for (i in 0 until listItems.size) {
                        val checked = arrayChecked[i]
                        if (checked) {
                            toast("${listItems[i]} is checked \n")
                        }
                    }
                }
                setCancelable(false)
                create()
                show()
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this@ActivityDialog, message, Toast.LENGTH_SHORT).show()
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
                setPositiveButton("OK") { _, _ ->
                    Toast.makeText(this@ActivityDialog, "OK Clicked!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("Cancel") { dialog, _ ->
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
                setSingleChoiceItems(listItems, -1) { _, _ ->
                }
                setPositiveButton("Submit") { dialog, _ ->
                    val position = (dialog as AlertDialog).listView.checkedItemPosition

                    if (position != -1) {
                        val selectedItem = listItems[position]
                        Toast.makeText(this@ActivityDialog, "$selectedItem submitted", Toast.LENGTH_SHORT).show()
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