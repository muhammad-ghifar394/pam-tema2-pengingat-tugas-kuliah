
package com.example.pengingattugaskuliah

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TombolTambahTugas(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Text("+")
    }
}
