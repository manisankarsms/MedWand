package com.techbros.medwand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val pagerAdapter = MyPagerAdapter(this)
        viewPager.adapter = pagerAdapter

//        // Attach TabLayout to ViewPager2
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            // Customize your tab text here
//            tab.text = "Tab ${(position + 1)}"
//        }.attach()

        // Attach TabLayout to ViewPager2 with custom layout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val customTabLayout = layoutInflater.inflate(R.layout.custom_tab_layout, null)

            // Customize your tab icon and text here
            val tabIcon = customTabLayout.findViewById<ImageView>(R.id.tabIcon)
            val tabText = customTabLayout.findViewById<TextView>(R.id.tabText)

            // Replace with actual icons and text
            when (position) {
                0 -> {
                    tabIcon.setImageResource(R.drawable.thermometer)
                    tabText.text = "Thermometer"
                }
                1 -> {
                    tabIcon.setImageResource(R.drawable.pulse_oximeter)
                    tabText.text = "Pulse Oximeter"
                }
            }

            tab.customView = customTabLayout
        }.attach()
    }
}