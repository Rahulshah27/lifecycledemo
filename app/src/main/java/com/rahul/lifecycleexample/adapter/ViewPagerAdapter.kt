package com.rahul.lifecycleexample.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rahul.lifecycleexample.Constants
import com.rahul.lifecycleexample.TabFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity ) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return Constants.Num.NUM_PAGE
    }

    override fun createFragment(position: Int) = TabFragment()

}