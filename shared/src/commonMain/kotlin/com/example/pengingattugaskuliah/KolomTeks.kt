package com.example.pengingattugaskuliah

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun KolomTeks(
    nilai: String,
    label: String,
    onNilaiBerubah: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = nilai,
        onValueChange = onNilaiBerubah,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(),
        singleLine = true
    )
}
