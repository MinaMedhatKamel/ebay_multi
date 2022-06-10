package com.ebayk.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

import androidx.compose.ui.unit.sp


@OptIn(ExperimentalTextApi::class)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

@OptIn(ExperimentalTextApi::class)
val fontName = GoogleFont("Roboto")

@OptIn(ExperimentalTextApi::class)
val fontRobotoBold = FontFamily(
    Font(
        googleFont = fontName, fontProvider = provider,
        weight = FontWeight.Bold, style = FontStyle.Normal
    )
)

@OptIn(ExperimentalTextApi::class)
val fontRobotoMeduim = FontFamily(
    Font(
        googleFont = fontName, fontProvider = provider,
        weight = FontWeight.Normal, style = FontStyle.Normal
    )
)


val titleLarge = TextStyle(
    fontFamily = fontRobotoBold,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    color = Color.Black
)
val titleLargeError = TextStyle(
    fontFamily = fontRobotoBold,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    color = Color.Red
)

val bodyMedium = TextStyle(
    fontFamily = fontRobotoMeduim,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
    color = Color.Black
)
val bodyMediumWite12 = TextStyle(
    fontFamily = fontRobotoMeduim,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    color = white
)
val bodyMediumGray14 = TextStyle(
    fontFamily = fontRobotoMeduim,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = gray_600
)
val bodyMediumBlack14 = TextStyle(
    fontFamily = fontRobotoMeduim,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = black
)
val bodyMediumGreen14 = TextStyle(
    fontFamily = fontRobotoMeduim,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = green_500
)
val bodyMediumGreen20 = TextStyle(
    fontFamily = fontRobotoMeduim,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
    color = green_500
)

val labelSmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp,
    color = Color.Black
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = titleLarge,
    h2 = bodyMedium,
    h3 = labelSmall
)