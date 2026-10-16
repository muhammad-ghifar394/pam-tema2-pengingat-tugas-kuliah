
package com.example.pengingattugaskuliah

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var tampilkanTentang by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("PENGINGAT TUGAS KULIAH")

            Text("Aplikasi untuk mencatat tugas kuliah")

            Button(
                onClick = {
                    tampilkanTentang = !tampilkanTentang
                }
            ) {
                Text("Tentang Aplikasi")
            }

            if (tampilkanTentang) {
                Text("Tema: Pengingat Tugas Kuliah")
                Text("Platform: Android")

                Text("Anggota Kelompok:")

                Text("1. Adhitya Warman - 124140007")
                Text("2. Muhammad Ghifar - 124140091")
                Text("3. Roy Kurniawan - 124140024")
                Text("4. [Nama Teman 3] - [NIM Teman 3]")
            }
        }
    }
}
