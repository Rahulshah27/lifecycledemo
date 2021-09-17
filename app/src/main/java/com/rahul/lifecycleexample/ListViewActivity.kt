package com.rahul.lifecycleexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.rahul.lifecycleexample.databinding.ActivityListViewBinding
import kotlinx.android.synthetic.main.toolbar_layout.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view)

        val data = arrayListOf<CustomData>()

        data.add(CustomData(R.drawable.ic_android, "version 1", "No codename", "released on 2008", "sdk 1", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 1.1", "No codename", "released on 2009", "sdk 2", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 1.5", "Cupcake", "released on 2009", "sdk 3", " codename of the dessert item (Cupcake)"))
        data.add(CustomData(R.drawable.ic_android, "version 1.6", "Donut", "released on 2009", "sdk 4", " It contains numerous new features"))
        data.add(CustomData(R.drawable.ic_android, "version 2.0", "Eclair", "released on 2009", "sdk 5", "It contains several features as speed"))
        data.add(CustomData(R.drawable.ic_android, "version 2.2", "Froyo", "released on 2010", "sdk 8", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 2.3", "Gingerbread", "released on 2010", "sdk 9", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 3", "Honeycomb", "released on 2011", "sdk 11", " It contains numerous new features"))
        data.add(CustomData(R.drawable.ic_android, "version 4", "Ice Cream Sandwich", "released on 2011", "sdk 14", "It contains several features as speed"))
        data.add(CustomData(R.drawable.ic_android, "version 4.1", "Jelly Bean", "released on 2012", "sdk 16", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 4.4", "KitKat", "released on 2013", "sdk 19", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 5.0", "Lollipop", "released on 2014", "sdk 21", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 6.0", "Marshmallow", "released on 2015", "sdk 23", " It contains numerous new features"))
        data.add(CustomData(R.drawable.ic_android, "version 7.0", "Nougat", "released on 2016", "sdk 24", " It contains numerous new features"))
        data.add(CustomData(R.drawable.ic_android, "version 7.1", "Nougat", "released on 2016", "sdk 25", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 8", "Oreo", "released on 2017", "sdk 26", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 8.1", "Oreo", "released on 2017", "sdk 27", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 9.0", "Pie", "released on 2018", "sdk 28", "initial version of Android operating system"))
        data.add(CustomData(R.drawable.ic_android, "version 10", "Android 10", "released on 2019", "sdk 29", " It contains numerous new features"))
        data.add(CustomData(R.drawable.ic_android, "version 11", "Android 11", "released on 2020", "sdk 30", "initial version of Android operating system"))

        binding.listView.adapter = ListViewAdapter(this, data)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.widgets_menu -> startWidgetsActivity()
            R.id.listView_menu -> Toast.makeText(this, "choose other options please!", Toast.LENGTH_SHORT).show()
            R.id.rv_menu -> startRecyclerViewActivity()
            R.id.cv_menu -> startCustomViewActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startWidgetsActivity() {
        val nextScreenIntent = Intent(this, ActivityDesigns::class.java)
        startActivity(nextScreenIntent)
    }

    private fun startRecyclerViewActivity() {
        val nextScreenIntent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(nextScreenIntent)
    }

    private fun startCustomViewActivity() {
        val nextScreenIntent = Intent(this, CustomViewActivity::class.java)
        startActivity(nextScreenIntent)    }


    override fun onStart() {
        super.onStart()
        setSupportActionBar(toolbar)
        title = "ListView"
    }
}