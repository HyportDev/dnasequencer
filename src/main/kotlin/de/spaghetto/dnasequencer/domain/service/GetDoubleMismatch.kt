package de.spaghetto.dnasequencer.domain.service

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import org.springframework.stereotype.Component

@Component
class GetDoubleMismatch: GetMatch() {

    operator fun invoke(dnaSequence: DnaSequence, guideRna: String): ArrayList<String> {
        val results: ArrayList<String> = ArrayList()
        val guideArray = guideRna.toCharArray().map(Char::toString)
        for (i in guideRna.indices) {
            for (j in i + 1 until guideRna.length) {
                findDoubleMismatchWithIndices(i, j, guideArray, dnaSequence).forEach { match -> results.add(match) }
            }
        }
        return results
    }

    private fun findDoubleMismatchWithIndices(
        index1: Int,
        index2: Int,
        guideArray: List<String>,
        dnaSequence: DnaSequence
    ): Sequence<String> {
        val tmpGuideRna = buildDoubleMismatchGuideRna(index1, index2, guideArray)
        return findGuideRnaInDnaSequence(tmpGuideRna, dnaSequence)
    }

    private fun buildDoubleMismatchGuideRna(index1: Int, index2: Int, guideArray: List<String>): String {
        var tmpGuideRna = guideArray.toMutableList()
        tmpGuideRna[index1] = "[^${guideArray[index1]}]"
        tmpGuideRna[index2] = "[^${guideArray[index2]}]"
        return tmpGuideRna.joinToString("")
    }
}
