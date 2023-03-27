package com.youarelaunched.challenge.presentation.vendors.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.youarelaunched.challenge.presentation.resourses.Dimens
import com.youarelaunched.challenge.presentation.resourses.VendorsTextStyle
import com.youarelaunched.challenge.presentation.resourses.textStyle
import com.youarelaunched.challenge.presentationmodels.vendors.VendorsPresentationModel

@Composable
fun VendorsItem(vendor: VendorsPresentationModel) {
    Column {
        Cover(vendor = vendor)
        Text(
            modifier = Modifier.padding(top = Dimens.spacingSmall),
            text = vendor.companyName,
            style = textStyle(style = VendorsTextStyle.HeadLine)
        )
        Category(categories = vendor.categories)
        Tags(tags = vendor.tags)
    }
}