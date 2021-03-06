package com.soywiz.korfl.abc

import com.soywiz.korfl.amf.AMF0
import com.soywiz.korio.stream.openSync
import com.soywiz.korio.util.fromHexChunks
import org.junit.Assert
import org.junit.Test

class AMFTest {
	@Test
	fun amf0() {
		Assert.assertEquals(
			hashMapOf("name" to "Mike", "age" to 30.0, "alias" to "Mike"),
			AMF0.decode(
				listOf(
					"03 00 04 6e 61 6d 65 02 00 04 4d 69 6b 65 00 03 61 67 65 00",
					"40 3e 00 00 00 00 00 00 00 05 61 6c 69 61 73 02 00 04 4d 69",
					"6b 65 00 00 09"
				).fromHexChunks().openSync()
			)
		)
	}
}
