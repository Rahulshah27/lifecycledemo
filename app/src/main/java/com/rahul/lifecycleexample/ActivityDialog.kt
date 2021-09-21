package com.rahul.lifecycleexample

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.d_bottom_sheet.*
import kotlinx.android.synthetic.main.dialog_custom_layout.*
import java.util.*

class ActivityDialog : AppCompatActivity() {

    private lateinit var listItems: Array<String>
    private val arrayChecked: BooleanArray = booleanArrayOf(true,false,true,false,false,false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        simpleDialog1()
        simpleDialog2()
        singleChoiceDialog()
        multiChoiceDialog()
        progressDialog1()
        progressDialog2()
        datePickerDialog()
        timePickerDialog()
        bottomDialog()
    }

    private fun progressDialog2() {
        btn_progress_dialog2?.setOnClickListener {
            val visibility = if (progress_2.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
            progress_2.visibility = visibility
        }
    }

    private fun bottomDialog() {
        btn_bottom_dialog.setOnClickListener {
            FragmentBottomSheet().also {
                it.show(supportFragmentManager, "TAG")
            }

//            val btnSheet = layoutInflater.inflate(R.layout.d_bottom_sheet, null)
//            val dialog = BottomSheetDialog(this)
//            dialog.setContentView(btnSheet)
//            btnSheet.setOnClickListener {
//                dialog.dismiss()
//            }
//
//            dialog.show()
        }
    }

    private fun simpleDialog1() {
        btn_simple_dialog1.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_custom_layout, null)
            val mAlertDialog = AlertDialog.Builder(this)
            mAlertDialog.apply {
                setView(dialogView)
                show()
            }
                val btnSubmit = dialogView.findViewById<Button>(R.id.btn_custom_submit)
                val edName = dialogView.findViewById<EditText>(R.id.ed_name)
                btnSubmit.setOnClickListener {
                   if (edName.text.isEmpty()) {
                        toast("please enter something!")
                    }
                   else toast("${edName.text.trim()} Submitted!")
                }

        }
    }

    private fun timePickerDialog() {
        btn_time_picker_dialog.setOnClickListener {
            val mTimePicker: TimePickerDialog
            val mCurrentTime = Calendar.getInstance()
            val hour = mCurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mCurrentTime.get(Calendar.MINUTE)

            mTimePicker = TimePickerDialog(this,
                { _, hourOfDay, mMinute ->
                    val selectedTime = String.format("Time %d : %d", hourOfDay, mMinute)
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
            listItems = resources.getStringArray(R.array.multiple_choice_item)
            val mAlertDialog = AlertDialog.Builder(this)
            mAlertDialog.apply {
                var items = ""
                setTitle("Choose multiple Items")
                setMultiChoiceItems(listItems, arrayChecked) { _, which, isChecked ->
                    arrayChecked[which] = isChecked
                }
                setPositiveButton("Submit") {_, _ ->
                    for (i in 0 until listItems.size) {
                        val checked = arrayChecked[i]
                        if (checked) {
                            items += listItems[i] + "\n"
                        }
                    }
                    toast("items: $items is checked!")
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


    private fun simpleDialog2() {
        btn_simple_dialog2.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this)
            mAlertDialog.apply {
                setTitle("Simple Dialog")
                setMessage("This is a simple message")
                setIcon(R.drawable.ic_sentiment)
                setPositiveButton("OK") { _, _ ->
                    toast("OK Clicked!")
                }
                setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                    toast("Cancel Clicked!")
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
                        listItems[position].also {
                            toast("$it submitted")
                            dialog.dismiss()
                        }
                    }
                }
                setCancelable(false)
                create()
                show()
            }
        }
    }


}