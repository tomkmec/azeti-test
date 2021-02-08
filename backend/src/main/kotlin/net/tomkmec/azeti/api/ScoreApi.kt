package net.tomkmec.azeti.api

import net.tomkmec.azeti.model.Score
import net.tomkmec.azeti.model.ScoreInput
import net.tomkmec.azeti.store.Store
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import kotlin.math.roundToInt

@RestController
@RequestMapping("/api")
class ScoreApi(@Autowired val store: Store) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE], path = ["/score"])
    fun list(): List<Score> = store.getAll()

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], path = ["/score"])
    fun insert(@RequestBody(required = true) scoreIn: ScoreInput): Score {
        val score = Score(
                name = scoreIn.name,
                score = (Math.random() * 2000 - 1000).roundToInt()
        )
        store.add(score)
        return score;
    }
}