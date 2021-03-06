package com.jmeranda.glazy.lib

import com.jmeranda.glazy.lib.handler.GlazyDraftableHeader
import com.jmeranda.glazy.lib.handler.GlazySimpleHeader
import com.jmeranda.glazy.lib.handler.GlazyTransferableHeader
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HeaderTest {
    private val nullHeader = GlazySimpleHeader(null)
    private val nonNullHeader = GlazySimpleHeader("foo")

    @Test fun testNullHeader() {
        assertTrue(this.nullHeader.headers.isEmpty())
    }

    @Test fun testHeader() {
        assertEquals(
                mapOf("Authorization" to "token foo"), nonNullHeader.headers
        )
    }
}

class DraftableHeaderTest {
    private val nullDraftable = GlazyDraftableHeader(null)
    private val nonNullDraftable = GlazyDraftableHeader("foo")

    @Test fun testNullHeader() {
        assertEquals(
                mapOf("Accept" to "application/vnd.github.shadow-cat-preview+json"),
                nullDraftable.headers
        )
    }

    @Test fun testHeader() {
        assertEquals(
                mapOf("Authorization" to "token foo")
                        .plus("Accept" to "application/vnd.github.shadow-cat-preview+json"),
                nonNullDraftable.headers
        )
    }
}

class TransferableHeaderTest {
    private val nullTransferable = GlazyTransferableHeader(null)
    private val nonNullTransferable = GlazyTransferableHeader("foo")

    @Test fun testNullHeader() {
        assertEquals(
                mapOf("Accept" to "application/vnd.github.nightshade-preview+json"),
                this.nullTransferable.headers
        )
    }

    @Test fun testHeader() {
        assertEquals(
                mapOf("Authorization" to "token foo")
                        .plus("Accept" to "application/vnd.github.nightshade-preview+json"),
                nonNullTransferable.headers
        )
    }
}