package de.spaghetto.dnasequencer

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val dnaRepository: DnaRepository
) {

}