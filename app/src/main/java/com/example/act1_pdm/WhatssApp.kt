package com.example.act1_pdm

import android.graphics.ColorSpace
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.act1_pdm.ui.theme.green
import com.example.act1_pdm.ui.theme.upGreen

@Composable
fun WhatssApp(nombres:List<String> , nombreApp : String ,modifier: Modifier){

    Column (
        modifier = modifier.fillMaxSize()
            .background(color = green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(upGreen)
                .padding(top = 20.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Box (
                contentAlignment = Alignment.Center,
            ){
                Text(text = nombreApp , fontSize = 8.em)
            }

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
            ){
                Image(
                    painter = painterResource(R.drawable.pngcamara),
                    contentDescription = "Camera Icon",
                    modifier = Modifier.size(34.dp)
                )

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Lupa Icon",
                    modifier = Modifier.size(34.dp)
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Points Icon",
                    modifier = Modifier.size(34.dp)
                )
            }
        }

        StringList(strings = nombres)



    }

}

@Composable
fun StringList(strings: List<String>) {
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(strings) { string ->
            Row(

            ){
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.fillMaxWidth().border(1.dp, upGreen, CircleShape)
                ){
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Points Icon",
                        modifier = Modifier.size(60.dp)
                    )

                    Text(text = string, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center , fontSize = 4.em)
                }
            }
        }
    }
}

