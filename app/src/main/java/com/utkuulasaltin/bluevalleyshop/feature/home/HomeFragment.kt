package com.utkuulasaltin.bluevalleyshop.feature.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.google.android.material.snackbar.Snackbar
import com.utkuulasaltin.bluevalleyshop.R
import com.utkuulasaltin.bluevalleyshop.databinding.FragmentHomeBinding
import com.utkuulasaltin.bluevalleyshop.feature.home.adapter.HomeProductAdapter
import com.utkuulasaltin.bluevalleyshop.feature.home.adapter.OnProductClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), OnProductClickListener {
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            launch {
                viewModel.uiState.collect {
                    when (it) {
                        is HomeViewState.Success -> {
                            binding.rvProductsList.adapter =
                                HomeProductAdapter(this@HomeFragment).apply {
                                    submitList(it.products)
                                }
                        }

                        is HomeViewState.Loading -> {

                        }
                    }
                }
            }

            launch {
                viewModel.uiEvent.collect {
                    when (it) {
                        is HomeViewEvent.ShowError -> {
                            Snackbar.make(
                                binding.root,
                                it.message.toString(),
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
    override fun onProductClick(id: Int?) {
        viewModel.onProductDetail(id)
    }
}
