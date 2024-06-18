package com.example.stylosense.presentations.page.dashboard_page.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylosense.presentations.common.Resource
import com.example.stylosense.presentations.items.GetProductUseCase
import com.example.stylosense.presentations.page.dashboard_page.dashboard_state.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val productUseCase: GetProductUseCase
) : ViewModel() {
    private val _state = mutableStateOf<ProductState>(ProductState())
    val state: State<ProductState> = _state

    init {
        getProduct()
    }

    private fun getProduct() {
        productUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ProductState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductState(product = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        ProductState(errorMessage = result.message ?: "Unexpected error.")
                }
            }
        }.launchIn(viewModelScope)
    }
}