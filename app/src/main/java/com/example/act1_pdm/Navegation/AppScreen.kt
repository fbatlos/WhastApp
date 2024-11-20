package com.example.act1_pdm.Navegation

sealed class AppScreen (val router:String){

    object intoChat:AppScreen("intoChat")

    object whatsApp:AppScreen("whatsApp")

}