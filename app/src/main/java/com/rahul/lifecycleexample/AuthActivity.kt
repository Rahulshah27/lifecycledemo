package com.rahul.lifecycleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    val fragmentManger: FragmentManager = supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManger.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        addReplaceFragment(FragmentLogin(), 1, "fragment")
    }
    fun addReplaceFragment(fragment: Fragment?, addOrReplace: Int, backStackValue:String) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        when (addOrReplace) {
            1 -> {
                transaction.add(activityMain.id, fragment!!)
                manager.popBackStack()
                transaction.commit()
            }
            2 -> {
                transaction.replace(activityMain.id, fragment!!)
                transaction.addToBackStack(backStackValue)
                transaction.commit()
            }
            else -> {
                transaction.replace(activityMain.id, fragment!!)
                manager.popBackStack()
                transaction.commit()

            }
        }
    }

}