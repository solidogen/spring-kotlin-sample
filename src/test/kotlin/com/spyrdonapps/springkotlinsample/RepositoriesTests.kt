package com.spyrdonapps.springkotlinsample

import com.spyrdonapps.springkotlinsample.model.entity.ArticleEntity
import com.spyrdonapps.springkotlinsample.model.entity.UserEntity
import com.spyrdonapps.springkotlinsample.repository.ArticleRepository
import com.spyrdonapps.springkotlinsample.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = UserEntity(
            "springjuergen",
            "Juergen",
            "Hoeller"
        )
        entityManager.persist(juergen)
        val article = ArticleEntity(
            "Spring Framework 5.0 goes GA",
            "Dear Spring community ...",
            "Lorem ipsum",
            juergen
        )
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val juergen = UserEntity(
            "springjuergen",
            "Juergen",
            "Hoeller"
        )
        entityManager.persist(juergen)
        entityManager.flush()
        val user = userRepository.findByLogin(juergen.login)
        assertThat(user).isEqualTo(juergen)
    }
}
