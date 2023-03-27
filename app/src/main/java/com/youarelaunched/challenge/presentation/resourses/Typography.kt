package com.youarelaunched.challenge.presentation.resourses

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.youarelaunched.challenge.R

private val openSansFontFamily = FontFamily(
    Font(R.font.open_sans_regular, FontWeight.Normal)
)

enum class VendorsTextStyle { HeadLine, BodyPrimary, BodySecondary }

@Composable
@ReadOnlyComposable
fun textStyle(style: VendorsTextStyle): TextStyle =
    when (style) {
        VendorsTextStyle.HeadLine -> {
            TextStyle(
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight(700),
                color = Colors.greyPrimary,
                fontSize = 16.sp,
            )
        }
        VendorsTextStyle.BodyPrimary -> {
            TextStyle(
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight(400),
                color = Colors.greyPrimary,
                fontSize = 14.sp
            )
        }

        VendorsTextStyle.BodySecondary -> {
            TextStyle(
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight(400),
                color = Colors.greySecondary,
                fontSize = 14.sp
            )
        }
    }