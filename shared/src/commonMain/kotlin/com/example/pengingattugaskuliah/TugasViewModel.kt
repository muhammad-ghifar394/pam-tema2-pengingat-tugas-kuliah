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

    fun bukaForm() {
        _uiState.value = _uiState.value.copy(
            tampilkanForm = true,
            pesanError = null
        )
    }

    fun tutupForm() {
        _uiState.value = _uiState.value.copy(
            tampilkanForm = false,
            pesanError = null
        )
    }

    fun ubahJudul(nilai: String) {
        _uiState.value = _uiState.value.copy(
            judul = nilai,
            pesanError = null
        )
    }

    fun ubahMataKuliah(nilai: String) {
        _uiState.value = _uiState.value.copy(
            mataKuliah = nilai,
            pesanError = null
        )
    }

    fun ubahTenggat(nilai: String) {
        _uiState.value = _uiState.value.copy(
            tenggat = nilai,
            pesanError = null
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
            tampilkanForm = false
        )
    }

    private fun validasiTanggal(tanggal: String): Boolean {
        val polaTanggal = Regex("""\d{4}-\d{2}-\d{2}""")
        return polaTanggal.matches(tanggal.trim())
    }
}