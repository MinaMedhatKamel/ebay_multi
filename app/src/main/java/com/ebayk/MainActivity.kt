package com.ebayk


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ebayk.ads.ui.AdsScreen
import dagger.hilt.android.AndroidEntryPoint
/*
Entry point for the app
the main activity for displaying the content
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdsScreen()
        }
    }
}
