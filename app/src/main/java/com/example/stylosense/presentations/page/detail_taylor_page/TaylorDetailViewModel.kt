package com.example.stylosense.presentations.page.detail_taylor_page

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylosense.presentations.common.Const
import com.example.stylosense.presentations.common.ResourceApp
import com.example.stylosense.presentations.items.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    stateHandle: SavedStateHandle
) : ViewModel() {
    //state
    private val _state = mutableStateOf<TaylorDetailState>(TaylorDetailState())
    val state: State<TaylorDetailState> = _state

    init {

        val productId = stateHandle.get<String>(Const.PRODUCT_ID_PARAM)
        getProductDetail(productId!!.toInt())
    }

    private fun getProductDetail(productId: Int) {
        getProductDetailUseCase(productId).onEach { result ->
            when (result) {
                is ResourceApp.LoadingApp -> {
                    _state.value = TaylorDetailState(isLoading = true)
                }
                is ResourceApp.SuccessApp -> {
                    _state.value = TaylorDetailState(productDetail = result.data)

                }
                is ResourceApp.ErrorApp -> {
                    _state.value = TaylorDetailState(errorMessage = result.message!!)
                }
            }

        }.launchIn(viewModelScope)
    }
}