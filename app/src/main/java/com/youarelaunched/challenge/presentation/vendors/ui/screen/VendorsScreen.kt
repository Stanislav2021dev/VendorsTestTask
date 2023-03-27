package com.youarelaunched.challenge.presentation.vendors.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.youarelaunched.challenge.presentation.resourses.Dimens
import com.youarelaunched.challenge.presentation.vendors.ui.components.VendorsItem
import com.youarelaunched.challenge.presentation.vendors.viewmodel.VendorsViewModel
import com.youarelaunched.challenge.presentationmodels.vendors.VendorsPresentationModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun VendorsScreen() {
    val viewModel: VendorsViewModel = koinViewModel()
    val vendors by viewModel.vendorsFlow.collectAsState(initial = emptyList())
    VendorsScreenContent(vendors = vendors)

}
@Composable
fun VendorsScreenContent(vendors: List<VendorsPresentationModel>) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = Dimens.spacingVertical,
            horizontal = Dimens.spacingSides
        ),
        verticalArrangement = Arrangement.spacedBy(Dimens.spacingVertical),
    ) {
        items(vendors) { vendor ->
            VendorsItem(vendor)
        }
    }
}