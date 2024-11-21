package com.example.act1_pdm.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em


@Composable
fun chats(strings: List<Contacto>, onChatClick: (Contacto) -> Unit, modifier: Modifier) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()

    ){
        items(strings) { string ->
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ){
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onChatClick(string)
                        }//Tengo que meterme en un chat.
                ){
                    Image(
                        painter = painterResource(string.imagenId),
                        contentDescription = "Imagen de usuario",
                        modifier = Modifier
                            .size(54.dp)
                            .clip(shape= CircleShape)
                            .background(Color.White)

                    )


                    Text(text = string.nombre, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center , fontSize = 4.em , color = Color.White)
                }
            }
        }
    }
}