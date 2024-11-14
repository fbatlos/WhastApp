package com.example.act1_pdm.novedades

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.act1_pdm.ui.theme.negroWhats


@Composable
fun novedades(strings: List<String>) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()

    ){

        items(strings) { string ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, negroWhats, CircleShape)
            ){
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Points Icon",
                    modifier = Modifier.size(60.dp)
                )

                Text(text = string, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center , fontSize = 4.em , color = Color.White)
            }
        }

    }
}