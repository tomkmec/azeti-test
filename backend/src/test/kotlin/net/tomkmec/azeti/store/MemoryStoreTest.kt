package net.tomkmec.azeti.store

import net.tomkmec.azeti.model.Score
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class MemoryStoreTest {

    private lateinit var fixture: MemoryStore

    @BeforeEach
    fun setup() {
        fixture = MemoryStore()
    }

    @Test
    fun testEmptyStorage() {
        val initial = fixture.getAll()
        Assertions.assertTrue(initial.isEmpty())
    }

    @Test
    fun testAdd() {
        fixture.add(Score("Tom", 42, LocalDateTime.now()))
        val all = fixture.getAll()
        Assertions.assertAll(
                { Assertions.assertEquals(1, all.size) },
                { Assertions.assertEquals("Tom", all[0].name) },
                { Assertions.assertEquals(42, all[0].score) }
        )
    }

    @Test
    fun testOrdering() {
        fixture.add(Score("Tom", 42, LocalDateTime.now()))
        fixture.add(Score("Jerry", 1, LocalDateTime.now()))

        val default = fixture.getAll();
        val byName = fixture.getAll { a,b -> a.name.compareTo(b.name) }
        val byScoreInverse = fixture.getAll { a,b -> a.score - b.score }

        Assertions.assertAll(
                { Assertions.assertEquals("Tom", default[0].name) },
                { Assertions.assertEquals("Jerry", byName[0].name) },
                { Assertions.assertEquals("Jerry", byScoreInverse[0].name) },
        )

    }

}