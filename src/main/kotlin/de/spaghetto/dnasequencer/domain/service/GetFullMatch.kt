package de.spaghetto.dnasequencer.domain.service

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import org.springframework.stereotype.Component

@Component
class GetFullMatch {

    operator fun invoke(dnaSequence: DnaSequence, guideRna: String): Int =
        "(?=($guideRna))".toRegex().findAll(dnaSequence.reverseComplementary()).count()

}

