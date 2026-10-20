package com.example.pengingattugaskuliah.data

import com.example.pengingattugaskuliah.model.StatusTugas
import com.example.pengingattugaskuliah.model.Tugas
import com.example.pengingattugaskuliah.model.ringkas
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SumberTugasPalsu : Sumber<Tugas> {
    override suspend fun ambil(id: Int): Tugas {
        delay(1000)
        return contohTugas(id)
    }

    suspend fun ambilRiwayat(id: Int): List<String> {
        delay(800)
        return listOf("Tugas #$id dibuat 08.10", "Mulai dikerjakan 08.40")
    }

    override fun pantau(id: Int): Flow<Tugas> = flow {
        val tugas = contohTugas(id)
        emit(tugas.copy(status = StatusTugas.BelumDikerjakan))
        delay(1500)
        emit(tugas.copy(status = StatusTugas.Dikerjakan(50)))
        delay(2000)
        emit(tugas.copy(status = StatusTugas.Selesai("2026-10-26 21.00")))
    }
}

suspend fun muatAman(sumber: Sumber<Tugas>, id: Int): String =
    try {
        require(id > 0) { "id harus positif" }
        sumber.ambil(id).ringkas()
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        "Gagal memuat tugas #$id"
    }