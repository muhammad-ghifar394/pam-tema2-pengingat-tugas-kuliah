package com.example.pengingattugaskuliah

import com.example.pengingattugaskuliah.data.SumberTugasPalsu
import com.example.pengingattugaskuliah.data.muatAman
import com.example.pengingattugaskuliah.model.StatusTugas
import com.example.pengingattugaskuliah.model.label
import com.example.pengingattugaskuliah.model.ringkas
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SumberTugasPalsuTest {

    private val sumber = SumberTugasPalsu()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun asyncBersamaanSelesaiSekitar1000ms() = runTest {
        val tugas = async { sumber.ambil(1) }
        val riwayat = async { sumber.ambilRiwayat(1) }

        println(tugas.await().ringkas())
        println(riwayat.await())
        println("Waktu berjalan: $currentTime ms")
        assertEquals(1000, currentTime)
    }

    @Test
    fun collectMencetakPerubahanStatus() = runTest {
        val aliran = sumber.pantau(1)
        println("Sebelum collect")
        aliran.collect { tugas ->
            println(tugas.status.label())
        }
        println("Sesudah collect")
    }

    @Test
    fun operatorMenyaringDanMengubahStatus() = runTest {
        val pesan = sumber.pantau(1)
            .filter { it.status !is StatusTugas.BelumDikerjakan }
            .map { it.status.label() }
            .onEach { println("Log: $it") }
            .toList()

        assertEquals(listOf("Dikerjakan 50%", "Selesai, dikumpulkan 2026-10-26 21.00"), pesan)
    }

    @Test
    fun muatAmanMenanganiError() = runTest {
        println(muatAman(sumber, 3))
        println(muatAman(sumber, -1))
        assertEquals("Gagal memuat tugas #-1", muatAman(sumber, -1))
    }
}