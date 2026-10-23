package com.example.pengingattugaskuliah.data

import com.example.pengingattugaskuliah.model.MataKuliah
import com.example.pengingattugaskuliah.model.StatusTugas
import com.example.pengingattugaskuliah.model.Tugas

private val pam = MataKuliah("IF25-22017", "Pengembangan Aplikasi Mobile", 3)
private val basisData = MataKuliah("IF25-22010", "Basis Data", 3)
private val drpl = MataKuliah("IF25-22012", "Dasar Rekayasa Perangkat Lunak", 3)

val daftarTugasPalsu = listOf(
    Tugas(1, "Checkpoint model data", pam, "2026-10-27", "Dua data class dan satu sealed class"),
    Tugas(2, "Laporan praktikum", basisData, "2026-10-30", null),
    Tugas(3, "Tiket keluar P2", pam, "2026-10-20", null, StatusTugas.Selesai("2026-10-20 10.15")),
    Tugas(4, "Layar daftar Compose", pam, "2026-10-24", "KartuTugas dan LazyColumn", StatusTugas.Dikerjakan(75)),
    Tugas(5, "ERD dan normalisasi", basisData, "2026-10-25", "Sampai 3NF", StatusTugas.Dikerjakan(50)),
    Tugas(6, "Dokumen SRS", drpl, "2026-10-28", "Use case diagram", StatusTugas.BelumDikerjakan),
    Tugas(7, "Latihan koleksi Kotlin", pam, "2026-10-23", null, StatusTugas.Selesai("2026-10-23 11.00")),
    Tugas(8, "Query SQL join", basisData, "2026-10-29", "Modul 4", StatusTugas.BelumDikerjakan),
    Tugas(9, "Wireframe aplikasi", drpl, "2026-10-31", null, StatusTugas.Dikerjakan(30)),
    Tugas(10, "Persiapan state minggu 4", pam, "2026-11-02", "Baca materi MVVM", StatusTugas.BelumDikerjakan)
)

fun contohTugas(id: Int): Tugas =
    requireNotNull(daftarTugasPalsu.find { it.id == id }) { "Tugas #$id tidak ditemukan" }