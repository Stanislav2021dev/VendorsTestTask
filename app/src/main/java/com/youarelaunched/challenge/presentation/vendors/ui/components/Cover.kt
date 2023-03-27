package com.youarelaunched.challenge.presentation.vendors.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.youarelaunched.challenge.R
import com.youarelaunched.challenge.presentation.resourses.Colors
import com.youarelaunched.challenge.presentation.resourses.Dimens
import com.youarelaunched.challenge.presentation.resourses.VendorsTextStyle
import com.youarelaunched.challenge.presentation.resourses.textStyle
import com.youarelaunched.challenge.presentationmodels.vendors.VendorsPresentationModel

@Composable
fun Cover(vendor: VendorsPresentationModel) {

    var vendorIsFavoriteState by remember { mutableStateOf(vendor.isFavorite) }

    ConstraintLayout {
        val (image, areaServed, favoriteLabel) = createRefs()
        AsyncImage(modifier = Modifier
            .constrainAs(image) {
                top.linkTo(parent.top)
            }
            .clip(RoundedCornerShape(Dimens.cardShapes))
            .height(Dimens.vendorsImageHeight)
            .fillMaxWidth(),
            model = vendor.coverPhotoUrl,
            contentDescription = vendor.companyName,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.gradi_dark)
        )

        Box(modifier = Modifier
            .constrainAs(areaServed) {
                bottom.linkTo(image.bottom, Dimens.spacingSmall)
                start.linkTo(image.start, Dimens.spacingSmall)
            }
            .background(
                color = Colors.backgroundPrimary, shape = RoundedCornerShape(Dimens.textBoxShapes)
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(modifier = Modifier
                .padding(horizontal = Dimens.spacingSmall)
                .padding(vertical = 2.dp),
                text = vendor.areaServed,
                style = textStyle(style = VendorsTextStyle.BodyPrimary)
            )
        }

        Image(
            modifier = Modifier
                .constrainAs(favoriteLabel) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, Dimens.spacingSmall)
                }
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    vendorIsFavoriteState = !vendorIsFavoriteState
                }
                .zIndex(1f),
            painter = painterResource(
                id = if (vendorIsFavoriteState) R.drawable.ic_save_active
                else R.drawable.ic_save_inactive
            ),
            contentDescription = if (vendorIsFavoriteState) stringResource(id = R.string.favorite_icon_active_content_description)
                                 else stringResource(id = R.string.favorite_icon_inactive_content_description)
        )
    }
}

@Composable
@Preview
fun CoverPreview() {
    Cover(
        vendor = VendorsPresentationModel(
            areaServed = "Kyiv",
            categories = emptyList(),
            companyName = "My company",
            coverPhotoUrl = "https://cdn-staging.chatsumer.app/eyJidWNrZXQiOiJjaGF0c3VtZXItZ2VuZXJhbC1zdGFnaW5nLXN0b3JhZ2UiLCJrZXkiOiIxMy84ZjMzZTgyNy0yNzIxLTQ3ZjctYjViNS0zM2Q5Y2E2MTM1OGQuanBlZyJ9",
            isFavorite = false,
            tags = emptyList()
        )
    )
}