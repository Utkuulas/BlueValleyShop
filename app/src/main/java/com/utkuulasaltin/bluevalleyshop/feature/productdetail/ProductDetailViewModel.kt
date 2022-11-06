package com.utkuulasaltin.bluevalleyshop.feature.productdetail

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.utkuulasaltin.bluevalleyshop.data.local.DataStoreManager
import com.utkuulasaltin.bluevalleyshop.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    // TODO: Implement the ViewModel
}

sealed class ProductDetailViewEvent {

}

sealed class ProductDetailViewState {

}