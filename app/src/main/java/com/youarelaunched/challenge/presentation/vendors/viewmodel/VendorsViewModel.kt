package com.youarelaunched.challenge.presentation.vendors.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youarelaunched.challenge.network.api.NetworkDataProvider
import com.youarelaunched.challenge.presentationmodels.vendors.VendorsPresentationModel
import com.youarelaunched.challenge.presentationmodels.vendors.mapNetworkVendorToNetworkVendorPresentationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class VendorsViewModel (val networkDataProvider: NetworkDataProvider): ViewModel() {

    private val _vendorsFlow: MutableStateFlow<List<VendorsPresentationModel>> = MutableStateFlow(emptyList())
    val vendorsFlow: Flow<List<VendorsPresentationModel>> = _vendorsFlow

    init {
        viewModelScope.launch {
            _vendorsFlow.emit(
                mapNetworkVendorToNetworkVendorPresentationModel(
                    networkDataProvider.getVendors()
                )
            )
        }
    }
}