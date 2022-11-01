package com.utkuulasaltin.bluevalleyshop.feature.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.utkuulasaltin.bluevalleyshop.R
import com.utkuulasaltin.bluevalleyshop.databinding.ActivityOnboardingBinding
import com.utkuulasaltin.bluevalleyshop.databinding.FragmentOnBoardingBinding
import com.utkuulasaltin.bluevalleyshop.feature.onboarding.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = OnBoardingAdapter(this, prepareOnBoardingItems())

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {

        })
    }

    private fun prepareOnBoardingItems(): List<Int> {
        return listOf(
            R.layout.item_onboarding,
            R.layout.item_onboarding_two,
            R.layout.item_onboarding_three)
    }
}