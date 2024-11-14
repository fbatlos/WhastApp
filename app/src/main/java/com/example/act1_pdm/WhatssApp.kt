package com.example.act1_pdm

import WhatsAppFooterCustom
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.act1_pdm.chats.chats
import com.example.act1_pdm.chats.intoChat
import com.example.act1_pdm.ui.theme.green
import com.example.act1_pdm.ui.theme.upGreen

@Composable
fun WhatssApp(nombres:List<String> , nombreApp : String ,modifier: Modifier){
    var itemSeleccionado by remember { mutableStateOf("chats") }
    var selectedChat by remember { mutableStateOf<String?>(null) }

    if (selectedChat == null) {
        Column (
            modifier = modifier
                .fillMaxSize()
                .background(color = upGreen)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(green)
                    .padding(top = 20.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Box {
                    Text(text = nombreApp , fontSize = 8.em , color = Color.White)
                }

                Row (
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                ){
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Lupa Icon",
                        modifier = Modifier.size(34.dp),
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Lupa Icon",
                        modifier = Modifier.size(34.dp),
                        tint = Color.White
                    )

                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Points Icon",
                        modifier = Modifier.size(34.dp),
                        tint = Color.White
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize().weight(10f)
            ) {

                    when (itemSeleccionado) {
                        "chats" -> {
                            chats(strings = nombres, modifier = modifier,
                                onChatClick = { selectedChat = it })
                        }

                        "novedades" -> {
                            novedades(strings = listOf("Añadir historia"))
                        }

                        "comunidades" -> {}
                        "llamadas" -> {}

                    }


            }
            Box (
                modifier = Modifier.fillMaxWidth().weight(1f)
            ){
                WhatsAppFooterCustom(onItemSelected = {item ->
                    itemSeleccionado = item
                })
                Log.e("Hola",itemSeleccionado)
            }
        }
    }else{
        intoChat(persona = selectedChat!!, onBack = {selectedChat = null}, modifier = modifier)
    }

}



