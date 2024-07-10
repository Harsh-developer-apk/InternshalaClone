package com.example.internshala.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

data class WindowSize(
    val width: WindowType,
    val height: WindowType)

enum class WindowType{
    COMPACT,
    MEDIUM,
    EXPANDED,
}

@Composable
fun rememberWindowSize(): WindowSize {
    val configuration = LocalConfiguration.current
    return WindowSize(
        width = when {
            configuration.screenWidthDp < 600 ->WindowType.COMPACT
            configuration.screenWidthDp < 840 ->WindowType.MEDIUM
            else ->WindowType.EXPANDED
        },
        height = when {
            configuration.screenHeightDp<480 ->WindowType.COMPACT
            configuration.screenHeightDp<900 ->WindowType.MEDIUM
            else ->WindowType.EXPANDED
        }
        )
}