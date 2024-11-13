package com.example.act1_pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.example.act1_pdm.ui.theme.Act1_PDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Act1_PDMTheme {
                val whatsappName = getString(R.string.whatsap_name)


                val nombres = listOf(
                    getString(R.string.nombre1),
                    getString(R.string.nombre2),
                    getString(R.string.nombre3),
                    getString(R.string.nombre4)
                )


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        WhatssApp(nombres,whatsappName,Modifier.padding(innerPadding))
                }
            }
        }
    }
}