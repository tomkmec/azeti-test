package net.tomkmec.azeti.store

import net.tomkmec.azeti.model.Score
import org.springframework.stereotype.Component

@Component
class MemoryStore: Store {
    val storage: MutableSet<Score> = HashSet()

    override fun add(score: Score) {
        storage.add(score)
    }

    override fun getAll(ordering: Comparator<Score>) = storage.toList().sortedWith(ordering)
}