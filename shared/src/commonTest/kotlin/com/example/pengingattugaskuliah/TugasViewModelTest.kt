package com.example.pengingattugaskuliah

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TugasViewModelTest {

    @Test
    fun formDapatDibukaDanDitutup() {
        val viewModel = TugasViewModel()

        viewModel.bukaForm()
        assertTrue(viewModel.uiState.value.tampilkanForm)

        viewModel.tutupForm()
        assertFalse(viewModel.uiState.value.tampilkanForm)
    }

    @Test
    fun judulKosongMenampilkanError() {
        val viewModel = TugasViewModel()

        viewModel.bukaForm()
        viewModel.ubahJudul("")
        viewModel.ubahMataKuliah("Basis Data")
        viewModel.ubahTenggat("2026-11-05")
        viewModel.simpanTugas()

        assertNotNull(viewModel.uiState.value.pesanError)
    }

    @Test
    fun mataKuliahKosongMenampilkanError() {
        val viewModel = TugasViewModel()

        viewModel.bukaForm()
        viewModel.ubahJudul("Laporan Praktikum")
        viewModel.ubahMataKuliah("")
        viewModel.ubahTenggat("2026-11-05")
        viewModel.simpanTugas()

        assertNotNull(viewModel.uiState.value.pesanError)
    }

    @Test
    fun formatTenggatSalahMenampilkanError() {
        val viewModel = TugasViewModel()

        viewModel.bukaForm()
        viewModel.ubahJudul("Laporan Praktikum")
        viewModel.ubahMataKuliah("Basis Data")
        viewModel.ubahTenggat("05-11-2026")
        viewModel.simpanTugas()

        assertEquals("Tenggat harus berformat YYYY-MM-DD.", viewModel.uiState.value.pesanError)
    }

    @Test
    fun tugasBaruBerhasilDitambahkanDanFormDireset() {
        val viewModel = TugasViewModel()
        val jumlahAwal = viewModel.uiState.value.daftarTugas.size

        viewModel.bukaForm()
        viewModel.ubahJudul("Tugas Pengujian MVVM")
        viewModel.ubahMataKuliah("Pengembangan Aplikasi Mobile")
        viewModel.ubahTenggat("2026-11-05")
        viewModel.simpanTugas()

        val state = viewModel.uiState.value
        assertEquals(jumlahAwal + 1, state.daftarTugas.size)
        assertTrue(state.daftarTugas.any { it.judul == "Tugas Pengujian MVVM" })
        assertEquals("", state.judul)
        assertEquals("", state.mataKuliah)
        assertEquals("", state.tenggat)
        assertNull(state.pesanError)
        assertFalse(state.tampilkanForm)
    }
}