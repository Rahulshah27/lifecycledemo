package com.rahul.lifecycleexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar_layout.*

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.widgets_menu -> startWidgetsActivity()
            R.id.listView_menu -> startListViewActivity()
            R.id.rv_menu -> startRecyclerViewActivity()
            R.id.cv_menu -> Toast.makeText(this, "choose other options please!", Toast.LENGTH_SHORT).show()
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

    private fun startListViewActivity() {
        val nextScreenIntent = Intent(this, ListViewActivity::class.java)
        startActivity(nextScreenIntent)
    }

    override fun onStart() {
        super.onStart()
        setSupportActionBar(toolbar)
        title = "CustomListView"
    }
}