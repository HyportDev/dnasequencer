package de.spaghetto.dnasequencer.domain.service

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import org.springframework.stereotype.Component

@Component
class GetDeletionMatch: GetMatch() {

    operator fun invoke(dnaSequence: DnaSequence, guideRna: String): ArrayList<String> {
        val results: ArrayList<String> = ArrayList()
        for (i in 1 until guideRna.length) {
            findDeletionMatchWithIndex(i, guideRna, dnaSequence).forEach { match -> results.add(match) }
        }
        return results
    }

    private fun findDeletionMatchWithIndex(index: Int, guideRna: String, dnaSequence: DnaSequence): Sequence<String> {
        val tmpGuideRna = deleteValueAtIndex(guideRna, index)
        return findGuideRnaInDnaSequence(tmpGuideRna, dnaSequence)
    }

    private fun deleteValueAtIndex(string: String, index: Int): String =
        string.removeRange(index..index)

}
