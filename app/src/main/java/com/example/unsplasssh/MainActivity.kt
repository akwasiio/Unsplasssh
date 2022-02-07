package com.example.unsplasssh

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.unsplasssh.ui.screens.ImagesScreen
import com.example.unsplasssh.ui.theme.UnsplassshTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplassshTheme {
                ImagesScreen()
            }
        }
    }
}