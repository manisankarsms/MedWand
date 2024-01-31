package com.techbros.medwand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val summaryBtn = findViewById<CardView>(R.id.summaryBtn)

        val pagerAdapter = MyPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        summaryBtn.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            startActivity(intent)
        }

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
                2 -> {
                    tabIcon.setImageResource(R.drawable.stethoscope)
                    tabText.text = "Stethoscope"
                }
                3 -> {
                    tabIcon.setImageResource(R.drawable.ecg)
                    tabText.text = "ECG"
                }
//                4 -> {
//                    tabIcon.setImageResource(R.drawable.pulse_oximeter)
//                    tabText.text = "Pulse Oximeter"
//                }
//                5 -> {
//                    tabIcon.setImageResource(R.drawable.stethoscope)
//                    tabText.text = "Stethoscope"
//                }
//                6 -> {
//                    tabIcon.setImageResource(R.drawable.ecg)
//                    tabText.text = "ECG"
//                }
//                7 -> {
//                    tabIcon.setImageResource(R.drawable.pulse_oximeter)
//                    tabText.text = "Pulse Oximeter"
//                }
//                8 -> {
//                    tabIcon.setImageResource(R.drawable.stethoscope)
//                    tabText.text = "Stethoscope"
//                }
//                9 -> {
//                    tabIcon.setImageResource(R.drawable.ecg)
//                    tabText.text = "ECG"
//                }
            }

            tab.customView = customTabLayout
        }.attach()
    }
}