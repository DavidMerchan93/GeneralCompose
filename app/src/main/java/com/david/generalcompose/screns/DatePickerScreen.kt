package com.david.generalcompose.screns

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
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
fun DatePickerScreen() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val selectedDateText = remember { mutableStateOf("") }

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val day = calendar[Calendar.DAY_OF_MONTH]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Fecha seleccionada")
        Text(
            text = if (selectedDateText.value.isEmpty()) {
                "No Seleccionada"
            } else {
                selectedDateText.value
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Button(
            onClick = {
                val datePicker = DatePickerDialog(
                    context,
                    { _: DatePicker, year: Int, month: Int, day: Int ->
                        selectedDateText.value = "$day/${month + 1}/$year"
                    },
                    year,
                    month,
                    day,
                )
                datePicker.datePicker.minDate = calendar.timeInMillis
                datePicker.show()
            },
        ) {
            Text(
                text = "Show Date picker",
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
            )
        }
    }
}
