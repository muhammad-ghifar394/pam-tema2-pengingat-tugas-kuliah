
package com.example.pengingattugaskuliah

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pengingattugaskuliah.model.StatusTugas
import com.example.pengingattugaskuliah.model.Tugas
import com.example.pengingattugaskuliah.model.label

@Composable
fun CardTugas(tugas: Tugas) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = tugas.judul,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Mata kuliah: ${tugas.mataKuliah.nama}"
            )

            Text(
                text = "Tenggat: ${tugas.tenggat}"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Status: ${tugas.status.label()}"
            )

            if (tugas.catatan != null) {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Catatan: ${tugas.catatan}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
