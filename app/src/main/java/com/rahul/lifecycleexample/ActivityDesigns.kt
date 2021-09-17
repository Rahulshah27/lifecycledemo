package com.rahul.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.rahul.lifecycleexample.databinding.ActivityDesignsBinding

class ActivityDesigns : AppCompatActivity() {

    var startPoint = 0
    var endpoint = 0

    private lateinit var binding: ActivityDesignsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_designs)


        binding.btnMaterialBtn1.setOnClickListener {
            snackbarDemo()
        }
        binding.btnMaterialBtn2.setOnClickListener {
            snackbarDemo()
        }
        binding.btnMaterialBtn3.setOnClickListener {
            snackbarDemo()
        }

        binding.toggleButton.setOnClickListener {
            Snackbar.make(binding.toggleButton, "Toggle Button is: " + binding.toggleButton.text, Snackbar.LENGTH_SHORT).show()
        }

        binding.chipGroupChoice.setOnCheckedChangeListener {
                group,
                checkedId ->
            val chip: Chip? = group.findViewById(checkedId)
            chip?.let { chipView ->
                Snackbar.make(binding.chipGroupChoice, chip.text, Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            val message = if(isChecked) "Switch is: ON" else "Switch is: OFF"
            Snackbar.make(binding.switch1, message, Snackbar.LENGTH_SHORT).show()
        }

        binding.check1.setOnClickListener {
            Snackbar.make(binding.check1,"selected : "+ binding.check1.text, Snackbar.LENGTH_SHORT).show()
        }

        binding.check2.setOnClickListener {
            Snackbar.make(binding.check2,"selected : "+ binding.check2.text, Snackbar.LENGTH_SHORT).show()
        }

        binding.check3.setOnClickListener {
            Snackbar.make(binding.check3,"selected : "+ binding.check3.text, Snackbar.LENGTH_SHORT).show()
        }

        binding.radioGroupCoice.setOnCheckedChangeListener {
                group,
                checkedId ->
            if(checkedId == R.id.radio1)
                Snackbar.make(binding.radio1,"selected : "+ binding.radio1.text, Snackbar.LENGTH_SHORT).show()
            if (checkedId == R.id.radio2)
                Snackbar.make(binding.radio2,"selected : "+ binding.radio2.text, Snackbar.LENGTH_SHORT).show()
            if (checkedId == R.id.radio3)
                Snackbar.make(binding.radio3,"selected : "+ binding.radio3.text, Snackbar.LENGTH_SHORT).show()
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                Snackbar.make(binding.seekBar, progress.toString(), Snackbar.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {
                if (seekbar != null) {
                    startPoint = binding.seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.let{
                    endpoint = seekBar.progress
                }
            }

        })

        val items = arrayOf("Spinner Item 1", "Spinner Item 2", "Spinner Item 3", "Spinner Item 4", "Spinner Item 5")
        val arrayAdapter = ArrayAdapter(this@ActivityDesigns, android.R.layout.simple_spinner_dropdown_item, items)
        binding.spinner.adapter = arrayAdapter

        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Snackbar.make(binding.spinner,"selected : "+items[p2], Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun snackbarDemo() {
        Snackbar.make(binding.btnMaterialBtn1,
            "material button is clicked!", Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.widgets_menu -> Toast.makeText(this, "text", Toast.LENGTH_SHORT).show()
            R.id.listView_menu -> Toast.makeText(this, "text", Toast.LENGTH_SHORT).show()
            R.id.rv_menu -> Toast.makeText(this, "text", Toast.LENGTH_SHORT).show()
            R.id.cv_menu -> Toast.makeText(this, "text", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}