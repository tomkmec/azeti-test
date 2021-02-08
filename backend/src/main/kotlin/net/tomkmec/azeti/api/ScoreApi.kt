package net.tomkmec.azeti.api

import net.tomkmec.azeti.model.Score
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api")
class ScoreApi {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE], path = ["/score"])
    fun list(): List<Score> = listOf(Score("Tom",42, LocalDateTime.now()))
}