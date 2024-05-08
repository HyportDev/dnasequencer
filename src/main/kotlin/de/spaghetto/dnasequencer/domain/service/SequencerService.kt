package de.spaghetto.dnasequencer.domain.service

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import org.springframework.stereotype.Service

@Service
class SequencerService(
    private val fullMatch: GetFullMatch,
    private val oneMismatch: GetOneMismatch,
    private val doubleMismatch: GetDoubleMismatch,
    private val deletionMatch: GetDeletionMatch,
    //private val repository: DnaRepository
    ) {

    //fun addDnaSequence(sequence: DnaSequence): DnaSequence {
    //    return repository.save(sequence)
    //}

    fun invertSequence(sequence: DnaSequence): String = sequence.reverseComplementary()

    fun checkFullMatches(dnaSequence: DnaSequence, guideRna: String): Int =
        fullMatch(dnaSequence, guideRna)

    fun checkOneMismatch(dnaSequence: DnaSequence, guideRna: String): ArrayList<String> =
        oneMismatch(dnaSequence, guideRna)

    fun checkDoubleMismatch(dnaSequence: DnaSequence, guideRna: String): ArrayList<String> =
        doubleMismatch(dnaSequence, guideRna)

    fun checkDeletionMatch(dnaSequence: DnaSequence, guideRna: String): ArrayList<String> =
        deletionMatch(dnaSequence, guideRna)

}