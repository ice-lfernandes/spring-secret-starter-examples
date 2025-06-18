package br.com.ldf.medium.spring_secret_starter_inject_example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
