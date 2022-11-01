package com.utkuulasaltin.bluevalleyshop.feature.onboarding.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utkuulasaltin.bluevalleyshop.R

class OnBoardingFragment : Fragment() {
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt("position")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(position, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putInt("position", position)
                }
            }
    }
}