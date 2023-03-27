package com.youarelaunched.challenge.presentation.vendors.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youarelaunched.challenge.presentation.resourses.Dimens
import com.youarelaunched.challenge.presentation.resourses.VendorsTextStyle
import com.youarelaunched.challenge.presentation.resourses.textStyle
import com.youarelaunched.challenge.presentation.vendors.ui.utils.VendorsUiUtils.downloadSvgIcon
import com.youarelaunched.challenge.presentationmodels.vendors.NetworkCategories

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Category(categories: List<NetworkCategories>) {
    FlowRow(modifier = Modifier.fillMaxWidth()) {
        categories.forEach { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: NetworkCategories) {
    Row(modifier = Modifier.padding(top = Dimens.spacingSmall),
        horizontalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.size(Dimens.defaultIconSize),
            painter = downloadSvgIcon(category.imageUrl),
            contentDescription = category.name,
        )

        Text(
            modifier = Modifier
                .padding(
                    start = Dimens.spacingMini,
                    end = Dimens.spacingMedium,
                    top = 2.dp
                ),
            text = category.name,
            style = textStyle(style = VendorsTextStyle.BodyPrimary)
        )
    }
}

@Composable
@Preview
fun CategoryPreview() {
    Category(categories = listOf(
        NetworkCategories(
            imageUrl = "https://media-staging.chatsumer.app/48/1830f855-6315-4d3c-a5dc-088ea826aef2.svg",
            name = "Home"
        )
    ))
}