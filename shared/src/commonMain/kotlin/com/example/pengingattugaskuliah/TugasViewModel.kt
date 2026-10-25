package com.example.pengingattugaskuliah

import androidx.lifecycle.ViewModel
import com.example.pengingattugaskuliah.model.MataKuliah
import com.example.pengingattugaskuliah.model.StatusTugas
import com.example.pengingattugaskuliah.model.Tugas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TugasViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TugasUiState())

    val uiState: StateFlow<TugasUiState> =
        _uiState.asStateFlow()

    private fun cekBisaSimpan(judul: String, mataKuliah: String, tenggat: String): Boolean {
        return judul.isNotBlank() && mataKuliah.isNotBlank() && validasiTanggal(tenggat)
    }

    fun bukaForm() {
        val state = _uiState.value
        _uiState.value = state.copy(
            tampilkanForm = true,
            pesanError = null,
            bisaSimpan = cekBisaSimpan(state.judul, state.mataKuliah, state.tenggat)
        )
    }

    fun tutupForm() {
        _uiState.value = _uiState.value.copy(
            tampilkanForm = false,
            pesanError = null
        )
    }

    fun ubahJudul(nilai: String) {
        val state = _uiState.value
        _uiState.value = state.copy(
            judul = nilai,
            pesanError = null,
            bisaSimpan = cekBisaSimpan(nilai, state.mataKuliah, state.tenggat)
        )
    }

    fun ubahMataKuliah(nilai: String) {
        val state = _uiState.value
        _uiState.value = state.copy(
            mataKuliah = nilai,
            pesanError = null,
            bisaSimpan = cekBisaSimpan(state.judul, nilai, state.tenggat)
        )
    }

    fun ubahTenggat(nilai: String) {
        val state = _uiState.value
        _uiState.value = state.copy(
            tenggat = nilai,
            pesanError = null,
            bisaSimpan = cekBisaSimpan(state.judul, state.mataKuliah, nilai)
        )
    }

    fun simpanTugas() {
        val state = _uiState.value

        if (state.judul.isBlank()) {
            _uiState.value = state.copy(
                pesanError = "Judul tugas wajib diisi."
            )
            return
        }

        if (state.mataKuliah.isBlank()) {
            _uiState.value = state.copy(
                pesanError = "Mata kuliah wajib diisi."
            )
            return
        }

        if (!validasiTanggal(state.tenggat)) {
            _uiState.value = state.copy(
                pesanError = "Tenggat harus berformat YYYY-MM-DD."
            )
            return
        }

        val idBaru = (state.daftarTugas.maxOfOrNull { it.id } ?: 0) + 1

        val tugasBaru = Tugas(
            id = idBaru,
            judul = state.judul.trim(),
            mataKuliah = MataKuliah(
                kode = "MK-BARU",
                nama = state.mataKuliah.trim(),
                sks = 3
            ),
            tenggat = state.tenggat.trim(),
            catatan = null,
            status = StatusTugas.BelumDikerjakan
        )

        _uiState.value = state.copy(
            daftarTugas = (state.daftarTugas + tugasBaru)
                .sortedBy { it.tenggat },
            judul = "",
            mataKuliah = "",
            tenggat = "",
            pesanError = null,
            tampilkanForm = false,
            bisaSimpan = false
        )
    }

    private fun validasiTanggal(tanggal: String): Boolean {
        val polaTanggal = Regex("""\d{4}-\d{2}-\d{2}""")
        return polaTanggal.matches(tanggal.trim())
    }
}