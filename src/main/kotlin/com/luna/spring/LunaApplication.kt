package com.luna.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LunaApplication

fun main(args: Array<String>) {
	runApplication<LunaApplication>(*args)
}
