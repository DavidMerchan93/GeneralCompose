package com.david.generalcompose.screns

import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimePickerScreen() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val selectedTimeText = remember { mutableStateOf("") }

    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Hora seleccionada")
        Text(
            text = if (selectedTimeText.value.isEmpty()) {
                "No Seleccionada"
            } else {
                selectedTimeText.value
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Button(
            onClick = {
                val timePicker = TimePickerDialog(
                    context,
                    { _, hour: Int, minute: Int ->
                        selectedTimeText.value = "$hour:$minute"
                    },
                    hour,
                    minute,
                    false,
                )
                timePicker.show()
            },
        ) {
            Text(
                text = "Show Time picker",
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
            )
        }
    }
}
