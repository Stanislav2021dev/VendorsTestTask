package com.youarelaunched.challenge.presentation.vendors.ui.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.youarelaunched.challenge.R
import com.youarelaunched.challenge.presentation.resourses.Dimens
import com.youarelaunched.challenge.presentation.resourses.VendorsTextStyle
import com.youarelaunched.challenge.presentation.resourses.textStyle

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Tags(tags: List<String>) {
    FlowRow(modifier = Modifier.fillMaxWidth().padding(top = Dimens.spacingSmall)) {
        tags.forEach { tag ->
            TagItem(tag = tag)
        }
    }
}

@Composable
fun TagItem(tag: String) {
    Text(
        modifier = Modifier.padding(start = Dimens.spacingMini),
        text = stringResource(id = R.string.vendor_tag).format(tag),
        style = textStyle(style = VendorsTextStyle.BodySecondary)
    )
}