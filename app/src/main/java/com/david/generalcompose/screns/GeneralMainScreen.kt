package com.david.generalcompose.screns

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.generalcompose.navigation.ROUTES

data class ComposeElements(
    val title: String,
    val route: ROUTES,
)

@Composable
fun GeneralMainScreen(onSelectItem: (route: ROUTES) -> Unit) {
    val elements = listOf(
        ComposeElements("DataPicker", ROUTES.DATE_PICKER),
        ComposeElements("TimePicker", ROUTES.TIME_PICKER),
        ComposeElements("Connectivity Status", ROUTES.CONNECTIVITY_STATUS),
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Compose General",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(elements) { element ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .clickable { onSelectItem(element.route) },
                ) {
                    Text(text = element.title, modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }
        }
    }
}
