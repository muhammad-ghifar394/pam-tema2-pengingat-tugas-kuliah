
package com.example.pengingattugaskuliah

import com.example.pengingattugaskuliah.model.Tugas

fun olahDaftarTugas(
    daftar: List<Tugas>
): List<Tugas> {
    return daftar.sortedBy { tugas ->
        tugas.tenggat
    }
}