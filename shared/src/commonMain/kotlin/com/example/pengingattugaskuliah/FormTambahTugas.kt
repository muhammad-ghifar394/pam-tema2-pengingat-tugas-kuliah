package com.example.pengingattugaskuliah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormTambahTugas(
    judul: String,
    mataKuliah: String,
    tenggat: String,
    pesanError: String?,
    onJudulBerubah: (String) -> Unit,
    onMataKuliahBerubah: (String) -> Unit,
    onTenggatBerubah: (String) -> Unit,
    onSimpan: () -> Unit,
    onBatal: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Tambah Tugas")

        KolomTeks(
            nilai = judul,
            label = "Judul tugas",
            onNilaiBerubah = onJudulBerubah
        )

        KolomTeks(
            nilai = mataKuliah,
            label = "Mata kuliah",
            onNilaiBerubah = onMataKuliahBerubah
        )

        KolomTeks(
            nilai = tenggat,
            label = "Tenggat (YYYY-MM-DD)",
            onNilaiBerubah = onTenggatBerubah
        )

        if (pesanError != null) {
            Text(pesanError)
        }

        Button(
            onClick = onSimpan,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan Tugas")
        }

        OutlinedButton(
            onClick = onBatal,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Batal")
        }
    }
}
