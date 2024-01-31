package com.techbros.medwand

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        // Replace with your fragment creation logic
        return when (position) {
            0 -> ThermometerFragment()
            1 -> PulseOximeterFragment()
            2 -> StethoscopeFragment()
            3 -> EcgFragment()
            4 -> BpFragment()
//            5 -> StethoscopeFragment()
//            6 -> EcgFragment()
//            7 -> PulseOximeterFragment()
//            8 -> StethoscopeFragment()
//            9 -> EcgFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}