package com.example.internshala.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.internshala.R

// Set of Material typography styles to start with
val nunitoFont = FontFamily(
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_light, FontWeight.Light),
    Font(R.font.nunito_regular,FontWeight.Normal),
    Font(R.font.nunito_medium,FontWeight.Medium)
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp
    ),
    displayMedium = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    ),
    displaySmall = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp

    ),
    titleMedium = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Black,
        fontSize = 26.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    */
)