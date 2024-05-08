package de.spaghetto.dnasequencer.domain.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.LinkedList

@Entity
data class DnaSequence(
    var name: String,
    val sequence: String,
    @Id @GeneratedValue var id: Long? = null
) {

    fun reverseComplementary(): String =
        sequence
            .toUpperCase()
            .reversed()
            .map { Nucleotide.getNucleotideBySymbol(it) }
            .map { Nucleotide.getNucleotideByPartner(it) }
            .map { it.symbol }
            .joinToString("")

}