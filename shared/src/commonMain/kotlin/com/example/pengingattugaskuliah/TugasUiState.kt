package com.example.pengingattugaskuliah

import com.example.pengingattugaskuliah.data.daftarTugasPalsu
import com.example.pengingattugaskuliah.model.Tugas

data class TugasUiState(
    val daftarTugas: List<Tugas> = daftarTugasPalsu,
    val judul: String = "",
    val mataKuliah: String = "",
    val tenggat: String = "",
    val pesanError: String? = null,
    val tampilkanForm: Boolean = false,
    val bisaSimpan: Boolean = false
)