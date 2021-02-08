package net.tomkmec.azeti.api

import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.argForWhich
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import net.tomkmec.azeti.model.Score
import net.tomkmec.azeti.model.ScoreInput
import net.tomkmec.azeti.store.Store
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

/**
 * I'm not a huge fan of API "unit" tests with web server, testing routes et al. I prefer testing that in e2e.
 */
@ExtendWith(MockitoExtension::class)
class ScoreApiTest {
    private lateinit var fixture: ScoreApi

    @Test
    fun testAddScore(@Mock storeMock: Store) {
        fixture = ScoreApi(storeMock)

        val result = fixture.insert(ScoreInput("Tom"))

        verify(storeMock).add(argForWhich { name == "Tom" })
        Assertions.assertEquals("Tom", result.name)
    }

    @Test
    fun testList(@Mock storeMock: Store) {
        val list = listOf(Score(name = "Tom", score = -42))
        whenever(storeMock.getAll(anyOrNull())).thenReturn(list)
        fixture = ScoreApi(storeMock)

        val result = fixture.list()

        Assertions.assertEquals(result, list)
    }
}