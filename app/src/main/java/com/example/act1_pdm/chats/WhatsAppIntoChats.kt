package com.example.act1_pdm.chats

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.act1_pdm.R
import com.example.act1_pdm.novedades
import com.example.act1_pdm.ui.theme.green
import com.example.act1_pdm.ui.theme.upGreen


@Composable
fun intoChat(persona: String, onBack: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = upGreen),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(green)
                .padding(top = 20.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Icono de volver",
                    modifier = Modifier
                        .size(34.dp)
                        .clickable { onBack() }, // Llamar a onBack para volver, Vip es necesario centar todo
                    tint = Color.White
                )

                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Imagen de usuario",
                    modifier = Modifier.size(34.dp),
                    tint = Color.White
                )

                Text(text = persona, fontSize = 8.em, color = Color.White)
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Icono de llamada",
                    modifier = Modifier.size(34.dp),
                    tint = Color.White
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Icono de opciones",
                    modifier = Modifier.size(34.dp),
                    tint = Color.White
                )
            }
        }
        Box( // Aquí iría el chat como tal
            modifier = Modifier
                .fillMaxSize()
                .weight(10f)
        ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsappfondo),
                    contentDescription = "Fondo de pantalla",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            //Contenido del chat


        }
        Box( // Caja de entrada de texto
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Campo de entrada de texto
        }
    }
}