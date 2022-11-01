package com.utkuulasaltin.bluevalleyshop.feature.onboarding.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.utkuulasaltin.bluevalleyshop.feature.onboarding.fragment.OnBoardingFragment

class OnBoardingAdapter(
    fragmentActivity: FragmentActivity,
    private val layouts: List<Int>
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return layouts.size
    }

    override fun createFragment(position: Int): Fragment {
        return OnBoardingFragment.newInstance(layouts[position])
    }
}