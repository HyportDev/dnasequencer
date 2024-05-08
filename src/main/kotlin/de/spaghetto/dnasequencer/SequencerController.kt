package de.spaghetto.dnasequencer

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import de.spaghetto.dnasequencer.domain.service.SequencerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sequence")
class SequencerController(private val sequencerService: SequencerService) {

    @PostMapping
    fun addSequence(@RequestBody dnaSequence: DnaSequence) : ResponseEntity<DnaSequence> {
        //sequencerService.addDnaSequence(dnaSequence)
        return ResponseEntity.ok(
            dnaSequence
        )
    }


}