package net.tomkmec.azeti.api

import net.tomkmec.azeti.model.Score
import net.tomkmec.azeti.model.ScoreInput
import net.tomkmec.azeti.store.Store
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import kotlin.math.roundToInt

@RestController
@RequestMapping("/api", produces = [MediaType.APPLICATION_JSON_VALUE])
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST])
class ScoreApi(@Autowired val store: Store) {

    @GetMapping(path = ["/score"])
    fun list(): List<Score> = store.getAll()

    @PostMapping(path = ["/score"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insert(@RequestBody(required = true) scoreIn: ScoreInput): Score {
        val score = Score(
                name = scoreIn.name,
                score = (Math.random() * 2000 - 1000).roundToInt()
        )
        store.add(score)
        return score;
    }
}