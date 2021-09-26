package com.rahul.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityTrans : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trans)
        supportFragmentManager.beginTransaction().replace(R.id.container1View,FragmentFirst()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.container2View,FragmentSecond()).commit()

    }
}