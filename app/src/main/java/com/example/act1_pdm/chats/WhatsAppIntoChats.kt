package com.example.act1_pdm.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.act1_pdm.R
import com.example.act1_pdm.ui.theme.negroWhats



@Composable
fun intoChat(persona: String?, onBack: () -> Unit, modifier: Modifier) {
    var textoantes by remember { mutableStateOf("") }
    val mensajes = remember { mutableStateListOf<String>() }
    Image(
        painter = painterResource(id = R.drawable.whatsappfondo),
        contentDescription = "Fondo de pantalla",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(negroWhats)
                .padding(top = 20.dp, bottom = 10.dp)
                ,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row (modifier = Modifier.weight(3f)
            ){
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
                    modifier = Modifier
                        .size(34.dp),
                    tint = Color.White
                )

                Text(text = persona?:"", fontSize = 6.em, color = Color.White )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.weight(2f)
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
            modifier = Modifier.weight(6f)

        ) {
            //Contenido del chat

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())  // Desplazamiento de los mensajes
                    .padding(16.dp)
            ) {
                // Mostrar los mensajes
                mensajes.forEach { mensaje ->
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = mensaje,
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                                .background(negroWhats, shape = RoundedCornerShape(8.dp))
                                .padding(12.dp)
                        )
                    }
                }
            }
        }



        Box( // Caja de entrada de texto
            modifier = Modifier
                .height(80.dp)
                .background(Color.White)
                .imePadding()
                ,

            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                // Campo de entrada de texto
                TextField(
                    modifier = Modifier
                        .padding(end = 8.dp), // Agregar un poco de padding
                    value = textoantes,
                    onValueChange = { textoantes = it },
                    placeholder = { Text("Escribe un mensaje...") },
                )

                IconButton(
                    onClick = {
                        if (textoantes.isNotEmpty()) {
                            mensajes.add(textoantes)  // Agregar el mensaje a la lista
                            textoantes = ""  // Limpiar el campo de texto
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Enviar",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}