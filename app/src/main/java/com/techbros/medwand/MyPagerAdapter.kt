package com.techbros.medwand

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        // Replace with your fragment creation logic
        return when (position) {
            0 -> ThermometerFragment()
            1 -> PulseOximeterFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}