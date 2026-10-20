package com.example.pengingattugaskuliah.model

fun StatusTugas.label(): String = when (this) {
    StatusTugas.BelumDikerjakan -> "Belum dikerjakan"
    is StatusTugas.Dikerjakan -> "Dikerjakan $progres%"
    is StatusTugas.Selesai -> "Selesai, dikumpulkan $dikumpulkanPada"
}

fun Tugas.ringkas(): String = "#$id $judul, ${mataKuliah.nama}, tenggat $tenggat"
