package net.tomkmec.azeti.model

import java.time.LocalDateTime
import java.util.*

data class Score(
        val name: String,
        val score: Int,
        val time: LocalDateTime = LocalDateTime.now(),
        val id: UUID = UUID.randomUUID())
