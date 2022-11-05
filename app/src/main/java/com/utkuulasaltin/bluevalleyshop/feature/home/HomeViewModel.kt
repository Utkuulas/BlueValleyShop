package com.utkuulasaltin.bluevalleyshop.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.utkuulasaltin.bluevalleyshop.data.model.ProductDTO
import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponse
import com.utkuulasaltin.bluevalleyshop.data.model.ProductResponseItem
import com.utkuulasaltin.bluevalleyshop.data.remote.utils.DataState
import com.utkuulasaltin.bluevalleyshop.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) :
    ViewModel() {
    private val _uiState = MutableStateFlow<HomeViewState>(HomeViewState.Success(mutableListOf()))
    val uiState: StateFlow<HomeViewState> = _uiState


    private val _uiEvent = MutableSharedFlow<HomeViewEvent>(replay = 0)
    val uiEvent: SharedFlow<HomeViewEvent> = _uiEvent

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            productsRepository.getProducts().collect() {
                when (it) {
                    is DataState.Success -> {
                        _uiState.value = HomeViewState.Success(it.data.map {
                            ProductDTO(
                                id = it.id,
                                title = it.title,
                                image = it.image,
                                price = it.price
                            )
                        }.toMutableList())
                    }

                    is DataState.Error -> {
                        _uiEvent.emit(HomeViewEvent.ShowError(it.error?.status_message))
                    }

                    is DataState.Loading -> {
                        _uiState.value = HomeViewState.Loading
                    }
                }
            }
        }
    }

    fun onProductDetail(id: Int?) {
        viewModelScope.launch {
            launch {

            }
        }
    }

}

sealed class HomeViewEvent {
    data class ShowError(val message: String?) : HomeViewEvent()
}

sealed class HomeViewState {
    class Success(val products: MutableList<ProductDTO>) : HomeViewState()
    object Loading : HomeViewState()
}