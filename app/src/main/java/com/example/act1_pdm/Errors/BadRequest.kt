package com.example.act1_pdm.Errors

class BadRequest (message: String)
    : Exception("Error el dato no es valido. $message")