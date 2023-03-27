package com.youarelaunched.challenge.presentation.vendors.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest

object VendorsUiUtils {
    @Composable
    fun downloadSvgIcon(iconUrl: String): AsyncImagePainter =
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(iconUrl)
                .decoderFactory(SvgDecoder.Factory())
                .build()
        )
}