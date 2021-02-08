package net.tomkmec.azeti.store

import net.tomkmec.azeti.model.Score

interface Store {
    fun add(score: Score)
    fun getAll(ordering: Comparator<Score> = Comparator<Score>{a: Score, b: Score -> b.score - a.score }) : List<Score>
}