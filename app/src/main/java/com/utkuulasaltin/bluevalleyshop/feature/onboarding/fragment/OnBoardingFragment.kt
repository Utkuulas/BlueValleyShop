package com.utkuulasaltin.bluevalleyshop.feature.onboarding.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.utkuulasaltin.bluevalleyshop.databinding.FragmentOnBoardingBinding
import com.utkuulasaltin.bluevalleyshop.feature.onboarding.OnBoardingViewModel

class OnBoardingFragment : Fragment() {
    private var layout: Int = 0
    private lateinit var binding: FragmentOnBoardingBinding
    private val viewModel by viewModels<OnBoardingViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layout = it.getInt("position")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(layout: Int) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putInt("layout", layout)
                }
            }
    }
}