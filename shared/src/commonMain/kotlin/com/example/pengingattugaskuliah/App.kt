
package com.example.pengingattugaskuliah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.pengingattugaskuliah.data.daftarTugasPalsu

@Composable
@Preview
fun App() {
    MaterialTheme {
        var tampilkanTentang by remember {
            mutableStateOf(false)
        }

        val daftarTugas = remember {
            olahDaftarTugas(daftarTugasPalsu)
        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { }
                ) {
                    Text("+")
                }
            }
        ) { innerPadding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "PENGINGAT TUGAS KULIAH",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Text("Aplikasi untuk mencatat tugas kuliah")

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                tampilkanTentang = !tampilkanTentang
                            }
                        ) {
                            Text("Tentang Aplikasi")
                        }

                        if (tampilkanTentang) {
                            Text("Tema: Pengingat Tugas Kuliah")
                            Text("Platform: ${getPlatform().name}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Anggota Kelompok:")
                            Text("1. Adhitya Warman - 124140007")
                            Text("2. Muhammad Ghifar - 124140091")
                            Text("3. Roy Kurniawan - 124140024")
                            Text("4. Reza Lesmana Julgi - 124140115")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Daftar Tugas",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text("${daftarTugas.size} tugas terdaftar")
                }

                items(
                    items = daftarTugas,
                    key = { tugas -> tugas.id }
                ) { tugas ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = tugas.judul,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Text("Mata kuliah: ${tugas.mataKuliah.nama}")
                            Text("Tenggat: ${tugas.tenggat}")
                            Text("Status: ${tugas.status.label()}")

                            if (tugas.catatan != null) {
                                Text("Catatan: ${tugas.catatan}")
                            }
                        }
                    }
                }
            }
        }
    }
}
