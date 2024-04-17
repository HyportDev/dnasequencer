package de.spaghetto.dnasequencer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DnasequencerApplication

fun main(args: Array<String>) {
	runApplication<DnasequencerApplication>(*args)
}
