import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.act1_pdm.R
import com.example.act1_pdm.ui.theme.green
import com.example.act1_pdm.ui.theme.upGreen

@Composable
fun WhatsAppFooterCustom(
    modifier: Modifier = Modifier,
    onItemSelected: (String) -> Unit = {}
) {
    var itemSeleccionado by remember { mutableStateOf("chats") }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(green)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FoterItem(
            iconRes = R.drawable.ic_chat,
            label = "Chats",
            Seleccionado = itemSeleccionado == "chats",
            onClick = {
                itemSeleccionado = "chats"
                onItemSelected("chats")
            }
        )

        FoterItem(
            iconRes = R.drawable.ic_status,
            label = "Novedades",
            Seleccionado = itemSeleccionado == "novedades",
            onClick = {
                itemSeleccionado = "novedades"
                onItemSelected("novedades")
            }
        )

        FoterItem(
            iconRes = R.drawable.ic_communities,
            label = "Comunidades",
            Seleccionado = itemSeleccionado == "comunidades",
            onClick = {
                itemSeleccionado = "comunidades"
                onItemSelected("comunidades")
            }
        )

        FoterItem(
            iconRes = R.drawable.ic_calls,
            label = "Llamadas",
            Seleccionado = itemSeleccionado == "llamadas",
            onClick = {
                itemSeleccionado = "llamadas"
                onItemSelected("llamadas")
            }
        )
    }
}

@Composable
fun FoterItem(
    iconRes: Int,
    label: String,
    Seleccionado: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            tint = if (Seleccionado) Color.White else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            fontSize = 10.sp,
            color = if (Seleccionado) Color.White else Color.Gray
        )
    }
}
