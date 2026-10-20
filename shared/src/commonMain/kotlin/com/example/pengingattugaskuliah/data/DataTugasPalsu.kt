package com.example.pengingattugaskuliah.data

import com.example.pengingattugaskuliah.model.MataKuliah
import com.example.pengingattugaskuliah.model.StatusTugas
import com.example.pengingattugaskuliah.model.Tugas

private val pam = MataKuliah("IF25-22017", "Pengembangan Aplikasi Mobile", 3)
private val basisData = MataKuliah("IF25-22010", "Basis Data", 3)

val daftarTugasPalsu = listOf(
    Tugas(1, "Checkpoint model data", pam, "2026-10-27", "Dua data class dan satu sealed class"),
    Tugas(2, "Laporan praktikum", basisData, "2026-10-30", null),
    Tugas(3, "Tiket keluar P2", pam, "2026-10-20", null, StatusTugas.Selesai("2026-10-20 10.15"))
)

fun contohTugas(id: Int): Tugas =
    requireNotNull(daftarTugasPalsu.find { it.id == id }) { "Tugas #$id tidak ditemukan" }