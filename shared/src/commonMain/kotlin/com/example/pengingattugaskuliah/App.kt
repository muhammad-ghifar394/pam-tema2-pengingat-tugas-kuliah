
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val tugasViewModel: TugasViewModel = viewModel()
        val state by tugasViewModel.uiState.collectAsState()

        var tampilkanTentang by remember {
            mutableStateOf(false)
        }

        Scaffold(
            floatingActionButton = {
                TombolTambahTugas(
                    onClick = { tugasViewModel.bukaForm() }
                )
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

                    Text("${state.daftarTugas.size} tugas terdaftar")
                }

                if (state.tampilkanForm) {
                    item {
                        FormTambahTugas(
                            judul = state.judul,
                            mataKuliah = state.mataKuliah,
                            tenggat = state.tenggat,
                            pesanError = state.pesanError,
                            onJudulBerubah = tugasViewModel::ubahJudul,
                            onMataKuliahBerubah =
                                tugasViewModel::ubahMataKuliah,
                            onTenggatBerubah = tugasViewModel::ubahTenggat,
                            onSimpan = tugasViewModel::simpanTugas,
                            onBatal = tugasViewModel::tutupForm
                        )
                    }
                }

                items(
                    items = olahDaftarTugas(state.daftarTugas),
                    key = { tugas -> tugas.id }
                ) { tugas ->
                    CardTugas(tugas = tugas)
                }
            }
        }
    }
}
