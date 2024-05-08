package de.spaghetto.dnasequencer

import de.spaghetto.dnasequencer.domain.model.entity.DnaSequence
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DnaRepository : CrudRepository<DnaSequence, Long>
