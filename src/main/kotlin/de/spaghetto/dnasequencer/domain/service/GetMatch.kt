package de.spaghetto.dnasequencer.domain.service

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence

abstract class GetMatch {

    internal fun findGuideRnaInDnaSequence(guideRna: String, dnaSequence: DnaSequence): Sequence<String> =
        "(?=($guideRna))"
            .toRegex()
            .findAll(dnaSequence.reverseComplementary())
            .map { it.groupValues[1] }
}