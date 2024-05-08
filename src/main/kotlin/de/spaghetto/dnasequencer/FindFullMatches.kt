package de.spaghetto.dnasequencer

import org.springframework.stereotype.Component

@Component
class FindFullMatches {

    operator fun invoke(sequence: String, guideRna: String) = sequence.toRegex().findAll(guideRna).count()

}