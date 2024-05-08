package de.spaghetto.dnasequencer.domain.model.entity

enum class Nucleotide(val symbol: Char, val pairNucleotide: Char) {
    ADENINE('A', 'T'),
    CYTOSINE('C', 'G'),
    GUANINE('G', 'C'),
    THYMINE('T', 'A'),
    PLACEHOLDER('.', '.');

    companion object {
        fun getNucleotideBySymbol(symbol: Char): Nucleotide =
            values().first{it.symbol == symbol}

        fun getNucleotideByPartner(pairNucleotide: Nucleotide) =
            values().first{it.pairNucleotide == pairNucleotide.symbol}
    }
}