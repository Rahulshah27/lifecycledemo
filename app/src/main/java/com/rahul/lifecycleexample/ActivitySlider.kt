package com.rahul.lifecycleexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.rahul.lifecycleexample.adapter.ViewPagerAdapter
import com.rahul.lifecycleexample.databinding.ActivitySliderBinding

class ActivitySlider : AppCompatActivity() {

    lateinit var binding: ActivitySliderBinding

    private val fragment by lazy {
        TabFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle(R.string.app_name)
        binding.viewPager2.adapter = ViewPagerAdapter(this)
        supportFragmentManager.beginTransaction().replace(R.id.containerMain,fragment).commit()

        binding.viewPager2.clipToPadding = false
        binding.viewPager2.clipChildren = false
        binding.viewPager2.offscreenPageLimit = 5
        binding.viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        binding.viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                when(position){
                    0->{
                        fragment.view?.setBackgroundColor(Color.RED)
                    }
                    1->{
                        fragment.view?.setBackgroundColor(Color.GRAY)
                    }
                    2->{
                        fragment.view?.setBackgroundColor(Color.GREEN)
                    }
                    3->{
                        fragment.view?.setBackgroundColor(Color.YELLOW)
                        Handler(Looper.getMainLooper()).postDelayed({
                            fragment.view?.setBackgroundColor(Color.RED)
                            binding.viewPager2.setCurrentItem(0,false)
                        },1000)
                    }
                }

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position != 4){
                    var setItem= 0

                    Handler(Looper.getMainLooper()).postDelayed({
                        setItem = position+1
                        binding.viewPager2.setCurrentItem(setItem,true)

                    },1000)

                }


            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

            }
        })

        binding.indicator.setViewPager(binding.viewPager2)
    }

}