package com.example.act1_pdm.chats

import kotlinx.serialization.Serializable

@Serializable
data class Contacto(val nombre:String, val mensaje:List<String>, val imagenId: Int)
