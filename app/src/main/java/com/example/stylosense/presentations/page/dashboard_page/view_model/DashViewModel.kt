package com.example.stylosense.presentations.page.dashboard_page.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylosense.presentations.common.ResourceApp
import com.example.stylosense.presentations.items.GetProductUseCase
import com.example.stylosense.presentations.page.dashboard_page.dashboard_state.TaylorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val productUseCase: GetProductUseCase
) : ViewModel() {
    private val _state = mutableStateOf<TaylorState>(TaylorState())
    val state: State<TaylorState> = _state

    init {
        getProduct()
    }

    private fun getProduct() {
        productUseCase().onEach { result ->
            when (result) {
                is ResourceApp.LoadingApp -> {
                    _state.value = TaylorState(isLoading = true)
                }
                is ResourceApp.SuccessApp -> {
                    _state.value = TaylorState(product = result.data ?: emptyList())
                }
                is ResourceApp.ErrorApp -> {
                    _state.value =
                        TaylorState(errorMessage = result.message ?: "Unexpected error.")
                }
            }
        }.launchIn(viewModelScope)
    }
}