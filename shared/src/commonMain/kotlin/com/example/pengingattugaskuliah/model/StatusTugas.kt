package com.example.pengingattugaskuliah.model

sealed class StatusTugas {
    data object BelumDikerjakan : StatusTugas()
    data class Dikerjakan(
        val progres: Int
    ) : StatusTugas()
    data class Selesai(
        val dikumpulkanPada: String
    ) : StatusTugas()
}
