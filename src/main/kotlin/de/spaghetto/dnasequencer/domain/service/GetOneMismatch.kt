package de.spaghetto.dnasequencer.domain.service

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import org.springframework.stereotype.Component

@Component
class GetOneMismatch: GetMatch() {

    operator fun invoke(dnaSequence: DnaSequence, guideRna: String): ArrayList<String> {
        val results: ArrayList<String> = ArrayList()
        for (i in guideRna.indices) {
            findMismatchWithIndex(i, guideRna, dnaSequence).forEach { match -> results.add(match) }
        }
        return results
    }

    private fun findMismatchWithIndex(index: Int, guideRna: String, dnaSequence: DnaSequence): Sequence<String> {
        val tmpGuideRna = invertValueAtIndex(guideRna, index)
        return findGuideRnaInDnaSequence(tmpGuideRna, dnaSequence)
    }

    private fun invertValueAtIndex(string: String, index: Int): String =
        string.replaceRange(index..index, "[^${string[index]}]")

}

