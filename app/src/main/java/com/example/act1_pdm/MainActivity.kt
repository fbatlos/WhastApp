package com.example.act1_pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.act1_pdm.Navegation.AppNavegation
import com.example.act1_pdm.chats.Contacto
import com.example.act1_pdm.ui.theme.Act1_PDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Act1_PDMTheme {
                val whatsappName = getString(R.string.whatsap_name)
                val contactos = resources.getStringArray(R.array.nombres).toList()
                val mensajes = resources.getStringArray(R.array.mensaje).toList()
                val imagenes = listOf (R.drawable.imagen1,R.drawable.imagen2,R.drawable.imagen3,R.drawable.imagen4)


                val listaContactos = contactos.indices.map { index ->
                    Contacto(
                        nombre = contactos[index],
                        mensaje = mensajes[index].split(","),
                        imagenId = if(index<=3){ imagenes[index]}else{imagenes[3]}
                    )
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    AppNavegation(modifier = Modifier.padding(innerPadding),listaContactos, whatsappName)

                }
            }
        }
    }
}
