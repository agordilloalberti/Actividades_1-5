package com.example.actividades_1_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.actividades_1_5.screens.Actividad5
import com.example.actividades_1_5.ui.theme.Actividades_15Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividades_15Theme {
                Actividad5()
            }
        }
    }
}