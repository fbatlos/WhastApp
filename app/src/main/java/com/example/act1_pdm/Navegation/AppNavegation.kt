package com.example.act1_pdm.Navegation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.act1_pdm.WhatssApp
import com.example.act1_pdm.chats.intoChat

@Composable
fun AppNavegation(modifier: Modifier , contactos:List<String> ,whatsappName:String ){
    val navContralador = rememberNavController()

    NavHost(
        navController = navContralador,
        startDestination = AppScreen.whatsApp.router
    ){
        composable(AppScreen.whatsApp.router){
            WhatssApp(contactos,whatsappName,modifier,navContralador)
        }

        composable(AppScreen.intoChat.router + "/{text}" , arguments = listOf(navArgument(name = "text"){
            type = NavType.StringType
        })){
            intoChat(persona = it?.arguments?.getString("text") , onBack = {navContralador.popBackStack()} , modifier)
        }
    }
}